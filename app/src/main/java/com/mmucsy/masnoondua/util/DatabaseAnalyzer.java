//package com.mmucsy.masnoondua.util;
//
//import android.os.AsyncTask;
//import android.support.annotation.NonNull;
//import android.util.Log;
//
//import com.mmucsy.masnoondua.data.db.AppDatabase;
//import com.mmucsy.masnoondua.data.vos.Category;
//
//import java.util.List;
//
///**
// * Created by aungmyooo on 2/21/18.
// */
//
//public class DatabaseAnalyzer {
//
//
//    public static void populateAsync(@NonNull final AppDatabase db) {
//        PopulateDbAsync task = new PopulateDbAsync(db);
//        task.execute();
//    }
//
//    public static void populateSync(@NonNull final AppDatabase db) {
//        loadCategory(db);
//    }
//
//    private static Category addCategory(final AppDatabase db, Category category) {
//        db.duaDao().insertAll(category);
//        return category;
//    }
//
//    private static void loadCategory(AppDatabase db) {
//        Category category = new Category();
//        category.setCategory("Hello");
//        addCategory(db, category);
//
//        category.setCategory("Hello1");
//        addCategory(db, category);
//
//        category.setCategory("Hello2");
//        addCategory(db, category);
//
//        category.setCategory("Hello3");
//        addCategory(db, category);
//
//        category.setCategory("Hello4");
//        addCategory(db, category);
//
//        category.setCategory("Hello5");
//        addCategory(db, category);
//
//        List<Category> categoryList = db.duaDao().getAllCategory();
//    }
//
//    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
//
//        private final AppDatabase mDb;
//
//        PopulateDbAsync(AppDatabase db) {
//            mDb = db;
//        }
//
//        @Override
//        protected Void doInBackground(final Void... params) {
//            loadCategory(mDb);
//            return null;
//        }
//
//    }
//
//}
