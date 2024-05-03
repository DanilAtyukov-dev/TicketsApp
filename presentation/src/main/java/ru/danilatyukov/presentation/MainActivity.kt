package ru.danilatyukov.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.danilatyukov.presentation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)
        val viewModel = (application as ViewModelProvider).mainViewModel()
        viewModel.loadOffers()

        viewModel.liveData.observe(this) {
            //binding.mainTV.text = it
        }
    }
}