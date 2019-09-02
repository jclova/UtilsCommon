package com.ellevsoft.utility

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageInfo
import android.content.res.Resources
import android.graphics.Typeface
import android.os.Build
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

object UtilCommon {

    fun splitString(src: String?, delim: String?): List<String>? {
        if (src == null || delim == null)
            return null
        return try {
            src.split(delim)
        } catch (e: Exception) {
            null
        }
    }

    fun mergeString(src: List<String>?, delim: String?): String? {
        if (src == null || delim == null)
            return null
        return try {
            var merged = StringBuilder()
            for (i in src.indices) {
                if (i == 0)
                    merged = StringBuilder(src[i])
                else
                    merged.append(delim).append(src[i])
            }
            merged.toString()
        } catch (e: Exception) {
            null
        }
    }

    fun convertDpToPixel(dp: Float, context: Context): Float {
        val resources = context.resources
        val metrics = resources.displayMetrics
        return dp * (metrics.densityDpi / 160f)
    }

    fun convertPixelsToDp(px: Float, context: Context): Float {
        val resources = context.resources
        val metrics = resources.displayMetrics
        return px / (metrics.densityDpi / 160f)
    }


    fun applyFont(group: ViewGroup?, font: Typeface?) {
        if (font == null)
            return
        if (group == null)
            return

        val count = group.childCount
        var v: View
        for (i in 0 until count) {
            v = group.getChildAt(i)
            when (v) {
                is TextView -> v.typeface = font
                is Button -> v.typeface = font
                is ViewGroup -> applyFont(v, font)
            }
        }
    }

}