package com.renanrhoden.coreapi.util

import androidx.lifecycle.ViewModel
import java.net.SocketTimeoutException
import java.net.UnknownHostException

inline fun ViewModel.safeRun(onSuccess: () -> Unit, onError: (String) -> Unit) {
    try {
        onSuccess()
    } catch (e: Exception) {
        val message = when (e) {
            is SocketTimeoutException -> "Connection timed out"
            is UnknownHostException -> "Please, check your connection"
            else -> "An error occured, please try again later"
        }
        onError(message)
    }
}