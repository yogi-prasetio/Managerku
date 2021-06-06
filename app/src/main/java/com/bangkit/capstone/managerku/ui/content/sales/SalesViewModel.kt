package com.bangkit.capstone.managerku.ui.content.sales

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bangkit.capstone.managerku.data.Repository
import com.bangkit.capstone.managerku.data.local.entity.DataEntity

class SalesViewModel (val repo: Repository): ViewModel() {

    fun getAllSales(): LiveData<List<DataEntity>>? {
        return repo.getSales()
    }

    fun getProduct(): List<String> {
        return repo.getProductName()
    }

}