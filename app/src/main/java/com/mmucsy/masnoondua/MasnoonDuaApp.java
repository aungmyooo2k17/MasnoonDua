package com.mmucsy.masnoondua;

import android.app.Application;

import com.mmucsy.masnoondua.data.db.DatabaseAccess;
import com.mmucsy.masnoondua.data.models.Category;
import com.mmucsy.masnoondua.data.models.Dua;

import java.util.List;

/**
 * Created by aungmyooo on 2/14/18.
 */

public class MasnoonDuaApp extends Application {
    public static final String TAG = "MasnoonDua";
    public static List<Category> categoryList;
    public static List<String> duaTitleList;
    public static List<String> duaArbicList;
    public static List<Dua> duaList;

    public static DatabaseAccess databaseAccess;
    public static SharedPreference sharedPreference;
    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreference=new SharedPreference();
        databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        categoryList = databaseAccess.getCategory();
        duaTitleList = databaseAccess.getDuaTitle();
        duaArbicList = databaseAccess.getDuaArbic();
        duaList = sharedPreference.getFavorites(this);
        databaseAccess.close();
    }
}
