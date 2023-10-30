package com.caseaplikasi.mobileapp.pembayaranqris.ui.common

import android.os.Build
import android.os.Bundle
import androidx.navigation.NavType
import com.caseaplikasi.mobileapp.pembayaranqris.model.QRModel
import com.google.gson.Gson

class AssetParamType : NavType<QRModel>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): QRModel? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, QRModel::class.java)
        } else {
           bundle.getParcelable(key)
        }
    }

    override fun parseValue(value: String): QRModel {
        return Gson().fromJson(value, QRModel::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: QRModel) {
        bundle.putParcelable(key, value)
    }
}