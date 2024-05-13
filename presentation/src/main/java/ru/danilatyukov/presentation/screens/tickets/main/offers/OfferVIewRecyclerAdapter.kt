package ru.danilatyukov.presentation.screens.tickets.main.offers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.danilatyukov.domain.model.offers.Offer
import ru.danilatyukov.presentation.R
import ru.danilatyukov.presentation.customViews.OfferView

class OfferVIewRecyclerAdapter(private val dataSet: List<Offer>) :
    RecyclerView.Adapter<OfferVIewRecyclerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val offerView: OfferView
        init {
            offerView = view.findViewById(R.id.offer_view)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.offer_view_for_recycler, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val resources = viewHolder.offerView.resources

        viewHolder.offerView.setCity(dataSet[position].town)
        viewHolder.offerView.setPrice("${resources.getText(R.string.start_price)} ${dataSet[position].price.value}₽")
        viewHolder.offerView.setTitle(dataSet[position].title)
        viewHolder.offerView.setImage(dataSet[position].image)
    }
    override fun getItemCount() = dataSet.size

}