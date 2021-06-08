package com.bangkit.capstone.managerku.ui.content.user

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bangkit.capstone.managerku.R
import com.bangkit.capstone.managerku.data.Repository
import com.bangkit.capstone.managerku.data.local.entity.UserEntity
import com.bangkit.capstone.managerku.data.local.room.ManagerkuDatabase
import com.bangkit.capstone.managerku.databinding.ActivitySignUpBinding
import com.bangkit.capstone.managerku.viewmodel.ViewModelFactory

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewModel: UserViewModel
    private lateinit var database: ManagerkuDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            Intent(this, LoginActivity::class.java).also { startActivity(it) }
        }

        database = ManagerkuDatabase.getInstance(this)
        val repo = Repository(database)
        val factory = ViewModelFactory(repo)

        viewModel = ViewModelProvider(this, factory)[UserViewModel::class.java]
        binding.btnSignup.setOnClickListener {
            addUser()
        }
    }

    private fun addUser(){
        val dialog = Dialog(this)
        val name = binding.edName.text.toString()
        val email = binding.edEmail.text.toString()
        val password = binding.edPassword.text.toString()

        val user = UserEntity(null, name, email, password)
        viewModel.addUser(user)
        dialog.setContentView(R.layout.signup_success)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val dialogButton = dialog.findViewById<Button>(R.id.success_button)
        dialogButton.setOnClickListener {
            Intent(this, LoginActivity::class.java).also { startActivity(it) }
        }
        dialog.show()
    }
}