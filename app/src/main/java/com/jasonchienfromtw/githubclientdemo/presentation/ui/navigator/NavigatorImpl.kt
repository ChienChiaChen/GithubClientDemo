package com.jasonchienfromtw.githubclientdemo.presentation.ui.navigator

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jasonchienfromtw.githubclientdemo.R
import com.jasonchienfromtw.githubclientdemo.presentation.extensions.fragmentTransaction
import com.jasonchienfromtw.githubclientdemo.presentation.ui.userdetail.UserDetailFragment
import com.jasonchienfromtw.githubclientdemo.presentation.ui.users.UsersFragment

class NavigatorImpl(private val activity: AppCompatActivity) : Navigator {

    override fun toUsersFragment() {
        activity.fragmentTransaction {
            setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            val fragment = activity.supportFragmentManager.findFragmentByTag(UsersFragment.TAG)
            if (fragment == null) {
                replace(R.id.fragmentContainer, UsersFragment.newInstance(), UsersFragment.TAG)
            } else {
                show(fragment)
            }
        }
    }

    override fun toDetailFragment() {
        activity.fragmentTransaction {
            setReorderingAllowed(true)
            setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            getFragmentOnFragmentContainer()?.let { hide(it) }
            replace(R.id.fragmentContainer, UserDetailFragment.newInstance(), UserDetailFragment.TAG)
            addToBackStack(UserDetailFragment.TAG)
        }
    }

    private fun getFragmentOnFragmentContainer(): androidx.fragment.app.Fragment? {
        return activity.supportFragmentManager.fragments
            .firstOrNull { (it.view?.parent as View?)?.id == R.id.fragmentContainer }
    }
}