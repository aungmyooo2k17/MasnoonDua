package com.mmucsy.masnoondua.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.adapters.DuaViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DuaDetailActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.view_pager_dua)
    ViewPager viewPagerDua;

    private DuaViewPagerAdapter duaViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Hello World");

        duaViewPagerAdapter = new DuaViewPagerAdapter(this);
        viewPagerDua.setAdapter(duaViewPagerAdapter);


    }
}
