package com.caseaplikasi.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.caseaplikasi.core.data.source.local.entity.RiwayatTransaksiEntity
import com.caseaplikasi.core.data.source.local.entity.UserEntity

@Database(entities = [
    RiwayatTransaksiEntity::class,
    UserEntity::class
], version = 1, exportSchema = false)
abstract class RiwayatTransaksiDatabase : RoomDatabase() {
    abstract fun riwayatTransaksiDao(): RiwayatTransaksiDao
    abstract fun userDao(): UserDao
}