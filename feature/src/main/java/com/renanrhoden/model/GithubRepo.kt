package com.renanrhoden.model

data class GithubRepo(
    var repoName: String,
    var authorName: String,
    var stars: Int,
    var forks: Int,
    var authorPhotoUrl: String
)
