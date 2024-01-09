package com.pico.mvvm.credibanco.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pico.mvvm.credibanco.presentation.screens.annulment.AnnulmentScreen
import com.pico.mvvm.credibanco.presentation.screens.authorization.AuthorizationScreen
import com.pico.mvvm.credibanco.presentation.screens.detailspayment.DetailsPaymentScreen
import com.pico.mvvm.credibanco.presentation.screens.home.HomeScreen
import com.pico.mvvm.credibanco.presentation.screens.listApprove.ListApproveSreen
import com.pico.mvvm.credibanco.presentation.screens.searchAuth.SearchAuthScreen


@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = AppScreen.Home.route
    ) {

        composable(route = AppScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = AppScreen.ListApprove.route) {
            ListApproveSreen(navController)
        }
        composable(route = AppScreen.Annulment.route) {
            AnnulmentScreen(navController)
        }
        composable(route = AppScreen.Authorization.route) {
            AuthorizationScreen(navController)
        }
        composable(route = AppScreen.SearchAuth.route) {
            SearchAuthScreen(navController)
        }

        composable(route = AppScreen.DetailsPayment.route) {
            DetailsPaymentScreen(navController)
        }

    }


}