package com.renanrhoden.feature.listing

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.renanrhoden.model.GithubRepo

class ListingViewModel : ViewModel() {

    val repos = MutableLiveData<List<GithubRepo>>()

    fun setup() {
        Handler().postDelayed({
            repos.postValue(
                listOf(
                    GithubRepo("Repo name 1", "author name 1", 1, 1, ""),
                    GithubRepo("Repo name 2", "author name 2", 2, 2, ""),
                    GithubRepo("Repo name 3", "author name 3", 3, 3, ""),
                    GithubRepo("Repo name 4", "author name 4", 4, 4, ""),
                    GithubRepo("Repo name 5", "author name 5", 5, 5, ""),
                    GithubRepo("Repo name 6", "author name 6", 6, 6, ""),
                    GithubRepo("Repo name 7", "author name 7", 76, 7, ""),
                )
            )
        }, 2000)
    }
}