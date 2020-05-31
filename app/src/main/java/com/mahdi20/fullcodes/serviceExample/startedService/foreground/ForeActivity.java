package com.mahdi20.fullcodes.serviceExample.startedService.foreground;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.content.ContextCompat;

import com.mahdi20.fullcodes.R;

public class ForeActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fore_service);


        findViewById(R.id.startBtn).setOnClickListener(v -> {

            Intent intent = new Intent(ForeActivity.this, ForeService.class);
            ContextCompat.startForegroundService(ForeActivity.this, intent);


        });

        findViewById(R.id.stopBtn).setOnClickListener(v -> {

            Intent intent = new Intent(ForeActivity.this, ForeService.class);
            stopService(intent);

        });

    }

}