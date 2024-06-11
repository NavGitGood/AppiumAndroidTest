package org.appiumdemo.screens;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen extends PageObject {

    public WebDriverWait getWait(int WaitSeconds) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(WaitSeconds));
    }

    public void navigateBack() {
        getDriver().navigate().back();
    }

    public void safeClick(By locator) {
        getWait(10).until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );
        $(locator).click();
    }

    public boolean safeDisplayCheck(By locator) {
        getWait(10).until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );
        return $(locator).isDisplayed();
    }
}
