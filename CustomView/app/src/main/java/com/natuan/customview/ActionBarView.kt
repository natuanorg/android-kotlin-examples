package com.natuan.customview

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.merge_action_bar_view.view.*
import kotlin.math.roundToInt

class ActionBarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : RelativeLayout(context, attrs, defStyle, defStyleRes) {

    interface ActionBarListener {
        fun onActionBarItemSelected(view: View)
    }

    var actionBarListener: ActionBarListener? = null

    init {
        inflate(context, R.layout.merge_action_bar_view, this)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.ActionBarView)
        title_tv.text = attributes.getString(R.styleable.ActionBarView_title)

        left_btn.setImageDrawable(attributes.getDrawable(R.styleable.ActionBarView_drawable_left))
        right_btn.setImageDrawable(attributes.getDrawable(R.styleable.ActionBarView_drawable_right))

        attributes.recycle()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dpToPixel(60))
        background = ContextCompat.getDrawable(context, R.drawable.action_bar_bg)

        actionBarListener?.let {
            left_btn.setOnClickListener { view -> it.onActionBarItemSelected(view) }
            right_btn.setOnClickListener { view -> it.onActionBarItemSelected(view) }
        }
    }

    fun dpToPixel(dp: Int): Int {
        val metrics = Resources.getSystem().displayMetrics
        return (dp * (metrics.densityDpi / 160f)).roundToInt()
    }
}