package com.mmucsy.masnoondua.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.adapters.DuaCategoryAdapter;
import com.mmucsy.masnoondua.delegates.DuaCategoryItemDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements DuaCategoryItemDelegate{

    @BindView(R.id.rv_category)RecyclerView recyclerViewCategory;

    private DuaCategoryAdapter duaCategoryAdapter;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, v);

        duaCategoryAdapter = new DuaCategoryAdapter(getContext(), this);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerViewCategory.setAdapter(duaCategoryAdapter);


        return v;
    }

    @Override
    public void onTapDuaCategory() {

    }
}
