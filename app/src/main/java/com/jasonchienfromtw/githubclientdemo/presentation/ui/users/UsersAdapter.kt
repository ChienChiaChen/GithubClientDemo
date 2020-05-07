package com.jasonchienfromtw.githubclientdemo.presentation.ui.users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.jasonchienfromtw.githubclientdemo.R
import com.jasonchienfromtw.githubclientdemo.domain.models.User
import com.jasonchienfromtw.githubclientdemo.presentation.di.app.GlideApp
import com.jasonchienfromtw.githubclientdemo.presentation.ui.common.UserDiffCallback
import com.jasonchienfromtw.githubclientdemo.presentation.ui.navigator.Navigator
import kotlinx.android.synthetic.main.item_user.view.*
import javax.inject.Inject

class UsersAdapter @Inject constructor(private val navigator: Navigator) :
    PagedListAdapter<User, UsersAdapter.UserViewHolder>(UserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UserViewHolder(inflater.inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        user?.let { holder.bind(user, navigator) }
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        companion object {
            private const val OVERRIDE_SMALL = 150
        }

        fun bind(
            user: User,
            navigator: Navigator
        ) {
            itemView.userName.text = user.name
            itemView.setOnClickListener { navigator.toUsersFragment() }
            setImageUrl(itemView.userAvatar, user.avatarUrl)
        }

        private fun setImageUrl(view: ImageView, url: String) {
            val context = view.context
            GlideApp.with(context).clear(view)

            GlideApp.with(context)
                .load(url)
                .override(OVERRIDE_SMALL)
                .placeholder(R.drawable.ic_octoface)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view)
        }
    }


}