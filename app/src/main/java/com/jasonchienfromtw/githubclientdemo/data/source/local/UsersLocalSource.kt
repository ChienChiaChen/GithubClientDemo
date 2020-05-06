package com.jasonchienfromtw.githubclientdemo.data.source.local

import androidx.paging.DataSource
import com.jasonchienfromtw.githubclientdemo.data.source.local.room.entity.UserEntity
import com.jasonchienfromtw.githubclientdemo.domain.models.User
import io.reactivex.Completable
import io.reactivex.Single

interface UsersLocalSource {
    fun getUsersCountFromDatabase(): Single<Int>
    fun getUsersFromDatabase(): DataSource.Factory<Int, User>
    fun saveUsersInDatabase(users: List<UserEntity>): Completable
    fun updateUser(user: UserEntity): Completable
    fun deleteLocalUsers(): Completable
}