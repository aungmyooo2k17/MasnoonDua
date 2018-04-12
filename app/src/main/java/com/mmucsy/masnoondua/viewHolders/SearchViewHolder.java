package com.mmucsy.masnoondua.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mmucsy.masnoondua.MasnoonDuaApp;
import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.data.models.Dua;
import com.mmucsy.masnoondua.delegates.DuaItemDelegate;
import com.mmucsy.masnoondua.delegates.SearchItemDelegate;

import net.aungpyaephyo.mmtextview.components.MMTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aungmyooo on 4/10/18.
 */

public class SearchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.fav_dua_title)
    TextView favDuaTitle;


    private SearchItemDelegate searchItemDelegate;
    private List<String> duaTitleListByCategoryId;
    private List<Integer> duaIdList;
    private int pos;


    public SearchViewHolder(View itemView, SearchItemDelegate searchItemDelegate, List<String> duaTitleListByCategoryId, List<Integer> duaIdList) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        favDuaTitle.setTypeface(MasnoonDuaApp.typeface);

        this.searchItemDelegate = searchItemDelegate;
        this.duaTitleListByCategoryId = duaTitleListByCategoryId;
        this.duaIdList = duaIdList;
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        searchItemDelegate.onTapDua(duaIdList.get(pos));
        Log.d(MasnoonDuaApp.TAG, "onClick: "+duaTitleListByCategoryId.get(pos));

    }

    public void bind(int position) {
        pos = position;
        favDuaTitle.setText(duaTitleListByCategoryId.get(pos)+"");
    }

}