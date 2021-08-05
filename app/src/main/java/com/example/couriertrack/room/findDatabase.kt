package com.example.couriertrack.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//database history
@Database(entities = [Find::class],version = 1,exportSchema = false)

abstract class findDatabase : RoomDatabase(){
    abstract fun findDao() : findDao

    companion object{
        @Volatile
        private var instance : findDatabase? = null

        fun getdatabase(context: Context): findDatabase{
            val tempinstance = instance
            if(tempinstance != null){
                return tempinstance
            }else{
                synchronized(this){
                    val builder = Room.databaseBuilder(context.applicationContext,findDatabase::class.java,"finddatabase").build()
                    instance = builder
                    return builder
                }
            }
        }
    }
}