package ru.startandroid.calclatorcredit;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by Настик on 20.11.2018.
 */

public class GraphPaymentAdapter extends RecyclerView.Adapter {
    double loanAmount;
    double interestRate;
    double loanPeriod;
    public String valueOfIntent;
    public String valueOfIntent2;
    public String valueOfIntent3;

    public String getValueOfIntent() {
        Intent intent = new Intent();
        valueOfIntent = intent.getStringExtra(MainActivity.EXTRA);

        return valueOfIntent;
    }
    public String getValueOfIntent2() {
        Intent intent2 = new Intent();
        valueOfIntent2 = intent2.getStringExtra(MainActivity.EXTRA2);

        return valueOfIntent2;
    }
    public String getValueOfIntent3() {
        Intent intent3 = new Intent();
        valueOfIntent3 = intent3.getStringExtra(MainActivity.EXTRA3);

        return valueOfIntent3;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
