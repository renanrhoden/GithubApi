package com.renanrhoden.feature.listing

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.renanrhoden.commons.OnError
import com.renanrhoden.commons.OnErrorImpl
import com.renanrhoden.coreapi.util.safeRun
import com.renanrhoden.domain.model.GithubRepo
import com.renanrhoden.usecase.GetKotlinRepositoriesSortedByStarsUseCase
import kotlinx.coroutines.launch

class ListingViewModel(private val useCase: GetKotlinRepositoriesSortedByStarsUseCase) :
    ViewModel(), OnError by OnErrorImpl() {

    val repos = MutableLiveData<List<GithubRepo>>()
    private val initialPageValue = 1
    private var page = initialPageValue
    val isLoading = MutableLiveData(false)

    fun setup() {
        viewModelScope.launch {
            isLoading.postValue(true)
            safeRun({
                val result = useCase(page)
                repos.postValue(result)
            }, ::onError)
            isLoading.postValue(false)
        }
    }

    fun loadNextRepos() {
        page++
        viewModelScope.launch {
            isLoading.postValue(true)
            safeRun({
                val result = useCase(page)
                repos.postValue(repos.value?.toMutableList()?.apply { addAll(result) })
            }, ::onError)
            isLoading.postValue(false)
        }
    }

}