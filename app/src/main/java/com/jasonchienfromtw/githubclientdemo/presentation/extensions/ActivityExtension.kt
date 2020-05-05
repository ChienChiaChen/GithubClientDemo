package com.jasonchienfromtw.githubclientdemo.presentation.extensions

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction

fun FragmentActivity.fragmentTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    supportFragmentManager
        .beginTransaction()
        .func()
        .commitAllowingStateLoss()
}