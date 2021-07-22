package com.diegoduarte.pokedex.base.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import com.diegoduarte.pokedex.R

class LoadingDialog @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val loadingDialogImageView: ImageView
    init{
        LayoutInflater.from(context)
            .inflate(R.layout.layout_custom_loading, this, true)
            .run {
                loadingDialogImageView = findViewById(R.id.loading_image)
                val rotate: Animation = AnimationUtils.loadAnimation(this.context, R.anim.rotate)
                loadingDialogImageView.startAnimation(rotate)
            }

    }

}