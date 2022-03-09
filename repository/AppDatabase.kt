package com.example.todoapplication.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao() : TodoDAO

    companion object{
        private var instant: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase{
            if(instant == null){
                synchronized(this){
                    instant = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "todo"
                    ).allowMainThreadQueries().build()
                }
            }
            return instant!!
        }
    }
}