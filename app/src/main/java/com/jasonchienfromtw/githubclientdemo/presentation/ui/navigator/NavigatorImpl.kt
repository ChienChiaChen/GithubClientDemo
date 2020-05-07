package com.jasonchienfromtw.githubclientdemo.presentation.ui.navigator

import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.jasonchienfromtw.githubclientdemo.R
import com.jasonchienfromtw.githubclientdemo.domain.models.User
import com.jasonchienfromtw.githubclientdemo.presentation.extensions.fragmentTransaction
import com.jasonchienfromtw.githubclientdemo.presentation.extensions.withArguments
import com.jasonchienfromtw.githubclientdemo.presentation.ui.userdetail.UserDetailFragment
import com.jasonchienfromtw.githubclientdemo.presentation.ui.users.UsersFragment
import javax.inject.Inject

class NavigatorImpl @Inject constructor(private val activity: AppCompatActivity) : Navigator {

    override fun toUsersFragment() {
        activity.fragmentTransaction {
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            val fragment = activity.supportFragmentManager.findFragmentByTag(UsersFragment.TAG)
            if (fragment == null) {
                replace(R.id.fragmentContainer, UsersFragment.newInstance(), UsersFragment.TAG)
            } else {
                show(fragment)
            }
        }
    }

    override fun toDetailFragment(user: User, pos: Int, userAvatar: ImageView) {
        activity.fragmentTransaction {
            setReorderingAllowed(true)
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            getFragmentOnFragmentContainer()?.let { hide(it) }
            addSharedElement(userAvatar, userAvatar.transitionName)
            replace(
                R.id.fragmentContainer, UserDetailFragment.newInstance().withArguments(
                    "user" to user,
                    "position" to pos
                )
                , UserDetailFragment.TAG
            )
            addToBackStack(UserDetailFragment.TAG)
        }
    }

    private fun getFragmentOnFragmentContainer(): androidx.fragment.app.Fragment? {
        return activity.supportFragmentManager.fragments
            .firstOrNull { (it.view?.parent as View?)?.id == R.id.fragmentContainer }
    }
}