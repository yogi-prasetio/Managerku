package com.bangkit.capstone.managerku.ui.content.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.capstone.managerku.databinding.ActivityLoginBinding
import com.bangkit.capstone.managerku.ui.home.MainActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            Intent(this, MainActivity::class.java).also{ startActivity(it) }
        }

        binding.btnSignup.setOnClickListener {
            Intent(this, SignUpActivity::class.java).also{ startActivity(it) }
        }
    }
}