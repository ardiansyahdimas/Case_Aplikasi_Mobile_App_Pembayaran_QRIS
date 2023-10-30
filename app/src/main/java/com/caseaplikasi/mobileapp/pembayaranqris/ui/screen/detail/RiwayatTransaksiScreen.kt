package com.caseaplikasi.mobileapp.pembayaranqris.ui.screen.detail

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.caseaplikasi.core.data.source.local.entity.RiwayatTransaksiEntity
import com.caseaplikasi.mobileapp.pembayaranqris.ui.components.TransaksiItem
import com.caseaplikasi.mobileapp.pembayaranqris.ui.screen.QrViewModel

@Composable
fun RiwayatTransaksiScreen(
    viewModel: QrViewModel,
    modifier: Modifier = Modifier
) {
    viewModel.getRiwayatTransaksi()
    TransactionRow(listRiwayat = viewModel.riwayatList.value)
}

@Composable
fun TransactionRow(
    listRiwayat: List<RiwayatTransaksiEntity>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ){
        items(listRiwayat) { riwayat ->
            TransaksiItem(
                riwayat = riwayat,
            )
        }
    }
}