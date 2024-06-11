package org.appiumdemo.screens;

import io.appium.java_client.AppiumBy;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class LemonTreeScreen extends BaseScreen {

    private final By lemonTree = AppiumBy.xpath("//android.view.View[@content-desc='Lemon tree']");

    public void clickLemonTree(){
        safeClick(lemonTree);
    }

    public boolean isLemonTreeVisible() {
        return safeDisplayCheck(lemonTree);
    }
}
