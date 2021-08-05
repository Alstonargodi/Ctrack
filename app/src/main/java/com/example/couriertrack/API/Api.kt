package com.example.couriertrack.API


import android.os.Parcelable
import com.google.gson.annotations.SerializedName

import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize


data class Api(
    @SerializedName("data")
    var `data`: Data,
    @SerializedName("message")
    var message: String,
    @SerializedName("status")
    var status: Int
)