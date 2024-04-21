package ru.danilatyukov.data

import retrofit2.http.GET
import ru.danilatyukov.domain.model.offers.Offers

interface  OffersService {

    //https://drive.google.com/file/d/1o1nX3uFISrG1gR-jr_03Qlu4_KEZWhav/view
    @GET("file/d/1o1nX3uFISrG1gR-jr_03Qlu4_KEZWhav/view")
    suspend fun offers(): Offers
}