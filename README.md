
---

# react-native-app-checker

A React Native module to check if specific Android apps are installed on a device. This module is useful for scenarios where you need to detect whether certain apps (e.g., Satispay) are installed and trigger app-specific flows accordingly.

## Features
- Check if a specific app is installed on Android.
- Support for querying apps by their package names.
- Easy integration into any React Native project.

## Installation

You can install the module directly from your GitHub repository:

```bash
npm i react-native-android-app-checker
```

Or using Yarn:

```bash
yarn add react-native-android-app-checker
```

## Android Setup

Since Android 11 (API level 30), you need to specify which apps you want to query in your app's `AndroidManifest.xml`. Here's an example of how to add the necessary `<queries>` section:

### Modify `AndroidManifest.xml`:

```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android">
    <queries>
        <!-- Declare the package name of the app you're querying -->
        <package android:name="com.satispay.customer" />
    </queries>

    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.POST_NOTIFICATIONS" />
    <uses-permission android:name="android.permission.VIBRATE"/>

    <application
        android:name=".MainApplication"
        android:label="@string/app_name"
        android:icon="@mipmap/ic_launcher"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:allowBackup="false"
        android:theme="@style/AppTheme">
        
        <activity
            android:name=".MainActivity"
            android:exported="true"
            android:screenOrientation="portrait">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>
```

## Usage

Once installed, you can use the `isAppInstalled` function to check if an app is installed:

```javascript
import { isAppInstalled } from 'react-native-app-checker';

const checkApp = async () => {
  try {
    const isInstalled = await isAppInstalled('com.satispay.customer');
    if (isInstalled) {
      console.log('Satispay is installed on the device.');
    } else {
      console.log('Satispay is NOT installed on the device.');
    }
  } catch (error) {
    console.error('Error checking app installation:', error);
  }
};

checkApp();
```

## API

### `isAppInstalled(packageName: string): Promise<boolean>`

- **packageName**: The package name of the Android app you want to check.
- **Returns**: A promise that resolves to `true` if the app is installed and `false` if it is not.

## Contributing

Contributions, issues, and feature requests are welcome! Feel free to open a pull request or issue on the [GitHub repository](https://github.com/Anzormumladze/react-native-app-checker).

## License

This project is licensed under the MIT License.

---

