package com.mmucsy.masnoondua.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

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
    MMTextView tvDuaTitle;

    @BindView(R.id.tv_dua)
    TextView tvDuaArbic;


    public DuaRecentViewHolder(View itemView, DuaRecentItemDelegate duaRecentItemDelegate, List<Dua> duaList) {
        super(itemView);

        ButterKnife.bind(this, itemView);

        this.duaRecentItemDelegate = duaRecentItemDelegate;
//        this.duaTitleList = duaTitleList;
//        this.duaArbicList = duaArbicList;
        this.duaList = duaList;

    }

    public void bind(int position) {
        tvDuaTitle.setText(duaList.get(position).getDuaTitle());
        tvDuaArbic.setText(duaList.get(position).getDuaArbic());
    }


}
