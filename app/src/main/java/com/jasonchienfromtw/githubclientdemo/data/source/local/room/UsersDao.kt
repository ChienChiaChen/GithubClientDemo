package com.jasonchienfromtw.githubclientdemo.data.source.local.room

import androidx.paging.DataSource
import androidx.room.*
import com.jasonchienfromtw.githubclientdemo.data.source.local.room.entity.UserEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface UsersDao {

    @Query("SELECT COUNT() FROM users")
    fun getUsersCount(): Single<Int>

    @Query("SELECT * FROM users")
    fun getUsers(): DataSource.Factory<Int, UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users: List<UserEntity>): Completable

    @Update
    fun update(user: UserEntity): Completable

    @Query("DELETE FROM users")
    fun deleteAllUsers(): Completable
}