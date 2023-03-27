package badanUsaha;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import createDataCSV.DataCSV;
import elementsPage.Const;
import jobs.DummyAppForm_BU;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import readFile.ReadCSVFormApproval;
import readFile.ReadRepayFileCSV;
import testData.ReadTestData;
import writeFile.MoveFileScenario;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import static badanUsaha.ApprovalFromMaker.*;

public class LibUtils {

    public static ExtentTest capture;
    static ReadTestData readTestData = new ReadTestData();
    private ExtentTest processRecomend, childRecomend, processApprove, childApprove;

    public static WebElement waitElementVisible(WebDriver driver, By locator, int seconds) {

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
        while (i < str.length() && str.charAt(i) == '0') {
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

    public static boolean verifyValue(String expected, String actual) {
        try {
            Assert.assertEquals(actual, expected);
            capture.log(Status.PASS, MarkupHelper.createUnorderedList(Arrays.asList("Value __________ : " + expected, "Expected______ : " + actual)).getMarkup());
            System.out.println("AssertTrue >>>>>>>>>> Expected : [" + expected + "]  -  " + "Actual : [" + actual + "]");
            return true;
        } catch (AssertionError ee) {
            capture.log(Status.FAIL, MarkupHelper.createUnorderedList(Arrays.asList("Value __________ : " + expected, "Expected______ : " + actual)).getMarkup());
            System.out.println("AssertFalse >>>>>>>>> Expected : [" + expected + "]  -  " + "Actual : [" + actual + "]");
            return false;
        }
    }
    public static boolean verifyCustom(String expected, String actual, String title) {
        try {
            Assert.assertEquals(actual, expected);
            capture.log(Status.PASS, MarkupHelper.createUnorderedList(Arrays.asList("Validation : "+title,"Actual     : " + expected, "Expected   : " + actual)).getMarkup());
            System.out.println("AssertTrue >>>>>>>>>> Expected : [" + expected + "]  -  " + "Actual : [" + actual + "]");
            return true;
        } catch (AssertionError ee) {
            capture.log(Status.FAIL, MarkupHelper.createUnorderedList(Arrays.asList("Validation : "+title,"Actual     : " + expected, "Expected   : " + actual)).getMarkup());
            System.out.println("AssertFalse >>>>>>>>> Expected : [" + expected + "]  -  " + "Actual : [" + actual + "]");
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

    public static void createTest(int iRowPictName, ExtentTest extent_test_case, ExtentReports extent) {

        extent_test_case = extent.createTest(ReadTestData.testCaseID(iRowPictName) + " : " + ReadTestData.testCaseName(iRowPictName)).assignAuthor(System.getProperty("user.name")).assignCategory("Regression");
        LibUtils.capture = extent_test_case.info("Expected Result from Excel : " + ReadTestData.expectedResult(iRowPictName));
//        LibUtils.capture = extent_test_case.info("Actual Result from UI : " + ReadTestData.expectedNoted(iRowPictName));
    }

    public static void createTestSkip(int iRowPictName, ExtentTest extent_test_case, ExtentReports extent,String reason) {

        extent_test_case = extent.createTest(ReadTestData.testCaseID(iRowPictName) + " : " + ReadTestData.testCaseName(iRowPictName)).assignAuthor(System.getProperty("user.name")).assignCategory("Regression");
        LibUtils.capture = extent_test_case.info("Expected Result from CSV : " + ReadTestData.expectedResult(iRowPictName));
        LibUtils.capture = extent_test_case.skip("Reason : " + reason);
    }

    public static void createInfo(ExtentTest extent_test_case, String msg) {
        capture.log(Status.INFO, MarkupHelper.createUnorderedList("Message : " + msg).getMarkup());
    }

    public static void infoData(String field, String value) {
        capture.log(Status.INFO, MarkupHelper.createUnorderedList(field + " -> "+value).getMarkup());
    }

    public static boolean infoLength(String field, String value, int expectedLen) {
        int len = value.replace(".","").length();
//        capture.log(Status.PASS, MarkupHelper.createUnorderedList(Arrays.asList(field + " -> "+value,"Length -----------> "+len)).getMarkup());
        try {
            Assert.assertEquals(expectedLen, len);
            capture.log(Status.PASS, MarkupHelper.createUnorderedList(Arrays.asList(field + " ----> "+value, "Actual Length ----> " + len, "Expected Length --> " + expectedLen)).getMarkup());
            System.out.println("AssertTrue >>>>>>>>>> Expected : [" + expectedLen + "]  -  " + "Actual : [" + len + "]");
            return true;
        } catch (AssertionError ee) {
            capture.log(Status.FAIL, MarkupHelper.createUnorderedList(Arrays.asList(field + " ----> "+value, "Actual Length ----> " + len, "Expected Length --> " + expectedLen)).getMarkup());
            System.out.println("AssertFalse >>>>>>>>> Expected : [" + expectedLen + "]  -  " + "Actual : [" + len + "]");
            return false;
        }
    }

    public static void createTable(int bariske, String dataFile) throws IOException {
        ReadRepayFileCSV readRepayFileCSV = new ReadRepayFileCSV();
        String[] arrSuc = readRepayFileCSV.fileCSVRepaySuccess2();
        String[] arrErr = readRepayFileCSV.fileCSVRepayError2();
        String[] arrReq = readRepayFileCSV.fileCSVRepayReq2();
        String[] arrEx = readRepayFileCSV.fileCSVRepayExist();

        ReadCSVFormApproval readCSVFormApproval = new ReadCSVFormApproval();
        String[] arrApp = readCSVFormApproval.fileCSVAppForm3();
        String[] arrRea = readCSVFormApproval.fileCSVRea2();

        switch (dataFile) {
            case "req":
                String[][] dataReq = {{arrReq[0]}, {arrReq[bariske]}};
                Markup mReq = MarkupHelper.createTable(dataReq);
                capture.log(Status.INFO, mReq);
                break;
            case "suc":
                String[][] dataSuc = {{arrSuc[0]}, {arrSuc[bariske]}};
                Markup mSuc = MarkupHelper.createTable(dataSuc);
                capture.log(Status.INFO, mSuc);
                break;
            case "err":
                String[][] dataErr = {{arrErr[0]}, {arrErr[bariske]}};
                Markup mErr = MarkupHelper.createTable(dataErr);
                capture.log(Status.INFO, mErr);
                break;
            case "app":
                String[][] dataApp = {{arrApp[0]}, {arrApp[bariske]}};
                Markup mApp = MarkupHelper.createTable(dataApp);
                capture.log(Status.INFO, mApp);
                break;
            case "rea":
                String[][] dataRea = {{arrRea[0]}, {arrRea[bariske]}};
                Markup mRea = MarkupHelper.createTable(dataRea);
                capture.log(Status.INFO, mRea);
                break;
            case "ex":
                String[][] dataEx = {{arrEx[0]}, {arrEx[bariske]}};
                Markup mEx = MarkupHelper.createTable(dataEx);
                capture.log(Status.INFO, MarkupHelper.createUnorderedList("Data Exist : "));
                capture.log(Status.INFO, mEx);
                break;
        }
    }

    public static void createTable2(int arraybaris, String dataFile2) throws IOException {
        ReadRepayFileCSV readRepayFileCSV = new ReadRepayFileCSV();
        ReadCSVFormApproval readCSVFormApproval = new ReadCSVFormApproval();
        String[] arrApp = readCSVFormApproval.fileCSVAppForm();
        String[] arrRea = readCSVFormApproval.fileCSVRea();
        String[] arrSuc = readRepayFileCSV.fileCSVRepaySuccess();
        String[] arrErr = readRepayFileCSV.fileCSVRepayError();
        String[] arrReq = readRepayFileCSV.fileCSVRepayReq();

        switch (dataFile2) {
            case "req":
                String[][] dataReq = {{arrReq[0], arrReq[1], arrReq[2], arrReq[3], arrReq[4], arrReq[5], arrReq[6]}, {arrReq[arraybaris], arrReq[++arraybaris], arrReq[++arraybaris], arrReq[++arraybaris], arrReq[++arraybaris], arrReq[++arraybaris], arrReq[++arraybaris]}};
                capture.log(Status.INFO, MarkupHelper.createUnorderedList("Data Request Ke Fineract ===> ").getMarkup());
                Markup mReq = MarkupHelper.createTable(dataReq);
                capture.log(Status.INFO, mReq);
                break;
            case "suc":
                String[][] dataSuc = {{arrSuc[0], arrSuc[1], arrSuc[2], arrSuc[3], arrSuc[4], arrSuc[5], arrSuc[6], arrSuc[7], arrSuc[8], arrSuc[9], arrSuc[10], arrSuc[11], arrSuc[12]}, {arrSuc[arraybaris], arrSuc[++arraybaris], arrSuc[++arraybaris], arrSuc[++arraybaris], arrSuc[++arraybaris], arrSuc[++arraybaris], arrSuc[++arraybaris], arrSuc[arraybaris], arrSuc[++arraybaris], arrSuc[++arraybaris], arrSuc[++arraybaris], arrSuc[++arraybaris], arrSuc[++arraybaris]}};
                capture.log(Status.INFO, MarkupHelper.createUnorderedList("Data Sukses Dari Fineract ===> ").getMarkup());
                Markup mSuc = MarkupHelper.createTable(dataSuc);
                capture.log(Status.INFO, mSuc);
                break;
            case "err":
                String[][] dataErr = {{arrErr[0], arrErr[1], arrErr[2], arrErr[3], arrErr[4], arrErr[5], arrErr[6], arrErr[7], arrErr[8]}, {arrErr[arraybaris], arrErr[++arraybaris], arrErr[++arraybaris], arrErr[++arraybaris], arrErr[++arraybaris], arrErr[++arraybaris], arrErr[++arraybaris], arrErr[++arraybaris], arrErr[++arraybaris]}};
                capture.log(Status.INFO, MarkupHelper.createUnorderedList("Data Gagal Dari Fineract ===> ").getMarkup());
                Markup mErr = MarkupHelper.createTable(dataErr);
                capture.log(Status.INFO, mErr);
                break;

            case "app":
                String[][] dataApp2 = {{arrApp[0], arrApp[1], arrApp[2], arrApp[3], arrApp[4], arrApp[5], arrApp[6], arrApp[7]}, {arrApp[arraybaris], arrApp[++arraybaris], arrApp[++arraybaris], arrApp[++arraybaris], arrApp[++arraybaris], arrApp[++arraybaris], arrApp[++arraybaris], arrApp[++arraybaris]}};
                capture.log(Status.INFO, MarkupHelper.createUnorderedList("Data AppForm ===> ").getMarkup());
                Markup mApp = MarkupHelper.createTable(dataApp2);
                capture.log(Status.INFO, mApp);
                break;

            case "rea":
                String[][] dataRea2 = {{arrRea[0], arrRea[1], arrRea[2], arrRea[3], arrRea[4], arrRea[5], arrRea[6], arrRea[7], arrRea[8], arrRea[9], arrRea[10], arrRea[11], arrRea[12], arrRea[13], arrRea[14], arrRea[15], arrRea[16], arrRea[17], arrRea[18], arrRea[19], arrRea[20], arrRea[21], arrRea[22], arrRea[23], arrRea[24], arrRea[25], arrRea[26], arrRea[27], arrRea[28], arrRea[29]}, {arrRea[arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris], arrRea[++arraybaris]}};
                capture.log(Status.INFO, MarkupHelper.createUnorderedList("Data ReaForm ===> ").getMarkup());
                Markup mRea = MarkupHelper.createTable(dataRea2);
                capture.log(Status.INFO, mRea);
                break;


        }


    }

}