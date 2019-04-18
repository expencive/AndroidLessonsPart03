package expencive.vk.com.fragmentbottomnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import expencive.vk.com.fragmentbottomnavigation.api.ApiClient;
import expencive.vk.com.fragmentbottomnavigation.api.ApiInterface;
import expencive.vk.com.fragmentbottomnavigation.api.RetrofitRequest;
import expencive.vk.com.fragmentbottomnavigation.models.Animal;
import expencive.vk.com.fragmentbottomnavigation.models.Animals;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private RetrofitRequest retrofitRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
               // new HomeFragment()).commit();

        textView = findViewById(R.id.tv_ma);
//        retrofitRequest = new RetrofitRequest();

        loadJson();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFrament = null;

            switch (menuItem.getItemId()){
                case R.id.nav_home:
                    selectedFrament = new HomeFragment();
                    break;
                case R.id.nav_favorits:
                    selectedFrament = new FavoritsFragment();
                    break;
                case R.id.nav_search:
                    selectedFrament = new SearchFragment();
                    break;

            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFrament).commit();

            return true;
        }

    };

    public void loadJson(){

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        //String cat = "cat";

        Call<Animals> call;

        call = apiInterface.getCats();

        call.enqueue(new Callback<Animals>() {
            @Override
            public void onResponse(Call<Animals> call, Response<Animals> response) {
                if (response.isSuccessful() && response.body().getAnimalList()!=null) {

                    List<Animal> animals = new ArrayList<>();
                    animals = response.body().getAnimalList();
                    String content = "";



                    for (Animal animal: animals){



                        content += "ImageUrl: " + animal.getImageUrl() + "\n";
                        content += "Title: " + animal.getImageTitle() + "\n\n";




                    }

                    textView.setText(content);



                    return;
                } else{
                    Toast.makeText(MainActivity.this, "not succesful", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<Animals> call, Throwable t) {
                textView.setText("Error: " + String.valueOf(t.getMessage()));


            }
        });

    }

//    public void onClickStartRequest(View view){
//
//
//        String content;
//           content= retrofitRequest.getmContent();
//           textView.setText(content);
//
//
//    }

}
