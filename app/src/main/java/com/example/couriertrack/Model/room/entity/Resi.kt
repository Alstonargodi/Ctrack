package com.example.couriertrack.Model.room.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tabelresi")
@Parcelize
data class Resi(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val kurir : String,
    val resi : String
) : Parcelable