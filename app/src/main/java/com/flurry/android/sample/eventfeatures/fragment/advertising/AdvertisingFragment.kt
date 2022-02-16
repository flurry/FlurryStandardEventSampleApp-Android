package com.flurry.android.sample.eventfeatures.fragment.advertising

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flurry.android.sample.eventfeatures.databinding.AdvertisingFragmentBinding
import com.flurry.android.FlurryEvent

import com.flurry.android.FlurryAgent
import com.flurry.android.sample.eventfeatures.SnackBarUtil


class AdvertisingFragment : Fragment() {
    private lateinit var binding: AdvertisingFragmentBinding
    private lateinit var showMessage:SnackBarUtil
    private val paramAd1 = FlurryEvent.Params()
    private val paramAd2 = FlurryEvent.Params()

    companion object {
        fun newInstance() = AdvertisingFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = AdvertisingFragmentBinding.inflate(inflater, container, false)
        showMessage = SnackBarUtil(binding.root)

        initYahooAdParams()
        initGoogleAdParams()
        binding.skipButton1.setOnClickListener{

            FlurryAgent.logEvent(FlurryEvent.AD_SKIPPED,paramAd1)
            showMessage.consoleLogMessage(FlurryEvent.AD_SKIPPED,paramAd1)
            showMessage.showMessage("Skipped AD 1")
            initYahooAdParams()
        }



        binding.ad1TextView.setOnClickListener{
            FlurryAgent.logEvent(FlurryEvent.AD_CLICK,paramAd1)
            showMessage.consoleLogMessage(FlurryEvent.AD_CLICK,paramAd1)
            showMessage.showMessage("Clicked on Ad 1")
            initYahooAdParams()
        }

        binding.skipButton2.setOnClickListener{

            FlurryAgent.logEvent(FlurryEvent.AD_SKIPPED,paramAd2)
            showMessage.consoleLogMessage(FlurryEvent.AD_SKIPPED,paramAd2)
            showMessage.showMessage("Skipped AD 2")
            initGoogleAdParams()
        }

        binding.ad2TextView.setOnClickListener{

            FlurryAgent.logEvent(FlurryEvent.AD_CLICK,paramAd2)
            showMessage.consoleLogMessage(FlurryEvent.AD_CLICK,paramAd2)
            showMessage.showMessage("Clicked on Ad 2")
            initGoogleAdParams()

        }

        return binding.root
    }

    private fun initYahooAdParams(){
        paramAd1.clear()
        paramAd1.putString(FlurryEvent.Param.AD_TYPE, "Banner")
                .putString(FlurryEvent.Param.CONTENT_ID ,"bannerAdID")
                .putString("Ad_Owner" ,"Yahoo") // custom parameters
    }

    private fun initGoogleAdParams(){
         paramAd2.clear()
         paramAd2.putString(FlurryEvent.Param.AD_TYPE, "Video")
                 .putString(FlurryEvent.Param.CONTENT_ID ,"VideoAdID")
                 .putString("Ad_Owner" ,"Google") // custom parameters
    }

}