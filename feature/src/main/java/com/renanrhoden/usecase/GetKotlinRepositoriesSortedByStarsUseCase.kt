package com.renanrhoden.usecase

import com.renanrhoden.repository.SearchRepositoriesRepository

class GetKotlinRepositoriesSortedByStarsUseCase(private val repository: SearchRepositoriesRepository) {

    suspend operator fun invoke(page: Int) =
        repository.getKotlinRepositoriesSortedByStars(page)
}