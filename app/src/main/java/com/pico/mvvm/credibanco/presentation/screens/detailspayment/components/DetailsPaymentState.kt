package com.pico.mvvm.credibanco.presentation.screens.detailspayment.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.pico.mvvm.credibanco.domain.model.Response
import com.pico.mvvm.credibanco.presentation.components.ProgressBar
import com.pico.mvvm.credibanco.presentation.screens.detailspayment.viewModel.DetailsPaymentViewModel
import com.pico.mvvm.credibanco.presentation.screens.listApprove.components.ListApproveContent
import com.pico.mvvm.credibanco.presentation.screens.listApprove.viewModel.ListApproveViewModel


@Composable
fun DetailsPaymentState(viewModel: DetailsPaymentViewModel) {
    when (val getAllPaymentsResponse = viewModel.getAllPaymentsResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success -> {
            Toast.makeText(LocalContext.current, "Info correctly extracted", Toast.LENGTH_SHORT).show()
            ListApproveContent(payments = viewModel.payments, "Details", viewModel)
        }

        is Response.Failure -> {
            Toast.makeText(
                LocalContext.current,
                getAllPaymentsResponse.Exception?.message ?: "Error Desconocido",
                Toast.LENGTH_LONG
            ).show()
        }
        else -> {}
    }
}