package com.caseaplikasi.mobileapp.pembayaranqris.ui.screen.detail

import android.net.Uri
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
import com.caseaplikasi.core.data.source.local.entity.RiwayatTransaksiEntity
import com.caseaplikasi.mobileapp.pembayaranqris.model.QRModel
import com.caseaplikasi.mobileapp.pembayaranqris.ui.screen.QrViewModel
import com.google.gson.Gson

@Composable
fun DetailScreen(
    qrModel:QRModel,
    viewModel: QrViewModel,
    navigateToDetail: (String) -> Unit,
    modifier: Modifier = Modifier
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
                text = "Detail Transaksi",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Sumber Bank\n${qrModel.sumber}",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Id Transaksi\n${qrModel.idTransaksi}",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Nama Merchant\n${qrModel.namaMerchant}",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Nominal\n${qrModel.nominal}",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    viewModel.countTransaction(qrModel.nominal, viewModel.userData.value)
                    val riwayatTransaksiEntity = RiwayatTransaksiEntity( namaMerchant = qrModel.namaMerchant,nominal = qrModel.nominal)
                    viewModel.insertRiwayatTransaksi(riwayatTransaksiEntity)
                    val json = Uri.encode(Gson().toJson(qrModel))
                    navigateToDetail(json)
                }
            ) {
                Text(text = "Bayar")
            }
        }

    }
}
