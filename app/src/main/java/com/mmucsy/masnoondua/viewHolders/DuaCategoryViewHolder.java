package com.mmucsy.masnoondua.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mmucsy.masnoondua.MasnoonDuaApp;
import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.data.models.Category;
import com.mmucsy.masnoondua.delegates.DuaCategoryItemDelegate;

import net.aungpyaephyo.mmtextview.components.MMTextView;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aungmyooo on 2/14/18.
 */

public class DuaCategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private DuaCategoryItemDelegate duaCategoryItemDelegate;
    private List<Category> categoryList;
    private int pos;

    @BindView(R.id.tv_category)MMTextView tvCategory;


    public DuaCategoryViewHolder(View itemView, DuaCategoryItemDelegate duaCategoryItemDelegate, List<Category> categoryList) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        this.duaCategoryItemDelegate = duaCategoryItemDelegate;
        this.categoryList = categoryList;
        itemView.setOnClickListener(this);



    }


    public void bind(int position){
        pos = position;
        tvCategory.setText(categoryList.get(position).getCategory()+"");
    }


    @Override
    public void onClick(View v) {
        duaCategoryItemDelegate.onTapDuaCategory(categoryList.get(pos).getCategory_id());
    }
}
