package ru.startandroid.countdowntimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView countdownText;
    private Button btnCountdown;

    private CountDownTimer countDownTimer;
    private long timeLeftInMiliseconds = 600000; //10 мин
    private boolean timerRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countdownText = (TextView) findViewById(R.id.countdown_text);
        btnCountdown = (Button) findViewById(R.id.countdown_button);

        btnCountdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();
            }
        });

        updateTimer();
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
        countDownTimer = new CountDownTimer(timeLeftInMiliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMiliseconds = millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {

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

    }
}
