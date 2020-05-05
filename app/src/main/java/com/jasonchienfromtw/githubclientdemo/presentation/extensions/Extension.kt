package com.jasonchienfromtw.githubclientdemo.presentation.extensions

fun <T> lazyFast(operation: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE) {
    operation()
}