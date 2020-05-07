package com.jasonchienfromtw.githubclientdemo.presentation.di.domain

import com.jasonchienfromtw.githubclientdemo.domain.repository.UsersRepository
import com.jasonchienfromtw.githubclientdemo.domain.usecase.GetUserDetailUseCase
import com.jasonchienfromtw.githubclientdemo.domain.usecase.GetUserListUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Singleton
    @Provides
    internal fun provideGetUserListUseCase(usersRepository: UsersRepository): GetUserListUseCase =
        GetUserListUseCase(usersRepository)

    @Singleton
    @Provides
    internal fun provideGetUserDetailUseCase(usersRepository: UsersRepository): GetUserDetailUseCase =
        GetUserDetailUseCase(usersRepository)

}