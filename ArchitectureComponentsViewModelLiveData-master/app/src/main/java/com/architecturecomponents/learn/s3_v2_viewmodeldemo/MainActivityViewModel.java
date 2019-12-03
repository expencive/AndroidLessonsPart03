package com.architecturecomponents.learn.s3_v2_viewmodeldemo;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.Random;

public class MainActivityViewModel extends ViewModel {

    private String TAG = this.getClass().getSimpleName();
    private MutableLiveData<String> myRandomNumber;

    Repository repository = new Repository();

    public MutableLiveData<String> getNumber() {
        Log.i(TAG, "Get number");
        if (myRandomNumber == null) {
            myRandomNumber = new MutableLiveData<>();
            createNumber();
        }
        return myRandomNumber;
    }

    public void createNumber() {
//        Random random = new Random();
//        String randomNumber = "Number: " + (random.nextInt(10 - 1) + 1);
//        Log.i(TAG, "Create new number" + randomNumber);

        String randomNumber = repository.getRandom();

        myRandomNumber.setValue(randomNumber);

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "ViewModel Destroyed");
    }
}
