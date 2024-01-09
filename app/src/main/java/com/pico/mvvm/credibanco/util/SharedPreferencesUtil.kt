package com.pico.mvvm.credibanco.util

import android.content.Context
import android.preference.PreferenceManager
import androidx.core.content.edit

object SharedPreferencesUtil {
    fun saveToSharedPreferences(context: Context, key: String, value: String) {
        PreferenceManager.getDefaultSharedPreferences(context).edit {
            putString(key, value)
            apply()
        }
    }

    fun readFromSharedPreferences(context: Context, key: String, defaultValue: String): String {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }
}