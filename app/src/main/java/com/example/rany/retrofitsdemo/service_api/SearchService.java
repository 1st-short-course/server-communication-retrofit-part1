package com.example.rany.retrofitsdemo.service_api;

import com.example.rany.retrofitsdemo.request.AddMainCateForm;
import com.example.rany.retrofitsdemo.response.main_cate_rs.MainCategoriesResponse;
import com.example.rany.retrofitsdemo.response.new_main_categories_rs.NewMainCateRS;
import com.example.rany.retrofitsdemo.response.sub_categories_rs.SubCateResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SearchService {

    // GET MAIN CATEGORIES
    @GET("categories")
    Call<MainCategoriesResponse> getAllMainCategories();

    // GET SUBCATE FROM MAINCATE
    @GET("categories/sub-by-main-id/{id}")
    Call<SubCateResponse> getSubByMainId(@Path("id") int mainId);

    // ADD NEW MAIN CATEGORIES
    @POST("categories/create-main")
    Call<NewMainCateRS> addNewMainCategories(@Body AddMainCateForm form);

}
