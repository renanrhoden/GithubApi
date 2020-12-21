package com.renanrhoden.repository

import com.renanrhoden.service.SearchRepositoriesService

class SearchRepositoriesRepository(private val service: SearchRepositoriesService) {

    suspend fun getKotlinRepositoriesSortedByStars(page: Int) =
        service.getRepositories("language:kotlin", "stars", page)

}