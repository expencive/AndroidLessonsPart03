package com.example.javacore;

import android.os.CountDownTimer;

public class Constructor {

    private int age;
    private String name;

    public Constructor(){
        age = 15;
        name = "Vasya";

    }

    public Constructor(int age){
        this.age = age;
        name = "Kolya";
    }

    public Constructor(String name){
        age = 52;
        this.name = name;
        CountDownTimer countDownTimer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                print();

            }
        }.start();
    }

    public void print(){
        System.out.println("Time over " + age + ", " + name);
    }
}
