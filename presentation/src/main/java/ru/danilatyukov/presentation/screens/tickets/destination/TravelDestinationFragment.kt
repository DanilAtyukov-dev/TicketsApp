package ru.danilatyukov.presentation.screens.tickets.destination

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
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

        val constraintLayout = binding!!.coordinator
        constraintLayout.minimumHeight = Resources.getSystem().displayMetrics.heightPixels
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}