package ru.danilatyukov.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.danilatyukov.domain.OffersRepository
import ru.danilatyukov.domain.model.offers.Offers
import java.lang.Exception

class OfferRepositoryImpl(
    private val service: OffersService
) : OffersRepository {
    constructor() : this(
        Retrofit.Builder()
            .baseUrl("https://drive.google.com/").addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OffersService::class.java)
    )


    override suspend fun loadOffers(): Pair<Boolean, Offers?> {
        return try {
            val offers = service.offers()
            Pair(true, offers)
        } catch (e: Exception) {
            //TODO: сделать кеширование
            Pair(false, null)
        }
    }
}