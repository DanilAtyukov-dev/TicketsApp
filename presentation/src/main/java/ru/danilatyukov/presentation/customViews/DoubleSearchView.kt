package ru.danilatyukov.presentation.customViews

import android.content.Context
import android.text.Editable
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import ru.danilatyukov.presentation.R

class DoubleSearchView(context: Context, val attributeSet: AttributeSet?) :
    LinearLayout(context, attributeSet) {
    constructor(context: Context) : this(context, null)

    val reverseIcon = ResourcesCompat.getDrawable(resources, R.drawable.reverse, context.theme)!!
    val closeIcon = ResourcesCompat.getDrawable(resources, R.drawable.close, context.theme)!!
    val planeUpIcon = ResourcesCompat.getDrawable(resources, R.drawable.plane_up, context.theme)!!
    val searchIcon = ResourcesCompat.getDrawable(resources, R.drawable.search, context.theme)!!


    private var leftIconsVisibility = false
    private var reversIconVisibility = false
    private var closeIconVisibility = false
    private var firstHint = "text"
    private var secondHint = "text"

    private var focusedSearchView: SearchView? = null
    private var firstText = ""
    private var secondText = ""


    val searchViewFirst = SearchView(context)
    val searchViewSecond = SearchView(context)
    val divider = View(context)

    var firstSearchViewTextChangeListener: (newText: Editable?) -> Unit = {}
    var secondSearchViewTextChangeListener: (newText: Editable?) -> Unit = {}

    var secondSearchViewChangeFocusListener: (v: SearchView, hasFocus: Boolean) -> Unit =
        { v, hasFocus -> }
    var firstSearchViewChangeFocusListener: (v: SearchView, hasFocus: Boolean) -> Unit =
        { v, hasFocus -> }

    init {
        tryInitFromXml()
        orientation = VERTICAL


        setDivider()
        setReversButtonOnClickListener()
        setLeftIconsDrawables()
        setRightIconsDrawables()

        setReversIconVisibility(reversIconVisibility)
        setLeftIconsVisibility(leftIconsVisibility)
        setCloseIconVisibility(closeIconVisibility)

        setFirstHint(firstHint)
        setSecondHint(secondHint)

        addView(searchViewFirst)
        addView(divider)
        addView(searchViewSecond)

        searchViewFirst.setTextChangedListener { s: Editable? ->
            firstText = s.toString()
            firstSearchViewTextChangeListener(s)
        }
        searchViewFirst.setChangeFocusedListener { v, hasFocus ->
            if (hasFocus) focusedSearchView = v as SearchView
            firstSearchViewChangeFocusListener(searchViewFirst, hasFocus)
        }

        searchViewSecond.setTextChangedListener { s: Editable? ->
            secondText = s.toString()
            secondSearchViewTextChangeListener(s)
        }
        searchViewSecond.setChangeFocusedListener { v, hasFocus ->
            if (hasFocus) focusedSearchView = v as SearchView
            secondSearchViewChangeFocusListener(searchViewSecond, hasFocus)
        }
    }

    private fun tryInitFromXml() {
        if (attributeSet == null) return

        context.theme.obtainStyledAttributes(attributeSet, R.styleable.DoubleSearchView, 0, 0)
            .apply {
                try {
                    leftIconsVisibility =
                        getBoolean(R.styleable.DoubleSearchView_visibilityLeftIcons, false)
                    reversIconVisibility =
                        getBoolean(R.styleable.DoubleSearchView_visibilityReversIcon, false)
                    closeIconVisibility =
                        getBoolean(R.styleable.DoubleSearchView_visibilityCloseIcon, false)

                    val hint1 = getString(R.styleable.DoubleSearchView_firstHint)
                    val hint2 = getString(R.styleable.DoubleSearchView_secondHint)
                    if (hint1 != null) firstHint = hint1
                    if (hint2 != null) secondHint = hint2
                } finally {
                    recycle()
                }
            }
    }

    private fun setDivider() {
        divider.setBackgroundColor(resources.getColor(R.color.gray6))
        divider.layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 3)
    }

    private fun setRightIconsDrawables() {
        reverseIcon.setTint(resources.getColor(R.color.gray6))
        closeIcon.setTint(resources.getColor(R.color.gray6))
        searchViewFirst.setButtonDrawable(reverseIcon)
        searchViewSecond.setButtonDrawable(closeIcon)
    }

    private fun setLeftIconsDrawables() {
        searchIcon.setTint(resources.getColor(R.color.blue))
        searchViewFirst.setLeftIconDrawable(planeUpIcon)
        searchViewSecond.setLeftIconDrawable(searchIcon)
    }

    private fun setReversButtonOnClickListener() {
        searchViewFirst.setButtonOnClickListener {
            val firstText = this.secondText
            val secondText = this.firstText

            searchViewFirst.setText(firstText)
            searchViewSecond.setText(secondText)
        }
    }

    public fun setCloseButtonOnClickListener(l: OnClickListener) {
        searchViewSecond.setButtonOnClickListener(l)
    }

    public fun setLeftIconsVisibility(boolean: Boolean) {
        searchViewFirst.setLeftIconVisibility(if (boolean) VISIBLE else GONE)
        searchViewSecond.setLeftIconVisibility(if (boolean) VISIBLE else GONE)
    }

    public fun setReversIconVisibility(boolean: Boolean) {
        searchViewFirst.setRightIconVisibility(if (boolean) VISIBLE else GONE)
    }

    public fun setCloseIconVisibility(boolean: Boolean) {
        searchViewSecond.setRightIconVisibility(if (boolean) VISIBLE else GONE)
    }

    public fun setFirstHint(hint: String) {
        searchViewFirst.setHint(hint)
    }

    public fun setSecondHint(hint: String) {
        searchViewSecond.setHint(hint)
    }
}