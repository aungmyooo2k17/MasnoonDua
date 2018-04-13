package com.mmucsy.masnoondua.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mmucsy.masnoondua.FavSharedPreference;
import com.mmucsy.masnoondua.MasnoonDuaApp;
import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.activities.DuaDetailActivity;
import com.mmucsy.masnoondua.adapters.DuaAdapter;
import com.mmucsy.masnoondua.adapters.FavoriteDuaAdapter;
import com.mmucsy.masnoondua.data.models.Dua;
import com.mmucsy.masnoondua.delegates.DuaItemDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.security.AccessController.getContext;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouriteFragment extends Fragment implements DuaItemDelegate {

    @BindView(R.id.rv_favourite)
    RecyclerView recyclerViewFavourite;

    @BindView(R.id.rl_not_have_fav)
    RelativeLayout rlNotHaveFav;

    @BindView(R.id.tv_no_fav)
    TextView tvNoFav;


    public FavoriteDuaAdapter duaAdapter;
    private FavSharedPreference favSharedPreference = new FavSharedPreference();


    public FavouriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_favourite, container, false);
        ButterKnife.bind(this, v);

        tvNoFav.setTypeface(MasnoonDuaApp.typeface);


        duaAdapter = new FavoriteDuaAdapter(getContext(), this, favSharedPreference.getFavorites(getActivity()));
        recyclerViewFavourite.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerViewFavourite.setAdapter(duaAdapter);
        if (favSharedPreference.getFavorites(getContext()) == null) {
            recyclerViewFavourite.setVisibility(View.INVISIBLE);
            rlNotHaveFav.setVisibility(View.VISIBLE);
        } else {
            recyclerViewFavourite.setVisibility(View.VISIBLE);
            rlNotHaveFav.setVisibility(View.INVISIBLE);
        }


        return v;
    }



    @Override
    public void onTapDua(int pos, int itemPos) {
        Log.i("FavoriteDuaAdapter", itemPos + "");
        Intent i = new Intent(getContext(), DuaDetailActivity.class);
        i.putExtra("ONTAP_POS", itemPos);
        i.putExtra("DUA_CATEGORY", 00);
        getContext().startActivity(i);


    }


    @Override
    public void onStart() {
        super.onStart();
        duaAdapter = new FavoriteDuaAdapter(getContext(), this, favSharedPreference.getFavorites(getActivity()));
        recyclerViewFavourite.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerViewFavourite.setAdapter(duaAdapter);
        if (favSharedPreference.getFavorites(getContext()).size() == 0) {
            recyclerViewFavourite.setVisibility(View.INVISIBLE);
            rlNotHaveFav.setVisibility(View.VISIBLE);
        } else {
            recyclerViewFavourite.setVisibility(View.VISIBLE);
            rlNotHaveFav.setVisibility(View.INVISIBLE);
        }

    }
}
