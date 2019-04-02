package expencive.vk.com.cif090foregroundservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Toast;

import static expencive.vk.com.cif090foregroundservice.App.CHANNEL_ID;

public class ExampleService extends Service {
    String mInput;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        final String input = intent.getStringExtra("inputExtra");

        Intent notificationIntent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, notificationIntent, 0);

        CountDownTimer countDownTimer;

        countDownTimer = new CountDownTimer(Integer.parseInt(input), 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
               String inputv = String.valueOf(millisUntilFinished);
               mInput = inputv;


            }

            @Override
            public void onFinish() {
                stopSelf();
                Toast.makeText(ExampleService.this, "Time is over", Toast.LENGTH_SHORT).show();


            }
        }.start();







        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("ExampleService")
                .setContentText(mInput)
                .setSmallIcon(R.drawable.ic_build)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1, notification);

        //do heavy work on background thread
        //stopSelf();

        return START_NOT_STICKY;


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
