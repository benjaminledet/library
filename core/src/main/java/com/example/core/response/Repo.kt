package com.example.core.response

import com.google.gson.annotations.SerializedName

data class Repo(

    @SerializedName("id")
    val id: Long,

    @SerializedName("name")
    val name: String,

    @SerializedName("private")
    val private: Boolean
)