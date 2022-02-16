package com.flurry.android.sample.eventfeatures

import android.app.Application
import android.util.Log
import com.flurry.android.FlurryAgent

//XFMGRB9FVS8F8H8XSXYG
class StandardEventApplication: Application() {
    private val APIKey = "XFMGRB9FVS8F8H8XSXYG"

    override fun onCreate() {
        super.onCreate()
        FlurryAgent.Builder()
            .withLogLevel(Log.VERBOSE)
            .withLogEnabled(true)
            .build(this, APIKey)
        Log.d("Application Class", "ONCREATE");

    }

}