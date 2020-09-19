package com.example.plobal.Model

import com.google.gson.annotations.SerializedName

class Sessions (
    @SerializedName("total") val total : Int,
    @SerializedName("month_wise") val month_wise : Month_wise
)
