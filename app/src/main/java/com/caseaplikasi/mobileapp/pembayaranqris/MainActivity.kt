package com.caseaplikasi.mobileapp.pembayaranqris

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.caseaplikasi.core.data.source.local.entity.UserEntity
import com.caseaplikasi.mobileapp.pembayaranqris.model.QRModel
import com.caseaplikasi.mobileapp.pembayaranqris.ui.common.AssetParamType
import com.caseaplikasi.mobileapp.pembayaranqris.ui.navigation.Screen
import com.caseaplikasi.mobileapp.pembayaranqris.ui.screen.QrViewModel
import com.caseaplikasi.mobileapp.pembayaranqris.ui.screen.detail.DetailScreen
import com.caseaplikasi.mobileapp.pembayaranqris.ui.screen.detail.PaymentScreen
import com.caseaplikasi.mobileapp.pembayaranqris.ui.screen.detail.RiwayatTransaksiScreen
import com.caseaplikasi.mobileapp.pembayaranqris.ui.screen.home.HomeScreen
import com.caseaplikasi.mobileapp.pembayaranqris.ui.theme.CaseAplikasiMobileAppPembayaranQRISTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel: QrViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            viewModel.insertUser(UserEntity(1,"user", 2000000))
            setContent {
                CaseAplikasiMobileAppPembayaranQRISTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colorScheme.background) {
                        QRApp(viewModel = viewModel)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QRApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: QrViewModel,
) {
    viewModel.getUsers()
    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                viewModel.userData.value.saldo?.let { it1 ->
                    HomeScreen(
                        valueSaldo = it1,
                        navigateToDetail = { qrModel ->
                            navController.navigate(Screen.DetailScreen.createRoute(qrModel))
                        })
                }
            }
            composable(
                route = Screen.DetailScreen.route,
                arguments = listOf(
                    navArgument("qrModel") {
                        type = AssetParamType()
                    }
                )
            ){
                val qrModel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    it.arguments?.getParcelable("qrModel", QRModel::class.java)
                } else {
                    it.arguments?.getParcelable("qrModel")
                }
                if (qrModel != null) {
                    DetailScreen(
                        qrModel = qrModel,
                        viewModel = viewModel,
                        navigateToDetail = { qr ->
                            navController.navigate(Screen.PaymentScreen.createRoute(qr))
                        })
                }
            }
            composable(
                Screen.PaymentScreen.route,
                arguments = listOf(
                    navArgument("qrModel") {
                        type = AssetParamType()
                    }
                )
            ) {
                val qrModel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    it.arguments?.getParcelable("qrModel", QRModel::class.java)
                } else {
                    it.arguments?.getParcelable("qrModel")
                }
                if (qrModel != null) {
                    PaymentScreen(
                        qrModel = qrModel,
                        viewModel = viewModel,
                        navigateToDetail = {
                            navController.navigate(Screen.Riwayat.route)
                        }
                    )
                }
            }
            composable(Screen.Riwayat.route) {
                RiwayatTransaksiScreen(viewModel = viewModel)
            }
        }
    }
}
