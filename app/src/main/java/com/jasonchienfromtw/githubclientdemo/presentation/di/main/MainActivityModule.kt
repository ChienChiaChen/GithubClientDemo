package com.jasonchienfromtw.githubclientdemo.presentation.di.main


import android.content.Context
import androidx.appcompat.app.AppCompatActivity

import com.jasonchienfromtw.githubclientdemo.presentation.di.scope.PerActivity
import com.jasonchienfromtw.githubclientdemo.presentation.ui.main.MainActivity
import com.jasonchienfromtw.githubclientdemo.presentation.ui.navigator.Navigator
import com.jasonchienfromtw.githubclientdemo.presentation.ui.navigator.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [MainActivityModule.Binding::class])
class MainActivityModule(private val activity: MainActivity) {

    @Provides
    internal fun provideSupportActivity(): AppCompatActivity = activity

//    @Provides
//    internal fun provideContext(): Context = activity

    @Module
    interface Binding {

        @Binds
        @PerActivity
        fun provideNavigator(navigatorImpl: NavigatorImpl): Navigator
    }

}