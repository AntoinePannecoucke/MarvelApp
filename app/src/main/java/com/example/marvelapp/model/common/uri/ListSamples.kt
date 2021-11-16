package com.example.marvelapp.model.common.uri

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ListSamples(
    @SerializedName("available") val available: String,
    @SerializedName("collectionURI") val collectionURI: String,
    @SerializedName("role") val role: String?,
    @SerializedName("items") val items: List<Sample>,
    @SerializedName("returned") val returned: Int,
) : Serializable
