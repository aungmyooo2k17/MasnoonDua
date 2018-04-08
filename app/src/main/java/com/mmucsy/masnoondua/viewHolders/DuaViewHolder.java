package com.mmucsy.masnoondua.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.data.models.Dua;
import com.mmucsy.masnoondua.delegates.DuaItemDelegate;

import net.aungpyaephyo.mmtextview.components.MMTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aungmyooo on 2/14/18.
 */

public class DuaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private DuaItemDelegate duaItemDelegate;
    private List<Dua> duaTitleListByCategoryId;
    private int pos;

    @BindView(R.id.tv_dua_title)MMTextView tvDuaTitle;

    public DuaViewHolder(View itemView, DuaItemDelegate duaItemDelegate, List<Dua> duaTitleListByCategoryId) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.duaItemDelegate = duaItemDelegate;
        this.duaTitleListByCategoryId = duaTitleListByCategoryId;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        duaItemDelegate.onTapDua(duaTitleListByCategoryId.get(pos).getDua_id(), pos);
    }

    public void bind(int position){
        pos = position;
        tvDuaTitle.setText(duaTitleListByCategoryId.get(position).getDuaTitle());
    }
}
