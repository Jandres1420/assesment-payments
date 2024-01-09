package com.pico.mvvm.credibanco.presentation.screens.detailspayment

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pico.mvvm.credibanco.presentation.components.TopLogo
import com.pico.mvvm.credibanco.presentation.screens.authorization.components.Authorization
import com.pico.mvvm.credibanco.presentation.screens.authorization.components.AuthorizationContent
import com.pico.mvvm.credibanco.presentation.screens.detailspayment.components.DetailsPaymentState
import com.pico.mvvm.credibanco.presentation.screens.detailspayment.viewModel.DetailsPaymentViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsPaymentScreen (navController: NavHostController, viewModel: DetailsPaymentViewModel = hiltViewModel()){
    Scaffold (
        topBar = { TopLogo() },
        content = { DetailsPaymentState(viewModel) },
        bottomBar = {}
    )
    Authorization(navController = navController)
}