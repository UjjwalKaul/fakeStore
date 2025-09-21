package com.ujjwal.fakestore.di

import com.ujjwal.fakestore.store.data.repository.ProductRepositoryImpl
import com.ujjwal.fakestore.store.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bingProductsRepository(impl: ProductRepositoryImpl): ProductRepository
}