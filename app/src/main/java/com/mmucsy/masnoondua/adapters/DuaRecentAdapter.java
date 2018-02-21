package com.mmucsy.masnoondua.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.delegates.DuaRecentItemDelegate;
import com.mmucsy.masnoondua.viewHolders.DuaCategoryViewHolder;
import com.mmucsy.masnoondua.viewHolders.DuaRecentViewHolder;

/**
 * Created by aungmyooo on 2/18/18.
 */

public class DuaRecentAdapter extends RecyclerView.Adapter<DuaRecentViewHolder> {

    private LayoutInflater mLayoutInflator;
    private DuaRecentItemDelegate duaRecentItemDelegate;

    public DuaRecentAdapter(Context context, DuaRecentItemDelegate duaRecentItemDelegate) {
        mLayoutInflator = LayoutInflater.from(context);
        this.duaRecentItemDelegate = duaRecentItemDelegate;


    }

    @Override
    public DuaRecentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflator.inflate(R.layout.view_item_dua_recent, parent, false);



        return new DuaRecentViewHolder(v, duaRecentItemDelegate);
    }

    @Override
    public void onBindViewHolder(DuaRecentViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
