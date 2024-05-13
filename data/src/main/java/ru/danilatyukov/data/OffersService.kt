package ru.danilatyukov.data

import retrofit2.http.GET
import retrofit2.http.Streaming
import ru.danilatyukov.domain.model.offers.Offers

interface  OffersService {


    //https://drive.google.com/file/d/1o1nX3uFISrG1gR-jr_03Qlu4_KEZWhav
    @Streaming
    @GET("1S1bkw54-X_qU5mnEsyx6Np8Fhg00-zUd")
    suspend fun offers(): Offers
}