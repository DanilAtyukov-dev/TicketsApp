package ru.danilatyukov.presentation.screens.tickets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.danilatyukov.domain.model.offers.Offer
import ru.danilatyukov.presentation.R
import ru.danilatyukov.presentation.customViews.OfferView

class CustomAdapter(private val dataSet: List<Offer>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val offerView: OfferView

        init {
            // Define click listener for the ViewHolder's View
            offerView = view.findViewById(R.id.offer_view)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.offer_view_for_recycler, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        viewHolder.offerView.setCity(dataSet[position].town)
        viewHolder.offerView.setPrice(dataSet[position].price.value.toString())
        viewHolder.offerView.setTitle(dataSet[position].title)

        println("onBindViewHolder "+dataSet[position].town)


        viewHolder.offerView.setImage("https://developer.alexanderklimov.ru/android/images/android_cat.jpg")
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}