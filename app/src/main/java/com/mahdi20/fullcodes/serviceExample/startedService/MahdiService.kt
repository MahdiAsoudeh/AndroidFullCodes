package com.mahdi20.codes.startedService

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MahdiService : Service() {
    override fun onBind(intent: Intent): IBinder? {
        Log.i("ZZZZZZZ", "onBind")
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("ZZZZZZZ", "onCreate")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Log.i("ZZZZZZZ", "onStartCommand")
//        stopSelf()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ZZZZZZZ", "onDestroy")
    }
}