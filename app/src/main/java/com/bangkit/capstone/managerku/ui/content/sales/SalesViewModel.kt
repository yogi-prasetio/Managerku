package com.bangkit.capstone.managerku.ui.content.sales

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bangkit.capstone.managerku.data.local.entity.ProductEntity
import com.bangkit.capstone.managerku.data.local.entity.SalesEntity
import com.bangkit.capstone.managerku.data.local.room.ManagerkuDao
import com.bangkit.capstone.managerku.data.local.room.ManagerkuDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SalesViewModel (application: Application): AndroidViewModel(application) {
    private var dataDao: ManagerkuDao? = null
    private var dataDb: ManagerkuDatabase?

    init {
        dataDb = ManagerkuDatabase.getInstance(application)
        dataDao = dataDb?.managerkuDao()
    }

    fun getAllSales(): LiveData<List<SalesEntity>>? {
        return dataDao?.getSales()
    }

    fun getProduct(): LiveData<List<ProductEntity>>? {
        return dataDao?.getProduct()
    }

    fun addSales(id: Int, productId: Int, qty: Int, tanggal: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val data = SalesEntity(
                id,
                productId,
                qty,
                tanggal
            )
            dataDao?.addSales(data)
        }
    }
}