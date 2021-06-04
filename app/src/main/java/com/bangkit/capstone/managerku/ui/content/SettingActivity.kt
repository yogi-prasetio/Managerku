package com.bangkit.capstone.managerku.ui.content

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.capstone.managerku.R
import com.bangkit.capstone.managerku.databinding.ActivitySettingBinding
import com.bangkit.capstone.managerku.ui.content.login.LoginActivity

class SettingActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.change_language -> {
                Intent(Settings.ACTION_LOCALE_SETTINGS).also {
                    startActivity(it)
                }
            }
            R.id.about -> {
                Intent(Settings.ACTION_LOCALE_SETTINGS).also {
                    startActivity(it)
                }
            }
            R.id.logout -> {
                Intent(this, LoginActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}