package com.example.rany.retrofitsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rany.retrofitsdemo.request.AddMainCateForm;
import com.example.rany.retrofitsdemo.response.new_main_categories_rs.NewMainCateRS;
import com.example.rany.retrofitsdemo.service_api.SearchService;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddMainCategoriesActivity extends AppCompatActivity implements Validator.ValidationListener{

    private static final String TAG = "ooooo";

    @NotEmpty
    private EditText name, des, url;

    private Button submit;
    private Retrofit retrofit;
    private SearchService service;
    private  Validator validator;
    public static final String BASE_URL = "http://110.74.194.125:15000/api/v1/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_main_categories);

        name = findViewById(R.id.mainCateName);
        des = findViewById(R.id.mainCateDesc);
        url = findViewById(R.id.mainCateUrl);
        submit = findViewById(R.id.btnSubmit);
        //validation
        validator = new Validator(this);
        validator.setValidationListener(this);

        setUpRetrofit();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validator.validate();
            }
        });
    }
    private void setUpRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(SearchService.class);

    }

    public void addNew(){
        String cName = name.getText().toString();
        String cDes = des.getText().toString();
        String cUrl = url.getText().toString();

        Call<NewMainCateRS> call = service.addNewMainCategories(
                new AddMainCateForm(
                        cName,
                        cDes,
                        cUrl,
                        0,
                        Arrays.asList("String"),
                        true

                )
        );
        call.enqueue(new Callback<NewMainCateRS>() {
            @Override
            public void onResponse(Call<NewMainCateRS> call, Response<NewMainCateRS> response) {
                if(response.isSuccessful()){
                    Log.e(TAG, "onResponse: "+ response.body().getMsg());
                }
            }

            @Override
            public void onFailure(Call<NewMainCateRS> call, Throwable t) {
                Log.e(TAG, "onFailure: "+ t.getMessage() );
            }
        });
    }

    @Override
    public void onValidationSucceeded() {
        addNew();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}
