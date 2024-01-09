package com.pico.mvvm.credibanco.presentation.screens.listApprove.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pico.mvvm.credibanco.domain.model.Payment
import com.pico.mvvm.credibanco.presentation.screens.detailspayment.components.DetailCard
import com.pico.mvvm.credibanco.presentation.screens.detailspayment.viewModel.DetailsPaymentViewModel
import com.pico.mvvm.credibanco.ui.theme.Purple80



@Composable
fun ListApproveContent(payments: List<Payment>, screen:String ,
                       detailsPaymentViewModel: DetailsPaymentViewModel? ) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(Purple80)
    ) {
        items(items = payments) { payment ->
            if(screen == "Details"){
                if (detailsPaymentViewModel != null) {
                    DetailCard(payment, detailsPaymentViewModel)
                }
            }else{
                PaymentCard(payment)
            }

        }
    }
}

