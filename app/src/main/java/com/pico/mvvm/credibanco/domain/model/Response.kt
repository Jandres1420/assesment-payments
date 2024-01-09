package com.pico.mvvm.credibanco.domain.model

import java.lang.Exception

sealed class Response<out T>{
    object Loading: Response<Nothing>()
    data class Success<out T>(val data: T): Response<T>()
    data class Failure<out T>(val Exception: Exception?): Response<T>()
}
