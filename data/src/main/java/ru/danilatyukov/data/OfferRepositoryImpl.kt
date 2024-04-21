package ru.danilatyukov.data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.danilatyukov.domain.OffersRepository
import ru.danilatyukov.domain.model.offers.Offers
import java.lang.Exception

const val apiKey = ""
class OfferRepositoryImpl(
    private val service: OffersService
) : OffersRepository {

    constructor() : this(
        Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/drive/v3/files/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val request = chain.request().newBuilder()
                    val originalHttpUrl = chain.request().url()
                    val url = originalHttpUrl
                        .newBuilder()
                        .addQueryParameter("alt", "media")
                        .addQueryParameter("key", apiKey).build()
                    request.url(url)
                    return@addInterceptor chain.proceed(request.build())
                }.build()
            )

            .build()
            .create(OffersService::class.java)
    )

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