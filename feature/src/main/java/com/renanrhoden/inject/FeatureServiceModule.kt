package com.renanrhoden.inject

import com.renanrhoden.service.SearchRepositoriesService
import org.koin.dsl.module
import retrofit2.Retrofit

val featureServiceModule = module {
    single { get<Retrofit>().create(SearchRepositoriesService::class.java) }
}