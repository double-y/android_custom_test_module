package com.doubley.customandroidtest.custom_test

import android.content.res.AssetManager
import android.test.InstrumentationTestCase
import junit.framework.Assert

import org.json.JSONException
import org.json.JSONObject

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

/**
 * Created by yasudayousuke on 7/2/15.
 */
public class CustomInstrumentationTestCase : InstrumentationTestCase() {

    protected fun getStringFromAssetFile(filename: String): String {
        val assets = getInstrumentation().getContext().getAssets()
        var buffer = ""

        val `is` = assets.open(filename)
        val isr = InputStreamReader(`is`)
        val reader = BufferedReader(isr)
        val str: String
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

    protected fun checkKeyValidation(expectJson: JSONObject, actualObject: JSONObject) {
        val keys = expectJson.keys()
        while (keys.hasNext()) {
            val key = keys.next()
            try {
                actualObject.get(key)
            } catch (e: JSONException) {
                Assert.fail("in " + actualObject.toString() + "" + key + " does not exist")
            }

        }
    }
}
