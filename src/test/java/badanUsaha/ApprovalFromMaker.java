package badanUsaha;

import capture.ImageExcel;
import capture.TakeScreenshot;
import elementsPage.Const;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import readFile.ReadCSVFormApproval;
import testData.ReadTestData;

import java.io.IOException;
import java.util.Arrays;

import static badanUsaha.LibUtils.status_testCase;

public class ApprovalFromMaker {

    private static WebDriver driver;
    int iSeq = 1;
    int iRowCapture = 55; // jarak antar picture
    int i = 1;
    static int iShoot = 1; // row number picture
    public static int iRowPictName = 1; // row number scenario
    public static String nomor_aplikasi;
    String str_rndm;
    static String notes = "";
    Actions builder;
    static ReadTestData readTestData = new ReadTestData();
    static TakeScreenshot takeScreenshot = new TakeScreenshot();
    static ImageExcel imageExcel = new ImageExcel();

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
            driver.findElement(Const.userId).sendKeys(Const.e2e_userMaker);
            driver.findElement(Const.pwd).sendKeys(Const.e2e_password);

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

    public void changeUserToApprove() throws InterruptedException, IOException {
//        logoutMaker(driver);
//        loginApprove();
        menuApprovalForm();
    }
    public void verifyData() throws IOException, InterruptedException {
        String[] arr;
        ReadCSVFormApproval readCSVFormApproval = new ReadCSVFormApproval();
        arr = readCSVFormApproval.fileCSVApp();

        Long getCount = Arrays.stream(arr).count();
        System.out.println("TOTAL ARRAY = " + Arrays.stream(arr).count() + "\n");

        try {
            boolean sts = true;
            int index = 0;
            while (sts) {
                Thread.sleep(Const.delay);
                driver.findElement(Const.txtSearch).sendKeys(arr[8 + index]);
                if (driver.getPageSource().contains("No matching records found")) {
                    Thread.sleep(Const.delay);
                    driver.findElement(Const.txtSearch).clear();
                    index = index + 8;
                } else {
                    index = 8;
                    for (i = index; i < getCount; i++) {
                        if (i % index == 0) {
                            driver.findElement(Const.txtSearch).clear();
                            driver.findElement(Const.txtSearch).sendKeys(arr[i]);
                            LibUtils.waitElementVisible(driver, Const.rwDatafirstApp1, 10); //5
                            sts = false;
                            System.out.println(index + "_" + arr[i]);

                            String getLOS = LibUtils.waitElementVisible(driver, By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[2]"), 10).getText();
                            String no_app = driver.findElement(Const.txtTbl_nomorAplikasi).getText();
                            String debt_name = driver.findElement(Const.txtTbl_namaDebitur).getText();
                            String partner = driver.findElement(Const.txtTbl_partner).getText();
                            String date = driver.findElement(Const.txtTbl_date).getText();
                            String loan_amount = driver.findElement(Const.txtTbl_palfon).getText();
                            String interest_rate = driver.findElement(Const.txtTbl_interestRate).getText();

                            Assert.assertEquals(getLOS, "LOS");
                            Assert.assertEquals(arr[i], no_app);
                            Assert.assertEquals(arr[i + 4], debt_name);
                            if (readTestData.environment.equals("E2E")) {
                                Assert.assertEquals(readTestData.companyName.toLowerCase().replace("new ", ""), partner.toLowerCase());
                            } else {
                                Assert.assertEquals(readTestData.companyName.toLowerCase(), partner.toLowerCase());
                            }
                            Assert.assertEquals(date, date);
                            if (readTestData.environment.equals("E2E")) {
                                Assert.assertEquals(arr[i + 7], "000000" + loan_amount.replace(".", "").replace("Rp", "").replace(",", "").replace(" ", "").trim() + "00");
                            } else {
                                Assert.assertEquals(arr[i + 7], "00000" + loan_amount.replace(".", "").replace("Rp", "").replace(",", "").replace(" ", "").trim() + "00");
                            }
                            Assert.assertEquals(arr[i + 6], "0" + interest_rate.replace("%", "").replace(".", ""));

                            System.out.println("==========================" + getLOS);
                            System.out.println(arr[i] + "=========" + no_app);
                            System.out.println(arr[i + 4] + "====" + debt_name);
                            System.out.println(readTestData.companyName + "===============" + partner);
                            System.out.println(date + "=======" + date);
                            System.out.println(arr[i + 7] + "===========" + loan_amount);
                            System.out.println(arr[i + 6] + "=====================" + interest_rate + "\n");

                            index = index + 8;
                            takeScreenshot.captureRobot(iShoot, "Badan Usaha - TC_23-29 - Application Id :" + arr[i], Const.sheetCaptureApproval);
//                            takeSreenshot.capture(driver, iShoot, iRowPictName, ReadTestData.testCaseID(iRowPictName) + " Nomor Aplikasi: " + no_app, Const.sheetCaptureApproval);
//                            takeSreenshot.capture(driver, iShoot, iRowPictName, value, Const.sheetCaptureApproval);
                            
                            driver.findElement(Const.txtSearch).clear();
                        }
                    }
//                    imageExcel.insertPathFileImages(iRowPictName, "", Const.tStatus);
                    status_testCase(iRowPictName, true, notes);
                    //iRowPictName = iRowPictName + iSeq;
                }
            }
        } catch (Exception e) {
            System.out.println("FAILED TC_23-29");
            e.printStackTrace();
            takeScreenshot.captureRobot(iShoot, "FAILED - Badan Usaha - TC_23-29 - Application Id :" + arr[i] + e.getMessage(), Const.sheetCaptureApproval);
//            takeSreenshot.capture(driver, iShoot, iRowPictName, value, Const.sheetCaptureApproval);
            
//            imageExcel.insertPathFileImages(iRowPictName, "", Const.fStatus);
            status_testCase(iRowPictName, true, notes);
            //iRowPictName = iRowPictName + iSeq;
        }
    }

    public void menuApprovalForm() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(@href, 'approval-form-process')]")).click();
//        LibUtils.waitElementVisible(driver, Const.rwDatafirstApp1, 10); //7
    }

    public void verifyDataSource() throws IOException, InterruptedException {
        String[] arr;
        ReadCSVFormApproval readCSVFormApproval = new ReadCSVFormApproval();
        arr = readCSVFormApproval.fileCSVApp();

        Long getCount = Arrays.stream(arr).count();
        System.out.println("TOTAL ARRAY = " + Arrays.stream(arr).count() + "\n");

        try {
            boolean sts = true;
            int index = 0;
            while (sts) {
                Thread.sleep(Const.delay);
                driver.findElement(Const.txtSearch).sendKeys(arr[8 + index]);
                if (driver.getPageSource().contains("No matching records found")) {
                    Thread.sleep(Const.delay);
                    driver.findElement(Const.txtSearch).clear();
                    index = index + 8;
                } else {
                    index = 8;
                    for (i = index; i < getCount; i++) {
                        if (i % index == 0) {
                            driver.findElement(Const.txtSearch).clear();
                            driver.findElement(Const.txtSearch).sendKeys(arr[i]);
                            LibUtils.waitElementVisible(driver, Const.rwDatafirstApp1, 10); //5
                            sts = false;
                            System.out.println(index + "_" + arr[i]);

                            String getLOS = LibUtils.waitElementVisible(driver, By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[2]"), 10).getText();
                            String no_app = driver.findElement(Const.txtTbl_nomorAplikasi).getText();
                            String debt_name = driver.findElement(Const.txtTbl_namaDebitur).getText();
                            String partner = driver.findElement(Const.txtTbl_partner).getText();
                            String date = driver.findElement(Const.txtTbl_date).getText();
                            String loan_amount = driver.findElement(Const.txtTbl_palfon).getText();
                            String interest_rate = driver.findElement(Const.txtTbl_interestRate).getText();

                            Assert.assertEquals(getLOS, "LOS");
                            Assert.assertEquals(arr[i], no_app);
                            Assert.assertEquals(arr[i + 4], debt_name);
                            if (readTestData.environment.equals("E2E")) {
                                Assert.assertEquals(readTestData.companyName.toLowerCase().replace("new ", ""), partner.toLowerCase());
                            } else {
                                Assert.assertEquals(readTestData.companyName.toLowerCase(), partner.toLowerCase());
                            }
                            Assert.assertEquals(date, date);
                            if (readTestData.environment.equals("E2E")) {
                                Assert.assertEquals(arr[i + 7], "000000" + loan_amount.replace(".", "").replace("Rp", "").replace(",", "").replace(" ", "").trim() + "00");
                            } else {
                                Assert.assertEquals(arr[i + 7], "00000" + loan_amount.replace(".", "").replace("Rp", "").replace(",", "").replace(" ", "").trim() + "00");
                            }
                            Assert.assertEquals(arr[i + 6], "0" + interest_rate.replace("%", "").replace(".", ""));

                            System.out.println("==========================" + getLOS);
                            System.out.println(arr[i] + "=========" + no_app);
                            System.out.println(arr[i + 4] + "====" + debt_name);
                            System.out.println(readTestData.companyName + "===============" + partner);
                            System.out.println(date + "=======" + date);
                            System.out.println(arr[i + 7] + "===========" + loan_amount);
                            System.out.println(arr[i + 6] + "=====================" + interest_rate + "\n");

                            index = index + 8;
                            takeScreenshot.captureRobot(iShoot, "Badan Usaha - TC_23-29 - Application Id :" + arr[i], Const.sheetCaptureApproval);
//                            takeSreenshot.capture(driver, iShoot, iRowPictName, ReadTestData.testCaseID(iRowPictName) + " Nomor Aplikasi: " + no_app, Const.sheetCaptureApproval);
//                            takeSreenshot.capture(driver, iShoot, iRowPictName, value, Const.sheetCaptureApproval);
                            
                            driver.findElement(Const.txtSearch).clear();
                        }
                    }
//                    imageExcel.insertPathFileImages(iRowPictName, "", Const.tStatus);
                    status_testCase(iRowPictName, true, notes);
                    //iRowPictName = iRowPictName + iSeq;
                }
            }
        } catch (Exception e) {
            System.out.println("FAILED TC_23-29");
            e.printStackTrace();
            takeScreenshot.captureRobot(iShoot, "FAILED - Badan Usaha - TC_23-29 - Application Id :" + arr[i] + e.getMessage(), Const.sheetCaptureApproval);
//            takeSreenshot.capture(driver, iShoot, iRowPictName, value, Const.sheetCaptureApproval);
            
//            imageExcel.insertPathFileImages(iRowPictName, "", Const.fStatus);
            status_testCase(iRowPictName, true, notes);
            //iRowPictName = iRowPictName + iSeq;
        }
    }

    public void verifyDataAppNo(){

    }
}
