package com.example.rany.retrofitsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.rany.retrofitsdemo.adapter.MainCateAdapter;
import com.example.rany.retrofitsdemo.callback.OnMainCateItemClickListener;
import com.example.rany.retrofitsdemo.response.main_cate_rs.MainCategoriesResponse;
import com.example.rany.retrofitsdemo.response.main_cate_rs.Maincates;
import com.example.rany.retrofitsdemo.response.main_cate_rs.SubCate;
import com.example.rany.retrofitsdemo.response.sub_categories_rs.SubCateResponse;
import com.example.rany.retrofitsdemo.response.sub_categories_rs.Subcates;
import com.example.rany.retrofitsdemo.service_api.SearchService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements OnMainCateItemClickListener{
    private static final String TAG = "ooooo";
    private Retrofit retrofit;
    private SearchService service;
    private RecyclerView recyclerView;
    private MainCateAdapter adapter;
    public static final String BASE_URL = "http://110.74.194.125:15000/api/v1/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setUpRetrofit();
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainCateAdapter();
        adapter.onClickListenet(this);
        recyclerView.setAdapter(adapter);
        addMain();
    }

    private void setUpRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(SearchService.class);

    }
    private void addMain() {
        Call<MainCategoriesResponse> call = service.getAllMainCategories();
        call.enqueue(new Callback<MainCategoriesResponse>() {
            @Override
            public void onResponse(Call<MainCategoriesResponse> call, Response<MainCategoriesResponse> response) {
                Log.e(TAG, " "+ response.body().getMsg());
                List<Maincates> maincatesList = response.body().getMaincates();
                adapter.getMainCates(maincatesList);
                // GET MAINCATEGORIES NAME
//                        ArrayList<String> cateName = new ArrayList<>();
//                        for(Maincates maincate : maincatesList){
//                            cateName.add(maincate.getCateName());
//                        }
//                        Log.e(TAG, "onResponse: "+ cateName);
            }

            @Override
            public void onFailure(Call<MainCategoriesResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " );
            }
        });
     }

    private void initView() {
        recyclerView = findViewById(R.id.rcMainCate);
    }

    @Override
    public void onItemClick(int position) {
        Log.e(TAG, "onItemClick: "+ position );
        Maincates maincates = adapter.getMainCateById(position);
        Log.e(TAG, "onItemClick: "+maincates.getId() );
        getSubCategoriesByMainId(maincates.getId());
    }

    private void getSubCategoriesByMainId(int id){
        Call<SubCateResponse> call = service.getSubByMainId(id);
        call.enqueue(new Callback<SubCateResponse>() {
            @Override
            public void onResponse(Call<SubCateResponse> call, Response<SubCateResponse> response) {
                Log.e(TAG, "onResponse: Success ^^" );
                List<Subcates> responses = response.body().getSubcates();
                ArrayList<String> des = new ArrayList<>();
                for(Subcates subcates : responses){

                    des.add(subcates.getCateName());
                }
                Log.e(TAG, "onResponse: "+ des );
            }

            @Override
            public void onFailure(Call<SubCateResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: "+ t.getMessage() );
            }
        });
    }
}
