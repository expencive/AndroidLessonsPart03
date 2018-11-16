package ru.startandroid.countdowntimer;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.CountDownTimer;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  long backPressedTime;
    private TextView countdownText, tvCheck;
    private Button btnCountdown, btnClearAll;
    EditText etMinutes, etSeconds;

    private CountDownTimer countDownTimer;
    private long timeLeftInMiliseconds;


    private boolean timerRunning;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countdownText = (TextView) findViewById(R.id.countdown_text);
        tvCheck = (TextView) findViewById(R.id.tvCheck);
        btnCountdown = (Button) findViewById(R.id.countdown_button);
        btnClearAll = (Button) findViewById(R.id.btnClearTimer);
        etMinutes = (EditText) findViewById(R.id.etMinutes);
        etSeconds = (EditText) findViewById(R.id.etSeconds);



        btnCountdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();
            }
        });



        updateTimer();
    }

    public long timeLeftInMilisecondsBegin() {


        long timeLeftInMiliseconds=0;
        if(etMinutes.length()!=0 & etSeconds.length()!=0)
        {
            timeLeftInMiliseconds = (Integer.parseInt(etSeconds.getText().toString()))*1000
                    + (Integer.parseInt(etMinutes.getText().toString()))*60000;
        }
        else if (etMinutes.length()==0 & etSeconds.length()!=0) {
            timeLeftInMiliseconds = (Integer.parseInt(etSeconds.getText().toString()))*1000;
        }
        else if (etMinutes.length()!=0 & etSeconds.length()==0) {
            timeLeftInMiliseconds = (Integer.parseInt(etMinutes.getText().toString()))*60000;
        } else {
            timeLeftInMiliseconds=600000;
        }
        return timeLeftInMiliseconds;

    }

    private void startStop() {
        if (timerRunning) {
            stopTimer();
        }
        else {
            startTimer();
        }
    }

    private void startTimer() {

        if(etMinutes.length()!=0 & etSeconds.length()!=0)
        {
            timeLeftInMiliseconds = (Integer.parseInt(etSeconds.getText().toString()))*1000
                    + (Integer.parseInt(etMinutes.getText().toString()))*60000;
        }
        else if (etMinutes.length()==0 & etSeconds.length()!=0) {
            timeLeftInMiliseconds = (Integer.parseInt(etSeconds.getText().toString()))*1000;
        }
        else if (etMinutes.length()!=0 & etSeconds.length()==0) {
            timeLeftInMiliseconds = (Integer.parseInt(etMinutes.getText().toString()))*60000;
        }


       countDownTimer = new CountDownTimer(timeLeftInMiliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMiliseconds = millisUntilFinished;
                updateTimer();
                tvCheck.setVisibility(View.INVISIBLE);
                etMinutes.setText("");
                etSeconds.setText("");
                etMinutes.setVisibility(View.INVISIBLE);
                etSeconds.setVisibility(View.INVISIBLE);
                countdownText.setVisibility(View.VISIBLE);
                btnClearAll.setVisibility(View.INVISIBLE);



            }

            @Override
            public void onFinish() {

                etMinutes.setText("");
                etSeconds.setText("");
                tvCheck.setText("Время вышло");
                tvCheck.setVisibility(View.VISIBLE);
                etMinutes.setVisibility(View.VISIBLE);
                etSeconds.setVisibility(View.VISIBLE);
                btnCountdown.setText("Новый отсчет");
                notificationEnd();




            }
        }.start();

        btnCountdown.setText("Пауза");

        timerRunning = true;
    }

    private void updateTimer() {
        int minutes = (int) timeLeftInMiliseconds / 60000;
        int seconds = (int) timeLeftInMiliseconds % 60000 /1000;

        String timeLeftText;
        timeLeftText = "" + minutes;
        timeLeftText +=":";
        if (seconds<10) timeLeftText +="0";
        timeLeftText +=seconds;
        countdownText.setText(timeLeftText);


    }

    public void stopTimer() {
        countDownTimer.cancel();
        btnCountdown.setText("Старт");
        timerRunning = false;
        tvCheck.setText("ПАУЗА");
        tvCheck.setVisibility(View.VISIBLE);
        btnClearAll.setVisibility(View.VISIBLE);


    }

    @Override
    public void onBackPressed() {


        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(getBaseContext(), "Для выхода нажмите кнопку возврата еще раз", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();
    }
    public void onClickClearAll (View view) {
        stopAllandAgain();
    }

    private void stopAllandAgain() {
        countDownTimer.cancel();
        etMinutes.setText("");
        etSeconds.setText("");
        tvCheck.setVisibility(View.INVISIBLE);
        etMinutes.setVisibility(View.VISIBLE);
        etSeconds.setVisibility(View.VISIBLE);
        btnClearAll.setVisibility(View.INVISIBLE);
        countdownText.setVisibility(View.INVISIBLE);
    }

    public void notificationEnd() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Время вышло")
                        .setContentText("Вы можете начать сначала");

        Notification notification = builder.build();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }

}
