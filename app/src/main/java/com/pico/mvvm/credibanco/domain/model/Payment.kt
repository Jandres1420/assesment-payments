package com.pico.mvvm.credibanco.domain.model

data class Payment(
    val id: String,
    val amount: String,
    val rrn: String,
    val statusCode: String,
    val statusDescription: String,
    val receiptId: String,

)