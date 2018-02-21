package com.mmucsy.masnoondua.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mmucsy.masnoondua.delegates.DuaRecentItemDelegate;

/**
 * Created by aungmyooo on 2/18/18.
 */

public class DuaRecentViewHolder extends RecyclerView.ViewHolder {

    private DuaRecentItemDelegate duaRecentItemDelegate;


    public DuaRecentViewHolder(View itemView, DuaRecentItemDelegate duaRecentItemDelegate) {
        super(itemView);
        this.duaRecentItemDelegate = duaRecentItemDelegate;
    }


}
