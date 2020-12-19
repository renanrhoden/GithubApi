package com.renanrhoden.inject

import com.renanrhoden.feature.listing.ListingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ListingViewModel() }
}