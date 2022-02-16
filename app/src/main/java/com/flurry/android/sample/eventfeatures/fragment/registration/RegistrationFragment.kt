package com.flurry.android.sample.eventfeatures.fragment.registration

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flurry.android.FlurryAgent
import com.flurry.android.FlurryEvent
import com.flurry.android.sample.eventfeatures.R
import com.flurry.android.sample.eventfeatures.SnackBarUtil
import com.flurry.android.sample.eventfeatures.databinding.RegistrationFragmentBinding
import com.flurry.android.sample.eventfeatures.databinding.SocialFragmentBinding

class RegistrationFragment : Fragment() {

    private lateinit var binding: RegistrationFragmentBinding
    private lateinit var userName:String

    companion object {
        fun newInstance() = RegistrationFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RegistrationFragmentBinding.inflate(inflater,container,false)
        val display = SnackBarUtil(binding.root)
        val userNameString = binding.editTextTextPersonName.text.toString()
        userName = if ( userNameString != "") userNameString else "defaultName"

        binding.registationButton.setOnClickListener {
            val params = FlurryEvent.Params()
                .putString(FlurryEvent.Param.METHOD, "Email")
                .putString(FlurryEvent.Param.USER_ID,userName)

            FlurryAgent.logEvent(FlurryEvent.USER_REGISTERED,params)
            display.consoleLogMessage(FlurryEvent.USER_REGISTERED,params)
            display.showMessage("Registered as a new user")

        }

        binding.googleButton.setOnClickListener {

            val params = FlurryEvent.Params()
                .putString(FlurryEvent.Param.METHOD, "Google")
                .putString(FlurryEvent.Param.USER_ID,userName)

            FlurryAgent.logEvent(FlurryEvent.USER_REGISTERED,params)
            display.consoleLogMessage(FlurryEvent.USER_REGISTERED,params)
            display.showMessage("Registered with a Google account")

        }

        binding.facebookButton.setOnClickListener {

            val params = FlurryEvent.Params()
                .putString(FlurryEvent.Param.METHOD, "Facebook")
                .putString(FlurryEvent.Param.USER_ID,userName)

            FlurryAgent.logEvent(FlurryEvent.USER_REGISTERED,params)
            display.consoleLogMessage(FlurryEvent.USER_REGISTERED,params)

            display.showMessage("Registered with a Facebook account")

        }

        binding.loginButton.setOnClickListener {

            val params = FlurryEvent.Params()
                .putString(FlurryEvent.Param.METHOD, "email and password")
                .putString(FlurryEvent.Param.USER_ID,userName)

            FlurryAgent.logEvent(FlurryEvent.LOGIN,params)
            display.consoleLogMessage(FlurryEvent.LOGIN,params)
            display.showMessage("Login with an old account")
        }

        return binding.root
    }



}