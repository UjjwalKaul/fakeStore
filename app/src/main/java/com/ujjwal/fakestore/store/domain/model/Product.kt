package com.ujjwal.fakestore.store.domain.model

data class Product(
    val id: String,
    val title:String,
    val price: Double,
    val description:String,
    val category: String,
    val image:String,
    val rating: Rating
)

data class Rating(
    val rate:Double,
    val count:Int
)