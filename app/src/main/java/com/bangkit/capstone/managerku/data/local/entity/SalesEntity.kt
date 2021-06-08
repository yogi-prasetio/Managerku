package com.bangkit.capstone.managerku.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_sales")
data class SalesEntity(

        @ColumnInfo(name = "id_product")
        var id_product: Int? = 0,

        @NonNull
        @ColumnInfo(name = "qty")
        var qty: Int? = 0,

        @NonNull
        @ColumnInfo(name = "date")
        var date: String? = null
) {
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var id: Int = 0
}
