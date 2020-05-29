package com.mahdi20.codes.intentService

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MahdiIntentService : IntentService("HelloIntentService") {
    override fun onHandleIntent(intent: Intent?) {
        Log.i("ZZZZZZZ", "onHandleIntent")
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("ZZZZZZZ", "onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("ZZZZZZZ", "onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }
}