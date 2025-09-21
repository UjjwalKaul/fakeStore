package com.ujjwal.fakestore.store.presentation.productScreen

import com.ujjwal.fakestore.store.domain.model.Product

data class ProductsViewState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)