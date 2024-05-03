package ru.danilatyukov.presentation.screens

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.danilatyukov.presentation.R
import ru.danilatyukov.presentation.databinding.FragmentMainBinding

class MainFragment: Fragment(R.layout.fragment_main) {
    companion object{
        const val userNameKey = "USER_NAME"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            val navController = (childFragmentManager.findFragmentById(R.id.mainContainerView) as NavHostFragment).navController
            NavigationUI.setupWithNavController(bottomNavigationView, navController)

    }
}