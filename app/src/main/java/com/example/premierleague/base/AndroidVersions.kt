package com.example.premierleague.base

import android.os.Build
import javax.inject.Inject

class AndroidVersions @Inject constructor() {
    fun isAndroidM(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
}