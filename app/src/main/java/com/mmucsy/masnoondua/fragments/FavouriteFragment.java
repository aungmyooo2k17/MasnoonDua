package com.mmucsy.masnoondua.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mmucsy.masnoondua.MasnoonDuaApp;
import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.SharedPreference;
import com.mmucsy.masnoondua.adapters.DuaAdapter;
import com.mmucsy.masnoondua.adapters.FavoriteDuaAdapter;
import com.mmucsy.masnoondua.delegates.DuaItemDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouriteFragment extends Fragment implements DuaItemDelegate {

    @BindView(R.id.rv_favourite)
    RecyclerView recyclerViewFavourite;

    private FavoriteDuaAdapter duaAdapter;
    SharedPreference sharedPreference = new SharedPreference();


    public FavouriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_favourite, container, false);
        ButterKnife.bind(this, v);

        duaAdapter = new FavoriteDuaAdapter(getContext(), this, sharedPreference.getFavorites(getActivity()));
        recyclerViewFavourite.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerViewFavourite.setAdapter(duaAdapter);

        return v;
    }

    @Override
    public void onTapDua(int pos, int itemPos) {
        Log.i("FavoriteDuaAdapter",itemPos+"");
        duaAdapter.remove(getActivity(),itemPos);


//        sharedPreference.removeFavorite(getActivity(),itemPos);
//        duaAdapter.notifyItemRemoved(itemPos);
//        duaAdapter.notifyItemRangeChanged(itemPos, sharedPreference.getFavorites(getActivity()).size());



    }
}
