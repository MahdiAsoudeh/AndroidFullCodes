package com.mahdi20.fullcodes.serviceExample.startedService.foreground;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.mahdi20.fullcodes.R;

public class ForeService extends Service {

    private MediaPlayer soundPlayer;
    private String CHANNEL_ID = "channelId";
    private NotificationManager notifManager;

    @Override
    public void onCreate() {

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        soundPlayer = MediaPlayer.create(this, R.raw.alarm);
        soundPlayer.setLooping(true);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "onStartCommand", Toast.LENGTH_SHORT).show();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            String offerChannelName = "Service Channel";
            String offerChannelDescription = "Music Channel";
            int offerChannelImportance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notifChannel = new NotificationChannel(CHANNEL_ID, offerChannelName, offerChannelImportance);
            notifChannel.setDescription(offerChannelDescription);
            notifManager = getSystemService(NotificationManager.class);
            notifManager.createNotificationChannel(notifChannel);

        }

        NotificationCompat.Builder sNotifBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("musiiic")
                .setContentText("Running.........");

        Notification servNotification = sNotifBuilder.build();

        startForeground(1, servNotification);

        soundPlayer.start();
        return START_STICKY;

    }

    @Override
    public void onDestroy() {

        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        soundPlayer.stop();

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}