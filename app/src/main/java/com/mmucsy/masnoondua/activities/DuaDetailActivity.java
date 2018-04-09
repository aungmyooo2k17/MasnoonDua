package com.mmucsy.masnoondua.activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mmucsy.masnoondua.MasnoonDuaApp;
import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.SharedPreference;
import com.mmucsy.masnoondua.adapters.DuaViewPagerAdapter;
import com.mmucsy.masnoondua.data.db.DatabaseAccess;
import com.mmucsy.masnoondua.data.models.Dua;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DuaDetailActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.view_pager_dua)
    ViewPager viewPagerDua;

    @BindView(R.id.bottom_navigation_dua_item)
    BottomNavigationView bottomNavigationView;

    private DuaViewPagerAdapter duaViewPagerAdapter;
    private int duaPosition, duaCategory;

    private DatabaseAccess databaseAccess;
    private List<Dua> duaList;

    private Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua_detail);
        ButterKnife.bind(this);

        duaPosition = getIntent().getExtras().getInt("ONTAP_POS");
        duaCategory = getIntent().getExtras().getInt("DUA_CATEGORY");

        databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        duaList = databaseAccess.getDuaByCategoryId(duaCategory);

        databaseAccess.close();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Hello World");


        duaViewPagerAdapter = new DuaViewPagerAdapter(this, duaList);
        viewPagerDua.setAdapter(duaViewPagerAdapter);
        viewPagerDua.setCurrentItem(duaPosition);


        bottomNavigationView.setOnNavigationItemSelectedListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        return true;

    }

    public boolean checkFavoriteItem(Dua checkCode) {
        boolean check = false;
        SharedPreference shrdPrefrefence = new SharedPreference();
        List<Dua> favorites = shrdPrefrefence.getFavorites(this);

        Log.i("SharedPreference...", favorites.size() + "");
        Log.i("SharedPreference...", duaList.get(duaPosition).getDua_id() + "");
        Log.i("SharedPreference...", checkCode.getDua_id() + "");

        if (favorites != null) {
            for (Dua code : favorites) {
                if (code.getDua_id() == duaList.get(duaPosition).getDua_id()) {
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
        if (checkFavoriteItem(duaList.get(duaPosition))) {
            BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_dua_item);
            navigationView.getMenu().findItem(R.id.action_favourite_dua).setIcon(android.R.drawable.btn_star);


        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favourite_dua:
                if (checkFavoriteItem(duaList.get(duaPosition))) {
                    duaViewPagerAdapter.removeFavFromThat();
                    Toast.makeText(getApplicationContext(), "Item Removed", Toast.LENGTH_SHORT).show();
                    item.setIcon(R.drawable.ic_favorite);

                } else {
                    duaViewPagerAdapter.addFavToThis();
                    item.setIcon(android.R.drawable.star_big_off);


                }
                return true;
            case R.id.action_share_dua:
                duaViewPagerAdapter.ShareImage();

                return true;
            case R.id.action_copy_dua:
                duaViewPagerAdapter.copyArbicText();
                return true;
        }
        return false;
    }


}
