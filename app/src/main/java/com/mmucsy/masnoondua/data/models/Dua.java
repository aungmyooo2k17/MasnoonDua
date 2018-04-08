package com.mmucsy.masnoondua.data.models;
/*
 * Created by aungmyooo on 2/21/18.
 */

public class Dua {
    private int dua_id;

    private String duaTitle;

    private String duaArbic;

    private String duaDescription;

    private int category_id;

    public Dua() {

    }

    public Dua(String duaTitle, String duaArbic, String duaDescription, int category_id) {
        this.duaTitle = duaTitle;
        this.duaArbic = duaArbic;
        this.duaDescription = duaDescription;
        this.category_id = category_id;
    }

    public int getDua_id() {
        return dua_id;
    }

    public String getDuaTitle() {
        return duaTitle;
    }

    public String getDuaArbic() {
        return duaArbic;
    }

    public String getDuaDescription() {
        return duaDescription;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setDua_id(int dua_id) {
        this.dua_id = dua_id;
    }

    public void setDuaTitle(String duaTitle) {
        this.duaTitle = duaTitle;
    }

    public void setDuaArbic(String duaArbic) {
        this.duaArbic = duaArbic;
    }

    public void setDuaDescription(String duaDescription) {
        this.duaDescription = duaDescription;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
