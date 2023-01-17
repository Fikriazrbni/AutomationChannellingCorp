package badanUsaha;

import capture.ImageExcel;
import capture.TakeScreenshot;
import elementsPage.Const;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import testData.ReadTestData;
import writeFile.CountImages;

public class LoginAsMaker {

    private static WebDriver driver;
    static ReadTestData readTestData = new ReadTestData();

    public static void loginMaker(WebDriver conn) {
        driver = conn;
        readTestData.testData();
        if (readTestData.environment.equals(Const.e2e_environment)) {
            try {
                driver.get(Const.urlE2E);
                driver.manage().window().maximize();
            } catch (Exception ignored) {
            }
            try {
                driver.findElement(Const.btnDetails).click();
                driver.findElement(Const.btnUnsafe).click();
            } catch (Exception ignored) {
            }
            driver.findElement(Const.userId).sendKeys(Const.uat_userMaker); //e2e_user_ldap_approveRealisasi
            driver.findElement(Const.pwd).sendKeys(Const.uat_password); //e2e_pwd_ldap_approveRealisasi

        } else {
            try {
                driver.get(Const.urlUAT);
                driver.manage().window().maximize();
            } catch (Exception ignored) {
            }
            try {
                driver.findElement(Const.btnDetails).click();
                driver.findElement(Const.btnUnsafe).click();
            } catch (Exception ignored) {
            }
            driver.findElement(Const.userId).sendKeys(Const.uat_userMaker);
            driver.findElement(Const.pwd).sendKeys(Const.uat_password);
        }
        driver.findElement(Const.btnLogin).click();
    }
    public static void logoutMaker(WebDriver conn) throws InterruptedException {
        driver = conn;
        driver.findElement(Const.btnProfile).click();
        Thread.sleep(3000);
        driver.findElement(Const.btnLogout).click();

    }
}
