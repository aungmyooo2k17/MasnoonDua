package com.mmucsy.masnoondua;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mmucsy.masnoondua.adapters.FavoriteDuaAdapter;
import com.mmucsy.masnoondua.data.models.Dua;
import com.mmucsy.masnoondua.fragments.FavouriteFragment;
import com.mmucsy.masnoondua.fragments.FavouriteFragment_ViewBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by soe_than on 4/8/18.
 */

public class FavSharedPreference {

    public static final String PREFS_NAME = "DUA_APP";
    public static final String FAVORITES = "Favourite_DUA";

    public FavSharedPreference() {
        super();
    }

    public void saveFavorites(Context context, List<Dua> favorites) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(FAVORITES, jsonFavorites);

        editor.commit();
    }


    public void removeFavorite(Context context, int position) {

        ArrayList<Dua> favorites = getFavorites(context);
        Log.i("SharefPreference", favorites.size() + "");
        if (favorites != null) {

            if (position < favorites.size()) {
                favorites.remove(favorites.get(position));


            }

            saveFavorites(context, favorites);
        }
    }

    public void addFavorite(Context context, Dua dua) {
        Log.i("FavSharedPreference", dua.getDua_id() + "");

        List<Dua> favorites = getFavorites(context);

        if (favorites == null)
            favorites = new ArrayList<Dua>();
        favorites.add(dua);
        Toast.makeText(context, "Added To Favourite", Toast.LENGTH_LONG).show();

        saveFavorites(context, favorites);
    }


    public ArrayList<Dua> getFavorites(Context context) {
        SharedPreferences settings;
        List<Dua> favorites;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(FAVORITES)) {
            String jsonFavorites = settings.getString(FAVORITES, null);
            Gson gson = new Gson();
            Dua[] favoriteItems = gson.fromJson(jsonFavorites,
                    Dua[].class);

            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<Dua>(favorites);
        } else
            return null;

        return (ArrayList<Dua>) favorites;
    }
}
