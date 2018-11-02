package ru.startandroid.simplelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvPlNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPlNames = (TextView) findViewById(R.id.tvPlNames);

        String[] names = {"Java", "Ruby", "Python", "JavaScript", "Delphi"};

        tvPlNames.setText("");

        for (String name : names) {
            tvPlNames.append(name + "\n");
        }

    }
}
