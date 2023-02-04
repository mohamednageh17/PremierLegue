package com.example.data.remote.response

import com.google.gson.annotations.SerializedName

data class Competition(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("area") var area: Area? = Area(),
    @SerializedName("name") var name: String? = null,
    @SerializedName("code") var code: String? = null,
    @SerializedName("plan") var plan: String? = null,
    @SerializedName("lastUpdated") var lastUpdated: String? = null,
)

data class Area(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
)
