package com.mmucsy.masnoondua.viewHolders;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.mmucsy.masnoondua.MasnoonDuaApp;
import com.mmucsy.masnoondua.delegates.DuaCategoryItemDelegate;

/**
 * Created by aungmyooo on 2/14/18.
 */

public class DuaCategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private DuaCategoryItemDelegate duaCategoryItemDelegate;

    public DuaCategoryViewHolder(View itemView, DuaCategoryItemDelegate duaCategoryItemDelegate) {
        super(itemView);
        this.duaCategoryItemDelegate = duaCategoryItemDelegate;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d(MasnoonDuaApp.TAG, "onClick: ");
    }
}
