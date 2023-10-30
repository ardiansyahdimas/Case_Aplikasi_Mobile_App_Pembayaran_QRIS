package com.caseaplikasi.mobileapp.pembayaranqris.di

import android.content.Context
import androidx.room.Room
import com.caseaplikasi.core.data.source.local.room.RiwayatTransaksiDao
import com.caseaplikasi.core.data.source.local.room.RiwayatTransaksiDatabase
import com.caseaplikasi.core.data.source.local.room.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context : Context): RiwayatTransaksiDatabase {
//        val passphrase: ByteArray = SQLiteDatabase.getBytes("transaksi".toCharArray())
//        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(
            context,
            RiwayatTransaksiDatabase::class.java, "qrisApp.db"
        ).fallbackToDestructiveMigration()
//            .openHelperFactory(factory)
            .build()
    }

    @Provides
    fun provideRiwayatTransaksiDao(database: RiwayatTransaksiDatabase): RiwayatTransaksiDao = database.riwayatTransaksiDao()

    @Provides
    fun provideUserDao(database: RiwayatTransaksiDatabase): UserDao = database.userDao()

}