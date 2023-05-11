package badanUsaha;

import elementsPage.BaseAction;
import elementsPage.Const;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import static elementsPage.Const.scrollIntoview;
import static elementsPage.Const.urlE2E;

public class UnitTest extends BaseAction {
    static BaseAction b = new BaseAction();

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

    private static final By dashboard = By.xpath("//span[contains(., 'Dashboard')]");
    private static final By week = By.xpath("//a[@class= 'nav-link btn-circle' and text()= 'Week']");
    private static final By today = By.xpath("//a[@class= 'nav-link btn-circle' and text()= 'Today']");
    private static final By chartRepay = By.xpath("//*[@id= 'repaymentApprovalChart']");
    private static final By chartApproval = By.xpath("//*[@id= 'channelingApprovalChart']");
    private static final By repayText = By.xpath("//h5[text()= 'Inquiry Total Repayment']");
    private static final By appNo = By.xpath("//tr[@class= 'odd' or @class= 'even']/td[3]");
    private static final By next = By.xpath("//a[@class='page-link' and text()= 'Next']");

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get(urlE2E);
        driver.manage().window().maximize();
        driver.findElement(Const.btnDetails).click();
        driver.findElement(Const.btnUnsafe).click();
        driver.findElement(Const.userId).sendKeys(Const.e2eAllIn_u);
        driver.findElement(Const.pwd).sendKeys(Const.e2eAllIn_pw);
        driver.findElement(Const.btnLogin).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(week).click();
        Thread.sleep(3000);
        driver.findElement(chartApproval).click();


        // Loop until there is no "Next" button
        while (true) {
            // Get all rows in the data table
            List<WebElement> rows = driver.findElements(appNo);
            // Iterate over each row
            for (WebElement row : rows) {
                System.out.println(row.getText());
            }
            scrollIntoView(driver, next);
            WebElement nextButton = driver.findElement(next);

            try {
                if (nextButton.isEnabled()) {
                    driver.findElement(next).click();
                }
            } catch (Exception e) {
                System.out.println("Finish!");
                break;
            }

        }
        driver.close();
    }
}
