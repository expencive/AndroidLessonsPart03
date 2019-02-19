package com.gmail.expencive.androidnewsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.gmail.expencive.androidnewsapp.Interface.NewsService;
import com.gmail.expencive.androidnewsapp.Model.Article;
import com.gmail.expencive.androidnewsapp.Model.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;

    private NewsService newsServiceApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create(/*gson*/))
                .build();

        newsServiceApi = retrofit.create(NewsService.class);


    }

    private void getNews() {




    }
}
