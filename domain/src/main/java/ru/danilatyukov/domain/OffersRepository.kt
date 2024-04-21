package ru.danilatyukov.domain

import ru.danilatyukov.domain.model.offers.Offers

interface OffersRepository {

    /**
     *
     */
    suspend fun loadOffers()

}