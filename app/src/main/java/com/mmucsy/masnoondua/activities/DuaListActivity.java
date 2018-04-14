package com.mmucsy.masnoondua.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.SharedPreference.RecentSharedPreference;
import com.mmucsy.masnoondua.adapters.DuaAdapter;
import com.mmucsy.masnoondua.adapters.DuaRecentAdapter;
import com.mmucsy.masnoondua.data.db.DatabaseAccess;
import com.mmucsy.masnoondua.data.models.Dua;
import com.mmucsy.masnoondua.delegates.DuaItemDelegate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DuaListActivity extends AppCompatActivity implements DuaItemDelegate {

    @BindView(R.id.rv_dua_list)
    RecyclerView recyclerViewDuaList;

    @BindView(R.id.toolbar_dua_list)
    Toolbar toolbar;

    private DuaAdapter duaAdapter;
    private int duaCategoryPos;
    private RecentSharedPreference recentSharedPreference = new RecentSharedPreference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua_list);
        ButterKnife.bind(this);


        duaCategoryPos = getIntent().getExtras().getInt("POSITION");
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<Dua> duaList = databaseAccess.getDuaByCategoryId(duaCategoryPos);
        databaseAccess.close();


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        duaAdapter = new DuaAdapter(this, this, duaList);
        recyclerViewDuaList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewDuaList.setAdapter(duaAdapter);
    }

    @Override
    public void onTapDua(int duaId, int itemPosition) {
        recentSharedPreference.addRecent(this, duaId);
        DuaRecentAdapter duaRecentAdapter = new DuaRecentAdapter();
        duaRecentAdapter.notifyDataSetChanged();
        Intent i = new Intent(DuaListActivity.this, DuaDetailActivity.class);
        i.putExtra("ONTAP_POS", itemPosition);
        i.putExtra("DUA_CATEGORY", duaCategoryPos);
        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }
}
