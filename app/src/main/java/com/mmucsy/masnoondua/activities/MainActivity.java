package com.mmucsy.masnoondua.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.fragments.FavouriteFragment;
import com.mmucsy.masnoondua.fragments.HomeFragment;
import com.mmucsy.masnoondua.fragments.RecentFragment;
import com.mmucsy.masnoondua.fragments.SearchFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

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
}
