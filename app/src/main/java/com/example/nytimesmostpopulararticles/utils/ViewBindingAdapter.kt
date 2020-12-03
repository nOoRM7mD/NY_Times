package com.example.nytimesmostpopulararticles.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


@BindingAdapter("goneUnless")
fun goneUnless(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("onRefresh")
fun onRefresh(view: SwipeRefreshLayout, func: () -> Unit) {
    view.setOnRefreshListener {
        func.invoke()
    }
}

@BindingAdapter("loadCircleImage")
fun bindLoadCircleImage(view: ImageView, url: String?) {
    Glide.with(view.context).load(url).apply(RequestOptions.circleCropTransform()).into(view)
}



