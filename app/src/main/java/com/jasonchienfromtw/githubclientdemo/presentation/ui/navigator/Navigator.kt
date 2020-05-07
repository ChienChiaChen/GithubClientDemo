package com.jasonchienfromtw.githubclientdemo.presentation.ui.navigator

import android.widget.ImageView
import com.jasonchienfromtw.githubclientdemo.domain.models.User

interface Navigator {
    fun toUsersFragment()
    fun toDetailFragment(user: User, pos: Int, userAvatar: ImageView)
}