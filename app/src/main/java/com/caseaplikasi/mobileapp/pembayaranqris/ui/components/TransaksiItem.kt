package com.caseaplikasi.mobileapp.pembayaranqris.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.caseaplikasi.core.data.source.local.entity.RiwayatTransaksiEntity

@Composable
fun TransaksiItem(
    riwayat: RiwayatTransaksiEntity,
    modifier: Modifier = Modifier
        .padding(10.dp)
) {
  Card(
      shape = RoundedCornerShape(8.dp),
      colors = CardDefaults.cardColors(
          containerColor = Color.Gray
      ),
      modifier = modifier

  ) {
      Column(
          modifier = Modifier
              .padding(10.dp)
              .fillMaxWidth()
      ) {
          Text(text =  "Nama Merchant: ${riwayat.namaMerchant}")
          Text(text = "Nominal: ${riwayat.nominal}")
      }
  }
}