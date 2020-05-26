package com.mahdi20.fullcodes.jobSchedulerExample;


import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.mahdi20.fullcodes.R;


public class JobSchedulerActivity extends AppCompatActivity {

    private static int kJobId = 0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_scheduler);


        findViewById(R.id.startBtn).setOnClickListener(v -> {

            ComponentName componentName = new ComponentName(this, TestJobService.class);
            JobInfo.Builder builder = new JobInfo.Builder(kJobId++, componentName);
            builder.setMinimumLatency(2 * 1000); // wait at least
            builder.setOverrideDeadline(10 * 1000); // maximum delay
            builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED); // require unmetered network
            builder.setRequiresDeviceIdle(true); // device should be idle
            builder.setRequiresCharging(false); // we don't care if the device is charging or not
            JobScheduler jobScheduler = (JobScheduler) getApplication().getSystemService(Context.JOB_SCHEDULER_SERVICE);
            jobScheduler.schedule(builder.build());

        });


        findViewById(R.id.cancelAllBtn).setOnClickListener(v -> {

            JobScheduler tm = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
            tm.cancelAll();

        });


    }
}