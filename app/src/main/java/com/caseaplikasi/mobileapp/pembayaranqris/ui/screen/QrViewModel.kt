package com.caseaplikasi.mobileapp.pembayaranqris.ui.screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caseaplikasi.core.data.source.local.LocalDataSource
import com.caseaplikasi.core.data.source.local.entity.RiwayatTransaksiEntity
import com.caseaplikasi.core.data.source.local.entity.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class QrViewModel @Inject constructor (private val localDataSource: LocalDataSource) : ViewModel() {
    val userData  = mutableStateOf<UserEntity>(UserEntity(1, "user", 2000000))
    val riwayatList = mutableStateOf<List<RiwayatTransaksiEntity>>(emptyList())

    fun getUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            userData.value =  localDataSource.getUser()

        }
    }

    fun insertUser(userEntity: UserEntity){
        viewModelScope.launch {
            localDataSource.insertUser(userEntity)
        }
    }

    fun countTransaction(nominal:Int, userEntity: UserEntity){
        viewModelScope.launch {
            val result = userEntity.saldo?.minus(nominal)
            val newUserEntity = UserEntity(userEntity.id, userEntity.nama, result)
            localDataSource.insertUser(newUserEntity)
        }
    }

    fun getRiwayatTransaksi() {
       viewModelScope.launch {
         riwayatList.value = localDataSource.getRiwayatTransaksi()
       }
    }

    fun insertRiwayatTransaksi(riwayatTransaksiEntity: RiwayatTransaksiEntity) {
        viewModelScope.launch {
            localDataSource.insertRiwayatTransaksi(riwayatTransaksiEntity)
        }
    }
}