package org.appiumdemo.screens;

import io.appium.java_client.AppiumBy;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class LemonScreen extends BaseScreen {

    private final By lemon = AppiumBy.xpath("//android.view.View[@content-desc='Lemon']");

    public void clickLemonFullSqueeze(){
        while($(lemon).isPresent()) {
            safeClick(lemon);
        }
    }

    public boolean isLemonVisible() {
        return safeDisplayCheck(lemon);
    }
}
