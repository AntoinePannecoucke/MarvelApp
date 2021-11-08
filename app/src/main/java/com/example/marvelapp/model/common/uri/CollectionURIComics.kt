package com.example.marvelapp.model.common.uri

import com.google.gson.annotations.SerializedName

data class CollectionURIComics(
    @SerializedName("available") val available: String,
    @SerializedName("collectionURI") val collectionURI: String,
    @SerializedName("role") val role: String?,
    @SerializedName("items") val items: List<ResourcesURI>,
    @SerializedName("returned") val returned: Int,
)
