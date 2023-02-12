package com.simba.addatimes.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class OriginalResponse(
    @SerializedName("data")
    @Expose
    val data: List<Data>? = null,

    @SerializedName("success")
    @Expose
    val success: Boolean
) : java.io.Serializable