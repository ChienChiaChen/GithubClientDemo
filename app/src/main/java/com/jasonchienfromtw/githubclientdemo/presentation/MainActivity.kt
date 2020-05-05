package com.jasonchienfromtw.githubclientdemo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jasonchienfromtw.githubclientdemo.R
import com.jasonchienfromtw.githubclientdemo.presentation.ui.navigator.NavigatorImpl

class MainActivity : AppCompatActivity() {

    private val navigator: NavigatorImpl by lazy(LazyThreadSafetyMode.NONE) {
        NavigatorImpl(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigator.toUsersFragment()
        }
    }
}
