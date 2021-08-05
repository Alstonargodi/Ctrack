package com.example.couriertrack.API


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.example.couriertrack.API.Detail
import com.example.couriertrack.API.History
import com.example.couriertrack.API.Summary
import kotlinx.android.parcel.Parcelize

data class Data(
    @SerializedName("detail")
    var detail: Detail,
    @SerializedName("history")
    var history: List<History>,
    @SerializedName("summary")
    var summary: Summary
)