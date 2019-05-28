package com.example.javacore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.javacore.Interfaces.AnimalInterfaces;
import com.example.javacore.Interfaces.Info;
import com.example.javacore.Interfaces.Person;

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

        textViewOutput = findViewById(R.id.text_view_output);

        Animal animal = new Animal("milk", 6) {
            @Override
            public void breath() {
                System.out.println("lung____________");

            }
        };

        Dog dog = new Dog("milk", 4);


        System.out.println(animal.equals(dog));
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
