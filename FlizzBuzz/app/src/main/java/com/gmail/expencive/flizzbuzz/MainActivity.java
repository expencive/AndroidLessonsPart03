package com.gmail.expencive.flizzbuzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter);

        textView = findViewById(R.id.text_view);

        listView = findViewById(R.id.list_view);

        ArrayList<String> arrayList = new ArrayList<>();

        String output = "";

        //String resultingString = "";


        for (int i =1; i<=100; i++) {




            if (i%3==0 && i%5 !=0 ) {
                //resultingString = resultingString + "Flizz" + "\n";
                output ="Flizz";

            } else if (i%5==0 && i%3!=0) {
                //resultingString = resultingString + "Buzz" + "\n";
                output = "Buzz";

            } else if (i%5==0 && i%5==0) {
                //resultingString = resultingString + "FlizzBuzz" + "\n";

                output = "FlizzBuzz";

            }else {
                //resultingString = resultingString + i + "\n";

                output = " " + i;

            }
            arrayList.add(output);





        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);


    }
}
