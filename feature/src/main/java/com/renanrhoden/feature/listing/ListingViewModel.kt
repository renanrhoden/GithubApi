package com.renanrhoden.feature.listing

import android.os.Handler
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.renanrhoden.model.GithubRepo
import com.renanrhoden.usecase.GetKotlinRepositoriesSortedByStarsUseCase
import kotlinx.coroutines.launch
import java.lang.Exception

class ListingViewModel(private val useCase: GetKotlinRepositoriesSortedByStarsUseCase) :
    ViewModel() {

    val repos = MutableLiveData<List<GithubRepo>>()

    fun setup() {

        viewModelScope.launch {
            try {
                val result = useCase(1)
                Log.i("resultado", result.toString())
            } catch (e: Exception) {

            }
        }
        Handler().postDelayed({
            repos.postValue(
                listOf(
                    GithubRepo(
                        "Repo name 1",
                        "author name 1",
                        1,
                        1,
                        "https://cdn0.iconfinder.com/data/icons/customicondesignoffice5/256/examples.png"
                    ),
                    GithubRepo(
                        "Repo name 2",
                        "author name 2",
                        2,
                        2,
                        "https://cdn0.iconfinder.com/data/icons/customicondesignoffice5/256/examples.png"
                    ),
                    GithubRepo(
                        "Repo name 3",
                        "author name 3",
                        3,
                        3,
                        "https://cdn0.iconfinder.com/data/icons/customicondesignoffice5/256/examples.png"
                    ),
                    GithubRepo(
                        "Repo name 4",
                        "author name 4",
                        4,
                        4,
                        "https://cdn0.iconfinder.com/data/icons/customicondesignoffice5/256/examples.png"
                    ),
                    GithubRepo(
                        "Repo name 5",
                        "author name 5",
                        5,
                        5,
                        "https://cdn0.iconfinder.com/data/icons/customicondesignoffice5/256/examples.png"
                    ),
                    GithubRepo(
                        "Repo name 6",
                        "author name 6",
                        6,
                        6,
                        "https://cdn0.iconfinder.com/data/icons/customicondesignoffice5/256/examples.png"
                    ),
                    GithubRepo(
                        "Repo name 7",
                        "author name 7",
                        76,
                        7,
                        "https://cdn0.iconfinder.com/data/icons/customicondesignoffice5/256/examples.png"
                    ),
                )
            )
        }, 2000)
    }
}