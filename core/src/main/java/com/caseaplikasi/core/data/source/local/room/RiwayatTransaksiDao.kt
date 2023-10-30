package com.caseaplikasi.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.caseaplikasi.core.data.source.local.entity.RiwayatTransaksiEntity

@Dao
interface RiwayatTransaksiDao {

    @Query("SELECT * FROM riwayat_transaksi")
   suspend fun getRiwayatTransaksi(): List<RiwayatTransaksiEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRiwayatTransaksi(riwayatList: RiwayatTransaksiEntity)
}