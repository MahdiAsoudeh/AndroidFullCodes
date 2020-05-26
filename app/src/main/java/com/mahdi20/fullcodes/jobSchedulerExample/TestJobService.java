package com.mahdi20.fullcodes.jobSchedulerExample;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class TestJobService extends JobService {

    private static final String TAG = "##########";

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.i(TAG, "on start job: " + params.getJobId());
        mJobHandler.sendMessage(Message.obtain(mJobHandler, 1, params));
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.i(TAG, "on stop job: " + params.getJobId());
        mJobHandler.removeMessages(1);
        return true;
    }


    private Handler mJobHandler = new Handler(msg -> {
        Toast.makeText(getApplicationContext(), "JobService task running", Toast.LENGTH_SHORT).show();
        jobFinished((JobParameters) msg.obj, false);
        return true;
    });

}