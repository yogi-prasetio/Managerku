package com.bangkit.capstone.managerku.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_user")
data class UserEntity(

        var img_profile: String? = null,
        var name: String? = null,
        var email: String? = null,
        var password: String? = null

) {
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id_user")
        var id: Int = 0


}