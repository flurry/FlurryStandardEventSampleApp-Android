package com.flurry.android.sample.eventfeatures.fragment.social

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
import com.flurry.android.sample.eventfeatures.databinding.SocialFragmentBinding

class SocialFragment : Fragment() {

    private lateinit var binding: SocialFragmentBinding
    private val params = FlurryEvent.Params()
    companion object {
        fun newInstance() = SocialFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = SocialFragmentBinding.inflate(inflater,container,false)
        val display = SnackBarUtil(binding.root)

        initParams()

        binding.commentButton.setOnClickListener{

            FlurryAgent.logEvent(FlurryEvent.COMMENT,params)
            display.consoleLogMessage(FlurryEvent.COMMENT,params)
            display.showMessage("Sent a comment")
            initParams()

        }
        binding.likeButton.setOnClickListener{
            params.putString(FlurryEvent.Param.LIKE_TYPE,"Emoji Reaction") // what kind of like is logged (“celebrate”, “insightful”, etc)

            FlurryAgent.logEvent(FlurryEvent.LIKE,params)
            display.consoleLogMessage(FlurryEvent.LIKE ,params)
            display.showMessage("Liked the post")
            initParams()

        }
        binding.shareButton.setOnClickListener{
             params.putString(FlurryEvent.Param.METHOD,"email")

            FlurryAgent.logEvent(FlurryEvent.SHARE,params)
            display.consoleLogMessage(FlurryEvent.SHARE ,params)
            display.showMessage("Shared the post")
            initParams()
        }

        return binding.root
    }

    private fun initParams(){
        params.clear()
        params.putString(FlurryEvent.Param.SOCIAL_CONTENT_NAME, "UserPost")
            .putString(FlurryEvent.Param.SOCIAL_CONTENT_ID,"#1234")
            .putString("PostType","FriendsPost")
    }


}