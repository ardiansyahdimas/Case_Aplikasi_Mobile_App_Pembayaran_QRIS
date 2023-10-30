package com.caseaplikasi.core.data.source.local

import com.caseaplikasi.core.data.source.local.entity.RiwayatTransaksiEntity
import com.caseaplikasi.core.data.source.local.entity.UserEntity
import com.caseaplikasi.core.data.source.local.room.RiwayatTransaksiDao
import com.caseaplikasi.core.data.source.local.room.UserDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

class LocalDataSource @Inject constructor(
    private val riwayatTransaksiDao: RiwayatTransaksiDao,
    private val userDao: UserDao,
) {
    suspend fun getRiwayatTransaksi(): List<RiwayatTransaksiEntity> = riwayatTransaksiDao.getRiwayatTransaksi()

    suspend fun insertRiwayatTransaksi(riwayatTransaksi: RiwayatTransaksiEntity) = riwayatTransaksiDao.insertRiwayatTransaksi(riwayatTransaksi)

    fun getUser():UserEntity = userDao.getUser()
    suspend fun insertUser(userEntity: UserEntity) = userDao.insertUser(userEntity)
}