package com.pico.mvvm.credibanco.presentation.screens.listApprove

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pico.mvvm.credibanco.presentation.components.TopLogo
import com.pico.mvvm.credibanco.presentation.screens.listApprove.components.GetAllPaymentsState
import com.pico.mvvm.credibanco.presentation.screens.listApprove.viewModel.ListApproveViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListApproveSreen (navController: NavHostController?,viewModel: ListApproveViewModel = hiltViewModel() ){
    val context = LocalContext.current
    Scaffold (
        topBar = { TopLogo() },
        content = { GetAllPaymentsState(viewModel) },
        bottomBar = {}
    )
}