package com.mahdi20.fullcodes.serviceExample.startedService.background;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.mahdi20.fullcodes.MainActivity;
import com.mahdi20.fullcodes.R;

public class BackActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_service);


        findViewById(R.id.startBtn).setOnClickListener(v -> {
            Intent intent = new Intent(BackActivity.this, BackService.class);
            startService(intent);
        });

        findViewById(R.id.stopBtn).setOnClickListener(v -> {
            Intent intent = new Intent(BackActivity.this, BackService.class);
            stopService(intent);
        });

    }

}