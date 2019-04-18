package expencive.vk.com.fragmentbottomnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import expencive.vk.com.fragmentbottomnavigation.adapter.AnimalAdapter;
import expencive.vk.com.fragmentbottomnavigation.api.ApiClient;
import expencive.vk.com.fragmentbottomnavigation.api.ApiInterface;
import expencive.vk.com.fragmentbottomnavigation.models.Animal;
import expencive.vk.com.fragmentbottomnavigation.models.Animals;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoritsFragment extends Fragment {

    private TextView textViewResultHome;

    private RecyclerView mRecyclerView;
    private AnimalAdapter mAnimalAdapter;
    private ArrayList<Animal> mAnimalList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favorits, container, false);

        mRecyclerView = rootView.findViewById(R.id.recycler_view_favorits);

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
                    mAnimalList = (ArrayList<Animal>) animals;

                    mAnimalAdapter = new AnimalAdapter(getContext(), mAnimalList);
                    mRecyclerView.setAdapter(mAnimalAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    mAnimalAdapter.notifyDataSetChanged();





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
