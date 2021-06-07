package com.bangkit.capstone.managerku.data

import androidx.lifecycle.LiveData
import com.bangkit.capstone.managerku.data.local.entity.DataEntity
import com.bangkit.capstone.managerku.data.local.entity.ProductEntity
import com.bangkit.capstone.managerku.data.local.entity.SalesEntity
import com.bangkit.capstone.managerku.data.local.room.ManagerkuDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository (val db: ManagerkuDatabase) {
//    private lateinit var product: ProductEntity
    fun getProduct(): LiveData<List<ProductEntity>>{
        return db.managerkuDao().getProduct()
    }

    fun getSales(): LiveData<List<DataEntity>>{
        return db.managerkuDao().getSalesDate()
    }

    fun getProductName(): List<String>{
        return db.managerkuDao().getProductName()
    }

    fun addProduct(id: Int, name: String, price: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val product = ProductEntity(id, name, price)
            db.managerkuDao().addProduct(product)
        }
    }

    fun addSales(id: Int, productId: Int, qty: Int, date: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val sales = SalesEntity(id, productId, qty, date)
            db.managerkuDao().addSales(sales)
        }
    }
}