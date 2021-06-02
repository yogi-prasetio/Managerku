package com.bangkit.capstone.managerku.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bangkit.capstone.managerku.data.local.entity.ProductEntity
import com.bangkit.capstone.managerku.data.local.entity.SalesEntity

@Database(entities = [ProductEntity::class, SalesEntity::class], version = 1, exportSchema = false)
abstract class ManagerkuDatabase : RoomDatabase() {
    abstract fun managerkuDao(): ManagerkuDao

    companion object {

        @Volatile
        private var INSTANCE: ManagerkuDao? = null

        fun getInstance(context: Context): ManagerkuDatabase =
                (INSTANCE ?: synchronized(this) {
                    INSTANCE ?: Room.databaseBuilder(
                            context.applicationContext,
                            ManagerkuDatabase::class.java,
                            "managerku.db"
                    ).build()
                }) as ManagerkuDatabase
    }
}