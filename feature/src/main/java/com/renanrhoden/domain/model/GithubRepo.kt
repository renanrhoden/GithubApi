package com.renanrhoden.domain.model

data class GithubRepo(
    var repoName: String,
    var authorName: String,
    var stars: Int,
    var forks: Int,
    var authorPhotoUrl: String
)
