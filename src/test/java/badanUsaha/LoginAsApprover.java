package badanUsaha;

import elementsPage.Const;
import org.openqa.selenium.WebDriver;
import testData.ReadTestData;

public class LoginAsApprover {

    private static WebDriver driver;
    static ReadTestData readTestData = new ReadTestData();

    public static void loginApproverLdap(WebDriver conn) {
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
            driver.findElement(Const.userId).sendKeys(Const.e2e_user_ldap_approveRealisasi);
            driver.findElement(Const.pwd).sendKeys(Const.e2e_pwd_ldap_approveRealisasi);

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
            driver.findElement(Const.userId).sendKeys(Const.uat_userApprover);
            driver.findElement(Const.pwd).sendKeys(Const.uat_password);
        }
        driver.findElement(Const.btnLogin).click();
    }
    public static void loginApprover(WebDriver conn) {
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
            driver.findElement(Const.userId).sendKeys(Const.uat_userApprover);
            driver.findElement(Const.pwd).sendKeys(Const.uat_password);

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
            driver.findElement(Const.userId).sendKeys(Const.uat_userApprover);
            driver.findElement(Const.pwd).sendKeys(Const.uat_password);
        }
        driver.findElement(Const.btnLogin).click();
    }

    public static void logoutApprover(WebDriver conn) throws InterruptedException {
        driver = conn;
        driver.findElement(Const.btnProfile).click();
        Thread.sleep(3000);
        driver.findElement(Const.btnLogout).click();
    }

}
