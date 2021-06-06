package com.bangkit.capstone.managerku.data

import androidx.lifecycle.LiveData
import com.bangkit.capstone.managerku.data.local.entity.DataEntity
import com.bangkit.capstone.managerku.data.local.entity.ProductEntity
import com.bangkit.capstone.managerku.data.local.room.ManagerkuDatabase

class Repository (val db: ManagerkuDatabase) {
    fun getProduct(): LiveData<List<ProductEntity>>{
        return db.managerkuDao().getProduct()
    }

    fun getSales(): LiveData<List<DataEntity>>{
        return db.managerkuDao().getSalesDate()
    }

    fun getProductName(): List<String>{
        return db.managerkuDao().getProductName()
    }
}