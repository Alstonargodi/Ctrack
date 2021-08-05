package com.example.couriertrack.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
abstract class findDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun addhistory(find: Find)

    @Delete
    abstract fun deletehisory(find: Find)

    @Query("select*from tabelfind order by id asc")
    abstract fun readhistory(): LiveData<List<Find>>
}