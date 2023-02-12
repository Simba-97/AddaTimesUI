package com.simba.addatimes.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("banner_id")
    @Expose
    val banner_id: Int,

    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("image")
    @Expose
    val image: String,

    @SerializedName("image_order")
    @Expose
    val image_order: Int,

    @SerializedName("url")
    @Expose
    val url: String
)