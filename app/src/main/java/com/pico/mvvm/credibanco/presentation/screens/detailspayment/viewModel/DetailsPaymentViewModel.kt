package com.pico.mvvm.credibanco.presentation.screens.detailspayment.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.pico.mvvm.credibanco.data.repository.MyDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pico.mvvm.credibanco.domain.model.Payment
import com.pico.mvvm.credibanco.domain.model.Response
import com.pico.mvvm.credibanco.presentation.screens.searchAuth.viewModel.SearchAuthViewModel
import com.pico.mvvm.credibanco.util.SharedPreferencesUtil
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsPaymentViewModel @Inject constructor(
    private val myDatabase: MyDatabase,
    @ApplicationContext private val context: Context
) : ViewModel() {



    var getAllPaymentsResponse by mutableStateOf<Response<List<Payment>>?>(null)
        private set

    var payments by mutableStateOf<List<Payment>>(listOf())
        private set

    var recieveState by mutableStateOf("")

    init {
        getReceipt()
        getAllPaymentsDetail()
    }

    private fun getReceipt() {
        recieveState = SharedPreferencesUtil.readFromSharedPreferences(context,"receiptId","")
    }

    fun getAllPaymentsDetail() = viewModelScope.launch {
        getAllPaymentsResponse = Response.Loading
        try {
            payments =  myDatabase.getAllData("receiptId = '${recieveState}'")
            getAllPaymentsResponse = Response.Success(payments)
        } catch (e: Exception) {
            e.printStackTrace()
            getAllPaymentsResponse = Response.Failure(e)
        }
    }

    fun paymentAnnulment(id: String){
        myDatabase.annulmentPayment(id,"Pago anulado")
    }
}