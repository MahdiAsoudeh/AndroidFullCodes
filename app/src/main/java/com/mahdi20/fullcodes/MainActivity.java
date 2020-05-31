package com.mahdi20.fullcodes;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mahdi20.fullcodes.alarmManagerExample.AlarmManagerActivity;
import com.mahdi20.fullcodes.asyncTaskExample.AsyncTaskActivity;
import com.mahdi20.fullcodes.eventBusExample.EventBusActivity;
import com.mahdi20.fullcodes.jobSchedulerExample.JobSchedulerActivity;
import com.mahdi20.fullcodes.recyclerviewExample.RecyclerViewActivity;
import com.mahdi20.fullcodes.retrofitExample.RetrofitActivity;
import com.mahdi20.fullcodes.serviceExample.boundService.BoundActivity;
import com.mahdi20.fullcodes.serviceExample.intentService.IntentServiceActivity;
import com.mahdi20.fullcodes.serviceExample.startedService.background.BackActivity;
import com.mahdi20.fullcodes.serviceExample.startedService.foreground.ForeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.rcyBtn).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.asyncBtn).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AsyncTaskActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.alarmManagerBtn).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AlarmManagerActivity.class);
            startActivity(intent);
        });


        findViewById(R.id.eventBusBtn).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EventBusActivity.class);
            startActivity(intent);
        });


        findViewById(R.id.jobBtn).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, JobSchedulerActivity.class);
            startActivity(intent);
        });


        findViewById(R.id.retrofitBtn).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RetrofitActivity.class);
            startActivity(intent);
        });


        findViewById(R.id.intentServiceBtn).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, IntentServiceActivity.class);
            startActivity(intent);
        });


        findViewById(R.id.backgroundServiceBtn).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BackActivity.class);
            startActivity(intent);
        });


        findViewById(R.id.foregroundServiceBtn).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ForeActivity.class);
            startActivity(intent);
        });


        findViewById(R.id.boundServiceBtn).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BoundActivity.class);
            startActivity(intent);
        });


    }
}
