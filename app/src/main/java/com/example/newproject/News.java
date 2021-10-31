package com.example.newproject;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;

public class News {

    @SerializedName("nws_title")
    private String mTittle;
    @SerializedName("nws_img_url")
    private String mImage;

    public News(String tittle , String glideImage){
        mTittle = tittle;
        mImage = glideImage;
    }

    public String getmTittle() {
        return mTittle;
    }


    public String getmImage() {
        return mImage;
    }
}
