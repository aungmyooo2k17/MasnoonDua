package com.mmucsy.masnoondua.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.data.models.Dua;
import com.mmucsy.masnoondua.delegates.DuaItemDelegate;
import com.mmucsy.masnoondua.viewHolders.DuaViewHolder;

import java.util.List;

/**
 * Created by aungmyooo on 2/14/18.
 */

public class DuaAdapter extends RecyclerView.Adapter<DuaViewHolder> {

    private LayoutInflater mLayoutInflator;
    private DuaItemDelegate duaItemDelegate;
    private List<Dua> duaTitleListByCategoryId;

    public DuaAdapter(Context context, DuaItemDelegate duaItemDelegate, List<Dua> duaTitleListByCategoryId) {
        mLayoutInflator = LayoutInflater.from(context);
        this.duaItemDelegate = duaItemDelegate;
        this.duaTitleListByCategoryId = duaTitleListByCategoryId;
    }

    @Override
    public DuaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflator.inflate(R.layout.view_dua_item, parent, false);

        return new DuaViewHolder(v, duaItemDelegate, duaTitleListByCategoryId);
    }

    @Override
    public void onBindViewHolder(DuaViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {


        return duaTitleListByCategoryId.size();
    }
}
