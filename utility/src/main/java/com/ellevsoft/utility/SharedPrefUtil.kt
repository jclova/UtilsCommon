package com.ellevsoft.utility

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class SharedPrefUtil {

    companion object {

        private val TAG = "SharedPrefUtil"
        private var sharedPreferences: SharedPreferences? = null

        // Singleton
        private fun getSharedPreferences(context: Context?): SharedPreferences? {
            if (context == null)
                return null

            if (sharedPreferences == null)
                sharedPreferences = context.getSharedPreferences("PreferenceManager", Context.MODE_PRIVATE)
            return sharedPreferences
        }

        fun saveString(context: Context?, key: String, value: String?) {
            if (context == null)
                return
            val editor = getSharedPreferences(context)?.edit()
            if (value == null) {
                editor?.remove(key)
                if (BuildConfig.DEBUG)
                    Log.d(TAG, "save(): Key: $key value: (removed)")
            } else {
                editor?.putString(key, value)
                if (BuildConfig.DEBUG)
                    Log.d(TAG, "save(): Key: $key value: $value")
            }
            editor?.apply()
        }

        fun saveLong(context: Context?, key: String, value: Long?) {
            if (context == null)
                return
            val editor = getSharedPreferences(context)?.edit()
            if (value == null) {
                editor?.remove(key)
                if (BuildConfig.DEBUG)
                    Log.d(TAG, "save(): Key: $key value: (removed)")
            } else {
                editor?.putLong(key, value)
                if (BuildConfig.DEBUG)
                    Log.d(TAG, "save(): Key: $key value: $value")
            }
            editor?.apply()
        }

        fun saveInt(context: Context?, key: String, value: Int?) {
            if (context == null)
                return
            val editor = getSharedPreferences(context)?.edit()
            if (value == null) {
                editor?.remove(key)
                if (BuildConfig.DEBUG)
                    Log.d(TAG, "save(): Key: $key value: (removed)")
            } else {
                editor?.putInt(key, value)
                if (BuildConfig.DEBUG)
                    Log.d(TAG, "save(): Key: $key value: $value")
            }
            editor?.apply()
        }

        fun saveFloat(context: Context?, key: String, value: Float?) {
            if (context == null)
                return
            val editor = getSharedPreferences(context)?.edit()
            if (value == null) {
                editor?.remove(key)
                if (BuildConfig.DEBUG)
                    Log.d(TAG, "save(): Key: $key value: (removed)")
            } else {
                editor?.putFloat(key, value)
                if (BuildConfig.DEBUG)
                    Log.d(TAG, "save(): Key: $key value: $value")
            }
            editor?.apply()
        }

        fun saveBoolean(context: Context?, key: String, value: Boolean?) {
            if (context == null)
                return
            val editor = getSharedPreferences(context)?.edit()
            if (value == null) {
                editor?.remove(key)
                if (BuildConfig.DEBUG)
                    Log.d(TAG, "save(): Key: $key value: (removed)")
            } else {
                editor?.putBoolean(key, value)
                if (BuildConfig.DEBUG)
                    Log.d(TAG, "save(): Key: $key value: $value")
            }
            editor?.apply()
        }


        fun loadString(context: Context?, key: String?, defaultValue: String): String? {
            return if (key == null || context == null) {
                null
            } else {
                val value = getSharedPreferences(context)?.getString(key, defaultValue)
                if (BuildConfig.DEBUG)
                    Log.d(TAG, "load(): Key: $key value: $value")
                value
            }
        }

        fun loadLong(context: Context?, key: String?, defaultValue: Long): Long? {
            return if (key == null || context == null) {
                null
            } else {
                val value = getSharedPreferences(context)?.getLong(key, defaultValue)
                if (BuildConfig.DEBUG)
                    Log.d(TAG, "load(): Key: $key value: $value")
                value
            }
        }

        fun loadInt(context: Context?, key: String?, defaultValue: Int): Int? {
            return if (key == null || context == null) {
                null
            } else {
                val value = getSharedPreferences(context)?.getInt(key, defaultValue)
                if (BuildConfig.DEBUG)
                    Log.d(TAG, "load(): Key: $key value: $value")
                value
            }
        }

        fun loadFloat(context: Context?, key: String?, defaultValue: Float): Float? {
            return if (key == null || context == null) {
                null
            } else {
                val value = getSharedPreferences(context)?.getFloat(key, defaultValue)
                if (BuildConfig.DEBUG)
                    Log.d(TAG, "load(): Key: $key value: $value")
                value
            }
        }

        fun loadBoolean(context: Context?, key: String?, defaultValue: Boolean): Boolean? {
            return if (key == null || context == null) {
                null
            } else {
                val value = getSharedPreferences(context)?.getBoolean(key, defaultValue)
                if (BuildConfig.DEBUG)
                    Log.d(TAG, "load(): Key: $key value: $value")
                value
            }
        }

    }


}