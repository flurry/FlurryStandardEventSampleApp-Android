package com.flurry.android.sample.eventfeatures.fragment.policy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flurry.android.FlurryAgent
import com.flurry.android.FlurryEvent
import com.flurry.android.sample.eventfeatures.SnackBarUtil
import com.flurry.android.sample.eventfeatures.databinding.PrivatePolicyFragmentBinding

class PrivatePolicyFragment : Fragment() {

    private lateinit var binding:PrivatePolicyFragmentBinding
    private val params = FlurryEvent.Params()

    companion object {
        fun newInstance() = PrivatePolicyFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Record that user has seen the policy
        FlurryAgent.logEvent(FlurryEvent.PRIVACY_PROMPT_DISPLAYED.toString())

        initParams()
        binding = PrivatePolicyFragmentBinding.inflate(inflater,container,false)
        val display = SnackBarUtil(binding.root)

        binding.AgreeButton.setOnClickListener {

            params.putBoolean(FlurryEvent.Param.SUCCESS, true)

            FlurryAgent.logEvent(FlurryEvent.PRIVACY_OPT_IN,params)
            display.consoleLogMessage(FlurryEvent.PRIVACY_OPT_IN,params)
            display.showMessage("User clicked Agree")
            initParams()
        }
        binding.declineButton.setOnClickListener {
            params.putBoolean(FlurryEvent.Param.SUCCESS, false)

            FlurryAgent.logEvent(FlurryEvent.PRIVACY_OPT_OUT,params)
            display.consoleLogMessage(FlurryEvent.PRIVACY_OPT_OUT,params)
            display.showMessage("User clicked Decline")
            initParams()
        }
        return binding.root
    }

    private fun initParams(){
        params.clear()
        params.putString(FlurryEvent.Param.CONTENT_TYPE,"Private Policy Agreement")
              .putInteger("Policy#",1234)
    }

}