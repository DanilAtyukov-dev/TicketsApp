package ru.danilatyukov.ticketsapp

import android.app.Application
import ru.danilatyukov.data.OfferRepositoryImpl
import ru.danilatyukov.domain.OffersRepository
import ru.danilatyukov.presentation.MainViewModel
import ru.danilatyukov.presentation.ProvideViewModel

class App: Application(), ProvideViewModel {

    private lateinit var mainViewModel: MainViewModel
    override fun onCreate() {
        super.onCreate()
        val offersRepository: OffersRepository = OfferRepositoryImpl()
        mainViewModel = MainViewModel(repository = offersRepository)
    }
    override fun mainViewModel(): MainViewModel {
        return mainViewModel
    }
}