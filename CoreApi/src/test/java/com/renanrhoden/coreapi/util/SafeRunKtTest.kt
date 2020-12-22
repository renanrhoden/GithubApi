package com.renanrhoden.coreapi.util

import androidx.lifecycle.ViewModel
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class SafeRunTest {

    @Test
    fun `when throw SocketTimeoutException must set message according to error`() {
        var error = ""
        object : ViewModel() {
        }.safeRun({
            throw SocketTimeoutException()
        }, {
            error = it
        })

        assertThat(error).isEqualTo("Connection timed out")
    }

    @Test
    fun `when throw UnknownHostException must set message according to error`() {
        var error = ""
        object : ViewModel() {

        }.safeRun({
            throw UnknownHostException()
        }, {
            error = it
        })

        assertThat(error).isEqualTo("Please, check your connection")
    }

    @Test
    fun `when throw Exception must set message according to error`() {
        var error = ""
        object : ViewModel() {

        }.safeRun({
            throw Exception()
        }, {
            error = it
        })

        assertThat(error).isEqualTo("An error occured, please try again later")
    }
}