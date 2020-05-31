package com.mahdi20.fullcodes.serviceExample.startedService.background;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.mahdi20.fullcodes.R;

public class BackService extends Service {

    private MediaPlayer soundPlayer;

    @Override
    public void onCreate() {
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        soundPlayer = MediaPlayer.create(this, R.raw.alarm);
        soundPlayer.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "onStartCommand", Toast.LENGTH_SHORT).show();
        soundPlayer.start();
//        return START_STICKY;
        return START_NOT_STICKY;
//        return START_REDELIVER_INTENT;
//        return START_STICKY_COMPATIBILITY;
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