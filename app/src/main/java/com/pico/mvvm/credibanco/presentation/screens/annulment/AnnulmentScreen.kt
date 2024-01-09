package com.pico.mvvm.credibanco.presentation.screens.annulment

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pico.mvvm.credibanco.presentation.components.TopLogo
import com.pico.mvvm.credibanco.presentation.screens.annulment.components.AnnulmentList
import com.pico.mvvm.credibanco.presentation.screens.annulment.viewModel.AnnulmentViewModel
import com.pico.mvvm.credibanco.presentation.screens.listApprove.components.GetAllPaymentsState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AnnulmentScreen (navController: NavHostController?,viewModel: AnnulmentViewModel = hiltViewModel() ){
    val context = LocalContext.current
    Scaffold (
        topBar = { TopLogo() },
        content = { AnnulmentList(viewModel) },
        bottomBar = {}
    )
}