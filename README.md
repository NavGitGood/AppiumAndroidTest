# AppiumAndroidTest
sample basic test in appium for an android app

# prerequisites setup
1. install Java (used jdk11 here)
2. install '[Gradle](https://gradle.org/install/)', if not installed already
3. install '[NodeJs](https://nodejs.org/en/download/package-manager)', if not installed already
    - install Appium globally via `npm install -g appium`
    - install appium doctor globally (to verify depedencies) via `npm install -g appium-doctor`
4. install '[Appium Inspector](https://github.com/appium/appium-inspector/releases)'
5. install drivers for 
    - android `appium driver install uiautomator2`
    - ios `appium driver install xcuitest` (on mac devices only)
6. verify driver installation by `appium driver list`
7. install '[Android studio](https://developer.android.com/studio)'

# troubleshooting with above setup
if any of the above commands do not work, make sure that following environment variables are set
- JAVA_HOME
- GRADLE_HOME
- APPIUM_HOME
- ANDROID_HOME
- NODE_HOME
- PATH

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
