package com.simba.addatimes.utils

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.simba.addatimes.R

object BindingUtils {

    @BindingAdapter("profileIcon")
    fun loadAndBindImage(imageView: ImageView, url: String?) {
        if (!TextUtils.isEmpty(url)) {
            imageView.load(url) {
                placeholder(R.drawable.addatimes_logo_full)
                error(R.drawable.addatimes_logo_full)
            }
        } else {
            imageView.load(R.drawable.addatimes_logo_full)
        }
    }
}