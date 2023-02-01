package com.partitionsoft.customview

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import kotlinx.parcelize.Parcelize


class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defaultAttrs: Int = 0
) : androidx.appcompat.widget.AppCompatTextView(context, attrs, defaultAttrs) {


    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.CustomView, 0, 0).apply {
            try {
                val revertText = getBoolean(R.styleable.CustomView_revertText, false)
                if (revertText) {
                    val revertedText = text.reversed()
                    text = revertedText
                }
            } finally {
                recycle()
            }
        }
    }

    override fun onSaveInstanceState(): Parcelable? {
        return SaveState(super.onSaveInstanceState(), text.toString())

    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val savedState = state as SaveState
        text = savedState.text
        super.onRestoreInstanceState(savedState.superState)

    }

    @Parcelize
    class SaveState(val superState: Parcelable?, val text: String?) : Parcelable


}