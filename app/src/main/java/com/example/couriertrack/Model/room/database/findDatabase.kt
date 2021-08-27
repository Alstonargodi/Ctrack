package com.example.couriertrack.Model.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.couriertrack.Model.room.dao.findDao
import com.example.couriertrack.Model.room.entity.Find

//database history
@Database(entities = [Find::class],version = 1,exportSchema = false)
abstract class findDatabase : RoomDatabase(){
    abstract fun findDao() : findDao

    companion object{
        @Volatile
        private var instance : findDatabase? = null

        fun getdatabase(context: Context): findDatabase {
            val tempinstance = instance
            if(tempinstance != null){
                return tempinstance
            }else{
                synchronized(this){
                    val builder = Room.databaseBuilder(context.applicationContext,
                        findDatabase::class.java,"tabelhistory").build()
                    instance = builder
                    return builder
                }
            }
        }
    }
}