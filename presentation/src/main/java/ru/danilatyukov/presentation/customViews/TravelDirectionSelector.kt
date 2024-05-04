package ru.danilatyukov.presentation.customViews

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import ru.danilatyukov.presentation.R


class TravelDirectionSelector(context: Context, attrs: AttributeSet) : CardView(context, attrs) {
    val verticalLinearLayout = LinearLayout(context)

    val horizontalLinearLayout = LinearLayout(context)

    val searchIconImageView = ImageView(context)

    val res = context.resources

    val fromLayout = LinearLayout(context)
    val fromET = EditText(context)


    val toLayout = LinearLayout(context)
    val toET = EditText(context)

    init {
        radius = res.getDimension(R.dimen.travel_direction_selector_radius)

        val imageIconDrawable = res.getDrawable(R.drawable.search)
        imageIconDrawable.setTint(res.getColor(R.color.black))

        searchIconImageView.setImageDrawable(imageIconDrawable)
        val searchIconImageViewParams = LayoutParams(LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT)
        searchIconImageViewParams.setMargins(30, 0, 30, 0)
        searchIconImageView.layoutParams = searchIconImageViewParams

        verticalLinearLayout.orientation = LinearLayout.VERTICAL

        fromET.hint = "Минск"
        fromET.background = null

        fromLayout.addView(fromET)

        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        val divider = View(context)
        divider.setBackgroundColor(res.getColor(R.color.gray7))
        divider.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, 2)

        toET.hint = "Куда - Турция"
        toET.background = null
        toLayout.addView(toET)


        verticalLinearLayout.addView(fromLayout)

        verticalLinearLayout.addView(divider)

        verticalLinearLayout.addView(toLayout)

        horizontalLinearLayout.gravity = Gravity.CENTER_VERTICAL



        horizontalLinearLayout.addView(searchIconImageView)
        horizontalLinearLayout.addView(verticalLinearLayout)


        this.addView(horizontalLinearLayout)
    }

    fun fromSetOnClickListener(onClickListener: OnClickListener) {
        fromET.setOnClickListener(onClickListener)
    }

    fun toSetOnClickListener(onClickListener: OnClickListener) {
        toET.setOnClickListener(onClickListener)
    }
}