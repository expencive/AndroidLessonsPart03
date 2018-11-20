package ru.startandroid.calclatorcredit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GraphPaymentsExperemental extends AppCompatActivity {

    TextView text1, text2, text3;
    GraphPaymentAdapter object = new GraphPaymentAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_cardview);

        text1 = (TextView) findViewById(R.id.tvNomer);
        text2 = (TextView) findViewById(R.id.tvOsnDolg);
        text3 = (TextView) findViewById(R.id.tvPayment);






        text1.setText(object.getValueOfIntent());
        text2.setText(object.getValueOfIntent2());
        text3.setText(object.getValueOfIntent3());


    }
}
