package com.jasonchienfromtw.githubclientdemo.data.repository

import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.jasonchienfromtw.githubclientdemo.data.mapper.mapDomainUserToLocal
import com.jasonchienfromtw.githubclientdemo.data.source.local.UsersLocalSource
import com.jasonchienfromtw.githubclientdemo.domain.models.User
import com.jasonchienfromtw.githubclientdemo.domain.repository.UsersRepository
import io.reactivex.Completable
import io.reactivex.Observable

class UsersRepositoryImpl(
    private val usersLocalSource: UsersLocalSource,
    private val pagedListBuilder: RxPagedListBuilder<Int, User>
): UsersRepository {

    override fun getUserList(): Observable<PagedList<User>> = pagedListBuilder.buildObservable()

    override fun updateUser(user: User): Completable = usersLocalSource.updateUser(mapDomainUserToLocal(user))
}