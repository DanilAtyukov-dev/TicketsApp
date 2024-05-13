package ru.danilatyukov.presentation.screens.tickets.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.danilatyukov.domain.OffersRepository
import ru.danilatyukov.domain.model.offers.Offers

class TicketsFragmentViewModel(
    val offersRepository: OffersRepository
): ViewModel() {
    private val innerLiveData = MutableLiveData<Offers>()
    val liveData: LiveData<Offers>
        get() = innerLiveData

    fun loadOffers() {
        viewModelScope.launch {
            val offers = offersRepository.loadOffers().second
            if (offers != null) innerLiveData.value = offers!!
        }
    }
}