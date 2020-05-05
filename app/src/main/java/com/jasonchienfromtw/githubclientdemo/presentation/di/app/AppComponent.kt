package com.jasonchienfromtw.githubclientdemo.presentation.di.app

import com.jasonchienfromtw.githubclientdemo.App
import com.jasonchienfromtw.githubclientdemo.presentation.di.main.MainActivityInjector
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        MainActivityInjector::class
    ]
)
@Singleton
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {

        internal abstract fun module(module: AppModule): Builder

        override fun seedInstance(instance: App) {
            module(AppModule(instance))
        }
    }

}