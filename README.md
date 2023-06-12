# Android Device Owner Kotlin

This is a sample Android application, written in Kotlin, that implements Android device owner mode.

## Making your app device owner

Assuming you have installed the app (i.e. in Android Studio, or built and pushed an APK, etc), you can make your app device owner as follows:

```
adb shell dpm set-device-owner co.coburglabs.mdm/.DeviceOwnerReceiver
```

## More documentation

See my [Medium article](https://medium.com/@codybrookshear/creating-an-android-device-owner-app-in-2023-b7e7b9fb3aca) that describes this code in greater detail.