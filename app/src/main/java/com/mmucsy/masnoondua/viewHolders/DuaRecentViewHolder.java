package com.mmucsy.masnoondua.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mmucsy.masnoondua.MasnoonDuaApp;
import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.data.models.Dua;
import com.mmucsy.masnoondua.delegates.DuaRecentItemDelegate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aungmyooo on 2/18/18.
 */

public class DuaRecentViewHolder extends RecyclerView.ViewHolder {

    private DuaRecentItemDelegate duaRecentItemDelegate;
//    private List<String> duaTitleList;
//    private List<String> duaArbicList;

    private List<Dua> duaList;

    @BindView(R.id.tv_dua_title)
    TextView tvDuaTitle;

    @BindView(R.id.tv_dua_s)
    TextView tvDuaArbic;

    @BindView(R.id.iv_dua_recent)
    ImageView ivDuaRecent;


    public DuaRecentViewHolder(View itemView, DuaRecentItemDelegate duaRecentItemDelegate, List<Dua> duaList) {
        super(itemView);

        ButterKnife.bind(this, itemView);

        this.duaRecentItemDelegate = duaRecentItemDelegate;
        this.duaList = duaList;

    }

    public void bind(int position) {
        tvDuaTitle.setTypeface(MasnoonDuaApp.typeface);
        tvDuaTitle.setText(duaList.get(position).getDuaTitle());
        tvDuaArbic.setText(duaList.get(position).getDuaArbic());
        int i = duaList.get(position).getCategory_id();
        if (i == 1) {
            ivDuaRecent.setImageDrawable(itemView.getContext().getResources().getDrawable(R.drawable.social));
        }else if(i == 2){
            ivDuaRecent.setImageDrawable(itemView.getContext().getResources().getDrawable(R.drawable.trip));
        }else if(i == 3){
            ivDuaRecent.setImageDrawable(itemView.getContext().getResources().getDrawable(R.drawable.namaz));
        }else if(i == 4){
            ivDuaRecent.setImageDrawable(itemView.getContext().getResources().getDrawable(R.drawable.food));
        }else if(i == 5){
            ivDuaRecent.setImageDrawable(itemView.getContext().getResources().getDrawable(R.drawable.daily));
        }else if(i == 6){
            ivDuaRecent.setImageDrawable(itemView.getContext().getResources().getDrawable(R.drawable.weather));
        }
    }


}
