package elementsPage;

import capture.TakeScreenshot;
import badanUsaha.LibUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BaseAction {

    public void click(WebDriver driver, By locator) {
        LibUtils.waitElementVisible(driver, locator, Const.seconds);
        driver.findElement(locator).click();
    }

    public void writeText(WebDriver driver, By locator, String value) {
        LibUtils.waitElementVisible(driver, locator, Const.seconds);
        driver.findElement(locator).sendKeys(value);
    }

    public String getText(WebDriver driver, By locator) {
        LibUtils.waitElementVisible(driver, locator, Const.seconds);
        return driver.findElement(locator).getText();
    }

    public void clearText(WebDriver driver, By locator) {
        LibUtils.waitElementVisible(driver, locator, Const.seconds);
        driver.findElement(locator).clear();
    }

    public boolean isPresent(WebDriver driver, By locator) {
        LibUtils.waitElementVisible(driver, locator, Const.seconds);
        return driver.findElement(locator).isDisplayed();
    }

    public void scrollUp(WebDriver driver, By locator) {
        LibUtils.waitElementVisible(driver, locator, Const.seconds);
        driver.findElement(locator).sendKeys(Keys.CONTROL,Keys.HOME);
    }

    public void scrollPageUp(WebDriver driver, By locator) {
        LibUtils.waitElementVisible(driver, locator, Const.seconds);
        driver.findElement(locator).sendKeys(Keys.PAGE_UP);
    }

    public void scrollDown(WebDriver driver, By locator) {
        LibUtils.waitElementVisible(driver, locator, Const.seconds);
        driver.findElement(locator).sendKeys(Keys.CONTROL,Keys.END);
    }

    public void scrollPageDown(WebDriver driver, By locator) {
        LibUtils.waitElementVisible(driver, locator, Const.seconds);
        driver.findElement(locator).sendKeys(Keys.PAGE_DOWN);
    }
}
