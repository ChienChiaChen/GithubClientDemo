package com.jasonchienfromtw.githubclientdemo.presentation.di.fragments.users

import androidx.lifecycle.ViewModel
import com.jasonchienfromtw.githubclientdemo.presentation.di.viewmodel.ViewModelKey
import com.jasonchienfromtw.githubclientdemo.presentation.ui.users.UsersFragment
import com.jasonchienfromtw.githubclientdemo.presentation.ui.users.UsersFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [UsersFragmentModule.Binding::class])
class UsersFragmentModule(private val fragment: UsersFragment) {

    @Module
    interface Binding {
        @Binds
        @IntoMap
        @ViewModelKey(UsersFragmentViewModel::class)
        fun provideViewModel(viewModel: UsersFragmentViewModel): ViewModel

    }
}