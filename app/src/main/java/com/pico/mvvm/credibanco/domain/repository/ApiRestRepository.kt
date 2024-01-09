package com.pico.mvvm.credibanco.domain.repository

import com.pico.mvvm.credibanco.domain.model.RequestAnnulment
import com.pico.mvvm.credibanco.domain.model.RequestAuth
import com.pico.mvvm.credibanco.domain.model.ResponseAnnulment
import com.pico.mvvm.credibanco.domain.model.ResponseAuth

interface ApiRestRepository {
    suspend fun authorization(requestAuth: RequestAuth): ResponseAuth
    suspend fun annulment(requestAnnulment: RequestAnnulment): ResponseAnnulment
}