package com.uos.smsmsm.fragment.tabmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uos.smsmsm.R



class UserFragment : Fragment() {

    companion object {
        var PICK_PROFILE_FROM_ALBUM = 101
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)
    }


}