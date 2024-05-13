package ru.danilatyukov.domain.model.offers

data class Offer(
    val id: Int,
    val price: Price,
    val title: String,
    val image: String,
    val town: String,

)