package com.mmucsy.masnoondua.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mmucsy.masnoondua.delegates.DuaItemDelegate;

/**
 * Created by aungmyooo on 2/14/18.
 */

public class DuaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private DuaItemDelegate duaItemDelegate;

    public DuaViewHolder(View itemView, DuaItemDelegate duaItemDelegate) {
        super(itemView);
        this.duaItemDelegate = duaItemDelegate;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        duaItemDelegate.onTapDua();
    }
}
