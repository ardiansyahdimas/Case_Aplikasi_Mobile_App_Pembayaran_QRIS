package com.caseaplikasi.mobileapp.pembayaranqris.ui.screen.home

import android.Manifest
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.caseaplikasi.mobileapp.pembayaranqris.ui.components.CameraPreview
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    valueSaldo:Int,
    navigateToDetail: (String) -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        val saldo = remember { valueSaldo }
        Text(text = "Saldo: ${saldo}")

        Spacer(modifier = Modifier.height(10.dp))

        val cameraPermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)

        Button(
            onClick = {
                cameraPermissionState.launchPermissionRequest()
            }
        ) {
            Text(text = "Camera Permission")
        }

        Spacer(modifier = Modifier.height(10.dp))

        CameraPreview(navigateToDetail)
    }
}