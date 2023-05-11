package elementsPage;

import badanUsaha.LibUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.netty.util.internal.ThrowableUtil;
import org.openqa.selenium.*;

import java.util.Arrays;
import java.util.List;

public class BaseAction {

    public static ExtentTest capture;


    public static void click2(WebDriver driver, By locator) {
        try {
//            LibUtils.waitElementVisible(driver, locator, Const.seconds);
            driver.findElement(locator).click();
        } catch (Throwable throwable) {
            String m = throwable.getMessage();
            System.out.println("Gagal klik => "+m);
            capture.log(Status.FAIL, MarkupHelper.createUnorderedList(Arrays.asList("not found element => "+m)).getMarkup());
        }
    }


    public static void scrollIntoView(WebDriver driver, By locator) {
        try {
            for (int i = 1; i <= 2; i++) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript(Const.scrollIntoview, driver.findElement(locator));
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String click(WebDriver driver, By locator) {
        LibUtils.waitElementVisible(driver, locator, Const.seconds);
        driver.findElement(locator).click();
        return null;
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
//    public void clearValue(WebDriver driver, By locator) {
//        LibUtils.waitElementVisible(driver, locator, Const.seconds);
//        driver.findElement(locator).click();
//        driver.findElement(locator).sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
//    }

    public boolean isPresent(WebDriver driver, By locator) {
        LibUtils.waitElementVisible(driver, locator, Const.seconds);
        return driver.findElement(locator).isDisplayed();
    }

    public void scrollUp(WebDriver driver, By locator) {
        LibUtils.waitElementVisible(driver, locator, Const.seconds);
        driver.findElement(locator).sendKeys(Keys.CONTROL, Keys.HOME);
    }

    public void scrollPageUp(WebDriver driver, By locator) {
        LibUtils.waitElementVisible(driver, locator, Const.seconds);
        driver.findElement(locator).sendKeys(Keys.PAGE_UP);
    }

    public void scrollDown(WebDriver driver, By locator) {
        LibUtils.waitElementVisible(driver, locator, Const.seconds);
        driver.findElement(locator).sendKeys(Keys.CONTROL, Keys.END);
    }

    public void scrollPageDown(WebDriver driver, By locator) {
        LibUtils.waitElementVisible(driver, locator, Const.seconds);
        driver.findElement(locator).sendKeys(Keys.PAGE_DOWN);
    }
}
