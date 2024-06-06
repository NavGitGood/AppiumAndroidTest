package org.appiumdemo.utils;

import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class DriverUtil {

    public static boolean isAndroid = System.getProperty(PLATFORM_NAME).equalsIgnoreCase("android");
    public static boolean isIOS = System.getProperty(PLATFORM_NAME).equalsIgnoreCase("ios");

}
