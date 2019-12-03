package com.example.catsanddogs.api;

import com.example.catsanddogs.models.Animals;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("api.php?query=cat")
    Call<Animals> getCats();



    @GET("api.php?query=dog")
    Call<Animals> getDogs();
}
