package com.caseaplikasi.mobileapp.pembayaranqris.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object DetailScreen : Screen("home/{qrModel}") {
        fun createRoute(qrModel: String) = "home/$qrModel"
    }
    object PaymentScreen : Screen("payment/{qrModel}") {
        fun createRoute(qrModel: String) = "payment/$qrModel"
    }
    object Riwayat : Screen("riwayat")
}