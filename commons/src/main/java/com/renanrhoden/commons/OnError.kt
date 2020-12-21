package com.renanrhoden.commons

interface OnError {
    val onErrorEvent: SingleLiveEvent<String>

    fun onError(message: String)
}