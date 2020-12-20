package com.renanrhoden.githubapi.injection

import com.renanrhoden.githubapi.BuildConfig
import org.koin.core.qualifier.named
import org.koin.dsl.module

val baseUrlModule = module {
    single(named("baseUrl")) { BuildConfig.SERVER_URL }
}