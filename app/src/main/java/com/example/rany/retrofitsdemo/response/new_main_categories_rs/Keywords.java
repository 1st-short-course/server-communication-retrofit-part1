package com.example.rany.retrofitsdemo.response.new_main_categories_rs;

import com.google.gson.annotations.SerializedName;

public class Keywords {
    @SerializedName("id")
    private int id;
    @SerializedName("status")
    private boolean status;
    @SerializedName("keyword_name")
    private String keyword_name;
    @SerializedName("cate_id")
    private String cate_id;

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

    public String getKeyword_name() {
        return keyword_name;
    }

    public void setKeyword_name(String keyword_name) {
        this.keyword_name = keyword_name;
    }

    public String getCate_id() {
        return cate_id;
    }

    public void setCate_id(String cate_id) {
        this.cate_id = cate_id;
    }
}
