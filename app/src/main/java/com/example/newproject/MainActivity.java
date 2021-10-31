package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mrecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutmanager;
    private ImageView myImage;
    private  JsonPlaceHolderApi jsonPlaceholderApi;
    private TextView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = (TextView) findViewById(R.id.myText1) ;
         Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://services.aimict.org/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        mrecyclerView = findViewById(R.id.recyclerView);
        mrecyclerView.setHasFixedSize(true);
        mLayoutmanager = new LinearLayoutManager(this);
        mrecyclerView.setLayoutManager(mLayoutmanager);


        jsonPlaceholderApi = retrofit.create(JsonPlaceHolderApi.class);

        getNews();
    }

    private void getNews() {
        Call<List<News>> call = jsonPlaceholderApi.getNews("news","en");
        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if(response.isSuccessful()){
                    mAdapter = new NewsAdapter((ArrayList<News>) response.body(), MainActivity.this);
                    mrecyclerView.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                    return;
                }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                myView.setText(t.getMessage());
            }
        });
    }


}
