package com.jasonchienfromtw.githubclientdemo.presentation.di.fragments.detail

import androidx.lifecycle.ViewModel
import com.jasonchienfromtw.githubclientdemo.presentation.di.fragments.users.UsersFragmentModule
import com.jasonchienfromtw.githubclientdemo.presentation.di.viewmodel.ViewModelKey
import com.jasonchienfromtw.githubclientdemo.presentation.ui.userdetail.UserDetailFragment
import com.jasonchienfromtw.githubclientdemo.presentation.ui.userdetail.UserDetailFragmentViewModel
import com.jasonchienfromtw.githubclientdemo.presentation.ui.users.UsersFragment
import com.jasonchienfromtw.githubclientdemo.presentation.ui.users.UsersFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [UserDetailFragmentModule.Binding::class])
class UserDetailFragmentModule(private val fragment: UserDetailFragment) {

    @Module
    interface Binding {
        @Binds
        @IntoMap
        @ViewModelKey(UserDetailFragmentViewModel::class)
        fun provideViewModel(viewModel: UserDetailFragmentViewModel): ViewModel

    }
}