package com.caseaplikasi.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.Nonnull

@Entity(tableName = "riwayat_transaksi")
data class RiwayatTransaksiEntity(
    @PrimaryKey(autoGenerate = true)
    var uId : Int = 0,
    @ColumnInfo(name = "nama_merchant")
    var namaMerchant: String?,

    @ColumnInfo(name = "nominal")
    var nominal: Int?,
)