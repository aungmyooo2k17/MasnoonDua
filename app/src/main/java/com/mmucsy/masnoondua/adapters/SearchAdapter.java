package com.mmucsy.masnoondua.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.SharedPreference.FavSharedPreference;
import com.mmucsy.masnoondua.data.models.Dua;
import com.mmucsy.masnoondua.delegates.SearchItemDelegate;
import com.mmucsy.masnoondua.viewHolders.SearchViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aungmyooo on 4/10/18.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    private LayoutInflater mLayoutInflator;
    private SearchItemDelegate searchItemDelegate;
    private List<String> duaList;
    private List<String> filteredData;
    private List<Integer> duaIdList;
    private FavSharedPreference s = new FavSharedPreference();
//    private ItemFilter mFilter = new ItemFilter();
    private ArrayList<Dua> filteredList = new ArrayList<>();
    private ArrayList<Dua> duaArrayList = new ArrayList<>();


    public SearchAdapter(Context context, SearchItemDelegate searchItemDelegate, ArrayList<Dua> duaList) {
        mLayoutInflator = LayoutInflater.from(context);
        this.searchItemDelegate = searchItemDelegate;
        this.duaArrayList = duaList;
//        this.duaIdList = duaIdList;
        this.filteredList = duaList;

    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflator.inflate(R.layout.favorite_dua_item, parent, false);

        return new SearchViewHolder(v, searchItemDelegate, duaArrayList);
    }


    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return filteredList.size();


    }

    public void swipeList(ArrayList<Dua> duaList) {
        this.duaArrayList = duaList;
        this.filteredList = duaList;
//        Log.i("Patient : ", this.duaList.size() + "");
//        Log.i("Filter List : ", this.filteredList.size() + "");
        notifyDataSetChanged();
    }


}