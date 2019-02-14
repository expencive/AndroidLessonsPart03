package com.gmail.expencive.cif064retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceholderApi {

    @GET("posts")
    Call<List<Post>> getPosts(@Query("userId") int userId);

    @GET("posts/2/comments")
    Call<List<Comment>> getComments();
}
