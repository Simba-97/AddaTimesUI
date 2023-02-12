package com.simba.addatimes.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Data(
    @SerializedName("banners")
    @Expose
    val banners: List<List<Banner>>,

    @SerializedName("category_id")
    @Expose
    val category_id: Int,

    @SerializedName("collection_id")
    @Expose
    val collection_id: Int,

    @SerializedName("items")
    @Expose
    val items: List<Item>,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("top_banner")
    @Expose
    val top_banner: Any
) : Serializable