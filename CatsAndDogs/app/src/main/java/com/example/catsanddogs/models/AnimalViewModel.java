package com.example.catsanddogs.models;



import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.catsanddogs.api.ApiClient;
import com.example.catsanddogs.api.ApiInterface;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimalViewModel extends ViewModel {

    private MutableLiveData<List<Animal>> animalList = new MutableLiveData<>();


    public MutableLiveData<List<Animal>> getAnimalList() {
        return animalList;
    }

    public void setCatsList() {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Animals> call;
        call = apiInterface.getCats();

        call.enqueue(new Callback<Animals>() {
            @Override
            public void onResponse(Call<Animals> call, Response<Animals> response) {
                if (response.isSuccessful() && response.body().getAnimalList()!=null) {
                    List<Animal> animals = new ArrayList<>();
                    animals = response.body().getAnimalList();
                    animalList.setValue(animals);
                }
            }

            @Override
            public void onFailure(Call<Animals> call, Throwable t) {
            }
        });
    }

    public void setDogsList() {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Animals> call;
        call = apiInterface.getDogs();

        call.enqueue(new Callback<Animals>() {
            @Override
            public void onResponse(Call<Animals> call, Response<Animals> response) {
                if (response.isSuccessful() && response.body().getAnimalList()!=null) {
                    List<Animal> animals = new ArrayList<>();
                    animals = response.body().getAnimalList();
                    animalList.setValue(animals);
                }
            }

            @Override
            public void onFailure(Call<Animals> call, Throwable t) {
            }
        });
    }
}


