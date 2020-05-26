package com.mahdi20.fullcodes.alarmManagerExample;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mahdi20.fullcodes.R;

import java.util.Calendar;

public class AlarmManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager);

        int year = 2020;
        int mount = 4;
        int day = 26;
        int hour = 13;
        int minute = 8;
        int second = 0;

        Intent intent = new Intent(getApplicationContext(), AlarmManagerReceiver.class);
        intent.putExtra("data", "");

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, mount, day, hour, minute, second);

        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
        am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);


    }

}