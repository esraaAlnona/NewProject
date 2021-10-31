package com.example.newproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsAdapterViewHolder> {

    private ArrayList<News> mNews;
    private Context context;

    public NewsAdapter(ArrayList<News> itemsList, Context context){
        mNews = itemsList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card,parent,false);
        NewsAdapterViewHolder newsAdapterViewHolder = new NewsAdapterViewHolder (view);
        return newsAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapterViewHolder holder, int position) {
        News news= mNews.get(position);
        try{
            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher_round);



            Glide.with(context).load(news.getmImage()).apply(options).into(holder.mImage);
        }catch (Exception e){
            Log.e("error", e.getMessage());
        }
        holder.mTxt1.setText(news.getmTittle());

    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }

    public static class NewsAdapterViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImage;
        public TextView mTxt1;
        public NewsAdapterViewHolder(View view){
            super(view);
            mImage = view.findViewById(R.id.myImage);
            mTxt1 =  view.findViewById(R.id.myText1);
        }
    }

}