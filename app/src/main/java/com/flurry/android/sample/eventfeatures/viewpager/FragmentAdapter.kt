package com.flurry.android.sample.eventfeatures.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.flurry.android.sample.eventfeatures.fragment.policy.PrivatePolicyFragment
import com.flurry.android.sample.eventfeatures.fragment.advertising.AdvertisingFragment
import com.flurry.android.sample.eventfeatures.fragment.registration.RegistrationFragment
import com.flurry.android.sample.eventfeatures.fragment.social.SocialFragment

class FragmentAdapter(fragManger: FragmentManager,lifecycle: Lifecycle,itemCount:Int):
    FragmentStateAdapter(fragManger,lifecycle)
{
    private val count = itemCount
    override fun getItemCount(): Int {
        return count
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            1 -> return PrivatePolicyFragment.newInstance()
            2 -> return  RegistrationFragment.newInstance()
            3 -> return SocialFragment.newInstance()
        }
        return AdvertisingFragment.newInstance()
    }
}

