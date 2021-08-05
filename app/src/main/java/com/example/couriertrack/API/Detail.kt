package com.example.couriertrack.API


import android.os.Parcelable
import com.google.gson.annotations.SerializedName

import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

data class Detail(
    @SerializedName("destination")
    var destination: String,
    @SerializedName("origin")
    var origin: String,
    @SerializedName("receiver")
    var `receiver`: String,
    @SerializedName("shipper")
    var shipper: String
)