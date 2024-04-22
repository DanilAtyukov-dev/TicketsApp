package ru.danilatyukov.ticketsapp

import android.app.Application
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.danilatyukov.data.OfferRepositoryImpl
import ru.danilatyukov.data.OffersService
import ru.danilatyukov.data.apiKey
import ru.danilatyukov.domain.OffersRepository
import ru.danilatyukov.presentation.MainViewModel
import ru.danilatyukov.presentation.ViewModelProvider

class App : Application(), ViewModelProvider {

    private lateinit var mainViewModel: MainViewModel
    override fun onCreate() {
        super.onCreate()

        val offersService = Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/drive/v3/files/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
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

        val offersRepository: OffersRepository = OfferRepositoryImpl(offersService)
        mainViewModel = MainViewModel(repository = offersRepository)
    }

    override fun mainViewModel(): MainViewModel {
        return mainViewModel
    }
}