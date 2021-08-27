package com.example.couriertrack.Model.cekresi


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("detail")
    var detail: Detail,
    @SerializedName("history")
    var history: List<History>,
    @SerializedName("summary")
    var summary: Summary
)