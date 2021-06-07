package com.bangkit.capstone.managerku.ui.content.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.capstone.managerku.databinding.ActivitySignUpBinding
import com.bangkit.capstone.managerku.ui.home.MainActivity

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            Intent(this, MainActivity::class.java).also { startActivity(it) }
        }
        binding.btnLogin.setOnClickListener {
            Intent(this, LoginActivity::class.java).also { startActivity(it) }
        }
    }
}