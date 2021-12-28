package com.example.couriertrack.Model.cekongkir


import com.google.gson.annotations.SerializedName

class Result(
    @SerializedName("city_id")
    var cityId: String,
    @SerializedName("city_name")
    var cityName: String,
    @SerializedName("postal_code")
    var postalCode: String,
    @SerializedName("province")
    var province: String,
    @SerializedName("province_id")
    var provinceId: String,
    @SerializedName("type")
    var type: String
)