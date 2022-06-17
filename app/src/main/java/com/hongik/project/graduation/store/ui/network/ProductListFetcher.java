package com.hongik.project.graduation.store.ui.network;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hongik.project.graduation.store.application.service.ProductService;
import com.hongik.project.graduation.store.ui.network.response.ProductDto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductListFetcher {
    public static String TAG = "ProductListFetcher";
    private ProductService productService;

    public ProductListFetcher() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://34.234.228.90:7777")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        productService = retrofit.create(ProductService.class);
    }

    public LiveData<List<ProductDto>> fetchContents(){
        MutableLiveData<List<ProductDto>> productList = new MutableLiveData<List<ProductDto>>();
        Call<List<ProductDto>> eventList = productService.getStoreListOrderByGrade();

        eventList.enqueue(new Callback<List<ProductDto>>() {
            @Override
            public void onResponse(Call<List<ProductDto>> call, Response<List<ProductDto>> response) {

                Log.d(TAG, "Response received : " + response.body());

                productList.setValue(response.body());
                Log.d(TAG, "productList : " + productList.getValue());

            }

            @Override
            public void onFailure(Call<List<ProductDto>> call, Throwable t) {
                Log.d(TAG, "Failed to fetch", t);
            }
        });

        return productList;
    }
}
