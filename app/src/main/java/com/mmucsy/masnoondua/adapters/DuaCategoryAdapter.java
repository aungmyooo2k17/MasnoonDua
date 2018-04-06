package com.mmucsy.masnoondua.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.delegates.DuaCategoryItemDelegate;
import com.mmucsy.masnoondua.viewHolders.DuaCategoryViewHolder;

import java.util.List;

/**
 * Created by aungmyooo on 2/14/18.
 */

public class DuaCategoryAdapter extends RecyclerView.Adapter<DuaCategoryViewHolder>{

    private LayoutInflater mLayoutInflator;
    private DuaCategoryItemDelegate duaCategoryItemDelegate;
//    private Category category;

    public DuaCategoryAdapter(Context context, DuaCategoryItemDelegate duaCategoryItemDelegate) {
        mLayoutInflator = LayoutInflater.from(context);
        this.duaCategoryItemDelegate = duaCategoryItemDelegate;
//        this.category = new Category();
    }

    @Override
    public DuaCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflator.inflate(R.layout.view_item_dua_category, parent, false);


        return new DuaCategoryViewHolder(v, duaCategoryItemDelegate);
    }

    @Override
    public void onBindViewHolder(DuaCategoryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
