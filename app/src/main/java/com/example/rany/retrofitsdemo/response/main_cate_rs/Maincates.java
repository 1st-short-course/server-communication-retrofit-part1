package com.example.rany.retrofitsdemo.response.main_cate_rs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Maincates {
    @SerializedName("id")
    private int id;
    @SerializedName("status")
    private boolean status;
    @SerializedName("cate_name")
    private String cateName;
    @SerializedName("des")
    private String des;
    @SerializedName("icon_name")
    private String iconName;
    @SerializedName("sub_cate")
    private List<SubCate> subCate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public List<SubCate> getSubCate() {
        return subCate;
    }

    public void setSubCate(List<SubCate> subCate) {
        this.subCate = subCate;
    }
}
