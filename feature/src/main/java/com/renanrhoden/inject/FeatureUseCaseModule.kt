package com.renanrhoden.inject

import com.renanrhoden.usecase.GetKotlinRepositoriesSortedByStarsUseCase
import org.koin.dsl.module

val featureUseCaseModule = module {
    single { GetKotlinRepositoriesSortedByStarsUseCase(get()) }
}