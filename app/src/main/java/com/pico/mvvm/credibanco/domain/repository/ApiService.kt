package com.pico.mvvm.credibanco.domain.repository


import com.pico.mvvm.credibanco.domain.model.RequestAnnulment
import com.pico.mvvm.credibanco.domain.model.RequestAuth
import com.pico.mvvm.credibanco.domain.model.ResponseAnnulment
import com.pico.mvvm.credibanco.domain.model.ResponseAuth
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST("authorization")
    suspend fun authorization(
        @Header("Authorization") authorizationHeader: String,
        @Body requestAuth: RequestAuth
    ):ResponseAuth

    @POST("annulment")
    suspend fun annulment(
        @Header("Authorization") authorizationHeader: String,
        @Body requestAnnulment: RequestAnnulment
    ):ResponseAnnulment

}