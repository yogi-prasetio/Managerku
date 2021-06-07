package com.bangkit.capstone.managerku.ui.content.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bangkit.capstone.managerku.data.Repository
import com.bangkit.capstone.managerku.data.local.entity.ProductEntity

class ProductViewModel (val repo: Repository): ViewModel() {

    fun getProduct(): LiveData<List<ProductEntity>>?{
        return repo.getProduct()
    }

    fun addProduct(id: Int, name: String, price: Int){
        return repo.addProduct(id, name, price)
    }
}