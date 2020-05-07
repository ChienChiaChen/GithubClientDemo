package com.jasonchienfromtw.githubclientdemo.presentation.ui.userdetail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.transition.TransitionInflater
import com.jasonchienfromtw.githubclientdemo.R
import com.jasonchienfromtw.githubclientdemo.domain.models.User
import com.jasonchienfromtw.githubclientdemo.presentation.extensions.setImageUrl
import kotlinx.android.synthetic.main.fragment_user_detail.*

class UserDetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_user_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = arguments?.getSerializable("user") as User
        val position = arguments?.getInt("position")
        bindUserData(user, position)
    }

    private fun bindUserData(user: User?, position: Int?) {
        userName.text = user?.name ?: "Ber"
        userLocation.text = "Location"
        userBlog.text = "Blog"

        userAvatar.transitionName = getString(R.string.user_image_transition, position)
        userAvatar.setImageUrl(user?.avatarUrl ?: "")
    }

    companion object {
        const val TAG = "UserDetailFragment"

        @JvmStatic
        fun newInstance() = UserDetailFragment()
    }
}
