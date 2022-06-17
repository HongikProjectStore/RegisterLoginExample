package com.hongik.project.graduation.store.application.service;

import com.hongik.project.graduation.store.ui.network.request.UserLoginRequest;
import com.hongik.project.graduation.store.ui.network.request.UserSignUpRequest;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserService {
    @FormUrlEncoded
    @POST("auth/signin/")
    Call<UserLoginRequest> userLogin(
            @Field("username") String id,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("auth/signup/")
    Call<UserSignUpRequest> userSignUp(
            @Field("username") String id,
            @Field("password") String password,
            @Field("name") String name,
            @Field("email") String email,
            @Field("gender") String gender,
            @Field("age") int age,
            @Field("image") int image
    );
}
