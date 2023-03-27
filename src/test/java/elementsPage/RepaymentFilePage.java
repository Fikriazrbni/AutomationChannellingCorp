package elementsPage;

import capture.TakeScreenshot;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mongodb.client.model.ValidationLevel;
import jobs.DummyExpiredAppForm_BU;
import jobs.DummySuppDocAppForm_BU;
import org.apache.poi.ss.formula.ptg.Area2DPtgBase;
import org.openqa.selenium.*;
import org.testng.Assert;
import readFile.ReadCSVFormApproval;
import readFile.ReadRepayFileCSV;
import runner.FormApprovalRunner;
import runner.FormRepaymentRunner;
import testData.ReadTestData;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static badanUsaha.LoginAsApprover.*;
import static badanUsaha.LoginAsMaker.*;
import static badanUsaha.LibUtils.*;
import static elementsPage.Const.*;
import static formatFile.ZipFolder.zipFolder;
import static runner.FormRepaymentRunner.extent;
import static runner.FormRepaymentRunner.extent_test_case;
import static writeFile.UtilsFile.*;

public class RepaymentFilePage extends BaseAction {

    ReadRepayFileCSV readRepayFileCSV = new ReadRepayFileCSV();

    String[] arrReq = readRepayFileCSV.fileCSVRepayReq();
    String[] arrSucc = readRepayFileCSV.fileCSVRepaySuccess();
    String[] arrErr = readRepayFileCSV.fileCSVRepayError();
    String expected, expected2, value, value2, value3, no_app1, no_app2, no_app3, no_app4, no_app5, no_app6, no_app7, no_app8, no_app9, no_app10;

    public static final By fieldUserName = By.xpath("//*[@id= 'uid']");
    public static final By fieldPassword = By.xpath("//*[@id= 'pwd']");
    public static final By login = By.xpath("//*[@id='login-button']");
    public static final By search = By.xpath("//*[@id='search']");
    public static final By resultSearch = By.xpath("(//a[text()= 'Akseleran'])[1]");
    public static final By appNum = By.xpath("(//th[text()= 'External Id']//following-sibling::td)[2]");
    public static final By loanId = By.xpath("//li[@class = 'active ng-binding'  and contains(text(), 'Akseleran') or contains(text(), 'Komunal')]");
    public static final By bcadOutstand = By.xpath("(//table [@class = 'table table-striped']/tbody/tr/td[5])[1]");
    public static final By bcadPokok = By.xpath("(//table [@class = 'table table-striped']/tbody/tr/td[1])[1]");
    public static final By bcadDate = By.xpath("(//th[contains(text(), 'Disbursement Date')]//following-sibling::td)[2]");
    int barisReq = 7;
    int barisErr = 9;
    int barisSucc = 13;
    private static WebDriver driver = FormRepaymentRunner.driver;
    int iSeq = 1;
    int iRowPictName;
    TakeScreenshot takeScreenshot = new TakeScreenshot();
    ReadTestData readTestData = new ReadTestData();

    public RepaymentFilePage() throws IOException {
    }

    public void loginMifos(WebDriver conn) throws InterruptedException {
        driver = conn;
        driver.get(mifosE2ESup);
        driver.manage().window().maximize();
        Thread.sleep(500);
        driver.findElement(Const.btnDetails).click();
        driver.findElement(Const.btnUnsafe).click();
//        String originalWindow = driver.getWindowHandle();
//
//        for (String windowHandle : driver.getWindowHandles()) {
//            if (!originalWindow.contentEquals(windowHandle)) {
//                driver.switchTo().window(windowHandle);
//                break;
//            }
//        }
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(mifosE2E);
        driver.manage().window().maximize();

        driver.findElement(fieldUserName).sendKeys("uat");
        driver.findElement(fieldPassword).sendKeys("uat");

        driver.findElement(login).click();
    }

    public void searchAppID(String arrReq) {
        writeText(driver, search, arrReq);
        driver.findElement(search).sendKeys(Keys.ENTER);
        click(driver, resultSearch);
    }

