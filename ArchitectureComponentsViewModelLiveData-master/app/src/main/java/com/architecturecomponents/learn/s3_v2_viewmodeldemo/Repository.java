package com.architecturecomponents.learn.s3_v2_viewmodeldemo;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.util.Log;

import java.util.Random;

public class Repository {

    private static final String TAG = "Repository";






    public String getRandom(){

        Random random = new Random();
        String randomNumber = "Number: " + (random.nextInt(10 - 1) + 1);
        Log.i(TAG, "Create new number" + randomNumber);

        return randomNumber;

    }

}
