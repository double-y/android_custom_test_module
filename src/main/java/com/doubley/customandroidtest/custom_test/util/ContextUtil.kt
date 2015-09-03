package com.doubley.customandroidtest.custom_test.util

import android.content.Context
import android.test.AndroidTestCase

import java.lang.reflect.Method

/**
 * Created by yasudayousuke on 7/29/15.
 */
public object ContextUtil {
    public fun getTestContext(testCase: AndroidTestCase): Context? {
        @SuppressWarnings("unchecked")
        val clz = testCase.javaClass
        val method: Method
        try {
            method = clz.getMethod("getTestContext")
            return method.invoke(testCase) as Context
        } catch (e: Exception) {
            return null
        }

    }
}
