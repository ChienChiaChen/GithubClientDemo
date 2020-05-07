package com.jasonchienfromtw.githubclientdemo.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DetailUser(
    val id: String,
    @SerializedName("location") val location: String,
    @SerializedName("blog") val blog: String
) : Serializable
