package com.simba.addatimes.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("horizontal_image")
    @Expose
    val horizontal_image: String,

    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("type")
    @Expose
    val type: Int,

    @SerializedName("vertical_image")
    @Expose
    val vertical_image: String
) : java.io.Serializable