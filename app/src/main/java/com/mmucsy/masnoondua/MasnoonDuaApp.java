package com.mmucsy.masnoondua;

import android.app.Application;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;

import com.mmucsy.masnoondua.data.db.DatabaseAccess;
import com.mmucsy.masnoondua.data.models.Category;
import com.mmucsy.masnoondua.data.models.Dua;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by aungmyooo on 2/14/18.
 */

public class MasnoonDuaApp extends Application {
    public static final String TAG = "MasnoonDua";
    public static List<Category> categoryList;
    public static List<String> duaTitleList;
    public static List<String> duaArbicList;
    public static List<Dua> duaList;
    public static List<Dua> duaAllList;
    public static List<Integer> duasId = new ArrayList<Integer>();
    public static List<Dua> duaById;

    public static DatabaseAccess databaseAccess;
    public static FavSharedPreference favSharedPreference;
    public static RecentSharedPreference recentSharedPreference;
    public static Typeface typeface;
    @Override
    public void onCreate() {
        super.onCreate();
        favSharedPreference =new FavSharedPreference();
        recentSharedPreference = new RecentSharedPreference();
        databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        categoryList = databaseAccess.getCategory();
        duaTitleList = databaseAccess.getDuaTitle();
        duaArbicList = databaseAccess.getDuaArbic();
        duaAllList = databaseAccess.getAllDua();
        duaById = databaseAccess.getDuaById(recentSharedPreference.getRecent(this));
        duaList = favSharedPreference.getFavorites(this);
        databaseAccess.close();

        AssetManager am = this.getApplicationContext().getAssets();

        typeface = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "ZawgyiOne.ttf"));
    }
}
