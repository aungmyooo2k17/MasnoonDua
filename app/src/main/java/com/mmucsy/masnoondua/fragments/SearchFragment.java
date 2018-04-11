package com.mmucsy.masnoondua.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.mmucsy.masnoondua.MasnoonDuaApp;
import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.activities.DuaDetailActivity;
import com.mmucsy.masnoondua.adapters.FavoriteDuaAdapter;
import com.mmucsy.masnoondua.adapters.SearchAdapter;
import com.mmucsy.masnoondua.delegates.DuaItemDelegate;
import com.mmucsy.masnoondua.delegates.SearchItemDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements SearchItemDelegate{

    @BindView(R.id.rv_search_list)
    RecyclerView rvSearch;

    @BindView(R.id.edit_text_search)
    EditText editTextSearch;

    private SearchAdapter duaAdapter;


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, v);

        duaAdapter = new SearchAdapter(getContext(), this, MasnoonDuaApp.duaTitleList);
        rvSearch.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvSearch.setAdapter(duaAdapter);

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                duaAdapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                duaAdapter.getFilter().filter(s.toString());
            }
        });


        return v;
    }

    @Override
    public void onTapDua(String s) {
        Intent i = new Intent(getContext(), DuaDetailActivity.class);
        i.putExtra("ONTAP_POS", s);
        i.putExtra("DUA_CATEGORY", 000);
        getContext().startActivity(i);
    }
}
