# AppiumAndroidTest
sample basic test in appium for an android app

# prerequisites setup
1. install Java (used jdk11 here)
2. install '[Gradle](https://gradle.org/install/)', if not installed already
3. install '[NodeJs](https://nodejs.org/en/download/package-manager)', if not installed already
    - install Appium globally via `npm install -g appium`
4. install '[Appium Inspector](https://github.com/appium/appium-inspector/releases)'
5. install drivers for 
    - android `appium driver install uiautomator2`
    - ios `appium driver install xcuitest` (on mac devices only)
6. verify driver installation by `appium driver list`
7. install '[Android studio](https://developer.android.com/studio)'
8. add path to `Android\Sdk\platform-tools` in env variable PATH

# troubleshooting with above setup
if any of the above commands do not work, make sure that following environment variables are set
- JAVA_HOME
- GRADLE_HOME
- APPIUM_HOME
- ANDROID_HOME
- NODE_HOME
- PATH

# verify if all the prequisites are available
 - android `appium driver doctor uiautomator2`
 - ios `appium driver doctor xcuitest`

# prepare your app
1. if you get an apk, put it in apps/androidAPK folder
2. if you get an aab file use following steps to extract the apk (acces to keystore used in signing the app is must)
 - download Android Bundletool 'https://github.com/google/bundletool/releases'
 - run this in terminal
    ```
    java -jar bundletool build-apks --bundle=/MyApp/my_app.aab --output=/MyApp/my_app.apks \
        --mode=universal \
        --ks=/MyApp/keystore.jks \
        --ks-pass=file:/MyApp/keystore.pwd \
        --ks-key-alias=MyKeyAlias \
        --key-pass=file:/MyApp/key.pwd
    ```
    or (if plain password)
     ```
    java -jar bundletool build-apks --bundle=/MyApp/my_app.aab --output=/MyApp/my_app.apks \
        --mode=universal \
        --ks=/MyApp/keystore.jks \
        --ks-pass=pass:/MyApp/keystore.pwd \
        --ks-key-alias=MyKeyAlias \
        --key-pass=pass:/MyApp/key.pwd
    ```
    e.g. (verified in git bash on windows)
     ```
    java -jar bundletool-all-1.16.0.jar build-apks --bundle=/c/Users/devUser/AndroidStudioProjects/InteractiveMicroApps/app/release/app-release.aab \
        --output=/c/Users/devUser/AndroidStudioProjects/InteractiveMicroApps/app/release/test_app.apks \
        --mode=universal \
        --ks=/c/Users/devUser/AndroidStudioProjects/keystore/android_upload_keystore.jks \
        --ks-pass=pass:password \
        --ks-key-alias=upload \
        --key-pass=pass:password
    ```
 - extract the generated apks file `unzip -p test_app.apks universal.apk > testApp.apk`

 # start required services
 1. start appium server `appium`
 2. start android avd image (emulator) either via android studio or command line
    ```
    /c/Users/{username}/AppData/Local/Android/Sdk/emulator/emulator -avd {avd_name} -netdelay none -netspeed full
    ```
3. start appium inspector

# prepare avd
1. There might already be versions of app on avd. Make sure to remove them first
 - find the device id for you emulator `adb devices -l`
 - find and list the apps you want to remove `adb -s device_key shell cmd package list packages | grep "{app_name}"`
 - remove the apps `adb -s device_key uninstall {app_name}` e.g. `adb -s emulator-5554 uninstall com.test.app`
2. Install the app you want to test `adb -s device_key install {path_to_app}`
3. Verify if app is installed successfully `adb -s device_key shell cmd package list packages | grep "{app_name}"`

# prepare capabilities for Appium
1. deviceName `adb -s device_key shell getprop ro.product.model`
2. platformVersion `adb -s device_key shell getprop ro.build.version.release`
3. appVersion `adb -s device_key shell dumpsys package {package_name} | grep versionName`
4. appPackage (after launching the app in emulator) `adb -s device_key shell dumpsys window displays | grep -e mCurrentFocus" |awk -F/ '{print $1}'`
5. appActivity (after launching the app in emulator) `adb -s device_key shell dumpsys window displays | grep -e mCurrentFocus" |awk -F/ '{print $2}'`
6. app -> path to apk (either your local system or a remote location), required only if you want to install the app via Appium and not adb