package com.jasonchienfromtw.githubclientdemo.data.source.remote

import com.jasonchienfromtw.githubclientdemo.data.source.remote.retrofit.UsersService
import com.jasonchienfromtw.githubclientdemo.domain.models.DetailUser
import com.jasonchienfromtw.githubclientdemo.domain.models.User
import io.reactivex.Single

class UsersRemoteSourceImpl(private val usersService: UsersService): UsersRemoteSource {

    override fun getUsersFromApi(page: Int): Single<List<User>> = usersService.getUsers(page)

    override fun getUserFromApi(name: String): Single<DetailUser> = usersService.getUser(name)
}