package com.example.couriertrack.Repo.Room

import androidx.lifecycle.LiveData
import com.example.couriertrack.Model.room.dao.residao
import com.example.couriertrack.Model.room.entity.Resi

class Resirepo(private val residao : residao) {
    val readresi : LiveData<List<Resi>> = residao.readresi()

    fun addresi(resi: Resi){
        residao.addresi(resi)
    }
}