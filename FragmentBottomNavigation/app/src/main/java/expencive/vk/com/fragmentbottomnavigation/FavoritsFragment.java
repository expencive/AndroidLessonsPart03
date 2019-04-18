package expencive.vk.com.fragmentbottomnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import expencive.vk.com.fragmentbottomnavigation.api.ApiClient;
import expencive.vk.com.fragmentbottomnavigation.api.ApiInterface;
import expencive.vk.com.fragmentbottomnavigation.models.Animal;
import expencive.vk.com.fragmentbottomnavigation.models.Animals;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoritsFragment extends Fragment {

    private TextView textViewResultHome;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favorits, container, false);

        textViewResultHome = rootView.findViewById(R.id.text_view_result_favorits);

        return rootView;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadJson();


    }

    public void loadJson(){

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);


        Call<Animals> call;

        call = apiInterface.getDogs();

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

                    textViewResultHome.setText(content);



                    return;
                } else{
                    Toast.makeText(getContext(), "not succesful", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<Animals> call, Throwable t) {
                textViewResultHome.setText("Error: " + String.valueOf(t.getMessage()));


            }
        });

    }

}
