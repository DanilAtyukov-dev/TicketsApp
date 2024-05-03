package ru.danilatyukov.presentation.screens

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.danilatyukov.presentation.R
import ru.danilatyukov.presentation.databinding.FragmentMainBinding

class MainFragment: Fragment(R.layout.fragment_main) {
    companion object{
        const val userNameKey = "USER_NAME"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<AppCompatTextView>(R.id.helloTv).text = arguments?.getString(userNameKey)


    }
}