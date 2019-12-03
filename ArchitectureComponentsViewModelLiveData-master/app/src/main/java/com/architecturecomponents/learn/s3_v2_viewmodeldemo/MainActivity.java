package com.architecturecomponents.learn.s3_v2_viewmodeldemo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();

     MainActivityViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final TextView mTextView = findViewById(R.id.tvNumber);
        Button button = findViewById(R.id.bRandom);
//        MainActivityDataGenerator myData = new MainActivityDataGenerator();
        model = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        final LiveData<String> myRandomNumber = model.getNumber();

        myRandomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mTextView.setText(s);

            }
        });
        //final Repository repository = new Repository();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.createNumber();

                //repository.getRandom();
            }
        });


        Log.i(TAG, "Random Number Set");
    }

    @Override
    protected void onPause() {
        super.onPause();
        model.createNumber();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
