package com.jasonchienfromtw.githubclientdemo.presentation.di.fragments.users

import com.jasonchienfromtw.githubclientdemo.presentation.di.scope.PerFragment
import com.jasonchienfromtw.githubclientdemo.presentation.ui.users.UsersFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [UsersFragmentModule::class])
@PerFragment
interface UsersFragmentSubComponent : AndroidInjector<UsersFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<UsersFragment>() {

        abstract fun module(module: UsersFragmentModule): Builder

        override fun seedInstance(instance: UsersFragment) {
            module(UsersFragmentModule(instance))
        }
    }

}