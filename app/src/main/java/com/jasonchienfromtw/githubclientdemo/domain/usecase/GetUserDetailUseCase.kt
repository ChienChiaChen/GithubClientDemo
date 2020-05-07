package com.jasonchienfromtw.githubclientdemo.domain.usecase

import com.jasonchienfromtw.githubclientdemo.domain.base.SingleUseCase
import com.jasonchienfromtw.githubclientdemo.domain.models.DetailUser
import com.jasonchienfromtw.githubclientdemo.domain.repository.UsersRepository
import io.reactivex.Single

class GetUserDetailUseCase(private val usersRepository: UsersRepository) :
    SingleUseCase<DetailUser, String>() {

    override fun useCaseExecution(name: String): Single<DetailUser> =
        usersRepository.getUser(name)
}