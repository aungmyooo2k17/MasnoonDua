package com.mmucsy.masnoondua;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.mmucsy.masnoondua.data.models.Dua;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aungmyooo on 4/11/18.
 */

public class RecentSharedPreference {

    public static final String PREFS_NAME = "DUA_APP__";
    public static final String RECENT = "RECENT_DUA";

    public RecentSharedPreference() {
        super();
    }

    public void saveRecent(Context context, List<Integer> recent) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(recent);

        editor.putString(RECENT, jsonFavorites);

        editor.commit();
    }


    public void removeFavorite(Context context, int position) {

        ArrayList<Integer> favorites = getRecent(context);
        Log.i("SharefPreference", favorites.size() + "");
        if (favorites != null) {

            if (position < favorites.size()) {
                favorites.remove(favorites.get(position));


            }

            saveRecent(context, favorites);
        }
    }

    public void addRecent(Context context, int duaId) {
//        Log.i("FavSharedPreference", dua.getDua_id() + "");

        List<Integer> favorites = getRecent(context);

        if (favorites == null)
            favorites = new ArrayList<Integer>();
        favorites.add(duaId);

        saveRecent(context, favorites);
    }


    public ArrayList<Integer> getRecent(Context context) {
        SharedPreferences settings;
        List<Integer> favorites;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(RECENT)) {
            String jsonFavorites = settings.getString(RECENT, null);
            Gson gson = new Gson();
            Integer[] favoriteItems = gson.fromJson(jsonFavorites,
                    Integer[].class);

            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<Integer>(favorites);
        } else
            return null;

        return (ArrayList<Integer>) favorites;
    }

    public void removeSharePreference(Context context){
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();
        editor.clear().commit();
    }

}