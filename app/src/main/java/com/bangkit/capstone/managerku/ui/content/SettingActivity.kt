package com.bangkit.capstone.managerku.ui.content

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.capstone.managerku.R
import com.bangkit.capstone.managerku.databinding.ActivitySettingBinding
import com.bangkit.capstone.managerku.ui.content.user.LoginActivity


class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding
    lateinit var myDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        myDialog = Dialog(this)

        binding.apply {
            changeLanguage.setOnClickListener {
                Intent(Settings.ACTION_LOCALE_SETTINGS).also {
                    startActivity(it)
                }
            }

            about.setOnClickListener {
                myDialog.setContentView(R.layout.about_page)
                myDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                myDialog.show()
            }

            logout.setOnClickListener {
                Intent(baseContext, LoginActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }

}