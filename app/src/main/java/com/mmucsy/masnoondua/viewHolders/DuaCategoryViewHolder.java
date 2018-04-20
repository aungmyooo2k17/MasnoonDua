package com.mmucsy.masnoondua.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mmucsy.masnoondua.MasnoonDuaApp;
import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.data.models.Category;
import com.mmucsy.masnoondua.delegates.DuaCategoryItemDelegate;



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

    @BindView(R.id.tv_category)
    TextView tvCategory;

    @BindView(R.id.iv_category_type)
    ImageView ivCategoryType;


    public DuaCategoryViewHolder(View itemView, DuaCategoryItemDelegate duaCategoryItemDelegate, List<Category> categoryList) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        this.duaCategoryItemDelegate = duaCategoryItemDelegate;
        this.categoryList = categoryList;
        itemView.setOnClickListener(this);


    }


    public void bind(int position) {
        pos = position;
        tvCategory.setTypeface(MasnoonDuaApp.typeface);
        tvCategory.setText(categoryList.get(position).getCategory() + "");
        int i = categoryList.get(position).getCategory_id();
        if (i == 1) {
            ivCategoryType.setImageDrawable(itemView.getContext().getResources().getDrawable(R.drawable.social));
        }else if(i == 2){
            ivCategoryType.setImageDrawable(itemView.getContext().getResources().getDrawable(R.drawable.trip));
        }else if(i == 3){
            ivCategoryType.setImageDrawable(itemView.getContext().getResources().getDrawable(R.drawable.namaz));
        }else if(i == 4){
            ivCategoryType.setImageDrawable(itemView.getContext().getResources().getDrawable(R.drawable.food));
        }else if(i == 5){
            ivCategoryType.setImageDrawable(itemView.getContext().getResources().getDrawable(R.drawable.daily));
        }else if(i == 6){
            ivCategoryType.setImageDrawable(itemView.getContext().getResources().getDrawable(R.drawable.weather));
        }

    }


    @Override
    public void onClick(View v) {
        duaCategoryItemDelegate.onTapDuaCategory(categoryList.get(pos).getCategory_id());
    }
}
