package com.pico.mvvm.credibanco.presentation.screens.searchAuth.viewModel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.pico.mvvm.credibanco.data.use_cases.CrediBancoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.pico.mvvm.credibanco.core.Constants
import com.pico.mvvm.credibanco.data.repository.MyDatabase
import com.pico.mvvm.credibanco.domain.model.Payment
import com.pico.mvvm.credibanco.domain.model.Response
import com.pico.mvvm.credibanco.domain.model.ResponseAnnulment
import com.pico.mvvm.credibanco.domain.model.ResponseAuth
import com.pico.mvvm.credibanco.presentation.navigation.AppScreen
import com.pico.mvvm.credibanco.util.SharedPreferencesUtil
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchAuthViewModel @Inject constructor(
    private val crediBancoUseCases: CrediBancoUseCases,
    private val myDatabase: MyDatabase,
    @ApplicationContext private val context: Context
) : ViewModel() {

    var state by mutableStateOf(SearchAuthState())
    var annulmentState by mutableStateOf<Response<ResponseAnnulment>?>(null)
    var payments by mutableStateOf<List<Payment>>(listOf())
        private set
    var navController by mutableStateOf<NavHostController?>(null)

    init {
        SharedPreferencesUtil.saveToSharedPreferences(context, "receiptId", "")
    }

    fun getAnnulment() = viewModelScope.launch {
        annulmentState = Response.Loading
        val result = crediBancoUseCases.postAnnulment(
            receiptId = state.receipt,
            rrn = state.rrn
        )
        if (result.statusCode != "Excepcion") {
            payments = myDatabase.getAllData("receiptId = '${state.receipt}'")
            if (payments.isNotEmpty()) {
                SharedPreferencesUtil.saveToSharedPreferences(context, "receiptId", state.receipt)
                annulmentState = Response.Success(result)
                navController!!.navigate(route = AppScreen.DetailsPayment.route)
                annulmentState = null
            } else {
                annulmentState = Response.Failure(Exception("Excepcion: Recibo no encontrado"))
            }
        } else {
            annulmentState = Response.Failure(Exception("Excepcion: Recibo no encontrado"))
        }
    }


    fun onrReceiptInput(receipt: String) {
        state = state.copy(receipt = receipt)
    }
}