package ru.startandroid.cif006notification;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etTitle, etMassege;
    private Button btnChanel1, btnChanel2;
    private NotificationHelper mNotificationHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = (EditText) findViewById(R.id.etTitle);
        etMassege = (EditText) findViewById(R.id.etMessage);
        btnChanel1 = (Button) findViewById(R.id.btnChanel1);
        btnChanel2 = (Button) findViewById(R.id.btnChanel2);
        mNotificationHelper = new NotificationHelper(this);

        btnChanel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChanel1(etTitle.getText().toString(), etMassege.getText().toString());

            }
        });

        btnChanel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChanel2(etTitle.getText().toString(), etMassege.getText().toString());

            }
        });

    }
    public void  sendOnChanel1(String title, String message) {
        NotificationCompat.Builder nb = mNotificationHelper.getChanel1Notification(title, message);
        mNotificationHelper.getManager().notify(1, nb.build());

    }

    public void sendOnChanel2(String title, String message) {
        NotificationCompat.Builder nb = mNotificationHelper.getChane2Notification(title, message);
        mNotificationHelper.getManager().notify(2, nb.build());

    }

}
