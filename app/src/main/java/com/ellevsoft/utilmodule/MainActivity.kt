package com.ellevsoft.utilmodule

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

import com.ellevsoft.utility.UtilCommon

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pixel = UtilCommon.convertDpToPixel(30f, this)
        Log.d("test", "convert 30dp -> px: $pixel")
        val dp = UtilCommon.convertPixelsToDp(pixel, this)
        Log.d("test", "convert px -> dp: $dp")
    }
}
