package com.gmail.expencive.cif064retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;

    private JsonPlaceholderApi jsonPlaceholderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);

       /*Gson gson = new GsonBuilder().serializeNulls().create(); //если есть задача использовать null  в проекте. он не будет игнорировать null

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(/*"https://jsonplaceholder.typicode.com/"*/ "https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create(/*gson*/))
                .build();

        jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi.class);

        //getPosts();

        //getComments();

       // createPost();

        //updatePost();
        //deletePost();

        getArticles();
    }

    private void getArticles() {
        Call<Article> call = jsonPlaceholderApi.getArticles();

        call.enqueue(new Callback<Article>() {
            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }


                //Article articles = response.body();

                List<Article> articles = (List<Article>) response.body();



                for (Article article: articles) {
                    String content = "";

                    content += "ID: " + article.getAuthor() + "\n";
                    content += "Post Id: " + article.getDescription() + "\n";
                    content += "Name: " + article.getTitle() + "\n";
                    content += "Email: " + article.getUrl() + "\n";

                    content += "Text: " + article.getUrlToimage() + "\n\n";

                    textViewResult.append(content);

                }





            }

            @Override
            public void onFailure(Call<Article> call, Throwable t) {

                textViewResult.setText(t.getMessage());

            }
        });
    }

    private void getComments() {
        Call<List<Comment>> call = jsonPlaceholderApi.getComments("posts/2/comments");
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Comment> comments = response.body();

                for (Comment comment: comments) {

                    //if (comment.getPostId()==2) {

                        String content = "";

                        content += "ID: " + comment.getId() + "\n";
                        content += "Post Id: " + comment.getPostId() + "\n";
                        content += "Name: " + comment.getName() + "\n";
                        content += "Email: " + comment.getEmail() + "\n";

                        content += "Text: " + comment.getText() + "\n\n";

                        textViewResult.append(content);
                    //}


                }

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

                textViewResult.setText(t.getMessage());

            }
        });
    }

    private void getPosts(){

        Map<String, String> parameters = new HashMap<>();

        parameters.put("userId", "1");
        parameters.put("_sort", "id");
        parameters.put("_order", "desc");

        Call<List<Post>> call = jsonPlaceholderApi.getPosts(parameters/*new Integer[] {2,3,6},  null, null*/);
        //если не хочется сортировать можно вместо в параметрах поставить null ('id", "desc")

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();


                for (Post post: posts) {
                    String content = "";

                    content += "ID: " + post.getId() + "\n";
                    content += "User Id: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";

                    textViewResult.append(content);


                }


            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                textViewResult.setText(t.getMessage());

            }
        });
    }

    private void createPost() {
        Post post = new Post(23, "New Title", "New Text");

        Map<String, String> fields = new HashMap<>();
        fields.put("userId", "25");
        fields.put("title", "nuovo title");
        fields.put("body", "nuovo text");

        Call<Post> call = jsonPlaceholderApi.createPost(fields);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                Post postResponse = response.body();

                String content = "";

                content += "Code: " + response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "User Id: " + postResponse.getUserId() + "\n";
                content += "Title: " + postResponse.getTitle() + "\n";
                content += "Text: " + postResponse.getText() + "\n\n";

                textViewResult.setText(content);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

                textViewResult.setText(t.getMessage());

            }
        });
    }

    private void updatePost() {
        Post post = new Post(12, null, "New Text");

        Call<Post> call = jsonPlaceholderApi.putPost(2, post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                Post postResponse = response.body();

                String content = "";

                content += "Code: " + response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "User Id: " + postResponse.getUserId() + "\n";
                content += "Title: " + postResponse.getTitle() + "\n";
                content += "Text: " + postResponse.getText() + "\n\n";

                textViewResult.setText(content);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

                textViewResult.setText(t.getMessage());

            }
        });
    }

    private void deletePost() {
        Call<Void> call = jsonPlaceholderApi.deletePost(2);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                textViewResult.setText("Code: " + response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                textViewResult.setText(t.getMessage());

            }
        });
    }


}
