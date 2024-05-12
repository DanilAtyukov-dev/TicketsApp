package ru.danilatyukov.presentation.screens.tickets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.danilatyukov.presentation.R
import ru.danilatyukov.presentation.ViewModelProvider
import ru.danilatyukov.presentation.customViews.DoubleSearchView
import ru.danilatyukov.presentation.customViews.OfferView
import ru.danilatyukov.presentation.databinding.FragmentTicketsBinding


class TicketsFragment : Fragment(R.layout.fragment_tickets) {
    var _binding: FragmentTicketsBinding? = null
    val binding get() = _binding
    lateinit var viewModel: TicketsFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTicketsBinding.inflate(inflater, container, false)
        viewModel = (activity?.application as ViewModelProvider).ticketsFragmentViewModel()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadOffers()

        val layoutManager =  LinearLayoutManager(context)
        layoutManager.orientation = RecyclerView.HORIZONTAL

        binding!!.hotTicketsRecycler.layoutManager = layoutManager

        viewModel.liveData.observe(viewLifecycleOwner){
            val adapter = CustomAdapter(it.offers)
            binding!!.hotTicketsRecycler.adapter = adapter
            println("обзерве ${adapter.itemCount}")
        }





        //findNavController().navigate(R.id.action_ticketsFragment_to_travelDestinationFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}