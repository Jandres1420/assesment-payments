package com.pico.mvvm.credibanco.presentation.screens.authorization.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pico.mvvm.credibanco.domain.model.Response
import com.pico.mvvm.credibanco.presentation.components.ProgressBar
import com.pico.mvvm.credibanco.presentation.screens.authorization.viewModel.AuthorizationViewModel

@Composable
fun Authorization(navController: NavHostController, viewModel: AuthorizationViewModel = hiltViewModel()) {

    when (val authorizationResponse = viewModel.authorizationState) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success -> {
            Toast.makeText(LocalContext.current, "Transacción Autorizada", Toast.LENGTH_SHORT).show()
        }

        is Response.Failure -> {
            Toast.makeText(
                LocalContext.current,
                authorizationResponse.Exception?.message ?: "Error Desconocido",
                Toast.LENGTH_LONG
            ).show()
        }

        else -> {}
    }
}