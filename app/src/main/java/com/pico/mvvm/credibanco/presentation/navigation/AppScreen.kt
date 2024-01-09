package com.pico.mvvm.credibanco.presentation.navigation


sealed class AppScreen(val route:String) {
    object Home: AppScreen("home")
    object ListApprove: AppScreen("listapprove")
    object Annulment: AppScreen("annulment")
    object Authorization: AppScreen("authorization")
    object SearchAuth: AppScreen("searchauth")
    object DetailsPayment: AppScreen("detailspayment")

}