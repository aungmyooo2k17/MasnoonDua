package com.mmucsy.masnoondua.data.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mmucsy.masnoondua.MasnoonDuaApp;
import com.mmucsy.masnoondua.data.models.Category;
import com.mmucsy.masnoondua.data.models.Dua;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by aungmyooo on 4/6/18.
 */

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }


    public List<Category> getCategory() {
        List<Category> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM category", null);
        cursor.moveToFirst();
        if(cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Category category = new Category();
                category.setCategory_id(cursor.getInt(0));
                category.setCategory(cursor.getString(1));
                list.add(category);
                Log.d(MasnoonDuaApp.TAG, "getCategory: " + cursor.getInt(0) + cursor.getString(1));

                cursor.moveToNext();
            }
        }
        cursor.close();
        return list;
    }

    public List<String> getDuaTitle() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT dua_title FROM dua", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getDuaArbic() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT dua_arbic FROM dua", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<Dua> getAllDua() {

        List<Dua> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM dua", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Dua dua = new Dua();
            dua.setDua_id(cursor.getInt(0));
            dua.setDuaTitle(cursor.getString(1));
            dua.setDuaArbic(cursor.getString(2));
            dua.setDuaDescription(cursor.getString(3));
            dua.setCategory_id(cursor.getInt(4));
            list.add(dua);

            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }


    public List<Dua> getDuaByCategoryId(int catId) {

        List<Dua> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM dua WHERE category_id = "+catId, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Dua dua = new Dua();
            dua.setDua_id(cursor.getInt(0));
            dua.setDuaTitle(cursor.getString(1));
            dua.setDuaArbic(cursor.getString(2));
            dua.setDuaDescription(cursor.getString(3));
            dua.setCategory_id(cursor.getInt(4));
            list.add(dua);

            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<Dua> getDuaById(List<Integer> duId){
        List<Dua> duaList = new ArrayList<>();
        if(duId != null) {
            HashSet<Integer> hashSet = new HashSet<Integer>();
            hashSet.addAll(duId);
            duId.clear();
            duId.addAll(hashSet);
        }

        if(duId != null) {
            for (int i : duId) {
                Cursor cursor = database.rawQuery("SELECT * FROM dua WHERE dua_id = " + i, null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    Dua dua = new Dua();
                    dua.setDua_id(cursor.getInt(0));
                    dua.setDuaTitle(cursor.getString(1));
                    dua.setDuaArbic(cursor.getString(2));
                    dua.setDuaDescription(cursor.getString(3));
                    dua.setCategory_id(cursor.getInt(4));
                    duaList.add(dua);

                    cursor.moveToNext();
                }
                cursor.close();
            }
        }

        return duaList;

    }

    public List<Dua> getDuaByPosition(int duaId) {

        List<Dua> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM dua WHERE dua_id = "+duaId, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Dua dua = new Dua();
            dua.setDua_id(cursor.getInt(0));
            dua.setDuaTitle(cursor.getString(1));
            dua.setDuaArbic(cursor.getString(2));
            dua.setDuaDescription(cursor.getString(3));
            dua.setCategory_id(cursor.getInt(4));
            list.add(dua);

            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<Dua> getDuaByDuaTitle(String duaPosition) {

        List<Dua> list = new ArrayList<>();
        Log.d(MasnoonDuaApp.TAG, "getDuaByDuaTitle: "+duaPosition);
        Cursor cursor = database.rawQuery("SELECT * FROM dua WHERE dua_title = "+duaPosition, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Dua dua = new Dua();
            dua.setDua_id(cursor.getInt(0));
            dua.setDuaTitle(cursor.getString(1));
            dua.setDuaArbic(cursor.getString(2));
            dua.setDuaDescription(cursor.getString(3));
            dua.setCategory_id(cursor.getInt(4));
            list.add(dua);

            cursor.moveToNext();
        }
        cursor.close();
        return list;

    }
//    public ArrayList<Dua> getFavorites(Context context) {
//        SharedPreferences settings;
//        List<Dua> favorites;
//
//        settings = context.getSharedPreferences(PREFS_NAME,
//                Context.MODE_PRIVATE);
//
//        if (settings.contains(FAVORITES)) {
//            String jsonFavorites = settings.getString(FAVORITES, null);
//            Gson gson = new Gson();
//            Dua[] favoriteItems = gson.fromJson(jsonFavorites,
//                    Dua[].class);
//
//            favorites = Arrays.asList(favoriteItems);
//            favorites = new ArrayList<Dua>(favorites);
//        } else
//            return null;
//
//        return (ArrayList<Dua>) favorites;
//    }







}