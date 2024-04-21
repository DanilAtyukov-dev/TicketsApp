package ru.danilatyukov.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.danilatyukov.domain.OffersRepository

class MainViewModel(
    private val repository: OffersRepository
) :ViewModel() {
    private val innerLiveData = MutableLiveData<String>()


    val liveData: LiveData<String>
        get() = innerLiveData


    private val viewmodelScope = CoroutineScope(SupervisorJob()+Dispatchers.Main.immediate)
    fun loadOffers() {
        viewmodelScope.launch {
           val offers = repository.loadOffers().second



            if (offers != null) {
                if (offers.offers != null) {
                    innerLiveData.value = offers.offers[0].title
                }
            }
        }
    }

}