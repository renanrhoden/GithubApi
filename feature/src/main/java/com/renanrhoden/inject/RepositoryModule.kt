package com.renanrhoden.inject

import com.renanrhoden.repository.SearchRepositoriesRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { SearchRepositoriesRepository(get()) }
}