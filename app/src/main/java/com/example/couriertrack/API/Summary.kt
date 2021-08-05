package com.example.couriertrack.API


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize
import java.math.BigInteger

data class Summary(
    @SerializedName("amount")
    var amount: String,
    @SerializedName("awb")
    var awb: Long,
    @SerializedName("courier")
    var courier: String,
    @SerializedName("date")
    var date: String,
    @SerializedName("desc")
    var desc: String,
    @SerializedName("service")
    var service: String,
    @SerializedName("status")
    var status: String,
    @SerializedName("weight")
    var weight: String
)