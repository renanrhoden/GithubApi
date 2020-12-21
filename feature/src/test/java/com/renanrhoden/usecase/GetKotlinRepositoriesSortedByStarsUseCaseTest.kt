package com.renanrhoden.usecase

import com.renanrhoden.domain.model.GithubRepo
import com.renanrhoden.repository.SearchRepositoriesRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class GetKotlinRepositoriesSortedByStarsUseCaseTest {

    private val repository: SearchRepositoriesRepository = mockk(relaxed = true)
    private val useCase = GetKotlinRepositoriesSortedByStarsUseCase(repository)
    private val mockResult = listOf(GithubRepo("repoName", "authorName", 12, 144, "url"))

    @Before
    fun setup() {
        coEvery { repository.getKotlinRepositoriesSortedByStars(any()) } returns mockResult
    }

    @Test
    fun `when calling use case, must return result unchanged`() {
        val result = runBlocking { useCase(1) }
        assertThat(result).isEqualTo(mockResult)
        coVerify { repository.getKotlinRepositoriesSortedByStars(1) }
    }
}