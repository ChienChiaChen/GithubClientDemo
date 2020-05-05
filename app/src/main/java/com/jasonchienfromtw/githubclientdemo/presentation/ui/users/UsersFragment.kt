package com.jasonchienfromtw.githubclientdemo.presentation.ui.users


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jasonchienfromtw.githubclientdemo.R
import com.jasonchienfromtw.githubclientdemo.presentation.extensions.lazyFast
import com.jasonchienfromtw.githubclientdemo.presentation.extensions.viewModelProvider
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_users.*
import javax.inject.Inject

class UsersFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val usersViewModel by lazyFast { viewModelProvider<UsersFragmentViewModel>(viewModelFactory) }

    @Inject
    lateinit var usersAdapter: UsersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_users, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        observeUsers()
        usersViewModel.getUsers()
    }

    private fun setRecyclerView() {
        usersRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = usersAdapter
        }
    }

    private fun observeUsers() {
    }

    companion object {
        const val TAG = "UsersFragment"

        @JvmStatic
        fun newInstance() = UsersFragment()
    }
}
