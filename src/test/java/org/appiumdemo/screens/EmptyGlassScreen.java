package org.appiumdemo.screens;

import io.appium.java_client.AppiumBy;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class EmptyGlassScreen extends BaseScreen {

    private final By emptyGlass = AppiumBy.xpath("//android.view.View[@content-desc='Empty glass']");

    public void clickEmptyGlass(){
        safeClick(emptyGlass);
    }

    public boolean isEmptyGlassDisplayed() {
        return safeDisplayCheck(emptyGlass);
    }
}
