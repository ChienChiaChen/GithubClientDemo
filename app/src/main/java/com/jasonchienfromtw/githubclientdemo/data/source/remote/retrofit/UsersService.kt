package com.jasonchienfromtw.githubclientdemo.data.source.remote.retrofit

import com.jasonchienfromtw.githubclientdemo.data.constants.RepositoryConstants.DEFAULT_PAGE
import com.jasonchienfromtw.githubclientdemo.data.constants.RepositoryConstants.DEFAULT_PAGE_SIZE
import com.jasonchienfromtw.githubclientdemo.domain.models.DetailUser
import com.jasonchienfromtw.githubclientdemo.domain.models.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UsersService {

    @GET("/users")
    fun getUsers(
        @Query("page") page: Int = DEFAULT_PAGE,
        @Query("per_page") perPage: Int = DEFAULT_PAGE_SIZE
    ): Single<List<User>>

    @GET("/users/{name}")
    fun getUser(@Path("name") name: String): Single<DetailUser>
}