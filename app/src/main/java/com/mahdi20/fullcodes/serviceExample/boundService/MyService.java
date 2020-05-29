package com.mahdi20.fullcodes.serviceExample.boundService;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MyService extends Service {

    MyBinder mBinder;

    public class MyBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        if (mBinder == null) {
            mBinder = new MyBinder();
        }
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return false;
    }
}