package com.jasonchienfromtw.githubclientdemo.data.repository

import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.jasonchienfromtw.githubclientdemo.data.mapper.mapDomainUserToLocal
import com.jasonchienfromtw.githubclientdemo.data.source.local.UsersLocalSource
import com.jasonchienfromtw.githubclientdemo.data.source.remote.UsersRemoteSource
import com.jasonchienfromtw.githubclientdemo.domain.models.DetailUser
import com.jasonchienfromtw.githubclientdemo.domain.models.User
import com.jasonchienfromtw.githubclientdemo.domain.repository.UsersRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class UsersRepositoryImpl(
    private val usersLocalSource: UsersLocalSource,
    private val usersRemoteSource: UsersRemoteSource,
    private val pagedListBuilder: RxPagedListBuilder<Int, User>
) : UsersRepository {

    override fun getUserList(): Observable<PagedList<User>> = pagedListBuilder.buildObservable()

    override fun updateUser(user: User): Completable =
        usersLocalSource.updateUser(mapDomainUserToLocal(user))

    override fun getUser(name: String): Single<DetailUser> =
        usersRemoteSource.getUserFromApi(name)
}