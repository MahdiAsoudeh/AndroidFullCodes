package com.mahdi20.fullcodes.alarmManagerExample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmManagerReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "alarm!!!!!!", Toast.LENGTH_SHORT).show();
        Log.e("########", "alarm!!!!!!");

        Intent i = new Intent(context, ReminderActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);


    }
}