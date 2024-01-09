package com.pico.mvvm.credibanco.presentation.screens.authorization.viewModel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.pico.mvvm.credibanco.data.use_cases.CrediBancoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.pico.mvvm.credibanco.core.Constants
import com.pico.mvvm.credibanco.data.repository.MyDatabase
import com.pico.mvvm.credibanco.domain.model.Payment
import com.pico.mvvm.credibanco.domain.model.Response
import com.pico.mvvm.credibanco.domain.model.ResponseAuth
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val crediBancoUseCases: CrediBancoUseCases,
    private val context: Context,
    private val myDatabase: MyDatabase
) : ViewModel() {

    var state by mutableStateOf(AuthorizationState())
    var authorizationState by mutableStateOf<Response<ResponseAuth>?>(null)

    init {

    }

    fun getAuthorization() = viewModelScope.launch {
        authorizationState = Response.Loading
        val result = crediBancoUseCases.getAuthorization(
            id = state.id,
            terminalCode = Constants.TERMINAL_CODE,
            commerceCode = Constants.COMERCE_CODE,
            amount = state.amount,
            card = Constants.CARD
        )
        if (result.statusCode != "Excepcion") {
            myDatabase.insertData(
                Payment(
                    id = state.id, receiptId = result.receiptId,
                    amount = state.amount, statusDescription = result.statusDescription,
                    statusCode = result.statusCode, rrn = result.rrn
                )
            )
            authorizationState = Response.Success(result)
        }else{
            authorizationState = Response.Failure(Exception(result.statusCode))
        }
    }

    fun onAmountInput(amount: String) {
        state = state.copy(amount = amount)
    }


    fun onIdInput(id: String) {
        state = state.copy(id = id)
    }
}