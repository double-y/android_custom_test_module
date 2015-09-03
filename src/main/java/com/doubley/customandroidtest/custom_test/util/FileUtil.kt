package com.doubley.customandroidtest.custom_test.util

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Created by yasudayousuke on 9/1/15.
 */
public object FileUtil {
    fun getStringFromAsset(context: Context, filename: String): String{
        var buffer = ""

        val `is` = context.getAssets().open(filename)
        val isr = InputStreamReader(`is`)
        val reader = BufferedReader(isr)
        while(true){
            val str = reader.readLine()
            if(str != null) {
                buffer += str
            }else{
                break
            }
        }
        return buffer
    }
}