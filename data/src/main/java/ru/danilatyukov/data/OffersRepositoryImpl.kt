package ru.danilatyukov.data


import ru.danilatyukov.domain.OffersRepository
import ru.danilatyukov.domain.model.offers.Offers
import java.lang.Exception

const val apiKey = "AIzaSyDVOqM0cYKQTPL7GdMCpuLuCn200Z5NSpY"
class OfferRepositoryImpl(
    private val service: OffersService
) : OffersRepository {



    override suspend fun loadOffers(): Pair<Boolean, Offers?> {
        val offers = service.offers()
        return try {
            Pair(true, offers)
        } catch (e: Exception) {
            println("except!")
            e.printStackTrace()
            //TODO: сделать кеширование
            Pair(false, null)
        }
    }
}