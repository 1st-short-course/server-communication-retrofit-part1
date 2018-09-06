package com.example.rany.retrofitsdemo.response.sub_categories_rs;

import com.google.gson.annotations.SerializedName;

public class Subcates {
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
    @SerializedName("total_url")
    private int totalUrl;

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

    public int getTotalUrl() {
        return totalUrl;
    }

    public void setTotalUrl(int totalUrl) {
        this.totalUrl = totalUrl;
    }
}
