package com.studypartner.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.studypartner.models.ReminderItem;

import androidx.core.app.NotificationCompat;

import static android.content.ContentValues.TAG;

public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int test = 0;
        ReminderItem item = (ReminderItem) intent.getParcelableExtra("Item");
        assert item != null;
        Log.d(TAG, "onReceive: item " + item.toString());
        test = item.getnotifyId();
        Log.d("Recieve", String.valueOf(test));
        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification(item);
        notificationHelper.getManager().notify(test, nb.build());
    }
}