    public void noAppSesuai() throws InterruptedException, IOException {
        loginMifos(driver);
        searchAppID(arrReq[7]);
        iRowPictName = 1;

        expected = getText(driver, appNum);
        value = arrReq[7];
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        createTable(1, "suc");
        infoData(arrReq[0], arrReq[7]);
        verifyCustom(value, expected, "CSV Request | Data Mifos");
        takeScreenshot.capture(driver);
    }

    public void noBayarSesuai() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        expected = arrReq[8];
        value = arrSucc[16];
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        createTable(1, "suc");
        infoData(arrSucc[16 - 14], arrSucc[16]);
        verifyCustom(value, expected, "CSV Request | CSV Approve");
    }

    public void tglBayarSesuai() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        expected = arrReq[9];
        value = arrSucc[17];
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        createTable(1, "suc");
        infoData(arrSucc[17 - 14], arrSucc[17]);
        verifyCustom(value, expected, "CSV Request | CSV Approve");

    }

    public void noPokNot0() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        long nopok = Long.parseLong(arrReq[10]);
        expected = String.valueOf(nopok);
        value = arrSucc[18].replace(".", "");
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        createTable(1, "suc");
        infoLength(arrSucc[18 - 14], arrReq[10], 15);
        verifyCustom(value, expected, "CSV Request | CSV Approve");

    }

    public void noPok0() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        long nopok = Long.parseLong(arrReq[10 + barisReq]);
        long nopok2 = Long.parseLong(arrSucc[18 + barisSucc].replace(".", ""));
        expected = String.valueOf(nopok);
        value = String.valueOf(nopok2);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(2, "req");
        createTable(2, "suc");
        infoLength(arrSucc[18 - 14], arrReq[10 + barisReq], 15);
        verifyCustom(value, expected, "CSV Request | CSV Approve");

    }

    public void noBungNot0() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        long nobung = Long.parseLong(arrReq[11]);
        expected = String.valueOf(nobung);
        value = arrSucc[19].replace(".", "");
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        createTable(1, "suc");
        infoLength(arrSucc[19 - 14], arrReq[11], 15);
        verifyCustom(value, expected, "CSV Request | CSV Approve");

    }

    public void noBung0() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        long nobung = Long.parseLong(arrReq[11 + barisReq]);
        long nobung2 = Long.parseLong(arrSucc[19 + barisSucc].replace(".", ""));
        expected = String.valueOf(nobung);
        value = String.valueOf(nobung2);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        createTable(1, "suc");
        infoLength(arrSucc[19 - 14], arrReq[11 + barisReq], 15);
        verifyCustom(value, expected, "CSV Request | CSV Approve");

    }

    public void noDenNot0() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        long noden = Long.parseLong(arrReq[12]);
        expected = String.valueOf(noden);
        value = arrSucc[20].replace(".", "");
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        createTable(1, "suc");
        infoLength(arrSucc[20 - 14], arrReq[12], 15);
        verifyCustom(value, expected, "CSV Request | CSV Approve");

    }

    public void noDen0() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        long noden = Long.parseLong(arrReq[12 + barisReq]);
        long noden2 = Long.parseLong(arrSucc[20 + barisSucc].replace(".", ""));
        expected = String.valueOf(noden);
        value = String.valueOf(noden2);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        createTable(1, "suc");
        infoLength(arrSucc[20 - 14], arrReq[12 + barisSucc], 15);
        verifyCustom(value, expected, "CSV Request | CSV Approve");

    }

    public void pel_Y() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        expected = arrReq[13];
        value = arrSucc[21];
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        createTable(1, "suc");
        infoData(arrSucc[21 - 14], arrSucc[21]);
        verifyCustom(value, expected, "CSV Request | CSV Approve");

    }

    public void pel_N() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        expected = arrReq[13 + barisReq];
        value = arrSucc[21 + barisSucc];
        createTest(iRowPictName, extent_test_case, extent);
        createTable(2, "req");
        createTable(2, "suc");
        infoData(arrSucc[21 - 14], arrSucc[21 + barisSucc]);
        verifyCustom(value, expected, "CSV Request | CSV Approve");

    }

    public void pel_I() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        expected = arrReq[13 + barisReq * 2];
        value = arrSucc[21 + barisSucc + barisSucc];
        createTest(iRowPictName, extent_test_case, extent);
        createTable(3, "req");
        createTable(3, "suc");
        infoData(arrSucc[21 - 14], arrSucc[21 + barisSucc * 2]);
        verifyCustom(value, expected, "CSV Request | CSV Approve");

    }

    public void pel_A() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Belum terdapat pelunasan Advance pada partner Akseleran");

    }

    public void addIntNot0() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Tidak terdapat additional interest pada partner Akseleran");

    }

    public void addInt0() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Tidak terdapat additional interest pada partner Akseleran");

    }

    public void finLoanId() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        Long loan = Long.parseLong(getText(driver, loanId).substring(10, 19));
        expected = arrSucc[14];
        value = String.valueOf(loan);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        createTable(1, "suc");
        infoData(arrSucc[0], arrSucc[14]);
        verifyCustom(value, expected, "Mifos | CSV Approve");
        takeScreenshot.capture(driver);
    }

    public void finCompCode() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
        expected = arrReq[7].substring(0, 7);
        value = arrSucc[15];
        createTable(1, "req");
        createTable(1, "suc");
        infoData(arrSucc[15 - 14], arrSucc[15]);
        verifyCustom(value, expected, "CSV Request | CSV Approve");

    }

    public void finRepayNum() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        expected = arrReq[8];
        value = arrSucc[16];
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        createTable(1, "suc");
        infoData(arrSucc[16 - 14], arrSucc[16]);
        verifyCustom(value, expected, "CSV Request | CSV Approve");

    }

    public void finPartDate() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        expected = arrReq[9];
        value = arrSucc[17];
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        createTable(1, "suc");
        infoData(arrSucc[17 - 14], arrSucc[17]);
        verifyCustom(value, expected, "CSV Request | CSV Approve");

    }

    public void finPartPok() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        long nopok = Long.parseLong(arrReq[10]);
        expected = String.valueOf(nopok);
        value = arrSucc[18].replace(".", "");
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        createTable(1, "suc");
        infoData(arrSucc[18 - 14], arrSucc[18]);
        verifyCustom(value, expected, "CSV Request | CSV Approve");

    }

    public void finPartBung() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        long nobung = Long.parseLong(arrReq[11]);
        expected = String.valueOf(nobung);
        value = arrSucc[19].replace(".", "");
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        createTable(1, "suc");
        infoData(arrSucc[19 - 14], arrSucc[19]);
        verifyCustom(value, expected, "CSV Request | CSV Approve");

    }

    public void finPartDen() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        long noden = Long.parseLong(arrReq[12]);
        expected = String.valueOf(noden);
        value = arrSucc[20].replace(".", "");
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        createTable(1, "suc");
        infoData(arrSucc[20 - 14], arrSucc[20]);
        verifyCustom(value, expected, "CSV Request | CSV Approve");

    }

    public void finPartPelnas() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        expected = arrReq[13];
        value = arrSucc[21];
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        createTable(1, "suc");
        infoData(arrSucc[21 - 14], arrSucc[21]);
        verifyCustom(value, expected, "CSV Request | CSV Approve");

    }

    public void finBcadOutstand() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        Long outCsv = Long.parseLong(arrSucc[22].replace(".000000", ""));
        Long interest = Long.parseLong(arrSucc[25]
                .replace(".000000", "")
                .replace("-", ""));
        Long outValue = Long.parseLong(getText(driver, bcadOutstand).replace(",", ""));
        Long result = outValue - interest;
        value = String.valueOf(result);
        expected = String.valueOf(outCsv);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        createTable(1, "suc");
        infoData(arrSucc[22 - 14], arrSucc[22]);
        verifyCustom(value, expected, "Mifos | CSV Approve");
        takeScreenshot.capture(driver);
    }

    public void finBcadDate() throws ParseException, IOException {
        iRowPictName = iRowPictName + iSeq;

        String pattern = "dd MMMM yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(getText(driver, bcadDate));
        SimpleDateFormat newFormat = new SimpleDateFormat("ddMMyyyy");
        value = (newFormat.format(date));
        expected = arrSucc[17];
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        createTable(1, "suc");
        infoData(arrSucc[17 - 14], arrSucc[17]);
        verifyCustom(value, expected, "Mifos | CSV Approve");
        takeScreenshot.capture(driver);
    }

    public void finBcadPok() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        Long val1 = Long.parseLong(arrSucc[24]
                .replace(".000000", ""));
        value = getText(driver, bcadPokok).replace(",", "");
        expected = String.valueOf(val1);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        createTable(1, "suc");
        infoData(arrSucc[24 - 14], arrSucc[24]);
        verifyCustom(value, expected, "Mifos | CSV Approve");
        takeScreenshot.capture(driver);
    }

    public void finBcadBung() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "BCAD bunga tobe confirm terkait nominal bunga");

