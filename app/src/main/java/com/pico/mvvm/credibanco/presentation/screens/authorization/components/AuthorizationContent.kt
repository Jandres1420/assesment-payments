package com.pico.mvvm.credibanco.presentation.screens.authorization.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pico.mvvm.credibanco.presentation.components.DefaultButton
import com.pico.mvvm.credibanco.presentation.components.DefaultTextField
import com.pico.mvvm.credibanco.presentation.navigation.AppScreen
import com.pico.mvvm.credibanco.presentation.screens.authorization.AuthorizationScreen
import com.pico.mvvm.credibanco.presentation.screens.authorization.viewModel.AuthorizationViewModel
import com.pico.mvvm.credibanco.presentation.screens.home.components.HomeContent
import com.pico.mvvm.credibanco.ui.theme.Purple80

@Composable
fun AuthorizationContent (navController: NavHostController, viewModel: AuthorizationViewModel = hiltViewModel()){
    Card(
        modifier = Modifier.padding(start = 30.dp, end = 30.dp, top = 50.dp),
        backgroundColor = Purple80
    ) {
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Text(
                modifier = Modifier.padding(top = 30.dp, bottom = 0.dp, start = 0.dp, end = 0.dp),
                text = "Autorice pago",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Por favor llene la información para confirmar el pago", fontSize = 12.sp,
                color = Color.Gray
            )

            DefaultTextField(
                value = viewModel.state.id,
                modifier = Modifier.padding(top = 10.dp),
                onValueChange = {viewModel.onIdInput(it)},
                label = "Id",
                icon = Icons.Default.Phone,
                keyBoardType = KeyboardType.Text,
                errorMsg = "")

            DefaultTextField(
                value = viewModel.state.amount,
                modifier = Modifier.padding(top = 10.dp),
                onValueChange = {viewModel.onAmountInput(it)},
                label = "Amount",
                icon = Icons.Default.Create,
                keyBoardType = KeyboardType.Text,
                errorMsg = "")

            DefaultButton(
                text = "Apruebe el pago",
                onClick = {viewModel.getAuthorization()},
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
fun DefaultAuthorizationContentPreview() {
    var navController: NavHostController = rememberNavController()
    AuthorizationScreen(navController)
}