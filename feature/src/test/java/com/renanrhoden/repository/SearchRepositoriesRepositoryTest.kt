package com.renanrhoden.repository

import com.renanrhoden.domain.model.GithubRepo
import com.renanrhoden.domain.response.ItemsItem
import com.renanrhoden.domain.response.Owner
import com.renanrhoden.domain.response.SearchRepoResponse
import com.renanrhoden.service.SearchRepositoriesService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SearchRepositoriesRepositoryTest {

    private val service: SearchRepositoriesService = mockk(relaxed = false)
    private val repository = SearchRepositoriesRepository(service)
    private val owner = Owner(login = "name", avatarUrl = "avatar owner")
    private val responseItem = ItemsItem(
        stargazersCount = 10, forks = 15, name = "name fic", owner = owner
    )
    private val mockResponse =
        SearchRepoResponse(20, false, listOf(responseItem))

    @Test
    fun `when calling service, must return response mapped`() {
        coEvery { service.getRepositories(any(), any(), any()) } returns mockResponse
        val result = runBlocking { repository.getKotlinRepositoriesSortedByStars(1) }
        val expectedResult =
            listOf(
                GithubRepo(
                    repoName = "name fic",
                    authorName = "name",
                    stars = 10,
                    forks = 15,
                    authorPhotoUrl = "avatar owner"
                )
            )
        assertThat(result).isEqualTo(expectedResult)
    }

    @Test
    fun `when calling service, must call with kotlin language and sort by stars`() {
        coEvery { service.getRepositories(any(), any(), any()) } returns mockResponse
        runBlocking { repository.getKotlinRepositoriesSortedByStars(1) }

        coVerify { service.getRepositories("language:kotlin", "stars", 1) }

    }
}