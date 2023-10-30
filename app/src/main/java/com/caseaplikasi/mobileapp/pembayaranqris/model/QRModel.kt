package com.caseaplikasi.mobileapp.pembayaranqris.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class QRModel(
    val sumber: String,
    val idTransaksi: String,
    val namaMerchant: String,
    val nominal: Int
):Parcelable