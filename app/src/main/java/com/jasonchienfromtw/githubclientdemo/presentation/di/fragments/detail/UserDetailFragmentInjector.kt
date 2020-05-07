package com.jasonchienfromtw.githubclientdemo.presentation.di.fragments.detail

import com.jasonchienfromtw.githubclientdemo.presentation.ui.userdetail.UserDetailFragment
import com.jasonchienfromtw.githubclientdemo.presentation.ui.users.UsersFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module(subcomponents = [UserDetailFragmentSubComponent::class])
abstract class UserDetailFragmentInjector {

    @Binds
    @IntoMap
    @ClassKey(UserDetailFragment::class)
    internal abstract fun injectorFactory(builder: UserDetailFragmentSubComponent.Builder)
            : AndroidInjector.Factory<*>

}
