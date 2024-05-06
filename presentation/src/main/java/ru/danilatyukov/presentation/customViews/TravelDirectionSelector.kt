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
    val linearEditTexts = LinearLayout(context)

    val horLinearCommon = LinearLayout(context)

    val searchIconImageView = ImageView(context)

    val editTextWhereFrom = EditText(context)

    val editTextWhereTo = EditText(context)

    init {
        radius = resources.getDimension(R.dimen.travel_direction_selector_radius)

        val imageIconDrawable = resources.getDrawable(R.drawable.search)
        imageIconDrawable.setTint(resources.getColor(R.color.black))

        searchIconImageView.setImageDrawable(imageIconDrawable)
        val searchIconImageViewParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        searchIconImageViewParams.setMargins(30, 0, 30, 0)
        searchIconImageView.layoutParams = searchIconImageViewParams

        linearEditTextsInit()
        editTextWhereFromInit()
        editTextWhereToInit()
        linearCommonInit()
        this.addView(horLinearCommon)
    }
    private fun linearCommonInit(){
        horLinearCommon.gravity = Gravity.CENTER_VERTICAL
        horLinearCommon.addView(searchIconImageView)
        horLinearCommon.addView(linearEditTexts)
    }

    private fun linearEditTextsInit(){
        val divider = View(context)
        divider.setBackgroundColor(resources.getColor(R.color.gray6))
        divider.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, 2)

        linearEditTexts.orientation = LinearLayout.VERTICAL
        linearEditTexts.addView(editTextWhereFrom)
        linearEditTexts.addView(divider)
        linearEditTexts.addView(editTextWhereTo)
    }

    private fun editTextWhereFromInit(){
        editTextWhereFrom.hint = resources.getString(R.string.WhereFrom)
        editTextWhereFrom.background = null
    }

    private fun editTextWhereToInit(){
        editTextWhereTo.hint = resources.getString(R.string.WhereTo)
        editTextWhereTo.background = null
    }

    public fun setWhereFromListener(onClickListener: OnClickListener) {
        editTextWhereFrom.setOnClickListener(onClickListener)
    }

   public fun setWhereToListener(onClickListener: OnClickListener) {
        editTextWhereTo.setOnClickListener(onClickListener)
    }
}