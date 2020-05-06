package com.jasonchienfromtw.githubclientdemo.data.source

import android.util.Log
import androidx.paging.PagedList
import com.jasonchienfromtw.githubclientdemo.data.constants.RepositoryConstants.DEFAULT_PAGE_SIZE
import com.jasonchienfromtw.githubclientdemo.data.mapper.mapDomainUserToLocal
import com.jasonchienfromtw.githubclientdemo.data.source.local.UsersLocalSource
import com.jasonchienfromtw.githubclientdemo.data.source.local.room.entity.UserEntity
import com.jasonchienfromtw.githubclientdemo.data.source.remote.UsersRemoteSource
import com.jasonchienfromtw.githubclientdemo.domain.models.User
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class UsersBoundaryCallback(
    private val usersLocalSource: UsersLocalSource,
    private val usersRemoteSource: UsersRemoteSource
) : PagedList.BoundaryCallback<User>() {

    private var nextPage = 1
    private var isRequestRunning = false
    private val disposables = CompositeDisposable()

    override fun onZeroItemsLoaded() {
        getUsersFromApiAndSaveInDatabase()//1
    }

    override fun onItemAtEndLoaded(itemAtEnd: User) {
        getUsersFromApiAndSaveInDatabase()
    }

    private fun getUsersFromApiAndSaveInDatabase() {//2
        if (isRequestRunning) return

        isRequestRunning = true
        val disposable = usersLocalSource.getUsersCountFromDatabase()
            .flatMap { usersCount -> getUsersFromApi(usersCount) }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .doFinally { isRequestRunning = false }
            .subscribe(
                {
                    Log.i(
                        "Jason ",
                        "$nextPage page retrieved from API and users saved in database successfully"
                    )
                },
                { it.printStackTrace() }
            )
        disposables.add(disposable)
    }

    private fun getUsersFromApi(usersCount: Int): Single<List<UserEntity>> {
        nextPage = (usersCount / DEFAULT_PAGE_SIZE) + 1

        return usersRemoteSource.getUsersFromApi(nextPage)
            .map { users -> users.map(mapDomainUserToLocal) }
            .doOnSuccess { users -> saveUsersInDatabase(users) }
    }

    private fun saveUsersInDatabase(users: List<UserEntity>) {
        if (users.isNotEmpty()) {
            val disposable = usersLocalSource.saveUsersInDatabase(users)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .doOnComplete {
                    Log.i("Jason","${users.size} users saved in database")
                }
                .subscribe()
            disposables.add(disposable)
        }
    }
}