package com.example.rany.retrofitsdemo.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AddMainCateForm {

    @SerializedName("cate_name")
    private String cateName;
    @SerializedName("des")
    private String des;
    @SerializedName("icon_name")
    private String iconName;
    @SerializedName("id")
    private int id;
    @SerializedName("keywords")
    private List<String> tags;
    @SerializedName("status")
    private boolean status;

    public AddMainCateForm(String cateName, String des, String iconName, int id, List<String> tags, boolean status) {
        this.cateName = cateName;
        this.des = des;
        this.iconName = iconName;
        this.id = id;
        this.tags = tags;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
