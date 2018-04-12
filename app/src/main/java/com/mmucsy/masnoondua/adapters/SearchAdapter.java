package com.mmucsy.masnoondua.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.mmucsy.masnoondua.R;
import com.mmucsy.masnoondua.FavSharedPreference;
import com.mmucsy.masnoondua.delegates.DuaItemDelegate;
import com.mmucsy.masnoondua.delegates.SearchItemDelegate;
import com.mmucsy.masnoondua.viewHolders.SearchViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aungmyooo on 4/10/18.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> implements Filterable {

    private LayoutInflater mLayoutInflator;
    private SearchItemDelegate searchItemDelegate;
    private List<String> duaList;
    private List<String> filteredData;
    private List<Integer> duaIdList;
    private FavSharedPreference s = new FavSharedPreference();
    private ItemFilter mFilter = new ItemFilter();

    public SearchAdapter(Context context, SearchItemDelegate searchItemDelegate, List<String> duaList, List<Integer> duaIdList) {
        mLayoutInflator = LayoutInflater.from(context);
        this.searchItemDelegate = searchItemDelegate;
        this.duaList = duaList;
        this.duaIdList = duaIdList;
        this.filteredData = duaList;

    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflator.inflate(R.layout.favorite_dua_item, parent, false);

        return new SearchViewHolder(v, searchItemDelegate, duaList, duaIdList);
    }


    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return filteredData.size();


    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    private void filter(String text) {
        //new array list that will hold the filtered data
        ArrayList<String> filterdNames = new ArrayList<>();

        //looping through existing elements
        for (String s : duaList) {
            //if the existing elements contains the search input
            if (s.toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list

                filterdNames.add(s);
            }
        }

    }

    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            String filterString = constraint.toString().toLowerCase();

            FilterResults results = new FilterResults();

            final List<String> list = duaList;

            int count = list.size();
            final ArrayList<String> nlist = new ArrayList<String>(count);

            String filterableString ;

            for (int i = 0; i < count; i++) {
                filterableString = list.get(i);
                if (filterableString.toLowerCase().contains(filterString)) {
                    nlist.add(filterableString);
                }
            }

            results.values = nlist;
            results.count = nlist.size();

            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredData = (ArrayList<String>) results.values;
            notifyDataSetChanged();
        }

    }
}