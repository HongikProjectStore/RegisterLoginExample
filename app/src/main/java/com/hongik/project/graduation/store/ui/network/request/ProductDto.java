package com.hongik.project.graduation.store.ui.network.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    @SerializedName("pid")
    @Expose
    private Integer pid;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("kinds")
    @Expose
    private Integer kinds;

    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;

    @SerializedName("price")
    @Expose
    private Integer price;

    @SerializedName("product_img_url")
    @Expose
    private String productImgUrl;

    @SerializedName("convenience_store")
    @Expose
    private String convenienceStore;

    @SerializedName("event_type")
    @Expose
    private JSONObject eventType;
}
