package com.bangkit.capstone.managerku.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bangkit.capstone.managerku.data.local.entity.DataEntity
import com.bangkit.capstone.managerku.data.local.entity.ProductEntity
import com.bangkit.capstone.managerku.data.local.entity.SalesEntity
import com.bangkit.capstone.managerku.data.local.entity.UserEntity

@Dao
interface ManagerkuDao {
    //product
    @Insert
    fun addProduct(product: ProductEntity)

    @Query("SELECT * FROM tbl_product")
    fun getProduct(): LiveData<List<ProductEntity>>

    @Query("SELECT name FROM tbl_product")
    fun getProductName():List<String>

    @Query("SELECT id_product FROM tbl_product WHERE name = :name")
    fun getIdByProductName(name: String): Int

    @Query("SELECT name FROM tbl_product WHERE id_product = :productId")
    fun getProductById(productId: Int): String

    //sales
    @Insert
    fun addSales(sales: SalesEntity)

    @Query("SELECT count(*) FROM tbl_sales")
    fun getSalesCount(): Int

    @Query("SELECT date, count(date) as qty FROM tbl_sales GROUP BY date")
    fun getSalesDate(): LiveData<List<DataEntity>>

    @Query("SELECT * FROM tbl_sales WHERE date = :date")
    fun getDetailSales(date: String): LiveData<List<SalesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = UserEntity::class)
    fun addUser(user: UserEntity)

    @Query("SELECT * FROM tbl_user WHERE email = :email AND password = :pass")
    fun getUser(email: String, pass: String): List<UserEntity>

}