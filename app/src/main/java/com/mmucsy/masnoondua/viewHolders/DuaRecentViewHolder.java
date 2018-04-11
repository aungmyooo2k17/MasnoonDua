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

import net.aungpyaephyo.mmtextview.components.MMTextView;

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

    @BindView(R.id.tv_dua)
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
            Glide.with(itemView.getContext()).load(itemView.getContext().getResources().getDrawable(R.drawable.social)).into(ivDuaRecent);
        } else if (i == 2) {
            Glide.with(itemView.getContext()).load(itemView.getContext().getResources().getDrawable(R.drawable.trip)).into(ivDuaRecent);
        } else if (i == 3) {
            Glide.with(itemView.getContext()).load(itemView.getContext().getResources().getDrawable(R.drawable.namaz)).into(ivDuaRecent);
        } else if (i == 4) {
            Glide.with(itemView.getContext()).load(itemView.getContext().getResources().getDrawable(R.drawable.food)).into(ivDuaRecent);
        } else if (i == 5) {
            Glide.with(itemView.getContext()).load(itemView.getContext().getResources().getDrawable(R.drawable.daily)).into(ivDuaRecent);
        } else if (i == 6) {
            Glide.with(itemView.getContext()).load(itemView.getContext().getResources().getDrawable(R.drawable.weather)).into(ivDuaRecent);
        }
    }


}
