package com.jasonchienfromtw.githubclientdemo.presentation.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.jasonchienfromtw.githubclientdemo.domain.models.User
import com.jasonchienfromtw.githubclientdemo.domain.usecase.GetUserListUseCase
import javax.inject.Inject

class UsersFragmentViewModel @Inject constructor(
    private val getUserListUseCase: GetUserListUseCase
) : ViewModel() {
    private val _users: MutableLiveData<PagedList<User>> = MutableLiveData()

    val users: LiveData<PagedList<User>>
        get() = _users

    fun getUsers() {
        getUserListUseCase.execute(
            { users -> _users.value = users },
            { },
            Unit
        )
    }

    override fun onCleared() {
        super.onCleared()
        getUserListUseCase.dispose()
    }
}