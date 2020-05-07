package com.jasonchienfromtw.githubclientdemo.presentation.ui.userdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.jasonchienfromtw.githubclientdemo.domain.models.DetailUser
import com.jasonchienfromtw.githubclientdemo.domain.models.User
import com.jasonchienfromtw.githubclientdemo.domain.usecase.GetUserDetailUseCase
import javax.inject.Inject

class UserDetailFragmentViewModel @Inject constructor(
    private val getUserUseCase: GetUserDetailUseCase
) : ViewModel() {
    private val _detailUser: MutableLiveData<DetailUser> = MutableLiveData()

    val detailUser: LiveData<DetailUser>
        get() = _detailUser

    fun getUsers(name: String) {
        getUserUseCase.execute(
            { users -> _detailUser.value = users },
            { },
            name
        )
    }

    override fun onCleared() {
        super.onCleared()
        getUserUseCase.dispose()
    }
}