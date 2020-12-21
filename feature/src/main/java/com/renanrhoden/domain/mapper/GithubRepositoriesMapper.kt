package com.renanrhoden.domain.mapper

import com.renanrhoden.domain.model.GithubRepo
import com.renanrhoden.domain.response.SearchRepoResponse

fun SearchRepoResponse.toGithubRepoList() =
    this.items.map {
        with(it) {
            GithubRepo(name, owner.login, stargazersCount, forks, owner.avatarUrl)
        }
    }