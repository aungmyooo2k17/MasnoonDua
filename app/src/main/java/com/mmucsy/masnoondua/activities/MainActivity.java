package com.mmucsy.masnoondua.activities;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.delegates.MainPageItemDelegate;
import com.mmucsy.masnoondua.fragments.FavouriteFragment;
import com.mmucsy.masnoondua.fragments.HomeFragment;
import com.mmucsy.masnoondua.fragments.RecentFragment;
import com.mmucsy.masnoondua.fragments.SearchFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, MainPageItemDelegate {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            requestPermissions(new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }

        loadFragment(new HomeFragment());




        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.action_home:
                fragment = new HomeFragment();
                loadFragment(fragment);
                return true;
            case R.id.action_recent:
                fragment = new RecentFragment();
                loadFragment(fragment);
                return true;
            case R.id.action_favorites:
                fragment = new FavouriteFragment();
                loadFragment(fragment);
                return true;
            case R.id.action_search:
                fragment = new SearchFragment();
                loadFragment(fragment);
                return true;
        }
        return false;
    }

    private void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_frame_container, fragment);
        transaction.commit();

    }

    @Override
    public void onTapDuaItem() {
        Intent i = new Intent(MainActivity.this, DuaDetailActivity.class);
        startActivity(i);
    }

    @Override
    public void onTapDuaCategory(int pos) {
        Intent i = new Intent(MainActivity.this, DuaListActivity.class);
        i.putExtra("POSITION", pos);
        startActivity(i);
    }
}
