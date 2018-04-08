package com.mmucsy.masnoondua.data.models;

/**
 * Created by aungmyooo on 2/21/18.
 */
public class Category {
     private int category_id;

    private String category;

    public Category() {
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
