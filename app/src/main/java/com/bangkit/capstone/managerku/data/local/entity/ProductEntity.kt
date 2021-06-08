package com.bangkit.capstone.managerku.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_product")
data class ProductEntity(
        @NonNull
        @ColumnInfo(name = "name")
        var name: String? = null,

        @NonNull
        @ColumnInfo(name = "price")
        var price: Int? = 0,

        @NonNull
        @ColumnInfo(name = "stok")
        var stok: Int? = 0
) {
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id_product")
        var id: Int = 0

}
