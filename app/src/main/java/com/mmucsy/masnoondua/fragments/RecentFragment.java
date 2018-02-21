package com.mmucsy.masnoondua.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.adapters.DuaAdapter;
import com.mmucsy.masnoondua.adapters.DuaRecentAdapter;
import com.mmucsy.masnoondua.delegates.DuaItemDelegate;
import com.mmucsy.masnoondua.delegates.DuaRecentItemDelegate;
import com.mmucsy.masnoondua.delegates.MainPageItemDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecentFragment extends Fragment implements DuaRecentItemDelegate{

    @BindView(R.id.rv_recent)
    RecyclerView recyclerViewRecent;

    private MainPageItemDelegate mMainPageItemDelegate;

    private DuaRecentAdapter duaRecentAdapter;


    public RecentFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mMainPageItemDelegate = (MainPageItemDelegate) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recent, container, false);

        ButterKnife.bind(this, v);

        duaRecentAdapter = new DuaRecentAdapter(getContext(), this);
        recyclerViewRecent.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerViewRecent.setAdapter(duaRecentAdapter);

        return v;
    }


    @Override
    public void onTapDuaRecentItem() {

    }
}
