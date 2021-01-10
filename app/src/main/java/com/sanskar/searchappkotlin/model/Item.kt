package com.sanskar.searchappkotlin.model


import com.google.gson.annotations.SerializedName

data class Item(

    @SerializedName("language")
    val language: String?,

    @SerializedName("name")
    val name: String,

    @SerializedName("avatar_url")
    val avatarUrl: String,

    @SerializedName("stargazers_count")
    val stargazersCount: Int


)