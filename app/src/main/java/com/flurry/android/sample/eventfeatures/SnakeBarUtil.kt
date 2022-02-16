package com.flurry.android.sample.eventfeatures

import android.util.Log
import android.view.View
import com.flurry.android.FlurryEvent
import com.flurry.android.sample.eventfeatures.fragment.policy.PrivatePolicyFragment
import com.google.android.gms.common.util.JsonUtils
import com.google.android.material.snackbar.Snackbar
import org.json.JSONObject

class SnackBarUtil(view:View) {
    private val currentView = view
    private val tagStart = "FlurryEvent"
    fun showMessage(message:String){
        Snackbar.make(
            currentView,
            message,
            Snackbar.LENGTH_SHORT
        ).show()
    }

    fun consoleLogMessage(flurryEvent:FlurryEvent, params: FlurryEvent.Params){
        val TAG = "$tagStart $flurryEvent"
        var paramsString = "{ "
        for (key in params.params.keys){
            paramsString += " $key : ${params.params[key]},"
        }
        paramsString+=" }"
        Log.d(TAG,paramsString)
    }
}