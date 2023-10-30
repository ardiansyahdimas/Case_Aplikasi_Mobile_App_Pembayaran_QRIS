package com.caseaplikasi.mobileapp.pembayaranqris.ui.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.caseaplikasi.mobileapp.pembayaranqris.model.QRModel
import com.caseaplikasi.mobileapp.pembayaranqris.ui.screen.QrViewModel

@Composable
fun PaymentScreen(
    qrModel: QRModel,
    viewModel: QrViewModel,
    modifier: Modifier = Modifier,
    navigateToDetail: () -> Unit,
) {
    viewModel.getUsers()
    Card(
        modifier = modifier
            .fillMaxSize(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray
        )
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Transaksi Berhasil",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Pembayaran: ${qrModel.nominal}",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Sisa Saldo: ${viewModel.userData.value.saldo}",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    navigateToDetail()
                }
            ) {
                Text(text = "Bayar")
            }
        }
    }
}