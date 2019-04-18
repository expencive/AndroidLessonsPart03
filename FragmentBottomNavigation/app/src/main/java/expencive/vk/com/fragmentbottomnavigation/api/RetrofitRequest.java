package expencive.vk.com.fragmentbottomnavigation.api;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import expencive.vk.com.fragmentbottomnavigation.MainActivity;
import expencive.vk.com.fragmentbottomnavigation.models.Animal;
import expencive.vk.com.fragmentbottomnavigation.models.Animals;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitRequest {
    public String mContent;



    public String loadJson(){


        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        //String cat = "cat";

        Call<Animals> call;

        call = apiInterface.getCats();

        call.enqueue(new Callback<Animals>() {
            @Override
            public void onResponse(Call<Animals> call, Response<Animals> response) {

                String content = "";
                if (response.isSuccessful() && response.body().getAnimalList()!=null) {

                    List<Animal> animals = new ArrayList<>();
                    animals = response.body().getAnimalList();



                    for (Animal animal: animals){



                        content += "ImageUrl: " + animal.getImageUrl() + "\n";
                        content += "Title: " + animal.getImageTitle() + "\n\n";


                    }

                    mContent = content;



                } else{ mContent = "Ничего не пришло";

                }


            }

            @Override
            public void onFailure(Call<Animals> call, Throwable t) {
                mContent = t.getMessage();



            }
        });



        return mContent;



    }

    public String getmContent(){
        return mContent;
    }
}
