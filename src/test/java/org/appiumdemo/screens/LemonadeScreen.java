package org.appiumdemo.screens;

import io.appium.java_client.AppiumBy;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class LemonadeScreen extends BaseScreen {

    private final By lemonade = AppiumBy.xpath("//android.view.View[@content-desc='Glass of lemonade']");

    public void clickLemonade(){
        safeClick(lemonade);
    }

    public boolean isLemonadeVisible() {
        return safeDisplayCheck(lemonade);
    }
}
