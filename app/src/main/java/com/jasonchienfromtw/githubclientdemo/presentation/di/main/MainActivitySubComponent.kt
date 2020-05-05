package com.jasonchienfromtw.githubclientdemo.presentation.di.main

import com.jasonchienfromtw.githubclientdemo.presentation.di.scope.PerActivity
import com.jasonchienfromtw.githubclientdemo.presentation.ui.main.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(
    modules = [
        MainActivityModule::class
    ]
)
@PerActivity
interface MainActivitySubComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>() {

        abstract fun module(module: MainActivityModule): Builder

        override fun seedInstance(instance: MainActivity) {
            module(MainActivityModule(instance))
        }
    }

}