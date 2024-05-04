package ru.danilatyukov.presentation.screens.tickets

import android.os.Bundle
import android.view.View
import android.widget.TextView

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.danilatyukov.presentation.R

class TicketsFragment: Fragment(R.layout.fragment_tickets) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



//        view.findViewById<TextView>(R.id.textView).setOnClickListener{
//            findNavController().navigate(R.id.action_ticketsFragment_to_travelDestinationFragment)
//        }

    }
}