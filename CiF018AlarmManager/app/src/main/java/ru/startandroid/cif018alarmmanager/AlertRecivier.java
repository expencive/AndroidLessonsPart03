package ru.startandroid.cif018alarmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

/**
 * Created by Настик on 23.11.2018.
 */

public class AlertRecivier extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb = notificationHelper.getChanel1Notification();
        notificationHelper.getManager().notify(1, nb.build());
    }
}
