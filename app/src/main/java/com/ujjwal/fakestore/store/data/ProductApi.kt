package com.ujjwal.fakestore.store.data

import com.ujjwal.fakestore.store.domain.model.Product
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    suspend fun getProducts(): List<Product>
}