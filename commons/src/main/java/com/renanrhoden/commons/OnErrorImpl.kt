package com.renanrhoden.commons

class OnErrorImpl : OnError {
    override val onErrorEvent = SingleLiveEvent<String>()

    override fun onError(message: String) {
        onErrorEvent.postValue(message)
    }
}