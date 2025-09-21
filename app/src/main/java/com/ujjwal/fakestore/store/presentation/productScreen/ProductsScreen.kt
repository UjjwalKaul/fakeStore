package com.ujjwal.fakestore.store.presentation.productScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ujjwal.fakestore.store.presentation.productScreen.components.ProductCard
import com.ujjwal.fakestore.store.presentation.util.components.LoadingDialog

@Composable
internal fun ProductsScreen(
    viewModel: ProductsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    ProductsContents(state = state)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsContents(
    state: ProductsViewState
) {
    LoadingDialog(isLoading = state.isLoading)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.shadow(elevation = 5.dp),
                title = {
                    Text("Products")
                }
            )
        }
    ) {
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(it.calculateTopPadding()),
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalItemSpacing = 10.dp
        ) {
            items(state.products) { product ->
                ProductCard(product = product)
            }
        }
    }
}