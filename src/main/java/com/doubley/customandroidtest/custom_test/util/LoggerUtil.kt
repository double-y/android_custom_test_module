package com.doubley.customandroidtest.custom_test.util

import android.os.Debug
import android.util.Log

/**
 * Created by yasudayousuke on 9/3/15.
 */
public object LoggerUtil {
    val TAG: String = javaClass<LoggerUtil>().getSimpleName()

    fun d(tag: String) {
        printLog(Log.DEBUG, tag, null)
    }

    fun d(tag: String, msg: String) {
        printLog(Log.DEBUG, tag, msg)
    }

    fun e(tag: String) {
        printLog(Log.ERROR, tag, null)
    }

    fun e(tag: String, msg: String) {
        printLog(Log.ERROR, tag, msg)
    }

    fun i(tag: String) {
        printLog(Log.INFO, tag, null)
    }

    fun i(tag: String, msg: String) {
        printLog(Log.INFO, tag, msg)
    }

    fun v(tag: String) {
        printLog(Log.VERBOSE, tag, null)
    }

    fun v(tag: String, msg: String) {
        printLog(Log.VERBOSE, tag, msg)
    }

    fun w(tag: String) {
        printLog(Log.WARN, tag, null)
    }

    fun w(tag: String, msg: String) {
        printLog(Log.WARN, tag, msg)
    }

    fun printLog(methodType: Int, tag: String, msg: String?) {
        val body = if ((msg == null)) printStackTrace() else msg + printStackTrace()
        when (methodType) {
            Log.DEBUG -> Log.d(tag, body)
            Log.VERBOSE -> Log.v(tag, body)
            Log.WARN -> Log.w(tag, body)
            Log.INFO -> Log.i(tag, body)
            Log.ERROR -> Log.e(tag, body)
        }
    }

    fun printHeapInfo() {
        val msg = "heap: Free=" + java.lang.Long.toString(Debug.getNativeHeapFreeSize() / 1024) + "kb" +
                ", Allocated=" + java.lang.Long.toString(Debug.getNativeHeapAllocatedSize() / 1024) + "kb" +
                ", Size=" + java.lang.Long.toString(Debug.getNativeHeapSize() / 1024) + "kb"

        printLog(Log.VERBOSE, TAG, msg)
    }

    fun printStackTrace(): String {

        val element = Thread.currentThread().getStackTrace()[5]

        val fullName = element.getClassName()
        val className = fullName.substring(fullName.lastIndexOf(".") + 1)
        val methodName = element.getMethodName()
        val lineNumber = element.getLineNumber()

        return "<<" + className + "#" + methodName + ":" + lineNumber + ">> "
    }
}