package ru.danilatyukov.presentation.screens.tickets

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.danilatyukov.presentation.R
import ru.danilatyukov.presentation.customViews.DoubleSearchView


class TicketsFragment : Fragment(R.layout.fragment_tickets) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val doubleSearchView = view.findViewById<DoubleSearchView>(R.id.doubleSearchView)

        doubleSearchView.firstSearchViewTextChangeListener = { newText ->
        }
        doubleSearchView.secondSearchViewTextChangeListener = { newText ->
        }

        doubleSearchView.firstSearchViewChangeFocusListener = { view, hasFocus ->
            if (hasFocus) findNavController().navigate(R.id.action_ticketsFragment_to_travelDestinationFragment)
        }

        doubleSearchView.secondSearchViewChangeFocusListener = { view, hasFocus ->
            if (hasFocus) findNavController().navigate(R.id.action_ticketsFragment_to_travelDestinationFragment)
        }



    }
}