package com.bangkit.capstone.managerku.ui.content.pofile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.bangkit.capstone.managerku.data.local.room.ManagerkuDao
import com.bangkit.capstone.managerku.data.local.room.ManagerkuDatabase

class ProfileViewModel (application: Application): AndroidViewModel(application) {
    private var dataDao: ManagerkuDao? = null
    private var dataDb: ManagerkuDatabase?

    init {
        dataDb = ManagerkuDatabase.getInstance(application)
        dataDao = dataDb?.managerkuDao()
    }

//    fun getUser(): LiveData<List<UserEntity>>? {
//        return dataDao?.getUser()
//    }
}