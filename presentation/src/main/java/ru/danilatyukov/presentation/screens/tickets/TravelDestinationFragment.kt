package ru.danilatyukov.presentation.screens.tickets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.danilatyukov.presentation.R
import ru.danilatyukov.presentation.databinding.FragmentTravelDestinationBinding

class TravelDestinationFragment: BottomSheetDialogFragment() {
    private var _binding: FragmentTravelDestinationBinding? = null
    private val binding get() = _binding

    private val viewModel: TravelDestinationFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTravelDestinationBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}