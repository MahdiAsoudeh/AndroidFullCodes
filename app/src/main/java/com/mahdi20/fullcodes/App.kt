package com.mahdi20.codes

import android.app.Application
import android.content.Context

class App : Application() {


    companion object {

//        lateinit var myCache: Cache
        lateinit var context: Context

    }

    override fun onCreate() {
        super.onCreate()

//        var cacheSize = (5 * 1024 * 1024).toLong()
//        myCache = Cache(this.cacheDir, cacheSize)


        context = applicationContext


    }
}