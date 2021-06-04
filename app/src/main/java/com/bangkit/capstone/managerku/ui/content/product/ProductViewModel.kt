package com.bangkit.capstone.managerku.ui.content.product

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bangkit.capstone.managerku.data.local.entity.ProductEntity
import com.bangkit.capstone.managerku.data.local.room.ManagerkuDao
import com.bangkit.capstone.managerku.data.local.room.ManagerkuDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel (application: Application): AndroidViewModel(application) {
    private var dataDao: ManagerkuDao? = null
    private var dataDb: ManagerkuDatabase?

    init {
        dataDb = ManagerkuDatabase.getInstance(application)
        dataDao = dataDb?.managerkuDao()
    }

    fun getAllProduct(): LiveData<List<ProductEntity>>? {
        return dataDao?.getProduct()
    }

    fun addProduct (id: Int, name: String, price: Int){
        CoroutineScope(Dispatchers.IO).launch {
            val product = ProductEntity(
                    id,
                    name,
                    price
            )
            dataDao?.addProduct(product)
        }
    }

}