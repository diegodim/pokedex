package com.diegoduarte.pokedex.base.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.diegoduarte.pokedex.R
import com.google.android.material.progressindicator.LinearProgressIndicator

class StatsIndicator @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {


    private val indicatorValue: LinearProgressIndicator
    private val textName: TextView
    private val textValue: TextView
    init {
        inflate(context, R.layout.layout_custom_stats, this)
            .run {

                indicatorValue = findViewById(R.id.stat_value_indicator)
                textName = findViewById(R.id.stat_name)
                textValue = findViewById(R.id.stat_value)

                context.theme.obtainStyledAttributes(
                    attrs,
                    R.styleable.StatsIndicator,
                    0, 0
                ).apply {

                    try {
                        val value = getInteger(R.styleable.StatsIndicator_value, 0)
                        val color = getColor(R.styleable.StatsIndicator_value, 0)
                        textName.text = getString(R.styleable.StatsIndicator_text)
                        indicatorValue.secondaryProgress = value
                        //indicatorValue.progress = value
                        indicatorValue.setIndicatorColor(color)
                        textValue.text = value.toString()

                    } finally {
                        recycle()
                        invalidate()
                    }
                }
            }

    }
}