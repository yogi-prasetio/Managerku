package com.bangkit.capstone.managerku.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bangkit.capstone.managerku.data.Repository
import com.bangkit.capstone.managerku.ui.content.product.ProductViewModel
import com.bangkit.capstone.managerku.ui.content.sales.SalesViewModel
import com.bangkit.capstone.managerku.ui.content.user.UserViewModel
import com.bangkit.capstone.managerku.ui.home.MainViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repo: Repository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel() as T
            }
            modelClass.isAssignableFrom(UserViewModel::class.java) -> {
                UserViewModel(repo) as T
            }
            modelClass.isAssignableFrom(ProductViewModel::class.java) -> {
                ProductViewModel(repo) as T
            }
            modelClass.isAssignableFrom(SalesViewModel::class.java) -> {
                SalesViewModel(repo) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}