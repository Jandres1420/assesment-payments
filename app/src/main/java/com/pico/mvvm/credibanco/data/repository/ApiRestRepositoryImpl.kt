package com.pico.mvvm.credibanco.data.repository

import android.util.Log
import com.pico.mvvm.credibanco.core.Constants
import com.pico.mvvm.credibanco.domain.model.RequestAnnulment
import com.pico.mvvm.credibanco.domain.model.RequestAuth
import com.pico.mvvm.credibanco.domain.model.ResponseAnnulment
import com.pico.mvvm.credibanco.domain.model.ResponseAuth
import com.pico.mvvm.credibanco.domain.repository.ApiRestRepository
import com.pico.mvvm.credibanco.domain.repository.ApiService
import retrofit2.HttpException
import javax.inject.Inject

class ApiRestRepositoryImpl @Inject constructor(private val apiService: ApiService):ApiRestRepository {

    override suspend fun authorization(requestAuth: RequestAuth): ResponseAuth {
        return try {
            apiService.authorization(Constants.AUTHORIZATION_HEADER,requestAuth)
        }catch (e: Exception){
            if (e is HttpException) {
                Log.e("ApiRestRepositoryImpl", "HTTP Status Code: ${e.code()}")
            }
            ResponseAuth("Excepcion", rrn = "", statusCode = "Excepcion", statusDescription = "")
        }
    }

    override suspend fun annulment(requestAnnulment: RequestAnnulment): ResponseAnnulment {
        return try {
            apiService.annulment(Constants.AUTHORIZATION_HEADER,requestAnnulment)
        }catch (e: Exception){
            if (e is HttpException) {
                Log.e("ApiRestRepositoryImpl", "HTTP Status Code: ${e.code()}")
            }
            ResponseAnnulment("Excepcion: Recibo no encontrado", "Not fount recieved in database")
        }
    }
}