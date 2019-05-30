package com.example.javacore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.javacore.Interfaces.AnimalInterfaces;
import com.example.javacore.Interfaces.Info;
import com.example.javacore.Interfaces.Person;
import com.example.javacore.Threads.MyThread;
import com.example.javacore.Threads.Runner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private TextView textViewOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MyThread myThread = new MyThread();
//        MyThread super1 = new MyThread(){
//            @Override
//            public void run() {
//                for (int i=0; i<1000; i++){
//
//                    System.out.println("Super " + i);
//
//                }
//
//            }
//        };
//        myThread.start();
//        super1.start();

        Thread thread = new Thread(new Runner());
        thread.start();
        Thread thread2 = new Thread(new Runner()){
            @Override
            public void run() {
                for (int i=0; i<1000; i++){

                    System.out.println("Third " + i);

                }
            }
        };

        thread2.start();

        for (int i=0; i<1000; i++){

            System.out.println("Main " + i);

        }
    }

    private void showSoundofAnimal(Animal animal){
       animal.move();

    }

    private void showList(List<? extends Animal> animalList){
        int legs;
        for (Animal animal: animalList){
            legs = animal.legs;

            System.out.println(String.valueOf(legs));


        }
    }
}
