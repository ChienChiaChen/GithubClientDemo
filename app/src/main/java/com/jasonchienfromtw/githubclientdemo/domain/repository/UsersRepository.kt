package com.jasonchienfromtw.githubclientdemo.domain.repository

import androidx.paging.PagedList
import com.jasonchienfromtw.githubclientdemo.domain.models.User
import io.reactivex.Completable
import io.reactivex.Observable

interface UsersRepository {
    fun getUserList(): Observable<PagedList<User>>
    fun updateUser(user: User): Completable
}