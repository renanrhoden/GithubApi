package com.renanrhoden.domain.response

import com.google.gson.annotations.SerializedName

data class ItemsItem(

    @SerializedName("stargazers_count")
    val stargazersCount: Int,

    @SerializedName("forks")
    val forks: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("owner")
    val owner: Owner,
)