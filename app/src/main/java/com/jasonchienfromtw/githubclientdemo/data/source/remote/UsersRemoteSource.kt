package com.jasonchienfromtw.githubclientdemo.data.source.remote

import com.jasonchienfromtw.githubclientdemo.domain.models.DetailUser
import com.jasonchienfromtw.githubclientdemo.domain.models.User
import io.reactivex.Single

interface UsersRemoteSource {
    fun getUsersFromApi(page: Int): Single<List<User>>
    fun getUserFromApi(name:String): Single<DetailUser>
}