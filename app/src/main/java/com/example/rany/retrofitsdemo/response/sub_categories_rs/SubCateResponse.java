package com.example.rany.retrofitsdemo.response.sub_categories_rs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubCateResponse {

    @SerializedName("code")
    private String code;
    @SerializedName("status")
    private boolean status;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private List<Subcates> subcates;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Subcates> getSubcates() {
        return subcates;
    }

    public void setSubcates(List<Subcates> subcates) {
        this.subcates = subcates;
    }
}
