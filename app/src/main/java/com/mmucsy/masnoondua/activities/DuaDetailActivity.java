package com.mmucsy.masnoondua.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mmucsy.masnoondua.FavSharedPreference;
import com.mmucsy.masnoondua.MasnoonDuaApp;
import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.adapters.DuaViewPagerAdapter;
import com.mmucsy.masnoondua.data.db.DatabaseAccess;
import com.mmucsy.masnoondua.data.models.Dua;
import com.mmucsy.masnoondua.fragments.FavouriteFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DuaDetailActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.view_pager_dua)
    ViewPager viewPagerDua;

    @BindView(R.id.bottom_navigation_dua_item)
    BottomNavigationView bottomNavigationView;

    private DuaViewPagerAdapter duaViewPagerAdapter;
    private String duaPosition;
    private int duaCategory;

    private DatabaseAccess databaseAccess;
    private List<Dua> duaList;
    private int currentPos;
    private View v;

    private Menu menu;

    private FavSharedPreference favSharedPreference = new FavSharedPreference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua_detail);
        ButterKnife.bind(this);

        duaPosition = String.valueOf(getIntent().getExtras().getInt("ONTAP_POS"));

        duaCategory = getIntent().getExtras().getInt("DUA_CATEGORY");
//        Log.d(MasnoonDuaApp.TAG, "onCreate: " + duaCategory + duaPosition);
//        Log.d("Position..", duaCategory + " " + duaPosition);


        if (duaCategory == 00) {
            duaList = favSharedPreference.getFavorites(this);

        } else if (duaCategory == 000) {
            Log.d(MasnoonDuaApp.TAG, "onCreate:is equal 000 " + duaCategory);
            databaseAccess = DatabaseAccess.getInstance(this);
            databaseAccess.open();
            duaList = databaseAccess.getDuaByDuaTitle(duaPosition);
            databaseAccess.close();

        } else {
            databaseAccess = DatabaseAccess.getInstance(this);
            databaseAccess.open();
            duaList = databaseAccess.getDuaByCategoryId(duaCategory);
            databaseAccess.close();
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Hello World");

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_dua_item);


        duaViewPagerAdapter = new DuaViewPagerAdapter(this, duaList);
        viewPagerDua.setAdapter(duaViewPagerAdapter);
        viewPagerDua.setCurrentItem(Integer.parseInt(duaPosition));

        viewPagerDua.setOnPageChangeListener(this);


        bottomNavigationView.setOnNavigationItemSelectedListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_navigation_dua_item, menu);
        this.menu = menu;
        return true;

    }

    public boolean checkFavoriteItem(Dua checkCode) {
        boolean check = false;
        FavSharedPreference shrdPrefrefence = new FavSharedPreference();
        List<Dua> favorites = shrdPrefrefence.getFavorites(this);
        if (favorites != null) {

            for (int i = 0; i < favorites.size(); i++) {
//                Log.i("CheckCode", " " + checkCode.getDua_id() + " " + favorites.get(i).getDua_id());
                if (checkCode.getDua_id() == favorites.get(i).getDua_id()) {
                    check = true;
                    break;
                }


            }
        }
        return check;
    }

    @Override
    protected void onStart() {
        super.onStart();
        currentPos = viewPagerDua.getCurrentItem();
        if (checkFavoriteItem(duaList.get(currentPos))) {
            bottomNavigationView.getMenu().findItem(R.id.action_favourite_dua).setIcon(android.R.drawable.star_big_off);

        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favourite_dua:
                currentPos = viewPagerDua.getCurrentItem();
//                Log.i("Position...", duaList.get(currentPos).getDuaTitle());


                if (checkFavoriteItem(duaList.get(currentPos))) {
//                    Log.i("Position...", currentPos + "soe");
                    duaViewPagerAdapter.removeFavFromThat(duaList.get(viewPagerDua.getCurrentItem()),this);

                    Toast.makeText(getApplicationContext(), "Item Removed", Toast.LENGTH_SHORT).show();
                    item.setIcon(R.drawable.ic_favorite);
                } else {
//                    Log.i("Position...", currentPos + "so");
                    duaViewPagerAdapter.addFavToThis(currentPos);
                    Toast.makeText(getApplicationContext(), "Added Favorite", Toast.LENGTH_SHORT).show();

                    item.setIcon(android.R.drawable.star_big_off);
                }
                return true;
            case R.id.action_share_dua:
                v = viewPagerDua.findViewWithTag("View" + viewPagerDua.getCurrentItem());
                duaViewPagerAdapter.ShareImage(v);

                return true;
            case R.id.action_copy_dua:
                currentPos = viewPagerDua.getCurrentItem();
                duaViewPagerAdapter.copyArbicText(currentPos);
                return true;
        }
        return false;
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int p) {
//        Log.i("Position", p + "dua");
        if (checkFavoriteItem(duaList.get(p))) {
            Toast.makeText(getApplicationContext(), "have fav", Toast.LENGTH_SHORT).show();
            bottomNavigationView.getMenu().findItem(R.id.action_favourite_dua).setIcon(android.R.drawable.star_big_off);
        } else if (!checkFavoriteItem(duaList.get(p))) {
            Toast.makeText(getApplicationContext(), "not have fav", Toast.LENGTH_SHORT).show();
            bottomNavigationView.getMenu().findItem(R.id.action_favourite_dua).setIcon(R.drawable.ic_favorite);

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {


    }


}

