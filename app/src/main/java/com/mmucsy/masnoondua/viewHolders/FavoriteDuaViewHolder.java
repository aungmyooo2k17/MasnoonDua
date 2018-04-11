package com.mmucsy.masnoondua.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mmucsy.masnoondua.MasnoonDuaApp;
import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.data.models.Dua;
import com.mmucsy.masnoondua.delegates.DuaItemDelegate;

import net.aungpyaephyo.mmtextview.components.MMTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by soe_than on 4/9/18.
 */

public class FavoriteDuaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.fav_dua_title)
    TextView favDuaTitle;


    private DuaItemDelegate duaItemDelegate;
    private List<Dua> duaTitleListByCategoryId;
    private int pos;


    public FavoriteDuaViewHolder(View itemView, DuaItemDelegate duaItemDelegate, List<Dua> duaTitleListByCategoryId) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.duaItemDelegate = duaItemDelegate;
        this.duaTitleListByCategoryId = duaTitleListByCategoryId;
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        duaItemDelegate.onTapDua(duaTitleListByCategoryId.get(pos).getDua_id(), pos);


    }

    public void bind(int position) {
        pos = position;
        favDuaTitle.setTypeface(MasnoonDuaApp.typeface);
        favDuaTitle.setText(duaTitleListByCategoryId.get(pos).getDuaTitle());
    }
}
