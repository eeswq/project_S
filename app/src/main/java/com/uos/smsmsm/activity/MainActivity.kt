package com.uos.smsmsm.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.uos.smsmsm.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
// Apply ktlint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
