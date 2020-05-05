package com.jasonchienfromtw.githubclientdemo.presentation.ui.userdetail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jasonchienfromtw.githubclientdemo.R

class UserDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_user_detail, container, false)


    companion object {
        const val TAG = "UserDetailFragment"

        @JvmStatic
        fun newInstance() = UserDetailFragment()
    }
}
