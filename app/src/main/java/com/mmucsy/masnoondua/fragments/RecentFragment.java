package com.mmucsy.masnoondua.fragments;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mmucsy.masnoondua.MasnoonDuaApp;
import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.RecentSharedPreference;
import com.mmucsy.masnoondua.adapters.DuaAdapter;
import com.mmucsy.masnoondua.adapters.DuaRecentAdapter;
import com.mmucsy.masnoondua.data.db.DatabaseAccess;
import com.mmucsy.masnoondua.data.models.Dua;
import com.mmucsy.masnoondua.delegates.DuaItemDelegate;
import com.mmucsy.masnoondua.delegates.DuaRecentItemDelegate;
import com.mmucsy.masnoondua.delegates.MainPageItemDelegate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecentFragment extends Fragment implements DuaRecentItemDelegate {

    @BindView(R.id.rv_recent)
    RecyclerView recyclerViewRecent;

    @BindView(R.id.fl_delete)
    FloatingActionButton floatingActionButtonDelete;

    @BindView(R.id.rl_have_recent)
    RelativeLayout rlHaveRecent;

    @BindView(R.id.rl_not_have_recent)
    RelativeLayout rlNotHaveRecent;

    @BindView(R.id.tv_no_recent)
    TextView tvNoRecent;

    private MainPageItemDelegate mMainPageItemDelegate;

    private DuaRecentAdapter duaRecentAdapter;
    private RecentSharedPreference recentSharedPreference;
    private DatabaseAccess databaseAccess;
    private List<Dua> duaList;


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

        tvNoRecent.setTypeface(MasnoonDuaApp.typeface);

        recentSharedPreference = new RecentSharedPreference();
        databaseAccess = DatabaseAccess.getInstance(getContext());
        databaseAccess.open();
        duaList = databaseAccess.getDuaById(recentSharedPreference.getRecent(getContext()));
        databaseAccess.close();

        duaRecentAdapter = new DuaRecentAdapter(getContext(), this, duaList);
        recyclerViewRecent.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerViewRecent.setAdapter(duaRecentAdapter);

        if (duaList.isEmpty()){
            rlHaveRecent.setVisibility(View.INVISIBLE);
            rlNotHaveRecent.setVisibility(View.VISIBLE);
        }else {
            rlHaveRecent.setVisibility(View.VISIBLE);
            rlNotHaveRecent.setVisibility(View.INVISIBLE);
        }

        floatingActionButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(getContext());
                }
                builder.setTitle("Delete Recent Items")
                        .setMessage("Are you sure you want to delete this recent items?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                recentSharedPreference.removeSharePreference(getContext());
                                duaRecentAdapter.notifyDataSetChanged();
                                databaseAccess = DatabaseAccess.getInstance(getContext());
                                databaseAccess.open();
                                duaList = databaseAccess.getDuaById(recentSharedPreference.getRecent(getContext()));
                                databaseAccess.close();
                                if (duaList.isEmpty()){
                                    rlHaveRecent.setVisibility(View.INVISIBLE);
                                    rlNotHaveRecent.setVisibility(View.VISIBLE);
                                }else {
                                    rlHaveRecent.setVisibility(View.VISIBLE);
                                    rlNotHaveRecent.setVisibility(View.INVISIBLE);
                                }
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

        return v;
    }


    @Override
    public void onTapDuaRecentItem() {

    }
}
