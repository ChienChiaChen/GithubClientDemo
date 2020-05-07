package com.jasonchienfromtw.githubclientdemo.presentation.extensions

import android.widget.ImageView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.jasonchienfromtw.githubclientdemo.R
import com.jasonchienfromtw.githubclientdemo.presentation.di.app.GlideApp

private const val OVERRIDE_SMALL = 150
fun ImageView.setImageUrl(url: String) {
    val context = this.context
    GlideApp.with(context).clear(this)

    GlideApp.with(context)
        .load(url)
        .override(OVERRIDE_SMALL)
        .placeholder(R.drawable.ic_octoface)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}