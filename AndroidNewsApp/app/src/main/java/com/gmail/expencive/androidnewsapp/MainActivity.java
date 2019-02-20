package com.gmail.expencive.androidnewsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;


import com.gmail.expencive.androidnewsapp.api.ApiClient;
import com.gmail.expencive.androidnewsapp.api.ApiInterface;
import com.gmail.expencive.androidnewsapp.models.Article;
import com.gmail.expencive.androidnewsapp.models.News;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String API_KEY = "f2a63266ca464da6b6cf1778ce5aea1b";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Article> articles = new ArrayList<>();
    private Adapter adapter;
    private String TAG = MainActivity.class.getSimpleName();
    private TextView textView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        textView = findViewById(R.id.textHeadline);

        loadJson();


    }

    public void loadJson() {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<News> call;

        String country = Utils.getCountry();

        call = apiInterface.getNews(country ,API_KEY);

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if (response.isSuccessful() && response.body().getArticle() !=null) {
                    /*if (!articles.isEmpty()) {
                        articles.clear();
                    }*/

                    articles = response.body().getArticle();
                    adapter = new Adapter(articles, MainActivity.this);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                    /*for (Article article: articles) {

                        String content = "";

                        content += "Author: " + article.getAuthor() + "\n";
                        content += "Description: " + article.getDescription() + "\n";
                        content += "Title: " + article.getTitle() + "\n";
                        content += "Email: " + article.getPublishedAt() + "\n";

                        content += "Image: " + article.getUrlToimage() + "\n\n";

                        textView.append(content);


                    }*/
                    
                }else {
                    Toast.makeText(MainActivity.this, "No result", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                textView.setText(t.getLocalizedMessage());


            }
        });
    }







}
