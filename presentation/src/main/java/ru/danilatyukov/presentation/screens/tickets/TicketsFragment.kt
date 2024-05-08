package ru.danilatyukov.presentation.screens.tickets

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import ru.danilatyukov.presentation.R


class TicketsFragment : Fragment(R.layout.fragment_tickets) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            //findNavController().navigate(R.id.action_ticketsFragment_to_travelDestinationFragment)

    }
}