package com.feng.jetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.feng.jetpack.ui.main.DataBindFragment
import com.feng.jetpack.ui.main.MainFragment
import com.feng.jetpack.ui.main.RoomFragment
import com.feng.jetpack.ui.main.SampleFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, RoomFragment.newInstance())
                    .commitNow()
        }
    }
}