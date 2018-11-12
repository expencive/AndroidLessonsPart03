package ru.startandroid.recycleviewtestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvNumbers;
    NumbersAdapter numbersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvNumbers = (RecyclerView) findViewById(R.id.rvNumbers);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvNumbers.setLayoutManager(layoutManager);
        rvNumbers.setHasFixedSize(true);

        numbersAdapter = new NumbersAdapter(100, this);
        rvNumbers.setAdapter(numbersAdapter);
    }
}
