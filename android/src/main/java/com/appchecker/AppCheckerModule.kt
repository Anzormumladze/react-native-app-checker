package com.appchecker

import android.content.pm.PackageManager
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class AppCheckerModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "AppChecker"
    }

    @ReactMethod
    fun isAppInstalled(packageName: String, promise: Promise) {
        val pm: PackageManager = reactApplicationContext.packageManager
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
            promise.resolve(true)  // App is installed
        } catch (e: PackageManager.NameNotFoundException) {
            promise.resolve(false)  // App is not installed
        }
    }
}
