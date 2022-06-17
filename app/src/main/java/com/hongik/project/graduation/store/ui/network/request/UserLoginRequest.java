package com.hongik.project.graduation.store.ui.network.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.ToString;

@ToString
public class UserLoginRequest {
    @SerializedName("username")
    @Expose
    private String id;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("token")
    private String token;

    @SerializedName("error")
    private String error;
}
