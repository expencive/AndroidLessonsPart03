package com.gmail.expencive.cif071broadcastrecievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class ExampleBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("com.gmail.expencive.EXAMPLE_ACTION".equals(intent.getAction())) {
            String recievedText = intent.getStringExtra("com.gmail.expencive.EXTRA_TEXT");
            Toast.makeText(context, recievedText, Toast.LENGTH_SHORT).show();
        }
    }
}