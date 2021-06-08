package com.bangkit.capstone.managerku.data

import androidx.lifecycle.LiveData
import com.bangkit.capstone.managerku.data.local.entity.DataEntity
import com.bangkit.capstone.managerku.data.local.entity.ProductEntity
import com.bangkit.capstone.managerku.data.local.entity.SalesEntity
import com.bangkit.capstone.managerku.data.local.entity.UserEntity
import com.bangkit.capstone.managerku.data.local.room.ManagerkuDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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

    fun getUser(email: String, pass: String): List<UserEntity>{
        return db.managerkuDao().getUser(email, pass)
    }

    fun addUser(user: UserEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            db.managerkuDao().addUser(user)
        }
    }

    fun addProduct(product: ProductEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            db.managerkuDao().addProduct(product)
        }
    }

    fun addSales(sales: SalesEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            db.managerkuDao().addSales(sales)
        }
    }
}