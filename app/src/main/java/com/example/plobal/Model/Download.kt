package com.example.plobal.Model

import com.google.gson.annotations.SerializedName

class Download (

    @SerializedName("total") val total : Int,
    @SerializedName("month_wise") val month_wise : Month_wise
)