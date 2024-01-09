package com.pico.mvvm.credibanco.domain.model

data class ResponseAuth(
    val receiptId: String,
    val rrn: String,
    val statusCode: String,
    val statusDescription: String
)