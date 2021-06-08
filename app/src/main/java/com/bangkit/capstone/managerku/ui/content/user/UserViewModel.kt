package com.bangkit.capstone.managerku.ui.content.user

import androidx.lifecycle.ViewModel
import com.bangkit.capstone.managerku.data.Repository
import com.bangkit.capstone.managerku.data.local.entity.UserEntity

class UserViewModel(val repo: Repository): ViewModel() {

    fun getUser(email: String, pass: String): List<UserEntity> {
        return repo.getUser(email, pass)
    }

    fun addUser(userEntity: UserEntity) {
        return repo.addUser(userEntity)
    }
}