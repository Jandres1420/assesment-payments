package com.pico.mvvm.credibanco.data.use_cases

import com.pico.mvvm.credibanco.domain.model.RequestAuth
import com.pico.mvvm.credibanco.domain.repository.ApiRestRepository

class GetAuthorization constructor(private val repository: ApiRestRepository) {
    suspend operator fun invoke(
        id: String, terminalCode: String,
        commerceCode: String, amount: String,
        card: String
    ) = repository.authorization(RequestAuth(id=id, terminalCode = terminalCode, commerceCode = commerceCode, amount = amount, card = card))
}