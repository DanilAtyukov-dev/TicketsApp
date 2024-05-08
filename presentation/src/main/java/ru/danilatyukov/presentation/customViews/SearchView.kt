package ru.danilatyukov.presentation.customViews

import android.content.Context
import android.graphics.drawable.Drawable
import android.opengl.Visibility
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout

class SearchView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    constructor(context: Context) : this(context, null)

    private val leftIcon = ImageView(context)
    private val editText = EditText(context)
    private val rightButton = ImageView(context)

    init {
        gravity = Gravity.CENTER_VERTICAL

        editText.maxLines = 1

        editText.background = null

        editText.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 1f)
        addView(leftIcon)
        addView(editText)
        addView(rightButton)
    }

    public fun setLeftIconVisibility(isVisible: Int){
        leftIcon.visibility = isVisible
    }

    public fun setRightIconVisibility(isVisible: Int){
        rightButton.visibility = isVisible
    }

    public fun setLeftIconDrawable(drawable: Drawable?) {
        leftIcon.setImageDrawable(drawable)
    }

    public fun setButtonDrawable(drawable: Drawable?) {
        rightButton.setImageDrawable(drawable)
    }

    public fun setButtonOnClickListener(l: OnClickListener) {
        rightButton.setOnClickListener(l)
    }

    public fun setChangeFocusedListener(listener: (v: View, hasFocus: Boolean) -> Unit){

        editText.setOnFocusChangeListener { v, hasFocus ->  listener(this, hasFocus)}
    }

    public fun setTextChangedListener(afterTextChanged: (s: Editable?) -> Unit) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                afterTextChanged(s)
            }
        })
    }

    public fun setHint(hint: String){
        editText.hint = hint
    }

    public fun setText(string: String){
        editText.setText(string)
    }
}