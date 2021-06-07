package com.bangkit.capstone.managerku.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_product")
data class ProductEntity(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id_product")
        val id: Int,

        @NonNull
        @ColumnInfo(name = "name")
        val name: String,

        @NonNull
        @ColumnInfo(name = "price")
        val price: Int,

        @NonNull
        @ColumnInfo(name = "stok")
        val stok: Int
)
