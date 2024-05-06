package ru.danilatyukov.presentation.customViews

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import ru.danilatyukov.presentation.R

class DoubleEditText(context: Context, attributeSet: AttributeSet): LinearLayout(context, attributeSet) {
    val editTextFirst = EditText(context)
    val editTextSecond = EditText(context)
    val divider = View(context)
    init {
        divider.setBackgroundColor(resources.getColor(R.color.gray6))
        divider.layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 2)

        editTextFirst.background = null
        editTextSecond.background = null

        addView(editTextFirst)
        addView(divider)
        addView(editTextSecond)
    }
}