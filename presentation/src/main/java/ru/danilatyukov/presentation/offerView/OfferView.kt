package ru.danilatyukov.presentation.offerView

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ImageView.ScaleType
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import ru.danilatyukov.presentation.R

class OfferView(context: Context) : LinearLayout(context) {
    private val res = context.resources
    private val titleTv = TextView(context)
    private val cityTv = TextView(context)
    private val picture = ImageView(context)
    private val pictureCard = CardView(context)
    private val priceTv = TextView(context)
    private val transportIcon = ImageView(context)
    private val priceRow = LinearLayout(context)

    init {
        orientation = VERTICAL


        //setPictureIV
        picture.scaleType = (ScaleType.CENTER_CROP)
        pictureCard.radius = res.getDimension(R.dimen.offer_card_rounded)
        pictureCard.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
        pictureCard.addView(picture)
        addView(pictureCard)

        //setTitleTV
        titleTv.textSize = res.getDimension(R.dimen.offer_title_size)
        titleTv.typeface = Typeface.DEFAULT_BOLD
        addView(titleTv)

        //setCityTV
        cityTv.textSize = res.getDimension(R.dimen.offer_city_size)
        addView(cityTv)

        //setPriceTV
        transportIcon.scaleType = (ScaleType.CENTER_CROP)
        priceRow.addView(transportIcon)
        priceRow.addView(priceTv)
        addView(priceRow)
    }

    public fun setTitle(title: String){
        titleTv.text = title
    }
    public fun setCity(city: String){
        cityTv.text = city
    }
    public fun setImage(drawable: Drawable){
        picture.setImageDrawable(drawable)
    }

    public fun setPrice(price: String){
        priceTv.text = price
    }

    public fun setTransport(transport: TransportIcon){
        transportIcon.setImageDrawable(res.getDrawable(transport.iconId))
    }


}