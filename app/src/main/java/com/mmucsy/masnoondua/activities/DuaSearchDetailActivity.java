package com.mmucsy.masnoondua.activities;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mmucsy.masnoondua.SharedPreference.FavSharedPreference;
import com.mmucsy.masnoondua.MasnoonDuaApp;
import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.data.db.DatabaseAccess;
import com.mmucsy.masnoondua.data.models.Dua;

import java.io.ByteArrayOutputStream;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DuaSearchDetailActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.root_v)
    RelativeLayout rlShareView;

    @BindView(R.id.tv_dua_s)
    TextView tvDua;

    @BindView(R.id.tv_dua_tilte_s)
    TextView tvDuaTitle;

    @BindView(R.id.tv_dua_translation_s)
    TextView tvDuaTrans;

    @BindView(R.id.bottom_navigation_dua_item)
    BottomNavigationView bottomNavigationView;


    private Menu menu;
    private int s;
    private DatabaseAccess databaseAccess;
    private List<Dua> duaList;
    private View v;
    private FavSharedPreference favSharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua_search_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        favSharedPreference = new FavSharedPreference();

        s = getIntent().getExtras().getInt("DUA_ID");

        Log.d(MasnoonDuaApp.TAG, "onCreate: " + s);
        databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        duaList = databaseAccess.getDuaByDuaTitle(s);
        databaseAccess.close();


        tvDua.setText(duaList.get(0).getDuaArbic());
        tvDuaTitle.setText(duaList.get(0).getDuaTitle());
        tvDuaTrans.setText(duaList.get(0).getDuaDescription());

        tvDuaTrans.setTypeface(MasnoonDuaApp.typeface);
        tvDuaTitle.setTypeface(MasnoonDuaApp.typeface);
        tvDua.setTypeface(MasnoonDuaApp.arbicTypeFace);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.bottom_navigation_dua_item, menu);
//        this.menu = menu;
//        return true;
//
//    }

    public boolean checkFavoriteItem(Dua checkCode) {
        boolean check = false;
        FavSharedPreference shrdPrefrefence = new FavSharedPreference();
        List<Dua> favorites = shrdPrefrefence.getFavorites(this);
        if (favorites != null) {

            for (int i = 0; i < favorites.size(); i++) {
                if (checkCode.getDua_id() == favorites.get(i).getDua_id()) {
                    check = true;
                    break;
                }


            }
        }
        return check;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favourite_dua:

                if (checkFavoriteItem(duaList.get(0))) {
                    favSharedPreference.removeFavorite(this, duaList.get(0));
                    Log.d(MasnoonDuaApp.TAG, "onNavigationItemSelected: " + duaList.get(0).getDuaTitle() + duaList.get(0).getDua_id());
                    Toast.makeText(getApplicationContext(), "Item Removed", Toast.LENGTH_SHORT).show();
                    item.setIcon(R.drawable.favorite_off);
                } else {
                    favSharedPreference.addFavorite(this, duaList.get(0));
                    Toast.makeText(getApplicationContext(), "Added Favorite", Toast.LENGTH_SHORT).show();
                    item.setIcon(R.drawable.favorite_on);
                }
                return true;
            case R.id.action_share_dua:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                    requestPermissions(new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                }
                v = rlShareView.getChildAt(0);
                ShareImage(v);

                return true;
            case R.id.action_copy_dua:
                copyArbicText(0);
                return true;
        }
        return false;
    }


    public Bitmap getBitmapFromView(View view) {

        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null)
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        else
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        // draw the view on the canvas
        view.draw(canvas);
        //return the bitmap
        return returnedBitmap;
    }

    public void ShareImage(View v) {
        Bitmap bitmap = getBitmapFromView(v);
        final Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/jpg");
        shareIntent.putExtra(Intent.EXTRA_STREAM, getImageUri(this, bitmap));
        startActivity(Intent.createChooser(shareIntent, "Share image using"));

    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }


    public void copyArbicText(int currentPos) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("arbic", duaList.get(currentPos).getDuaArbic());
        Toast.makeText(this, "Copy to Clipboard" + duaList.get(currentPos).getDuaArbic(), Toast.LENGTH_LONG).show();
        clipboard.setPrimaryClip(clip);
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (checkFavoriteItem(duaList.get(0))) {
            bottomNavigationView.getMenu().findItem(R.id.action_favourite_dua).setIcon(R.drawable.favorite_on);

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
