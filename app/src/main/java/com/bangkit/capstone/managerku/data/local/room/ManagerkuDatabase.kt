package com.bangkit.capstone.managerku.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.bangkit.capstone.managerku.data.local.entity.ProductEntity
import com.bangkit.capstone.managerku.data.local.entity.SalesEntity

@Database(entities = [ProductEntity::class, SalesEntity::class], version = 2, exportSchema = false)
abstract class ManagerkuDatabase : RoomDatabase() {
    abstract fun managerkuDao(): ManagerkuDao

    companion object {

        @Volatile
        private var INSTANCE: ManagerkuDatabase? = null

        val MIGRATION_1_2: Migration by lazy {
            object : Migration(1,2) {
                override fun migrate(database: SupportSQLiteDatabase) { }
            }
        }

        fun getInstance(context: Context): ManagerkuDatabase =
                INSTANCE ?: synchronized(this) {
                    Room.databaseBuilder(
                            context.applicationContext,
                            ManagerkuDatabase::class.java,
                            "managerku.db"
                    ).fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .addMigrations(MIGRATION_1_2)
                        .build().apply { INSTANCE = this }
                }
    }
}