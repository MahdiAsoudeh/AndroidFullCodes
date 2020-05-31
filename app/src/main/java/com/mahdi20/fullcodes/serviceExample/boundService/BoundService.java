package com.mahdi20.fullcodes.serviceExample.boundService;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Calendar;
import java.util.Date;

// local service
public class BoundService extends Service {

    private final IBinder binder = new LocalBinder();

    public class LocalBinder extends Binder {
        BoundService getService() {
            return BoundService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }
}