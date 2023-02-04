package com.example.premierleague.utils.network_validator

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.premierleague.base.AndroidVersions
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface NetworkValidator {
    fun isConnected(): Boolean
}

class NetworkValidatorImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val versions: AndroidVersions,
) : NetworkValidator {
    @Suppress("DEPRECATION")
    override fun isConnected(): Boolean {
        val connectivityManager = (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
        if (versions.isAndroidM()) {
            connectivityManager.isActiveNetworkMetered
            val nw = connectivityManager.activeNetwork ?: return false
            val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
            return when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        } else {
            val activeNetInfo = connectivityManager.activeNetworkInfo
            return activeNetInfo != null && activeNetInfo.isConnected
        }
    }
}