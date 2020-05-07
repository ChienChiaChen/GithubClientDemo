package com.jasonchienfromtw.githubclientdemo.presentation.di.fragments.detail

import com.jasonchienfromtw.githubclientdemo.presentation.di.scope.PerFragment
import com.jasonchienfromtw.githubclientdemo.presentation.ui.userdetail.UserDetailFragment
import com.jasonchienfromtw.githubclientdemo.presentation.ui.users.UsersFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [UserDetailFragmentModule::class])
@PerFragment
interface UserDetailFragmentSubComponent : AndroidInjector<UserDetailFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<UserDetailFragment>() {

        abstract fun module(module: UserDetailFragmentModule): Builder

        override fun seedInstance(instance: UserDetailFragment) {
            module(UserDetailFragmentModule(instance))
        }
    }

}