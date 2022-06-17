package com.hongik.project.graduation.store.ui.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
