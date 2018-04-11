package com.mmucsy.masnoondua.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mmucsy.masnoondua.FavSharedPreference;
import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.data.models.Dua;
import com.mmucsy.masnoondua.delegates.DuaItemDelegate;
import com.mmucsy.masnoondua.viewHolders.FavoriteDuaViewHolder;

import java.util.List;

/**
 * Created by soe_than on 4/8/18.
 */

public class FavoriteDuaAdapter extends RecyclerView.Adapter<FavoriteDuaViewHolder> {

    private LayoutInflater mLayoutInflator;
    private DuaItemDelegate duaItemDelegate;
    private List<Dua> favDuaList;
    FavSharedPreference s = new FavSharedPreference();

    public FavoriteDuaAdapter(Context context, DuaItemDelegate duaItemDelegate, List<Dua> duaTitleListByCategoryId) {
        mLayoutInflator = LayoutInflater.from(context);
        this.duaItemDelegate = duaItemDelegate;
        this.favDuaList = duaTitleListByCategoryId;
//        this.context=context;

    }

    @Override
    public FavoriteDuaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflator.inflate(R.layout.favorite_dua_item, parent, false);

        return new FavoriteDuaViewHolder(v, duaItemDelegate, favDuaList);
    }

    public void remove(Context context, int position) {

        s.removeFavorite(context, position);
        favDuaList.remove(favDuaList.get(position));

        notifyDataSetChanged();

    }

    @Override
    public void onBindViewHolder(FavoriteDuaViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return favDuaList == null ? 0 : favDuaList.size();


    }
}
