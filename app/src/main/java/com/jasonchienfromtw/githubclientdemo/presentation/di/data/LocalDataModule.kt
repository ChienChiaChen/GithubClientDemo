package com.jasonchienfromtw.githubclientdemo.presentation.di.data

import android.content.Context
import androidx.room.Room
import com.jasonchienfromtw.githubclientdemo.data.source.UsersBoundaryCallback
import com.jasonchienfromtw.githubclientdemo.data.source.local.UsersLocalSource
import com.jasonchienfromtw.githubclientdemo.data.source.local.UsersLocalSourceImpl
import com.jasonchienfromtw.githubclientdemo.data.source.local.room.DATABASE_NAME
import com.jasonchienfromtw.githubclientdemo.data.source.local.room.UsersDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    internal fun provideAppDatabase(context: Context): UsersDatabase =
        Room.databaseBuilder(context, UsersDatabase::class.java, DATABASE_NAME).build()


    @Provides
    internal fun provideUsersLocalSource(usersDatabase: UsersDatabase): UsersLocalSource =
        UsersLocalSourceImpl(usersDatabase)


}