package com.renanrhoden.service

import com.renanrhoden.domain.response.SearchRepoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchRepositoriesService {
    @GET("search/repositories")
    suspend fun getRepositories(
        @Query("q") searchQuery: String,
        @Query("sort") sort: String,
        @Query("page") page: Int
        ): SearchRepoResponse
}