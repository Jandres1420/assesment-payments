package com.pico.mvvm.credibanco.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pico.mvvm.credibanco.presentation.components.TopLogo
import com.pico.mvvm.credibanco.presentation.screens.home.components.HomeContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen (navController: NavHostController){

    Scaffold (
        topBar = { TopLogo() },
        content = { HomeContent(navController) },
        bottomBar = {}
    )
}