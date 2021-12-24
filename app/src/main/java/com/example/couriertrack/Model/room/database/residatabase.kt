package com.example.couriertrack.Model.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.couriertrack.Model.room.dao.residao
import com.example.couriertrack.Model.room.entity.Resi

@Database(entities = [Resi::class],version = 1,exportSchema = false)
abstract class residatabase: RoomDatabase() {
  abstract fun residao() : residao

  companion object{
        @Volatile
        private var minstace : residatabase? = null

        fun getdatabase(context: Context): residatabase{
            val tempinstace = minstace
            if (tempinstace != null){
                return tempinstace
            }else{
                synchronized(this){
                    val builder = Room.databaseBuilder(
                        context.applicationContext,
                        residatabase::class.java,
                        "residatabase"
                    ).build()
                    minstace = builder
                    return builder
                }
            }
        }
  }
}