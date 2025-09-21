package com.ujjwal.fakestore.store.domain.repository

import arrow.core.Either
import com.ujjwal.fakestore.store.domain.model.NetworkError
import com.ujjwal.fakestore.store.domain.model.Product

/**
Either has 2 values

Either<Left,Right>

The Left -> Indicated Error Values
The Right -> Success Case
 */

interface ProductRepository {
    suspend fun getProducts(): Either<NetworkError, List<Product>>
}