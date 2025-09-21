package com.ujjwal.fakestore.store.data.repository

import arrow.core.Either
import com.ujjwal.fakestore.store.data.ProductApi
import com.ujjwal.fakestore.store.data.mapper.toNetworkError
import com.ujjwal.fakestore.store.domain.model.NetworkError
import com.ujjwal.fakestore.store.domain.model.Product
import com.ujjwal.fakestore.store.domain.repository.ProductRepository

class ProductRepositoryImpl constructor(
    private val productApi: ProductApi
) : ProductRepository {

    override suspend fun getProducts(): Either<NetworkError, List<Product>> {
        return Either.catch {
            productApi.getProducts()
        }.mapLeft {
            it.toNetworkError()
        }
    }
}