package badanUsaha;

import elementsPage.Const;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testData.ReadTestData;

import static elementsPage.Const.akunActive;

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
        try {
            WebElement accOn = driver.findElement(Const.akunActive);
            if (accOn.isDisplayed()){
                driver.findElement(Const.userId).sendKeys(Const.e2e_user_ldap_approveRealisasi);
                driver.findElement(Const.pwd).sendKeys(Const.e2e_pwd_ldap_approveRealisasi);
                driver.findElement(Const.btnLogin).click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("login sukses");
        }
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
        try {
            WebElement accOn = driver.findElement(Const.akunActive);
            if (accOn.isDisplayed()){
                driver.findElement(Const.userId).sendKeys(Const.uat_userApprover);
                driver.findElement(Const.pwd).sendKeys(Const.uat_password);
                driver.findElement(Const.btnLogin).click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("login sukses");
        }
    }
    public static void loginAllIn(WebDriver conn) {
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
            driver.findElement(Const.userId).sendKeys(Const.e2eAllIn_u);
            driver.findElement(Const.pwd).sendKeys(Const.e2eAllIn_pw);

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
        try {
            WebElement accOn = driver.findElement(Const.akunActive);
            if (accOn.isDisplayed()){
                driver.findElement(Const.userId).sendKeys(Const.e2eAllIn_u);
                driver.findElement(Const.pwd).sendKeys(Const.e2eAllIn_pw);
                driver.findElement(Const.btnLogin).click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("login sukses");
        }
    }
    public static void loginJCO(WebDriver conn) {
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
            driver.findElement(Const.userId).sendKeys(Const.e2eCr_u);
            driver.findElement(Const.pwd).sendKeys(Const.e2eCr_pw);

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
            driver.findElement(Const.userId).sendKeys(Const.e2eCr_u);
            driver.findElement(Const.pwd).sendKeys(Const.e2eCr_pw);
        }
        driver.findElement(Const.btnLogin).click();
        try {
            WebElement accOn = driver.findElement(Const.akunActive);
            if (accOn.isDisplayed()){
                driver.findElement(Const.userId).sendKeys(Const.e2eCr_u);
                driver.findElement(Const.pwd).sendKeys(Const.e2eCr_pw);
                driver.findElement(Const.btnLogin).click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("login sukses");
        }
    }
    public static void loginSCA(WebDriver conn) {
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
            driver.findElement(Const.userId).sendKeys(Const.e2e_sca_userName);
            driver.findElement(Const.pwd).sendKeys(Const.e2e_sca_password);

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
            driver.findElement(Const.userId).sendKeys(Const.e2e_sca_userName);
            driver.findElement(Const.pwd).sendKeys(Const.e2e_sca_password);
        }
        driver.findElement(Const.btnLogin).click();
        try {
            WebElement accOn = driver.findElement(akunActive);
            if (accOn.isDisplayed()) {
                driver.findElement(Const.userId).sendKeys(Const.e2e_sca_userName);
                driver.findElement(Const.pwd).sendKeys(Const.e2e_sca_password);
                driver.findElement(Const.btnLogin).click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("login sukses");
        }
    }
    public static void loginJCA(WebDriver conn) {
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
            driver.findElement(Const.userId).sendKeys(Const.e2e_jca_userName);
            driver.findElement(Const.pwd).sendKeys(Const.e2e_jca_password);

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
            driver.findElement(Const.userId).sendKeys(Const.e2e_jca_userName);
            driver.findElement(Const.pwd).sendKeys(Const.e2e_jca_password);
        }
        driver.findElement(Const.btnLogin).click();
        try {
            WebElement accOn = driver.findElement(akunActive);
            if (accOn.isDisplayed()) {
                driver.findElement(Const.userId).sendKeys(Const.e2e_jca_userName);
                driver.findElement(Const.pwd).sendKeys(Const.e2e_jca_password);
                driver.findElement(Const.btnLogin).click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("login sukses");
        }
    }

    public static void logoutApprover(WebDriver conn) throws InterruptedException {
        driver = conn;
        driver.findElement(Const.btnProfile).click();
        Thread.sleep(3000);
        driver.findElement(Const.btnLogout).click();
    }

}
