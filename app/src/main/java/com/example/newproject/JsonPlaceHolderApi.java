package com.example.newproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface JsonPlaceHolderApi {
@GET ("media_news")
Call<List<News>> getNews(@Query("strGroup") String group,
                          @Query("lang") String lang);

}
