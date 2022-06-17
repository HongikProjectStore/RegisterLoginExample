package com.hongik.project.graduation.store.application.service;

import com.hongik.project.graduation.store.ui.network.response.ProductDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ProductService {
    @GET("/product")
    Call<List<ProductDto>> getStoreListOrderByGrade();
}
