package com.bangkit.capstone.managerku.ui.content.dashboard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bangkit.capstone.managerku.data.local.entity.ProductEntity
import com.bangkit.capstone.managerku.data.local.room.ManagerkuDao
import com.bangkit.capstone.managerku.data.local.room.ManagerkuDatabase

class DashboardViewModel  (application: Application): AndroidViewModel(application) {
    private var dataDao: ManagerkuDao? = null
    private var dataDb: ManagerkuDatabase?

    init {
        dataDb = ManagerkuDatabase.getInstance(application)
        dataDao = dataDb?.managerkuDao()
    }

    fun getAllProduct(): LiveData<List<ProductEntity>>? {
        return dataDao?.getProduct()
    }

    fun getAllSales(): Int? {
        return dataDao?.getSalesCount()
    }
}