package com.example.rany.retrofitsdemo.response.main_cate_rs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainCategoriesResponse {

    @SerializedName("code")
    private String code;
    @SerializedName("status")
    private boolean status;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private List<Maincates> maincates;

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

    public List<Maincates> getMaincates() {
        return maincates;
    }

    public void setMaincates(List<Maincates> maincates) {
        this.maincates = maincates;
    }
}
