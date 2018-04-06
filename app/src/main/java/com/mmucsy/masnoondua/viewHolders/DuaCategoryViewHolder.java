package com.mmucsy.masnoondua.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.data.models.Category;
import com.mmucsy.masnoondua.delegates.DuaCategoryItemDelegate;

import net.aungpyaephyo.mmtextview.components.MMTextView;


import butterknife.BindView;

/**
 * Created by aungmyooo on 2/14/18.
 */

public class DuaCategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private DuaCategoryItemDelegate duaCategoryItemDelegate;

    @BindView(R.id.tv_category)MMTextView tvCategory;

    public DuaCategoryViewHolder(View itemView, DuaCategoryItemDelegate duaCategoryItemDelegate) {
        super(itemView);
        this.duaCategoryItemDelegate = duaCategoryItemDelegate;
        itemView.setOnClickListener(this);

    }


    public void bind(Category category){

    }


    @Override
    public void onClick(View v) {
        duaCategoryItemDelegate.onTapDuaCategory();
    }
}
