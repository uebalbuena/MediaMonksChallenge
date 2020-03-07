package com.example.mediamonkschallenge.model


import com.google.gson.annotations.SerializedName

data class Albums(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)