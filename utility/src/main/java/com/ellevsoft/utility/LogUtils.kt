package com.ellevsoft.utility

import android.util.Log

object LogUtils {

    private val LOGTAG = "LogUtils"

    // Shows logs on debug version only (Does not appear on the release version)
    private val DEBUG = BuildConfig.DEBUG

    fun v(message: String, vararg args: Any) {
        if (DEBUG) {
            Log.v(LOGTAG, if (args == null || args.size == 0)
                message
            else
                String.format(message, *args))
        }
    }

    fun v(tag: String, message: String, vararg args: Any) {
        if (DEBUG) {
            Log.v("$LOGTAG/$tag", if (args == null || args.size == 0)
                message
            else
                String.format(message, *args))
        }
    }

    fun d(message: String, vararg args: Any) {
        if (DEBUG) {
            Log.d(LOGTAG, if (args == null || args.size == 0)
                message
            else
                String.format(message, *args))
        }
    }

    fun d(tag: String, message: String, vararg args: Any) {
        if (DEBUG) {
            Log.d("$LOGTAG/$tag", if (args == null || args.size == 0)
                message
            else
                String.format(message, *args))
        }
    }

    fun i(message: String, vararg args: Any) {
        if (DEBUG) {
            Log.i(LOGTAG, if (args == null || args.size == 0)
                message
            else
                String.format(message, *args))
        }
    }

    fun i(tag: String, message: String, vararg args: Any) {
        if (DEBUG) {
            Log.i("$LOGTAG/$tag", if (args == null || args.size == 0)
                message
            else
                String.format(message, *args))
        }
    }

    fun w(message: String, vararg args: Any) {
        if (DEBUG) {
            Log.w(LOGTAG, if (args == null || args.size == 0)
                message
            else
                String.format(message, *args))
        }
    }

    fun w(tag: String, message: String, vararg args: Any) {
        if (DEBUG) {
            Log.w("$LOGTAG/$tag", if (args == null || args.size == 0)
                message
            else
                String.format(message, *args))
        }
    }

    fun e(message: String, vararg args: Any) {
        if (DEBUG) {
            Log.e(LOGTAG, if (args == null || args.size == 0)
                message
            else
                String.format(message, *args))
        }
    }

    fun e(tag: String, message: String, vararg args: Any) {
        if (DEBUG) {
            Log.e("$LOGTAG/$tag", if (args == null || args.size == 0)
                message
            else
                String.format(message, *args))
        }
    }

    fun e(message: String, e: Exception) {
        if (DEBUG) {
            Log.e(LOGTAG, message, e)
        }
    }

    fun e(tag: String, message: String, e: Exception) {
        if (DEBUG) {
            Log.e("$LOGTAG/$tag", message, e)
        }
    }

    fun wtf(message: String, vararg args: Any) {
        if (DEBUG) {
            Log.wtf(LOGTAG, if (args == null || args.size == 0)
                message
            else
                String.format(message, *args))
        }
    }

    fun wtf(tag: String, message: String, vararg args: Any) {
        if (DEBUG) {
            Log.wtf("$LOGTAG/$tag", if (args == null || args.size == 0)
                message
            else
                String.format(message, *args))
        }
    }

}
