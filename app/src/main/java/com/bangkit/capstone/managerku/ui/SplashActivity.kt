package com.bangkit.capstone.managerku.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.capstone.managerku.R
import com.bangkit.capstone.managerku.ui.home.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(mainLooper).postDelayed({
            Intent(this, MainActivity::class.java).also { startActivity(it) }
            finish()
        }, 2500 )
    }
}