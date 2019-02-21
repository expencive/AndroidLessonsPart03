package com.gmail.expencive.androidnewsapp;

import android.app.SearchManager;
import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
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

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    public static final String API_KEY = "f2a63266ca464da6b6cf1778ce5aea1b";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Article> articles = new ArrayList<>();
    private Adapter adapter;
    private String TAG = MainActivity.class.getSimpleName();
    private TextView topHeadline;
    private SwipeRefreshLayout swipeRefreshLayout;
    private String mQuery = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) this);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        topHeadline = findViewById(R.id.textHeadline);

        onLoadingSwipeRefresh("");


    }

    public void loadJson(final String keyword) {
        topHeadline.setVisibility(View.INVISIBLE);
        swipeRefreshLayout.setRefreshing(true);
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        String country = Utils.getCountry();


        Call<News> call;

        if (keyword.length()>0) {
            call = apiInterface.getNewsSearch(keyword, country, "publishedAt", API_KEY);
        }else{
            call = apiInterface.getNews(country ,API_KEY);
        }

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
                    topHeadline.setVisibility(View.VISIBLE);

                    swipeRefreshLayout.setRefreshing(false);

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
                    topHeadline.setVisibility(View.INVISIBLE);
                    swipeRefreshLayout.setRefreshing(false);
                    Toast.makeText(MainActivity.this, "No result", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                topHeadline.setText(t.getLocalizedMessage());


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        MenuItem seachMenuItem = menu.findItem(R.id.action_search);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint("Искать последние новости...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.length() > 2) {
                    mQuery = query;
                    onLoadingSwipeRefresh(query);
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        seachMenuItem.getIcon().setVisible(false, false);

        return true;

    }

    @Override
    public void onRefresh() {
        onLoadingSwipeRefresh(mQuery);
        mQuery = "";
    }

    public void onLoadingSwipeRefresh(final String keyword) {
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                loadJson(keyword);

            }
        });
    }
}
