package ru.danilatyukov.presentation.offerView

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ImageView.ScaleType
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import ru.danilatyukov.presentation.R

class OfferView(context: Context, attributeSet: AttributeSet?) :
    LinearLayout(context, attributeSet) {



    val typedArray = context.theme.obtainStyledAttributes(attributeSet, R.styleable.OfferView, 0, 0)
    val res = context.resources

    public constructor(context: Context) : this(context, null)



    init {
        orientation = VERTICAL
        addView(imageCard(imageView()))
        addView(title())
        addView(city())

        val transportLayout = LinearLayout(context)
        transportLayout.addView(transportIcon())
        transportLayout.addView(price())

        addView(transportLayout)
    }

    private fun imageCard(image: ImageView): CardView {
        val imageCard = CardView(context)
        imageCard.radius = res.getDimension(R.dimen.offer_card_rounded)
        imageCard.layoutParams =
            LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)

        imageCard.addView(image)
        return imageCard
    }

    private fun imageView(): ImageView {
        val image = ImageView(context)
        image.scaleType = (ScaleType.CENTER_CROP)
        image.setImageDrawable(typedArray.getDrawable(R.styleable.OfferView_img))
        return image
    }

    private fun title(): TextView {
        val title = TextView(context)
        title.textSize = res.getDimension(R.dimen.offer_title_size)
        title.typeface = Typeface.DEFAULT_BOLD
        title.text = typedArray.getString(R.styleable.OfferView_title)
        return title
    }

    private fun city(): TextView {
        val city = TextView(context)
        city.textSize = res.getDimension(R.dimen.offer_city_size)
        city.text = typedArray.getString(R.styleable.OfferView_city)
        return city
    }


    private fun transportIcon(): ImageView {
        val id =
        println("ID = $id")


        val image = ImageView(context)
        image.scaleType = (ScaleType.CENTER_CROP)
        image.setImageDrawable(res.getDrawable(typedArray.getInteger(R.styleable.OfferView_transport)))
        return image
    }
    private fun price(): TextView {
        val price = TextView(context)
        price.textSize = res.getDimension(R.dimen.offer_price_size)
        price.text = typedArray.getString(R.styleable.OfferView_price)
        return price
    }

    enum class Transport(val resId: Int){
        AIRPLANE(R.drawable.airplane)
    }

}