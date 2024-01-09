package com.pico.mvvm.credibanco.presentation.screens.detailspayment.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pico.mvvm.credibanco.domain.model.Payment
import com.pico.mvvm.credibanco.presentation.components.DefaultButton
import com.pico.mvvm.credibanco.presentation.navigation.AppScreen
import com.pico.mvvm.credibanco.presentation.screens.detailspayment.viewModel.DetailsPaymentViewModel
import com.pico.mvvm.credibanco.presentation.screens.listApprove.components.ListApproveContent


@Composable
fun DetailCard(payment: Payment, viewModel: DetailsPaymentViewModel) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "ID:  ${payment.id}" ?: "",
                color = Color.Black
            )
            Text(
                modifier = Modifier.padding(vertical = 10.dp),
                text = "AMOUNT:  ${payment.amount}" ?: "",
                color = Color.Black
            )
            Text(
                modifier = Modifier.padding(vertical = 10.dp),
                text = "RRN:  ${payment.rrn}" ?: "",
                color = Color.Black
            )
            Text(
                modifier = Modifier.padding(vertical = 10.dp),
                text = "STATUS CODE:  ${payment.statusCode}" ?: "",
                color = Color.Black
            )
            Text(
                modifier = Modifier.padding(vertical = 10.dp),
                text = "STATUS DESCRIPTION:  ${payment.statusDescription}" ?: "",
                color = Color.Black
            )
            Text(
                modifier = Modifier.padding(vertical = 10.dp),
                text = "RECEIPT ID:  ${payment.receiptId}" ?: "",
                color = Color.Black
            )

            DefaultButton(
                text = "Anular transacción",
                onClick = {viewModel.paymentAnnulment(payment.id)},
                enabled = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            )

        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPaymentCardPreview() {
    var listPayment = listOf<Payment>(
        Payment(
            id = "24124",
            amount = "545435435",
            rrn = "1a3ccb26-a0c3-4358-a68f-3f4beeca32b1",
            statusCode = "00",
            statusDescription = "Aprobada",
            receiptId = "6b82eacf-98da-421b-999a-18f2b970eb43"
        )
    )
    ListApproveContent(listPayment, "Details", null)
}