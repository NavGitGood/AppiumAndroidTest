package org.appiumdemo.setup;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.appium.java_client.android.options.UiAutomator2Options.*;

import static org.appiumdemo.utils.DriverUtil.isAndroid;
import static org.appiumdemo.utils.DriverUtil.isIOS;

public class CapabilitiesSetup {
    
    static Capabilities getCapabilities() {
        if (isAndroid) {
            return getBaseCapabilities("UIAutomator2");
        } else if (isIOS) {
            return getBaseCapabilities("XCUITest");
        } else {
            throw new NotFoundException("Please specify the platformName (android or ios)");
        }
    }

    private static Capabilities getBaseCapabilities(String deviceType) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(DEVICE_NAME_OPTION, System.getProperty(DEVICE_NAME_OPTION));
        capabilities.setCapability(PLATFORM_VERSION_OPTION, System.getProperty(PLATFORM_VERSION_OPTION));
        capabilities.setCapability(APP_OPTION, System.getProperty(APP_OPTION));
        capabilities.setCapability(APP_PACKAGE_OPTION, System.getProperty(APP_PACKAGE_OPTION));
        capabilities.setCapability(FULL_RESET_OPTION, true);
        capabilities.setCapability(NO_RESET_OPTION, false);
        capabilities.setCapability(NEW_COMMAND_TIMEOUT_OPTION, 3600);
        if (System.getProperty("realDevice").equalsIgnoreCase("true")) {
            capabilities.setCapability(UDID_OPTION, System.getProperty(UDID_OPTION));
        }
        capabilities.setCapability(AUTOMATION_NAME_OPTION, deviceType);
        return capabilities;
    }
}
