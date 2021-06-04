package com.bangkit.capstone.managerku.ui.content.about

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.capstone.managerku.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private var _activityBinding: ActivityAboutBinding? = null
    private val binding get() = _activityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityBinding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }
}