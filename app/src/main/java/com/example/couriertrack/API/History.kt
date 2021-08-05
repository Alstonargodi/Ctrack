package com.example.couriertrack.API

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize


data class History(
    @SerializedName("date")
    var date: String,
    @SerializedName("desc")
    var desc: String,
    @SerializedName("location")
    var location: String
)