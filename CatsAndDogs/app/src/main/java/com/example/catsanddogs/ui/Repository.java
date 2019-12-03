package com.example.catsanddogs.ui;

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
