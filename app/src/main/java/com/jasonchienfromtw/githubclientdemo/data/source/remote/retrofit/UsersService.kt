package com.jasonchienfromtw.githubclientdemo.data.source.remote.retrofit

import com.jasonchienfromtw.githubclientdemo.data.constants.RepositoryConstants.DEFAULT_PAGE
import com.jasonchienfromtw.githubclientdemo.data.constants.RepositoryConstants.DEFAULT_PAGE_SIZE
import com.jasonchienfromtw.githubclientdemo.domain.models.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersService {

    @GET(" ")
    fun getUsers(
        @Query("page") page: Int = DEFAULT_PAGE,
        @Query("per_page") perPage: Int = DEFAULT_PAGE_SIZE
    ): Single<List<User>>
}