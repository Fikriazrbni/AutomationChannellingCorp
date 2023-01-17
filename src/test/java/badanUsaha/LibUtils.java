package badanUsaha;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import createDataCSV.DataCSV;
import elementsPage.Const;
import jobs.DummyAppForm_BU;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testData.ReadTestData;
import writeFile.MoveFileScenario;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;

import static badanUsaha.ApprovalFromMaker.*;

public class LibUtils {

    public static ExtentTest capture;
    static ReadTestData readTestData = new ReadTestData();
    private ExtentTest processRecomend, childRecomend, processApprove, childApprove;
    public static WebElement waitElementVisible(WebDriver driver, By locator, int seconds){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        return element;
    }

    public static boolean _boleanWaitElementVisible(WebDriver driver, By locator, int seconds) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.isDisplayed();
    }
    public static WebElement waitElementClickAble(WebDriver driver, By locator, int seconds) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        return element;
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
    public static void moveTo(WebDriver driver, By locator) {
        try {
            driver.findElement(locator).sendKeys(Keys.PAGE_DOWN);
            Thread.sleep(Const.delay);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
    public static void moveToEnd(WebDriver driver, By locator) {
        try {
            driver.findElement(locator).sendKeys(Keys.CONTROL, Keys.END);
            Thread.sleep(Const.delay);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public static String removeZero(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0')
        {
            i++;
        }
        StringBuffer sb = new StringBuffer(str);
        sb.replace(0, i, "");
        return sb.toString();
    }

    public static void status_testCase(int iRPN, boolean status, String notes) {
        readTestData.testData();
        switch (readTestData.tagName) {
            case "approvalForm":
                if (status) {
                    imageExcel.insertStatusExcel(iRPN, Const.attachmentName, Const.tStatus, notes);
                } else {
                    imageExcel.insertStatusExcel(iRPN, Const.attachmentName, Const.fStatus, notes);
                }
                break;
            case "realizationForm":
                if (status) {
                    imageExcel.insertStatusExcel(iRPN, Const.attachmentNameRea, Const.tStatus, notes);
                } else {
                    imageExcel.insertStatusExcel(iRPN, Const.attachmentNameRea, Const.fStatus, notes);
                }
                break;
            case "validationApprovalFile":
                if (status) {
                    imageExcel.insertStatusExcel(iRPN, Const.attachmentNameValidateAppFile, Const.tStatus, notes);
                } else {
                    imageExcel.insertStatusExcel(iRPN, Const.attachmentNameValidateAppFile, Const.fStatus, notes);
                }
                break;
            case "validationRealizationFile":
                if (status) {
                    imageExcel.insertStatusExcel(iRPN, Const.attachmentNameValidateReaFile, Const.tStatus, notes);
                } else {
                    imageExcel.insertStatusExcel(iRPN, Const.attachmentNameValidateReaFile, Const.fStatus, notes);
                }
                break;
        }
    }
    public static void status_testCase_skip(int iRPN, boolean status, String notes) {
        readTestData.testData();
        switch (readTestData.tagName) {
            case "approvalForm":
                if (status) {
                    imageExcel.insertStatusExcel(iRPN, Const.attachmentName, Const.sStatus, notes);
                } else {
                    imageExcel.insertStatusExcel(iRPN, Const.attachmentName, Const.fStatus, notes);
                }
                break;
            case "realizationForm":
                if (status) {
                    imageExcel.insertStatusExcel(iRPN, Const.attachmentNameRea, Const.sStatus, notes);
                } else {
                    imageExcel.insertStatusExcel(iRPN, Const.attachmentNameRea, Const.fStatus, notes);
                }
                break;
            case "validationApprovalFile":
                if (status) {
                    imageExcel.insertStatusExcel(iRPN, Const.attachmentNameValidateAppFile, Const.sStatus, notes);
                } else {
                    imageExcel.insertStatusExcel(iRPN, Const.attachmentNameValidateAppFile, Const.fStatus, notes);
                }
                break;
            case "validationRealizationFile":
                if (status) {
                    imageExcel.insertStatusExcel(iRPN, Const.attachmentNameValidateReaFile, Const.sStatus, notes);
                } else {
                    imageExcel.insertStatusExcel(iRPN, Const.attachmentNameValidateReaFile, Const.fStatus, notes);
                }
                break;
        }
    }

    public static boolean verifyValue(String value_expected, String value_actual) {
        try {
            Assert.assertEquals(value_actual, value_expected);
            capture.log(Status.PASS, MarkupHelper.createUnorderedList(Arrays.asList("Actual from UI __________ : " + value_expected, "Actual from csv/testdata : " + value_actual)).getMarkup());
            System.out.println("AssertTrue >>>>>>>>>> Expected : [" + value_expected + "]  -  " + "Actual : [" + value_actual + "]");
            return true;
        } catch (AssertionError ee) {
            capture.log(Status.FAIL, MarkupHelper.createUnorderedList(Arrays.asList("Actual from UI __________ : " + value_expected, "Actual from csv/testdata : " + value_actual)).getMarkup());
            System.out.println("AssertFalse >>>>>>>>> Expected : [" + value_expected + "]  -  " + "Actual : [" + value_actual + "]");
            return false;
        }
    }
    public static boolean verifyLength(String msg, int value_actual, int value_expected) {
        try {
            Assert.assertEquals(value_expected, value_actual);
            capture.log(Status.PASS, MarkupHelper.createUnorderedList(Arrays.asList("Print character value : " + msg, "Actual___ character : " + value_actual, "Expected character : " + value_expected)).getMarkup());
            System.out.println("AssertTrue >>>>>>>>>> Expected : [" + value_expected + "]  -  " + "Actual : [" + value_actual + "]");
            return true;
        } catch (AssertionError ee) {
            capture.log(Status.FAIL, MarkupHelper.createUnorderedList(Arrays.asList("Print character value : " + msg, "Actual___ character : " + value_actual, "Expected character : " + value_expected)).getMarkup());
            System.out.println("AssertFalse >>>>>>>>> Expected : [" + value_expected + "]  -  " + "Actual : [" + value_actual + "]");
            return false;
        }
    }
    public static boolean verifyValueData1Data2(String value_expected, String value_actual) {
        try {
            Assert.assertEquals(value_actual, value_expected);
            capture.log(Status.PASS, MarkupHelper.createUnorderedList(Arrays.asList("Data 1 : " + value_expected, "Data 2 : " + value_actual)).getMarkup());
            System.out.println("AssertTrue >>>>>>>>>> Expected : [" + value_expected + "]  -  " + "Actual : [" + value_actual + "]");
            return true;
        } catch (AssertionError ee) {
            capture.log(Status.FAIL, MarkupHelper.createUnorderedList(Arrays.asList("Data 1 : " + value_expected, "Data 2 " + value_actual)).getMarkup());
            System.out.println("AssertFalse >>>>>>>>> Expected : [" + value_expected + "]  -  " + "Actual : [" + value_actual + "]");
            return false;
        }
    }
    public static boolean verifyValueDisplay(boolean value_expected, boolean value_actual, String msg) {
        try {
            Assert.assertEquals(value_actual, value_expected);
            capture.log(Status.PASS, MarkupHelper.createUnorderedList(Arrays.asList("Actual from UI __________ : " + value_expected + ">> " + msg)).getMarkup());
            System.out.println("AssertTrue >>>>>>>>>> Expected : [" + value_expected + "]  -  " + "Actual : [" + value_actual + "]");
            return true;
        } catch (AssertionError ee) {
            capture.log(Status.FAIL, MarkupHelper.createUnorderedList(Arrays.asList("Actual from UI __________ : " + value_expected + ">> " + msg)).getMarkup());
            System.out.println("AssertFalse >>>>>>>>> Expected : [" + value_expected + "]  -  " + "Actual : [" + value_actual + "]");
            return false;
        }
    }
    public static boolean verifyValueNotEquals(String value_expected, String value_actual, String msg) {
        try {
            Assert.assertNotEquals(value_actual, value_expected);
            capture.log(Status.PASS, MarkupHelper.createUnorderedList(Arrays.asList("Actual from UI __________ : " + value_expected, "Actual from csv/testdata : " + value_actual, msg)).getMarkup());
            System.out.println("AssertTrue >>>>>>>>>> Expected : [" + value_expected + "]  -  " + "Actual : [" + value_actual + "]");
            return true;
        } catch (AssertionError ee) {
            capture.log(Status.FAIL, MarkupHelper.createUnorderedList(Arrays.asList("Actual from UI __________ : " + value_expected, "Actual from csv/testdata : " + value_actual, msg)).getMarkup());
            System.out.println("AssertFalse >>>>>>>>> Expected : [" + value_expected + "]  -  " + "Actual : [" + value_actual + "]");
            return false;
        }
    }

    public static boolean verifyElementExist(WebDriver driver, By locator) {
        if (driver.findElement(locator).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
    public static String timestamp() {
        String pattern = "ddMMMyyyyHHmmss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String fdate = simpleDateFormat.format(new Date());
        return fdate;
    }
    public static void provideDataToLOS(WebDriver driver, String jumlahData) throws IOException, InterruptedException {
        // provide data dummy
        MoveFileScenario cleanFolder = new MoveFileScenario();
        cleanFolder.dltDummyExist();

        DataCSV dataCSV = new DataCSV();
        dataCSV.dataDummy(Const.appFile, Const.reaFile, jumlahData);

        DummyAppForm_BU consumeData = new DummyAppForm_BU();
        consumeData.serverAkses();
//        logoutMaker(driver);
//        loginMaker(driver);
//        changedRecomendationAsMaker_rea(driver, Integer.parseInt(jumlahData));
//        loginApprover(driver, "surya.simarmata", "Surya2022");// approval file
//        changedApproveAsApprover_rea(driver, Integer.parseInt(jumlahData));
//        consumeData.serverAksesRea();

//        loginApprover(driver, "weike.phinjaya", "Weike1234");
    }

    public static void createTest(int iRowPictName, ExtentTest extent_test_case, ExtentReports extent){

        extent_test_case = extent.createTest(ReadTestData.testCaseID(iRowPictName) + " : " + ReadTestData.testCaseName(iRowPictName)).assignAuthor(System.getProperty("user.name")).assignCategory("Regression");
        LibUtils.capture = extent_test_case.info("Expected Result from Excel : "+ ReadTestData.expectedResult(iRowPictName));
        LibUtils.capture = extent_test_case.info("Actual Result from UI : "+ ReadTestData.expectedNoted(iRowPictName));
    }
    public static void createTestSkip(int iRowPictName, ExtentTest extent_test_case, ExtentReports extent){

        extent_test_case = extent.createTest(ReadTestData.testCaseID(iRowPictName) + " : " + ReadTestData.testCaseName(iRowPictName)).assignAuthor(System.getProperty("user.name")).assignCategory("Regression");
        LibUtils.capture = extent_test_case.info("Expected Result from CSV : "+ ReadTestData.expectedResult(iRowPictName));
        LibUtils.capture = extent_test_case.skip("Expected Result from UI : "+ ReadTestData.expectedNoted(iRowPictName));
    }
    public static void createInfo(ExtentTest extent_test_case, String msg){
        capture.log(Status.INFO, MarkupHelper.createUnorderedList("Message : " + msg).getMarkup());
    }
}
