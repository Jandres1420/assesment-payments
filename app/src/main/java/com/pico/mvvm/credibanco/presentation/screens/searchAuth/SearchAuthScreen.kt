package com.pico.mvvm.credibanco.presentation.screens.searchAuth

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.pico.mvvm.credibanco.presentation.components.TopLogo
import com.pico.mvvm.credibanco.presentation.screens.authorization.components.Authorization
import com.pico.mvvm.credibanco.presentation.screens.authorization.components.AuthorizationContent
import com.pico.mvvm.credibanco.presentation.screens.searchAuth.components.SearchAuthContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SearchAuthScreen (navController: NavHostController){
    Scaffold (
        topBar = { TopLogo() },
        content = { SearchAuthContent(navController = navController) },
        bottomBar = {}
    )

}