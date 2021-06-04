package com.bangkit.capstone.managerku.ui.content

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.capstone.managerku.databinding.ActivitySettingBinding
import com.bangkit.capstone.managerku.ui.content.about.AboutActivity
import com.bangkit.capstone.managerku.ui.content.login.LoginActivity

class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.changeLanguage.setOnClickListener {
            Intent(Settings.ACTION_LOCALE_SETTINGS).also {
                startActivity(it)
            }
        }
        binding.about.setOnClickListener {
            Intent(this, AboutActivity::class.java).also {
                startActivity(it)
            }
        }
        binding.logout.setOnClickListener {
            Intent(this, LoginActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}