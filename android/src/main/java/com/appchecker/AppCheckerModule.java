package com.appchecker;

import android.content.pm.PackageManager;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class AppCheckerModule extends ReactContextBaseJavaModule {

    private static ReactApplicationContext reactContext;

    AppCheckerModule(ReactApplicationContext context) {
        super(context);
        reactContext = context;
    }

    @Override
    public String getName() {
        return "AppChecker";
    }

    @ReactMethod
    public void isAppInstalled(String packageName, Promise promise) {
        PackageManager pm = reactContext.getPackageManager();
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            promise.resolve(true); // App is installed
        } catch (PackageManager.NameNotFoundException e) {
            promise.resolve(false); // App is not installed
        }
    }
}
