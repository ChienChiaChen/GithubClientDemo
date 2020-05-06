package com.jasonchienfromtw.githubclientdemo.data.mapper

import com.jasonchienfromtw.githubclientdemo.data.source.local.room.entity.UserEntity
import com.jasonchienfromtw.githubclientdemo.domain.models.User


val mapDomainUserToLocal: (User) -> UserEntity =
    { user ->
        UserEntity(user.id, user.name, user.avatarUrl)
    }

val mapLocalUserToDomain: (UserEntity) -> User =
    { user ->
        User(user.id, user.name, user.picture)
    }