package com.mmucsy.masnoondua.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.adapters.DuaAdapter;
import com.mmucsy.masnoondua.delegates.DuaItemDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DuaListActivity extends AppCompatActivity implements DuaItemDelegate {

    @BindView(R.id.rv_dua_list)
    RecyclerView recyclerViewDuaList;

    @BindView(R.id.toolbar_dua_list)
    Toolbar toolbar;

    private DuaAdapter duaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua_list);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("BATHROOM");

        duaAdapter = new DuaAdapter(this, this);
        recyclerViewDuaList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewDuaList.setAdapter(duaAdapter);
    }

    @Override
    public void onTapDua() {
        Intent i = new Intent(DuaListActivity.this, DuaDetailActivity.class);
        startActivity(i);
    }
}
