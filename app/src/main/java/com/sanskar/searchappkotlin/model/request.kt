package com.sanskar.searchappkotlin.model


import com.google.gson.annotations.SerializedName

data class request(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("total_count")
    val totalCount: Int
)