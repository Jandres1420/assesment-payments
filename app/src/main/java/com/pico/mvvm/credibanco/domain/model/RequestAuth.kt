package com.pico.mvvm.credibanco.domain.model

data class RequestAuth(
    val id: String,
    val commerceCode: String,
    val terminalCode: String,
    val amount: String,
    val card: String
)