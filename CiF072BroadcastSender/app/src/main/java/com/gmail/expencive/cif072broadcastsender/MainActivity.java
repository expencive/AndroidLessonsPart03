package com.gmail.expencive.cif072broadcastsender;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
    }

    public void sendBroadcast(View v) {
        Intent intent = new Intent("com.gmail.expencive.EXAMPLE_ACTION");

        //intent.setClass(this, ExampleBroadcastReceiver2.class);

        /*ComponentName cn = new ComponentName("com.gmail.expencive.cif071broadcastrecievers",
                "com.gmail.expencive.cif071broadcastrecievers.ExampleBroadcastReceiver");
       intent.setComponent(cn);*/
        /*intent.setClassName("com.gmail.expencive.cif071broadcastrecievers",
                "com.gmail.expencive.cif071broadcastrecievers.ExampleBroadcastReceiver")*/

        intent.setPackage("com.gmail.expencive.cif071broadcastrecievers");

        Bundle extras = new Bundle();
        extras.putString("stringExtra", "Start");
        sendOrderedBroadcast(intent, null, new SenderReceiver(),
                null, 0, "Start", extras);
    }


}
