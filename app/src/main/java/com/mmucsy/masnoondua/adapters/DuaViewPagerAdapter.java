package com.mmucsy.masnoondua.adapters;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mmucsy.masnoondua.FavSharedPreference;
import com.mmucsy.masnoondua.MasnoonDuaApp;
import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.data.models.Dua;

import java.io.ByteArrayOutputStream;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aungmyooo on 2/16/18.
 */

public class DuaViewPagerAdapter extends PagerAdapter {

    @BindView(R.id.tv_dua_tilte)
    TextView tvDuaTitle;

    @BindView(R.id.tv_dua)
    TextView tvDua;

    @BindView(R.id.tv_dua_translation)
    TextView tvDuaTranslation;

    private View viewShare;
    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<Dua> duaList;
    private int pos;

    public DuaViewPagerAdapter(Context context, List<Dua> duaList) {
        this.context = context;
        this.duaList = duaList;
        mLayoutInflater = (LayoutInflater) this.context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return duaList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mLayoutInflater.inflate(R.layout.view_dua_detail_item, container, false);
        ButterKnife.bind(this, view);

        pos = position;

        tvDuaTitle.setTypeface(MasnoonDuaApp.typeface);
        tvDuaTranslation.setTypeface(MasnoonDuaApp.typeface);

        tvDuaTitle.setText(duaList.get(position).getDuaTitle());
        tvDua.setText(duaList.get(position).getDuaArbic());
        tvDuaTranslation.setText(duaList.get(position).getDuaDescription());


        container.addView(view);

        view.setTag("View"+position);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public Bitmap getBitmapFromView(View view) {

        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable =view.getBackground();
        if (bgDrawable!=null)
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

    public void ShareImage(View v){
        RelativeLayout rlShareView =(RelativeLayout) v.findViewById(R.id.share_view);
        viewShare = rlShareView.getRootView();
        Bitmap bitmap = getBitmapFromView(viewShare);
        final Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/jpg");
        shareIntent.putExtra(Intent.EXTRA_STREAM, getImageUri(context, bitmap));
        context.startActivity(Intent.createChooser(shareIntent, "Share image using"));

    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }


    public void copyArbicText(int currentPos){
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("arbic", duaList.get(currentPos).getDuaArbic());
        Toast.makeText(context, "Copy to Clipboard"+duaList.get(currentPos).getDuaArbic(), Toast.LENGTH_LONG).show();
        clipboard.setPrimaryClip(clip);
    }

    public void addFavToThis(int currentPos){
        FavSharedPreference s=new FavSharedPreference();
        s.addFavorite(context,duaList.get(currentPos));

    }
    public void removeFavFromThat(int currentPos)
    {
        FavSharedPreference shrd=new FavSharedPreference();
        shrd.removeFavorite(context,currentPos);
    }



}
