package com.example.couriertrack.Model.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.couriertrack.Model.room.entity.Resi

@Dao
abstract class residao {

    @Query("select*from tabelresi")
    abstract fun readresi(): LiveData<List<Resi>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun addresi(resi : Resi)


}