//        expected = arrSucc[25].replace(".000000", "");
//        value = "0";
//        createTest(iRowPictName, extent_test_case, extent);
//        createTable(1, "suc");
//        infoData(arrSucc[25-14], arrSucc[25]);
//        verifyCustom(value, expected,"Mifos | CSV Approve");
    }

    public void finBcadAddInt() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Tidak terdapat additional interest pada partner Akseleran");

    }

    public void negFinNoAplikasi() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
        expected = arrReq[7 + barisReq * 4];
        value = arrErr[9 + barisErr];
        createTable(5, "req");
        createTable(2, "err");
        infoData(arrErr[0], arrErr[9 + barisErr]);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void negFinNoPembayaran() throws IOException {

        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        expected = arrReq[8 + (barisReq * 3)];
        value = arrErr[10];
        createTable(4, "req");
        createTable(1, "err");
        infoData(arrErr[10 - 9], arrErr[10]);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void negFintglPembayaran() throws IOException {

        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        expected = arrReq[9 + (barisReq * 3)];
        value = arrErr[11];
        createTable(4, "req");
        createTable(1, "err");
        infoData(arrErr[11 - 9], arrErr[11]);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void negFinNomPok() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        expected = arrReq[10 + (barisReq * 3)];
        value = arrErr[12];
        createTable(4, "req");
        createTable(1, "err");
        infoData(arrErr[12 - 9], arrErr[12]);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void negFinNomBung() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        expected = arrReq[11 + (barisReq * 3)];
        value = arrErr[13];
        createTable(4, "req");
        createTable(1, "err");
        infoData(arrErr[13 - 9], arrErr[13]);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void negFinNomDen() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        expected = arrReq[12 + (barisReq * 3)];
        value = arrErr[14];
        createTable(4, "req");
        createTable(1, "err");
        infoData(arrErr[14 - 9], arrErr[14]);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void negFinPel() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        expected = arrReq[13 + (barisReq * 3)];
        value = arrErr[15];
        createTable(4, "req");
        createTable(1, "err");
        infoData(arrErr[15 - 9], arrErr[15]);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void negFinAddInt() {

        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Tidak terdapat additional interest pada partner Akseleran");

    }

    public void nullNoApp() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message -> " + arrErr[17]);
        expected = arrReq[7 + (barisReq * 3)];
        value = arrErr[9];
        createTable(4, "req");
        createTable(1, "err");
        infoData(arrErr[0], arrErr[9]);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void nullNoPembayaran() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr]);
        expected = arrReq[8 + (barisReq * 4)];
        value = arrErr[10 + barisErr];
        createTable(5, "req");
        createTable(2, "err");
        infoData(arrErr[10 - 9], arrErr[10 + barisErr]);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void nullTglBayar() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr * 2]);
        expected = arrReq[9 + barisReq * 5];
        value = arrErr[11 + barisErr * 2];
        createTable(6, "req");
        createTable(3, "err");
        infoData(arrErr[11 - 9], arrErr[11 + barisErr * 2]);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void nullNomPok() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr * 3]);
        expected = arrReq[10 + (barisReq * 6)];
        value = arrErr[12 + barisErr * 3];
        createTable(7, "req");
        createTable(4, "err");
        infoData(arrErr[12 - 9], arrErr[12 + barisErr * 3]);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void nullNomBung() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr * 4]);
        expected = arrReq[11 + (barisReq * 7)];
        value = arrErr[13 + barisErr * 4];
        createTable(8, "req");
        createTable(5, "err");
        infoData(arrErr[13 - 9], arrErr[13 + barisErr * 4]);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void nullNomDen() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr * 5]);
        expected = arrReq[12 + (barisReq * 8)];
        value = arrErr[14 + barisErr * 5];
        createTable(9, "req");
        createTable(6, "err");
        infoData(arrErr[14 - 9], arrErr[14 + barisErr * 5]);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void nullPelnas() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr * 6]);
        expected = arrReq[13 + (barisReq * 9)];
        value = arrErr[15 + barisErr * 6];
        createTable(10, "req");
        createTable(7, "err");
        infoData(arrErr[15 - 9], arrErr[15 + barisErr * 6]);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void nullAddInt() {
        iRowPictName = iRowPictName + iSeq;

        createTestSkip(iRowPictName, extent_test_case, extent, "Tidak terdapat additional interest pada partner Akseleran");
    }

    //OOB Length -1
    public void oobNoApp() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr * 7]);
        expected = arrReq[7 + (barisReq * 10)];
        value = arrErr[9 + barisErr * 7];
        createTable(11, "req");
        createTable(8, "err");
        infoLength(arrErr[0], arrErr[9 + barisErr * 7], 16);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void oobNoPembayaran() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr * 8]);
        expected = arrReq[8 + (barisReq * 11)];
        value = arrErr[10 + barisErr * 8];
        createTable(12, "req");
        createTable(9, "err");
        infoLength(arrErr[10 - 9], arrErr[10 + barisErr * 8], 19);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void oobTglPembayaran() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr * 9]);
        expected = arrReq[9 + (barisReq * 12)];
        value = arrErr[11 + barisErr * 9];
        createTable(13, "req");
        createTable(10, "err");
        infoLength(arrErr[11 - 9], arrErr[11 + barisErr * 9], 7);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void oobNomPok() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr * 10]);
        expected = arrReq[10 + (barisReq * 13)];
        value = arrErr[12 + barisErr * 10];
        createTable(14, "req");
        createTable(11, "err");
        infoLength(arrErr[12 - 9], arrErr[12 + barisErr * 10], 14);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void oobNomBung() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr * 11]);
        expected = arrReq[11 + (barisReq * 14)];
        value = arrErr[13 + barisErr * 11];
        createTable(15, "req");
        createTable(12, "err");
        infoLength(arrErr[13 - 9], arrErr[13 + barisErr * 11], 14);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void oobNomDen() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr * 12]);
        expected = arrReq[12 + (barisReq * 15)];
        value = arrErr[14 + barisErr * 12];
        createTable(16, "req");
        createTable(13, "err");
        infoLength(arrErr[14 - 9], arrErr[14 + barisErr * 12], 14);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void oobPelnas() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr * 13]);
        expected = arrReq[13 + (barisReq * 16)];
        value = arrErr[15 + barisErr * 13];
        createTable(17, "req");
        createTable(14, "err");
        infoData(arrErr[15 - 9], arrErr[15 + barisErr * 13]);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void oobAddInt() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Tidak terdapat additional interest pada partner Akseleran");
    }

    //OOB Lenght + 1
    public void oobNoApp2() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr * 14]);
        expected = arrReq[7 + (barisReq * 17)];
        value = arrErr[9 + barisErr * 14];
        createTable(18, "req");
        createTable(15, "err");
        infoLength(arrErr[0], arrErr[9 + barisErr * 14], 18);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void oobNoPembayaran2() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr * 15]);
        expected = arrReq[8 + (barisReq * 18)];
        value = arrErr[10 + barisErr * 15];
        createTable(19, "req");
        createTable(16, "err");
        infoLength(arrErr[10 - 9], arrErr[10 + barisErr * 15], 21);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void oobTglPembayaran2() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr * 16]);
        expected = arrReq[9 + (barisReq * 19)];
        value = arrErr[11 + barisErr * 16];
        createTable(20, "req");
        createTable(17, "err");
        infoLength(arrErr[11 - 9], arrErr[11 + barisErr * 16], 9);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void oobNomPok2() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr * 17]);
        expected = arrReq[10 + (barisReq * 20)];
        value = arrErr[12 + barisErr * 17];
        createTable(21, "req");
        createTable(18, "err");
        infoLength(arrErr[12 - 9], arrErr[12 + barisErr * 17], 16);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void oobNomBung2() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr * 18]);
        expected = arrReq[11 + (barisReq * 21)];
        value = arrErr[13 + barisErr * 18];
        createTable(22, "req");
        createTable(19, "err");
        infoLength(arrErr[13 - 9], arrErr[13 + barisErr * 18], 16);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void oobNomDen2() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr * 19]);
        expected = arrReq[12 + (barisReq * 22)];
        value = arrErr[14 + barisErr * 19];
        createTable(23, "req");
        createTable(20, "err");
        infoLength(arrErr[14 - 9], arrErr[14 + barisErr * 19], 16);
        verifyCustom(value, expected, "CSV Request | CSV Error");


    }

    public void oobAddInt2() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Tidak terdapat additional interest pada partner Akseleran");
    }

    public void notFoundNoApp() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr * 20]);
        expected = arrReq[7 + (barisReq * 23)];
        value = arrErr[9 + barisErr * 20];
        createTable(24, "req");
        createTable(21, "err");
        infoData(arrErr[0], arrErr[9 + barisErr * 20]);
        verifyCustom(value, expected, "CSV Request | CSV Error");
    }

    public void duplicatExistNoBayar() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr * 21]);
        expected = arrReq[8 + (barisReq * 24)];
        value = arrErr[10 + barisErr * 21];
        createTable(1, "ex");
        createTable(25, "req");
        createTable(22, "err");
        infoData(arrErr[1], arrErr[10 + barisErr * 21]);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void duplicatInFileNoBayar() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Error Message => " + arrErr[17 + barisErr * 12]);
        expected = arrReq[8 + (barisReq * 25)];
        value = arrErr[10 + barisErr * 22];
        createInfo(extent_test_case, "Data Exist in same file (Data row 1)");
        createTable(1, "req");
        createTable(26, "req");
        createTable(23, "err");
        infoData(arrErr[1], arrErr[10 + barisErr * 22]);
        verifyCustom(value, expected, "CSV Request | CSV Error");

    }

    public void comparation() throws IOException {

        createTest(iRowPictName, extent_test_case, extent);

        createInfo(extent_test_case, "Data Appform");
        createTable(1, "app");
        createTable2(8, "app");

        createInfo(extent_test_case, "Data ReaForm");
        createTable(1, "rea");
        createTable2(30, "rea");

        createInfo(extent_test_case, "Data RepayForm");
        createTable(1, "suc");
        createTable2(14, "suc");


    }

    //Repayment Form
    public void openRepayMenu() {
        loginMaker(driver);
    }

    public void dtlTgMskFile() {
        iRowPictName = 1;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void dtlBatchNo() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void dtlNoApp() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void dtlNoDebitur() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void dtlPartner() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void dtlNoBayar() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void dtlStatKurangBayar() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void dtlStatPasBayar() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void dtlStatLebihBayar() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyStatAfterConsume() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyApprovedbyAfterConsume() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyTglApprovalAfterCons() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyTypeRejectReason() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyDescAfterConsume() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyTglBayar() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void cardTotPem() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void cardTotPemDend0() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void cardPempok() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void cardPempoknopok0() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void cardPempokbung() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void cardPempokbung0() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void cardPempokden() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void cardPempokden0() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void cardPempokaddInt() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "additional Interest tidak ada pada partner ini");
    }

    public void cardPempokaddInt0() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "additional interest tidak ada");
    }

    public void cardPemN() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void cardPemY(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void cardPemI(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void cardPemA(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void listTglbayar(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void listTotPem() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void listTotPemDen0(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void listTotTagihan(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void listStatKurangBayar(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void listStatSesuai() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void listStatLebih(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void listTglMasukFile(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void listBatchNo(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void listStatWaitforApp(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void cardTglPemBulBerjalan(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void cardTotTagih(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void cardPemPokBulBerjalan(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void cardPemBungBulBerjalan(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void cardPemDenBulBerjalan(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void cardAddIntBulBerjalan(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Tidak Terdapat AddInt...");
    }

    public void klikApprv(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void klikApprvNo(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void klikApprvYes(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyApprovedData(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void klikReject(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyTypeofReject(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void klikRejectCancel(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void rejectwithoutDesc(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void rejectWoutTypeReject(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void rejectDesc100(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void rejectDesc99(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void rejectedData(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void bulkApprv(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void bulkApprvBatal(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void bulkApprvSubmit(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void checkDataWaitforAppr(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void checkDataApprov(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void checkDataRejected(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void checkDataPBR(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void checkDataApprvExp(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void editWaiting(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void editRejected(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void editPBR(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void approvEditData(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void rejectEditData(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void checkButtonWaitforApprv(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void checkButtonApproved(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void checkButtonRejected(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void checkButtonPBR(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void checkButtonApprvExp(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void backdatedData(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void sysdateData(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void advanceData(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void rejectBySystemData(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void waitforApprHmin1(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void approvDataHmin1(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void rejectByAnalystDataHmin1(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void PBRDataHmin1(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void apprExpDataHmin1(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void apprExpDataHmin2(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyIsiFilter(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void filterBySourceAll(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void filterBySourceLos(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void filterBySourceNikel(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyIsiFilterPelunasan(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void filterPelAll(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void filterPelYes(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void filterPelNo(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void filterPelInsurance(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void filterPelAdvance(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyIsiFilterStatus(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void filterByStatusAll(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void filterByStatusWaitforApprov(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void filterByStatusPBR(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void filterByStatusApproved(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void filterByStatusRejected(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void filterByStatusApprvExp(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyIsiFilterPartner(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void filterByPartnerAll(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void filterByPartnerPilih1(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyIsiStatAmountRepay(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void filterAmountRepayByAll(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void filterAmountRepayBySesuai(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void filterAmountRepayByKurangBayar(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void filterAmountRepayByLebihBayar(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyIsiFilterBatchNo(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void filterByBatchnoPilih1(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyfilterSearch(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifySourceLOS(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifySourceNIKEL(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyAppNo(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyPartner(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyDebtorName(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyPelN(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyPelY(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyPelI(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyPelA(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void sortStatus(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void sortTglBayar(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void nextPage(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void clickNumPage(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }
    public void previousPage(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void sortStatus2(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void sortTglBayarHmin1(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyTglMenuRepayment(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void totNomApproved(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void totNomPembayaran(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void bulkApproveCheck2Data(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void bulkApprovUncheck2Data(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void bulkApprvCheckAll(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void bulkApprCheckAllandApprov(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void bulkApprCheckAllApprovandBatal(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyAfterBulkAll(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void bulkBeberapaReject(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void bulkBeberapaRejectAndBatal(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void bulkBeberapaRejectAndSubmit(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void bulkAllReject(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void bulkAllRejectAndBatal(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void bulkApprvAndTidakCheckDataKlikApprv(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void bulkApprvTidakCheckDataKlikReject(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyBulkRejected(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void bulkEdit(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void bulkEditCheckall(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void bulkEditCheckbeberapaAndCancel(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void bulkEditCheckBeberapaAndChange(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void bulkEditCheckAllAndCancel(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void apprvAfterEdited(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void rejectAfterEdited(){
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }
}

