package com.pico.mvvm.credibanco.data.use_cases

import com.pico.mvvm.credibanco.domain.model.RequestAnnulment
import com.pico.mvvm.credibanco.domain.model.RequestAuth
import com.pico.mvvm.credibanco.domain.repository.ApiRestRepository

class PostAnnulment constructor(private val repository: ApiRestRepository) {
    suspend operator fun invoke(
        receiptId: String, rrn:String
    ) = repository.annulment(RequestAnnulment(receiptId = receiptId, rrn = rrn))
}