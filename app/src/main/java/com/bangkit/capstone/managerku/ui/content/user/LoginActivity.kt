package com.bangkit.capstone.managerku.ui.content.user

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bangkit.capstone.managerku.R
import com.bangkit.capstone.managerku.data.Repository
import com.bangkit.capstone.managerku.data.local.room.ManagerkuDatabase
import com.bangkit.capstone.managerku.databinding.ActivityLoginBinding
import com.bangkit.capstone.managerku.ui.content.pofile.ProfileFragment
import com.bangkit.capstone.managerku.ui.home.MainActivity
import com.bangkit.capstone.managerku.viewmodel.ViewModelFactory

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: UserViewModel
    private lateinit var database: ManagerkuDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            Intent(this, SignUpActivity::class.java).also{ startActivity(it) }
        }

        database = ManagerkuDatabase.getInstance(this)
        val repo = Repository(database)
        val factory = ViewModelFactory(repo)

        viewModel = ViewModelProvider(this, factory)[UserViewModel::class.java]
        binding.btnLogin.setOnClickListener {
            checkLogin()
        }
    }

    private fun checkLogin(){
        val email = binding.username.text.toString()
        val password = binding.password.text.toString()
        val status =  viewModel.getUser(email, password)
        if (status.isEmpty()) {
            Toast.makeText(this, "Login failed!", Toast.LENGTH_SHORT).show()
        }
        else {
            val transaction  = supportFragmentManager.beginTransaction()
            val bundle = Bundle()
            val frag = ProfileFragment()
            val em = "Emailku"
            bundle.putString("email", em)
            bundle.putString("password", password)
            frag.arguments = bundle

            transaction.replace(R.id.profile_navigation, frag)
            transaction.commit()
            Intent(this, MainActivity::class.java).also { startActivity(it) }

        }
    }
}