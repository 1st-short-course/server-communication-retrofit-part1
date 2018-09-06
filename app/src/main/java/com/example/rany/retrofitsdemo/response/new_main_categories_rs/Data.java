package com.example.rany.retrofitsdemo.response.new_main_categories_rs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("id")
    private int id;
    @SerializedName("status")
    private boolean status;
    @SerializedName("keywords")
    private List<Keywords> keywords;
    @SerializedName("cate_name")
    private String cate_name;
    @SerializedName("des")
    private String des;
    @SerializedName("icon_name")
    private String icon_name;
    @SerializedName("main_cate")
    private String main_cate;

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

    public List<Keywords> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keywords> keywords) {
        this.keywords = keywords;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getIcon_name() {
        return icon_name;
    }

    public void setIcon_name(String icon_name) {
        this.icon_name = icon_name;
    }

    public String getMain_cate() {
        return main_cate;
    }

    public void setMain_cate(String main_cate) {
        this.main_cate = main_cate;
    }
}
