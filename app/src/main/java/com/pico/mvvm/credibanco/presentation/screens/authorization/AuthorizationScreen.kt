package com.pico.mvvm.credibanco.presentation.screens.authorization

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.pico.mvvm.credibanco.presentation.components.TopLogo
import com.pico.mvvm.credibanco.presentation.screens.authorization.components.Authorization
import com.pico.mvvm.credibanco.presentation.screens.authorization.components.AuthorizationContent
import com.pico.mvvm.credibanco.presentation.screens.home.components.HomeContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AuthorizationScreen (navController: NavHostController){
    Scaffold (
        topBar = { TopLogo() },
        content = { AuthorizationContent(navController) },
        bottomBar = {}
    )
    Authorization(navController = navController)
}