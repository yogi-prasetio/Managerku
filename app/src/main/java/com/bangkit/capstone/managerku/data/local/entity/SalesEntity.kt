package com.bangkit.capstone.managerku.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_sales")
data class SalesEntity(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        val id: Int,

        @NonNull
        @ColumnInfo(name = "id_product")
        val id_product: Int,

        @NonNull
        @ColumnInfo(name = "qty")
        val qty: Int,

        @NonNull
        @ColumnInfo(name = "tanggal")
        val tanggal: String
)
