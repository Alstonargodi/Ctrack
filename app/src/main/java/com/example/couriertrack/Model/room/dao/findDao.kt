package com.example.couriertrack.Model.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.couriertrack.Model.room.entity.Find

@Dao
abstract class findDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun addhistory(find: Find)

    @Delete
    abstract fun deletehisory(find: Find)

    @Query("select*from tabelfind order by id asc")
    abstract fun readhistory(): LiveData<List<Find>>
}