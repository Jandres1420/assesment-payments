package com.pico.mvvm.credibanco.presentation.screens.listApprove.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pico.mvvm.credibanco.data.repository.MyDatabase
import com.pico.mvvm.credibanco.domain.model.Payment
import com.pico.mvvm.credibanco.domain.model.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListApproveViewModel @Inject constructor(
    private val myDatabase: MyDatabase,
) : ViewModel() {


    var getAllPaymentsResponse by mutableStateOf<Response<List<Payment>>?>(null)
        private set

    var payments by mutableStateOf<List<Payment>>(listOf())
        private set

    init {
        getAllPayments()
    }


    fun getAllPayments() = viewModelScope.launch {
        getAllPaymentsResponse = Response.Loading
        try {
            payments =  myDatabase.getAllData("statusDescription = 'Aprobada'")
            getAllPaymentsResponse = Response.Success(payments)
        } catch (e: Exception) {
            e.printStackTrace()
            getAllPaymentsResponse = Response.Failure(e)
        }
    }

}