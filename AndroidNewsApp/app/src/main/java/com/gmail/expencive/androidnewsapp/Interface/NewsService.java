package com.gmail.expencive.androidnewsapp.Interface;

import com.gmail.expencive.androidnewsapp.Model.Article;
import com.gmail.expencive.androidnewsapp.Model.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public abstract class NewsService {

    @GET("v2/top-headlines?country=ru&apiKey=f2a63266ca464da6b6cf1778ce5aea1b")
    abstract Call<News> getNews();




}
