package com.bangkit.capstone.managerku.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bangkit.capstone.managerku.data.local.entity.ProductEntity
import com.bangkit.capstone.managerku.data.local.entity.SalesEntity

@Dao
interface ManagerkuDao {
    @Insert
    suspend fun addProduct(product: ProductEntity)

    @Query("SELECT * FROM tbl_product")
    fun getProduct(): LiveData<List<ProductEntity>>

    @Insert
    suspend fun addSales(sales: SalesEntity)

    @Query("SELECT * FROM tbl_sales")
    fun getSales(): LiveData<List<SalesEntity>>

//    @Insert
//    suspend fun addUser(user: UserEntity)
//
//    @Update
//    suspend fun updateUser(user: UserEntity)

//    @Query("SELECT * FROM tbl_user")
//    fun getUser(): LiveData<List<UserEntity>>

}