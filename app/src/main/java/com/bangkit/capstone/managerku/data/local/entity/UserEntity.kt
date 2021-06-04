package com.bangkit.capstone.managerku.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_user")
data class UserEntity(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id_user")
        val id: Int,

        @NonNull
        @ColumnInfo(name = "img_profile")
        val img_profile: String,

        @NonNull
        @ColumnInfo(name = "name")
        val name: String,

        @NonNull
        @ColumnInfo(name = "email")
        val email: String,

        @NonNull
        @ColumnInfo(name = "no_hp")
        val phone: String
)
