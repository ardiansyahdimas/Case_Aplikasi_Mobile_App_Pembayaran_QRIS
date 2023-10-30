package com.caseaplikasi.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.Nonnull

@Entity(tableName = "user", indices = [androidx.room.Index(value = ["id"], unique = true)])
data class UserEntity(
    @PrimaryKey
    @Nonnull
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "nama")
    var nama: String?,

    @ColumnInfo(name = "saldo")
    var saldo: Int?,
)