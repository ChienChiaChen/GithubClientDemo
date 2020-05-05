package com.jasonchienfromtw.githubclientdemo.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    val id: String,
    @SerializedName("login") val name: String,
    @SerializedName("avatar_url") val avatarUrl: String
) : Serializable
