package com.mahdi20.fullcodes.serviceExample.boundService;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import com.mahdi20.fullcodes.R;

import java.util.Date;

public class BoundActivity extends Activity {

    BoundService localService;
    private boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service);


        findViewById(R.id.dateBtn).setOnClickListener(v -> {

            dispalyDate();

        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, BoundService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isBound) {
            unbindService(connection);
            isBound = false;
        }
    }

    public void dispalyDate() {
        if (isBound) {
            Date date = localService.getCurrentDate();
            Toast.makeText(this, String.valueOf(date), Toast.LENGTH_SHORT).show();
        }
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            BoundService.LocalBinder binder = (BoundService.LocalBinder) service;
            localService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            isBound = false;
        }
    };
} 