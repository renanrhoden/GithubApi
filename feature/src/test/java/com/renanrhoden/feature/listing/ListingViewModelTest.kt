package com.renanrhoden.feature.listing

import com.renanrhoden.domain.model.GithubRepo
import com.renanrhoden.usecase.GetKotlinRepositoriesSortedByStarsUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ListingViewModelTest {

    lateinit var viewModel: ListingViewModel
    private val usecase: GetKotlinRepositoriesSortedByStarsUseCase = mockk(relaxed = true)

    @Before
    fun setUp() {
        viewModel = ListingViewModel(usecase)
    }

    @Test
    fun `when loading initial values, must use first page`() {
        val mockResult = listOf<GithubRepo>()
        coEvery { usecase.invoke(any()) } returns mockResult
        runBlocking { viewModel.setup() }

        coVerify { usecase.invoke(1) }
        assertThat(viewModel.repos.value).isEqualTo(mockResult)
    }

    @Test
    fun `when loading initial values, error occurs, must set error message`() {
        coEvery { usecase.invoke(any()) } throws Exception()
        runBlocking { viewModel.setup() }

        assertThat(viewModel.onErrorEvent.value).isEqualTo("An error occured, please try again later")
    }

    @Test
    fun `when loading more items, must call added 1 to pages`() {
        val mockResult = listOf<GithubRepo>()
        coEvery { usecase.invoke(any()) } returns mockResult

        runBlocking { viewModel.loadNextRepos() }
        coVerify { usecase.invoke(2) }
        runBlocking { viewModel.loadNextRepos() }
        coVerify { usecase.invoke(3) }
    }

    @Test
    fun `when loading more items, items must be appended to list`() {
        val firstRepo = GithubRepo("name1", "author 1", 1, 1, "url 1")
        val secondRepo = GithubRepo("name2", "author 2", 2, 2, "url 2")

        val mockResult = listOf(firstRepo)
        val mockSecondPage = listOf(secondRepo)

        coEvery { usecase.invoke(1) } returns mockResult
        coEvery { usecase.invoke(2) } returns mockSecondPage

        viewModel.setup()
        viewModel.loadNextRepos()
        assertThat(viewModel.repos.value).isEqualTo(listOf(firstRepo, secondRepo))
    }
}