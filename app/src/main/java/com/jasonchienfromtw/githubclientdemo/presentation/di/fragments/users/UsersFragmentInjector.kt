package com.jasonchienfromtw.githubclientdemo.presentation.di.fragments.users

import com.jasonchienfromtw.githubclientdemo.presentation.ui.users.UsersFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module(subcomponents = [UsersFragmentSubComponent::class])
abstract class UsersFragmentInjector {

    @Binds
    @IntoMap
    @ClassKey(UsersFragment::class)
    internal abstract fun injectorFactory(builder: UsersFragmentSubComponent.Builder)
            : AndroidInjector.Factory<*>

}
