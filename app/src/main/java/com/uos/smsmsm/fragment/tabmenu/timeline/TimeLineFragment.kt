package com.uos.smsmsm.fragment.tabmenu.timeline

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.uos.smsmsm.R
import com.uos.smsmsm.databinding.FragmentTimeLineBinding

class TimeLineFragment : Fragment() {


    lateinit var binding : FragmentTimeLineBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_time_line,container,false)

        return binding.root
    }

}