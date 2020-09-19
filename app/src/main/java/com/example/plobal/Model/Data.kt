package com.example.plobal.Model

import android.provider.MediaStore
import com.google.gson.annotations.SerializedName

class Data (
    @SerializedName("downloads") val downloads : Download,
    @SerializedName("sessions") val sessions : Sessions,
    @SerializedName("total_sale") val total_sale : Total_sale,
    @SerializedName("add_to_cart") val add_to_cart : Add_to_cart
)