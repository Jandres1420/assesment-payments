package com.pico.mvvm.credibanco.presentation.screens.searchAuth.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pico.mvvm.credibanco.domain.model.Response
import com.pico.mvvm.credibanco.presentation.components.ProgressBar
import com.pico.mvvm.credibanco.presentation.navigation.AppScreen
import com.pico.mvvm.credibanco.presentation.screens.authorization.viewModel.AuthorizationViewModel
import com.pico.mvvm.credibanco.presentation.screens.searchAuth.viewModel.SearchAuthViewModel

@Composable
fun SearchAuth(navController: NavHostController, viewModel: SearchAuthViewModel = hiltViewModel()) {
    viewModel.navController = navController
    when (val searchAuthResponse = viewModel.annulmentState) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success -> {
            Toast.makeText(LocalContext.current, "PAGO ENCONTRADO", Toast.LENGTH_SHORT).show()
        }

        is Response.Failure -> {
            Toast.makeText(
                LocalContext.current,
                searchAuthResponse.Exception?.message ?: "Recibo desconocido",
                Toast.LENGTH_SHORT
            ).show()
        }

        else -> {}
    }
}