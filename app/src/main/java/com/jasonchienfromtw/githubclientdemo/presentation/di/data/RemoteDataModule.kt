package com.jasonchienfromtw.githubclientdemo.presentation.di.data

import com.jasonchienfromtw.githubclientdemo.BuildConfig
import com.jasonchienfromtw.githubclientdemo.data.source.remote.UsersRemoteSource
import com.jasonchienfromtw.githubclientdemo.data.source.remote.UsersRemoteSourceImpl
import com.jasonchienfromtw.githubclientdemo.data.source.remote.retrofit.UsersService
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


const val BASE_URL: String = "https://api.github.com/"

@Module
class RemoteDataModule {
    @Provides
    @Singleton
    internal fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(logInterceptor())
            .connectTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .build()
    }

    private fun logInterceptor(): Interceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            // disable retrofit log on release
            loggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        return loggingInterceptor
    }


    @Provides
    @Singleton
    internal fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(client)
            .build()
    }

    @Provides
    internal fun provideGithubService(retrofit: Retrofit): UsersService {
        return retrofit.create(UsersService::class.java)
    }

    @Provides
    internal fun provideUsersRemoteSource(usersService: UsersService): UsersRemoteSource =
        UsersRemoteSourceImpl(usersService)
}