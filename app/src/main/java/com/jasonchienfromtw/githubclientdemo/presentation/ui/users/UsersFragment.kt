package com.jasonchienfromtw.githubclientdemo.presentation.ui.users


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jasonchienfromtw.githubclientdemo.R
import com.jasonchienfromtw.githubclientdemo.presentation.ui.userdetail.UserDetailFragment

class UsersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_users, container, false)

    companion object {
        const val TAG = "UsersFragment"

        @JvmStatic
        fun newInstance() = UsersFragment()
    }
}
