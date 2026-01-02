package com.devshady.captone.littlelemon.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Database(version = 1, entities = [MenuItemRoom::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun menuDao(): MenuDao
}

@Entity(tableName = "order_menu")
data class MenuItemRoom(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val image: String,
    val category: String
)

@Dao
interface MenuDao {
    @Query("SELECT * FROM order_menu")
    fun getAll(): LiveData<List<MenuItemRoom>>

    @Insert
    fun insertAll(menuItems: List<MenuItemRoom>)

    @Query("SELECT (SELECT COUNT(*) FROM order_menu) == 0")
    fun isEmpty(): Boolean
}