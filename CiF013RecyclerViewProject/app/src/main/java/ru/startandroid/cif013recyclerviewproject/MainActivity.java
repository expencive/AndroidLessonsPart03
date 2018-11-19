package ru.startandroid.cif013recyclerviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.ic_android, "line 1", "line 2"));
        exampleList.add(new ExampleItem(R.drawable.ic_arrow, "line A", "line B"));
        exampleList.add(new ExampleItem(R.drawable.ic_beach_access, "line I", "line II"));
    }
}
