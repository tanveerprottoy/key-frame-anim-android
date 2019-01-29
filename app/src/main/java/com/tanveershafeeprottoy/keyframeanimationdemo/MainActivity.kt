package com.tanveershafeeprottoy.keyframeanimationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ActivityUtils.addFragmentOnActivity(
            supportFragmentManager, MainFragment.newInstance(), R.id.mainFrame
        )
    }
}
