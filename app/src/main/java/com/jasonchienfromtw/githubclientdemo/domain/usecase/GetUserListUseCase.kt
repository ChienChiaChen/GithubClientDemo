package com.jasonchienfromtw.githubclientdemo.domain.usecase

import androidx.paging.PagedList
import com.jasonchienfromtw.githubclientdemo.domain.base.ObservableUseCase
import com.jasonchienfromtw.githubclientdemo.domain.models.User
import com.jasonchienfromtw.githubclientdemo.domain.repository.UsersRepository
import io.reactivex.Observable

class GetUserListUseCase(private val usersRepository: UsersRepository) :
    ObservableUseCase<PagedList<User>, Unit>() {

    override fun useCaseExecution(params: Unit): Observable<PagedList<User>> =
        usersRepository.getUserList()
}