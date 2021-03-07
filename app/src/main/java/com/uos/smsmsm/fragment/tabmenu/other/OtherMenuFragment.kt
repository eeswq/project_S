package com.uos.smsmsm.fragment.tabmenu.other

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.uos.smsmsm.R
import com.uos.smsmsm.activity.setting.SettingActivity
import com.uos.smsmsm.databinding.FragmentOtherMenuBinding

class OtherMenuFragment : Fragment() {

    lateinit var binding: FragmentOtherMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { // View? -> View (NonNull)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_other_menu, container, false)
        binding.fragmentothermenu = this

        // 설정
        binding.fragmentOtherMenuSettingButton.setOnClickListener {
            startActivity(Intent(binding.root.context, SettingActivity::class.java))
        }

        return binding.root
    }

    fun onClickProfilePhoto(view: View) {
    }

    fun onClickSettingButton(view: View) {
        startActivity(Intent(binding.root.context, SettingActivity::class.java))
    }
}
