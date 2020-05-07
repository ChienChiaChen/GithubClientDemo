package com.jasonchienfromtw.githubclientdemo.presentation.di.data

import android.content.Context
import androidx.paging.RxPagedListBuilder
import androidx.room.Room
import com.jasonchienfromtw.githubclientdemo.data.constants.RepositoryConstants
import com.jasonchienfromtw.githubclientdemo.data.repository.UsersRepositoryImpl
import com.jasonchienfromtw.githubclientdemo.data.source.UsersBoundaryCallback
import com.jasonchienfromtw.githubclientdemo.data.source.local.UsersLocalSource
import com.jasonchienfromtw.githubclientdemo.data.source.local.UsersLocalSourceImpl
import com.jasonchienfromtw.githubclientdemo.data.source.local.room.DATABASE_NAME
import com.jasonchienfromtw.githubclientdemo.data.source.local.room.UsersDatabase
import com.jasonchienfromtw.githubclientdemo.data.source.remote.UsersRemoteSource
import com.jasonchienfromtw.githubclientdemo.domain.models.User
import com.jasonchienfromtw.githubclientdemo.domain.repository.UsersRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    internal fun provideAppDatabase(context: Context): UsersDatabase =
        Room.databaseBuilder(context, UsersDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    internal fun provideUsersLocalSource(usersDatabase: UsersDatabase): UsersLocalSource =
        UsersLocalSourceImpl(usersDatabase)

    @Singleton
    @Provides
    internal fun provideUsersBoundaryCallback(
        usersLocalSource: UsersLocalSource,
        usersRemoteSource: UsersRemoteSource
    ): UsersBoundaryCallback = UsersBoundaryCallback(usersLocalSource, usersRemoteSource)

    @Singleton
    @Provides
    internal fun provideRxPagedListBuilder(
        usersLocalSource: UsersLocalSource,
        usersBoundaryCallback: UsersBoundaryCallback
    ): RxPagedListBuilder<Int, User> =
        RxPagedListBuilder(
            usersLocalSource.getUsersFromDatabase(),
            RepositoryConstants.DEFAULT_PAGE_SIZE
        ).setBoundaryCallback(usersBoundaryCallback)

    @Singleton
    @Provides
    internal fun provideUsersRepository(
        usersLocalSource: UsersLocalSource,
        usersRemoteSource: UsersRemoteSource,
        pagedListBuilder: RxPagedListBuilder<Int, User>
    ): UsersRepository = UsersRepositoryImpl(usersLocalSource, usersRemoteSource, pagedListBuilder)
}