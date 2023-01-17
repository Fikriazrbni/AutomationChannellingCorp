package elementsPage;

import capture.TakeScreenshot;
import jobs.DummyReaForm_BU;
import jobs.FileReaForm_BU;
import org.openqa.selenium.*;
import readFile.ReadCSVFormApproval;
import runner.FormApprovalRunner;
import runner.ValidateFileRunner;
import testData.ReadTestData;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static badanUsaha.LoginAsApprover.*;
import static badanUsaha.LoginAsMaker.*;
import static badanUsaha.LibUtils.*;
import static elementsPage.ApprovalFormPage.*;
import static elementsPage.ApprovalFormPage.body;
import static elementsPage.ApprovalFormPage.rwDatafirstApp1;
import static elementsPage.ApprovalFormPage.txtSearch;
import static elementsPage.ApprovalFormPage.txtTbl_nomorAplikasi;
import static elementsPage.ApprovalFormPage.txtTbl_source;
import static elementsPage.ApprovalFormPage.txtTbl_status;
import static elementsPage.RealizationFormPage.*;
import static runner.ValidateFileRunner.extent;
import static runner.ValidateFileRunner.extent_test_case;

public class ValidateFilePage extends BaseAction {

    public  static final By menuProductProfile     = By.xpath("(//a[@href= '/product-profile'])[1]");
    public  static final By inputSearchProduct     = By.xpath("//input[@id='search']");
    public  static final By selectProductProfileKomunal = By.xpath("//tr[@class='odd']//following-sibling::td//a[text()='24BL002']");
    public  static final By selectProductProfileAkseleran = By.xpath("//tr[@class='odd']//following-sibling::td//a[text()='24BL001']");
    public  static final By buttonBackProduct      = By.xpath("//h5/a[@href='/product-profile']");
    public  static final By labelProductPlafon     = By.xpath("(//*[contains(@value,'Rp')])[3]");
    public  static final By labelProductIntRate    = By.xpath("(//*[contains(@value,'%')])[3]");
    public  static final By labelProductLoanTerm   = By.xpath("(//*[contains(@value,'Month')])");
    public  static final By menuExposureDebt       = By.xpath("//a[contains(@href, 'exposure-debtor-limit')]");
    public  static final By selectDropdownExposure = By.xpath("//span[@id='select2-exposureCode-container']");
    public  static final By selectValueExposureBU   = By.xpath("//li[text()='EX0005 - Automation Channeling BU']");
    public  static final By selectValueExposureRevert= By.xpath("//li[contains(text(),'EX0001')]");
    public  static final By selectValueExposure2    = By.xpath("//li[contains(text(),'EX0006')]");
    public  static final By buttonUseExposure      = By.xpath("//button[text()='Use']");
    public static final By inputSearch             = By.id("myInput");
    public static final By txtTblNoApp             = By.xpath("//tr[@class='odd']//td[3]");
    public static final By dtlBtnBackRea           = By.xpath("(//a[@href='/approval-form'])[2]");
    public static final By txtDetail_NoApp         = By.xpath("(//label[@class='col-form-label'])[3]");

    public static final By dtlLabelNoUrut        = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[1]//child::td[1]");
    public static final By dtlValueNoUrut        = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[1]//child::td[2]");
    public static final By dtlLabelJmlPengurus   = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[2]//child::td[1]");
    public static final By dtlValueJmlPengurus   = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[2]//child::td[2]");
    public static final By dtlLabelSandiJabatan  = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[3]//child::td[1]");
    public static final By dtlValueSandiJabatan  = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[3]//child::td[2]");
    public static final By dtlValueSandiJabatan2 = By.xpath("//*[@id='datatable']/tbody/tr[4]/td/table/tbody/tr[3]//child::td[2]");
    public static final By dtlLabelPangsaPemilik = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[4]//child::td[1]");
    public static final By dtlValuePangsaPemilik = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[4]//child::td[2]");
    public static final By dtlLabelBentukPengurus= By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[5]//child::td[1]");
    public static final By dtlValueBentukPengurus= By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[5]//child::td[2]");
    public static final By dtlLabelModalDasar    = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[6]//child::td[1]");
    public static final By dtlValueModalDasar    = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[6]//child::td[2]");
    public static final By dtlValueModalDasar2   = By.xpath("//*[@id='datatable']/tbody/tr[4]/td/table/tbody/tr[6]//child::td[2]");
    public static final By dtlLabelModalDisetor  = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[7]//child::td[1]");
    public static final By dtlValueModalDisetor  = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[7]//child::td[2]");
    public static final By dtlValueModalDisetor2 = By.xpath("//*[@id='datatable']/tbody/tr[4]/td/table/tbody/tr[7]//child::td[2]");
    public static final By dtlLabelModalDitempat = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[8]//child::td[1]");
    public static final By dtlValueModalDitempat = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[8]//child::td[2]");
    public static final By dtlValueModalDitempat2= By.xpath("//*[@id='datatable']/tbody/tr[4]/td/table/tbody/tr[8]//child::td[2]");
    public static final By dtlLabelNpwp          = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[9]//child::td[1]");
    public static final By dtlValueNpwp          = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[9]//child::td[2]");
    public static final By dtlLabelNama          = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[10]//child::td[1]");
    public static final By dtlValueNama          = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[10]//child::td[2]");
    public static final By dtlValueNama2         = By.xpath("//*[@id='datatable']/tbody/tr[4]/td/table/tbody/tr[10]//child::td[2]");
    public static final By dtlLabelAlamat        = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[11]//child::td[1]");
    public static final By dtlValueAlamat        = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[11]//child::td[2]");
    public static final By dtlValueAlamat2       = By.xpath("//*[@id='datatable']/tbody/tr[4]/td/table/tbody/tr[11]//child::td[2]");
    public static final By dtlLabelKelurahan     = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[12]//child::td[1]");
    public static final By dtlValueKelurahan     = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[12]//child::td[2]");
    public static final By dtlValueKelurahan2    = By.xpath("//*[@id='datatable']/tbody/tr[4]/td/table/tbody/tr[12]//child::td[2]");
    public static final By dtlLabelKecamatan     = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[13]//child::td[1]");
    public static final By dtlValueKecamatan     = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[13]//child::td[2]");
    public static final By dtlValueKecamatan2    = By.xpath("//*[@id='datatable']/tbody/tr[4]/td/table/tbody/tr[13]//child::td[2]");
    public static final By dtlLabelKdDati        = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[14]//child::td[1]");
    public static final By dtlValueKdDati        = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[14]//child::td[2]");
    public static final By dtlLabelNoKtp         = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[15]//child::td[1]");
    public static final By dtlValueNoKtp         = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[15]//child::td[2]");
    public static final By dtlLabelNoAkte        = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[16]//child::td[1]");
    public static final By dtlValueNoAkte        = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[16]//child::td[2]");
    public static final By dtlValueNoAkte2       = By.xpath("//*[@id='datatable']/tbody/tr[4]/td/table/tbody/tr[16]//child::td[2]");
    public static final By dtlLabelTanggalLahir  = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[17]//child::td[1]");
    public static final By dtlValueTanggalLahir  = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[17]//child::td[2]");
    public static final By dtlLabelTanggalAkte   = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[18]//child::td[1]");
    public static final By dtlValueTanggalAkte   = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[18]//child::td[2]");
    public static final By dtlLabelKdDatiLahir   = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[19]//child::td[1]");
    public static final By dtlValueKdDatiLahir   = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[19]//child::td[2]");
    public static final By dtlLabelJenisKel      = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[20]//child::td[1]");
    public static final By dtlValueJenisKel      = By.xpath("//*[@id='datatable']/tbody/tr[2]/td/table/tbody/tr[20]//child::td[2]");
    public static final By dtlValueJenisKel2     = By.xpath("//*[@id='datatable']/tbody/tr[4]/td/table/tbody/tr[20]//child::td[2]");
    public static final By dtlLabelDataPengurus  = By.xpath("(//tr[@class='odd']//child::td[1])[1]");
    public static final By dtlLabelDataPengurus2 = By.xpath("(//tr[@class='even']//child::td[1])[1]");
    public static final By dtlListNoDataPengurus  = By.xpath("(//tbody//child::tr//child::td[@class='details-control sorting_1'])");
    public static final By dtlListValueDataPengurus  = By.xpath("(//tbody//child::tr//child::td[@class=' details-control'][3])");


    private static final WebDriver driver = ValidateFileRunner.driver;
    int iSeq = 1;
    int iRowPictName;
    TakeScreenshot takeScreenshots = new TakeScreenshot();
    ReadTestData readTestData = new ReadTestData();
    ReadCSVFormApproval readCSVFormApproval = new ReadCSVFormApproval();
    String expected, value, value2, value3, no_app1, no_app2, no_app3, no_app4, no_app5, no_app6, no_app7, no_app8, no_app9, no_app10;

    public void login() throws IOException {
        readTestData.testData();
        loginMaker(driver);

        String[] arr = readCSVFormApproval.fileCSVAppPartner();
        no_app1 = arr[8];
        no_app2 = arr[16];
        no_app3 = arr[24];
        no_app4 = arr[32];
        no_app5 = arr[40];
    }
    public void loginLdap() throws IOException {
        readTestData.testData();
        readTestData.testDataMaintananceTable();
        loginApproverLdap(driver);

        String[] arr = readCSVFormApproval.fileCSVAppPartner();
        no_app1 = arr[8];
        no_app2 = arr[16];
        no_app3 = arr[24];
        no_app4 = arr[32];
        no_app5 = arr[40];
    }
    public void logout() throws InterruptedException {
        logoutMaker(driver);
    }
    public void changeUserToApprove() throws InterruptedException {
        logoutMaker(driver);
        loginApprover(driver);
        menuApprovalForm();
    }
    public void changeUserToMaker() throws InterruptedException {
        logoutApprover(driver);
        loginMaker(driver);
        menuApprovalForm();
    }

    public void menuNotification() {
        click(driver, notif);
        click(driver, notifSeeAll);
    }
    public void verifyNotification() {

        List<WebElement> ListRow = driver.findElements(By.xpath("//tr[2][@class='pointer'] //td[2][contains(text(),'Approval')][contains(text(),'AKSELERAN')] | //tr[1][@class='pointer'] //td[2][contains(text(),'Approval')][contains(text(),'AKSELERAN')]"));
        value                    = "";
        boolean dataConsume      = driver.findElement(By.xpath("//tr[2][@class='pointer'] //td[2][contains(text(),'Approval')][contains(text(),'AKSELERAN')] | //tr[1][@class='pointer'] //td[2][contains(text(),'Approval')][contains(text(),'AKSELERAN')]")).isDisplayed();
        for (WebElement webElement : ListRow) {
            if (webElement.getText().contains("AKSELERAN")) {
                value            = webElement.getText();
            }
        }
        verifyValueDisplay(dataConsume,true, "Consume data berhasil approval form partner 1 : "+value);

        List<WebElement> ListRow2 = driver.findElements(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),'Approval')][contains(text(),'NEW KOMUNAL')] | //tr[2][@class='pointer'] //td[2][contains(text(),'Approval')][contains(text(),'NEW KOMUNAL')]"));
        value                    = "";
        boolean dataConsume2      = driver.findElement(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),'Approval')][contains(text(),'NEW KOMUNAL')] | //tr[2][@class='pointer'] //td[2][contains(text(),'Approval')][contains(text(),'NEW KOMUNAL')]")).isDisplayed();
        for (WebElement webElement : ListRow2) {
            if (webElement.getText().contains("KOMUNAL")) {
                value            = webElement.getText();
            }
        }
        verifyValueDisplay(dataConsume2,true, "Consume data berhasil approval form partner 2 : "+value);
        takeScreenshots.capture(driver);
    }

    public void setProductProfile()   {
        iRowPictName = 1;
        click(driver, menuProductProfile);
        click(driver, inputSearchProduct);
        writeText(driver, inputSearchProduct, "komunal");
        click(driver, selectProductProfileKomunal);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshots.capture(driver);
        click(driver, buttonBackProduct);
        writeText(driver, inputSearchProduct, "akseleran");
        click(driver, selectProductProfileAkseleran);
        takeScreenshots.capture(driver);
        click(driver, buttonBackProduct);
    }
    public void menuProductProfileAkseleran() {
        click(driver, menuProductProfile);
        click(driver, inputSearchProduct);
        writeText(driver, inputSearchProduct, "akseleran");
        click(driver, selectProductProfileAkseleran);
    }
    public void menuProductProfileKomunal() {
        click(driver, menuProductProfile);
        click(driver, inputSearchProduct);
        writeText(driver, inputSearchProduct, "komunal");
        click(driver, selectProductProfileKomunal);
    }
    public void menuProductProfile() {
        if ((readTestData.environment.equals("E2E") && readTestData.companyName.equals("AKSELERAN")) | (readTestData.environment.equals("UAT") && readTestData.companyName.equals("AKSELERAN"))) {
            menuProductProfileAkseleran();
        } else if ((readTestData.environment.equals("E2E") && readTestData.companyName.equals("NEW KOMUNAL")) | (readTestData.environment.equals("UAT") && readTestData.companyName.equals("NEW KOMUNAL")) ) {
            menuProductProfileKomunal();
        }
    }

    public void setExposureDebt() throws InterruptedException {
        click(driver, menuExposureDebt);
        scrollDown(driver, By.xpath("(//button[@type='submit' ])[2]"));
        scrollDown(driver, By.xpath("(//button[@type='submit' ])[2]"));
        scrollDown(driver, By.xpath("(//button[@type='submit' ])[2]"));
        click(driver, selectDropdownExposure);
        Thread.sleep(2000);
        scrollIntoView(driver, selectValueExposure2);
        scrollIntoView(driver, selectValueExposureBU);
        Thread.sleep(2000);
//        click(driver, selectDropdownExposure);
        driver.findElement(selectValueExposureBU).click();
        click(driver, buttonUseExposure);
        takeScreenshots.capture(driver);
    }
    public void setExposureDebtRevert() throws InterruptedException {
        click(driver, menuExposureDebt);
        scrollDown(driver, By.xpath("(//button[@type='submit' ])[2]"));
        scrollDown(driver, By.xpath("(//button[@type='submit' ])[2]"));
        scrollDown(driver, By.xpath("(//button[@type='submit' ])[2]"));
        click(driver, selectDropdownExposure);
        Thread.sleep(2000);
        scrollIntoView(driver, selectValueExposureRevert);
        Thread.sleep(2000);
        driver.findElement(selectValueExposureRevert).click();
        click(driver, buttonUseExposure);
    }

    public void menuProductProfile2Partner() {
        click(driver, menuProductProfile);
        click(driver, inputSearchProduct);
        writeText(driver, inputSearchProduct, "akseleran");
        click(driver, selectProductProfileAkseleran);
        takeScreenshots.capture(driver);
        click(driver, buttonBackProduct);
        writeText(driver, inputSearchProduct, "komunal");
        click(driver, selectProductProfileKomunal);
    }
    public void menuExposureDebt() {
        click(driver, menuExposureDebt);
    }
    public void menuApprovalForm()   {
        click(driver, menuApprovalForm);
    }
    public void menuRealizationForm()   {
        click(driver, menuReaForm);
    }

    public void verifyDataAppFormNoApp() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] arr = readCSVFormApproval.fileCSVAppPartner();

        writeText(driver, txtSearch, no_app1);
        value    = getText(driver, txtTbl_nomorAplikasi);
        expected = arr[8];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[8], arr[8].length(),17);
        verifyValue(value,expected);
        takeScreenshots.capture(driver);
    }
    public void verifyDataAppFormNpwp() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] arr = readCSVFormApproval.fileCSVAppPartner();

        click(driver, rwDatafirstApp1);
        value    = getText(driver, txtDetail_npwp);
        expected = arr[10];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[10], arr[10].length(),15);
        verifyValue(value.replace(".", "").replace("-", "")
                    ,expected);
        takeScreenshots.capture(driver);
    }
    public void verifyDataAppFormJenisDebitur() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] arr = readCSVFormApproval.fileCSVAppPartner();

        value    = getText(driver, txtDetail_jenisDebitur);
        expected = arr[11];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[11], arr[11].length(),1);
        verifyValue(value.substring(0,1),expected);
        takeScreenshots.capture(driver);
    }

    public void verifyDataAppFormNamaDebitur40karakter() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] arr = readCSVFormApproval.fileCSVAppPartner();

        value    = getText(driver, txtDetail_namaDebitur);
        expected = arr[12];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[12], arr[12].length(),60);
        verifyValue(value,expected);
        takeScreenshots.capture(driver);
    }
    public void verifyDataAppFormJangkaWaktuBawah() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] arr = readCSVFormApproval.fileCSVAppPartner();

        long parse = Long.parseLong(removeZero(arr[13]));
        value    = getText(driver, txtDetail_jangkaWaktu);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[13], arr[13].length(),3);
        verifyValue(value.replace(" Bulan", "")
                   ,expected);
        takeScreenshots.capture(driver);
        menuProductProfile();
        takeScreenshots.capture(driver);
        menuApprovalForm();
    }
    public void verifyDataAppFormInterestRateBawah() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] arr = readCSVFormApproval.fileCSVAppPartner();

        writeText(driver, txtSearch, no_app1);
        click(driver, rwDatafirstApp1);

        long parse = Long.parseLong(removeZero(arr[14])) / 100;
        value    = getText(driver, txtDetail_interestRate);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[14], arr[14].length(),5);
        value    = getText(driver, txtDetail_interestRate)
                   .replace("%", "")
                   .replace(".", "");
        verifyValue(value,expected);
        takeScreenshots.capture(driver);
        menuProductProfile();
        takeScreenshots.capture(driver);
        menuApprovalForm();
    }
    public void verifyDataAppFormPlafonBawah() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] arr = readCSVFormApproval.fileCSVAppPartner();

        writeText(driver, txtSearch, no_app1);
        click(driver, rwDatafirstApp1);

        long parse = Long.parseLong(removeZero(arr[15])) / 100;
        value    = getText(driver, txtDetail_plafon);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[15], arr[15].length(),15);
        value    = getText(driver, txtDetail_plafon)
                   .replace(".", "")
                   .replace("Rp", "")
                   .replace(",", "")
                   .replace(" ", "")
                   .trim();
        verifyValue(value,expected);
        takeScreenshots.capture(driver);
        menuProductProfile();
        takeScreenshots.capture(driver);
        menuApprovalForm();
    }

    public void verifyDataAppFormNamaDebitur39karakter() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] arr = readCSVFormApproval.fileCSVAppPartner();

        writeText(driver, txtSearch, no_app2);
        click(driver, rwDatafirstApp1);
        value    = getText(driver, txtDetail_namaDebitur);
        expected = arr[20];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[20], arr[20].length(),59);
        verifyValue(value,expected);
        takeScreenshots.capture(driver);
        menuProductProfile();
        takeScreenshots.capture(driver);
        menuApprovalForm();
    }
    public void verifyDataAppFormJangkaWaktuTengah() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] arr = readCSVFormApproval.fileCSVAppPartner();

        writeText(driver, txtSearch, no_app2);
        click(driver, rwDatafirstApp1);

        long parse = Long.parseLong(removeZero(arr[21]));
        value    = getText(driver, txtDetail_jangkaWaktu);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[21], arr[21].length(),3);
        verifyValue(value.replace(" Bulan", "")
                    ,expected);
        takeScreenshots.capture(driver);
        menuProductProfile();
        takeScreenshots.capture(driver);
        menuApprovalForm();
    }
    public void verifyDataAppFormInterestRateTengah() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] arr = readCSVFormApproval.fileCSVAppPartner();

        writeText(driver, txtSearch, no_app2);
        click(driver, rwDatafirstApp1);

        long parse = Long.parseLong(removeZero(arr[22])) / 10;
        value    = getText(driver, txtDetail_interestRate);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[22], arr[22].length(),5);
        value    = getText(driver, txtDetail_interestRate)
                   .replace("%", "")
                   .replace(".", "");
        verifyValue(value,expected);
        takeScreenshots.capture(driver);
        menuProductProfile();
        takeScreenshots.capture(driver);
        menuApprovalForm();
    }
    public void verifyDataAppFormPlafonTengah() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] arr = readCSVFormApproval.fileCSVAppPartner();

        writeText(driver, txtSearch, no_app2);
        click(driver, rwDatafirstApp1);

        long parse = Long.parseLong(removeZero(arr[23])) / 100;
        value    = getText(driver, txtDetail_plafon);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[23], arr[23].length(),15);
        value    = getText(driver, txtDetail_plafon)
                   .replace(".", "")
                   .replace("Rp", "")
                   .replace(",", "")
                   .replace(" ", "")
                   .trim();
        verifyValue(value,expected);
        takeScreenshots.capture(driver);
        menuProductProfile();
        takeScreenshots.capture(driver);
        menuApprovalForm();
    }

    public void verifyDataAppFormJangkaWaktuAtas() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] arr = readCSVFormApproval.fileCSVAppPartner();

        writeText(driver, txtSearch, no_app3);
        click(driver, rwDatafirstApp1);

        long parse = Long.parseLong(removeZero(arr[29]));
        value    = getText(driver, txtDetail_jangkaWaktu);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[29], arr[29].length(),3);
        verifyValue(value.replace(" Bulan", "")
                    ,expected);
        takeScreenshots.capture(driver);
        menuProductProfile();
        takeScreenshots.capture(driver);
        menuApprovalForm();
    }
    public void verifyDataAppFormInterestRateAtas() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] arr = readCSVFormApproval.fileCSVAppPartner();

        writeText(driver, txtSearch, no_app3);
        click(driver, rwDatafirstApp1);

        long parse = Long.parseLong(removeZero(arr[30])) / 100;
        value    = getText(driver, txtDetail_interestRate);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[30], arr[30].length(),5);
        value    = getText(driver, txtDetail_interestRate)
                   .replace("%", "")
                   .replace(".", "");
        verifyValue(value,expected);
        takeScreenshots.capture(driver);
        menuProductProfile();
        takeScreenshots.capture(driver);
        menuApprovalForm();
    }
    public void verifyDataAppFormPlafonAtas() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] arr = readCSVFormApproval.fileCSVAppPartner();

        writeText(driver, txtSearch, no_app3);
        click(driver, rwDatafirstApp1);

        long parse = Long.parseLong(removeZero(arr[31])) / 100;
        value    = getText(driver, txtDetail_plafon);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[31], arr[31].length(),15);
        value    = getText(driver, txtDetail_plafon)
                   .replace(".", "")
                   .replace("Rp", "")
                   .replace(",", "")
                   .replace(" ", "")
                   .trim();
        verifyValue(value,expected);
        takeScreenshots.capture(driver);
        menuProductProfile();
        takeScreenshots.capture(driver);
        menuApprovalForm();
    }

    public void verifyDataNpwpSama1Partner() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] arr = readCSVFormApproval.fileCSVAppPartner();

        writeText(driver, txtSearch, no_app4);
        click(driver, rwDatafirstApp1);
        value    = getText(driver, txtDetail_npwp);
        expected = arr[34];
        value3   = arr[39];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "NPWP AppNo "+no_app4+" : "+value);
        createInfo(extent_test_case, "Plafon AppNo "+no_app4+" : "+value3);
        verifyValue(value.replace(".", "").replace("-", "")
                    ,expected);
        value2 = value;
        takeScreenshots.capture(driver);

        click(driver, btnBackToTable);
        writeText(driver, txtSearch, no_app5);
        click(driver, rwDatafirstApp1);
        value    = getText(driver, txtDetail_npwp);
        expected = arr[42];
        value3   = arr[47];
        createInfo(extent_test_case, "NPWP AppNo "+no_app5+" : "+value);
        createInfo(extent_test_case, "Plafon AppNo "+no_app5+" : "+value3);
        verifyValue(value.replace(".", "").replace("-", "")
                    ,expected);
        value3 = value;
        takeScreenshots.capture(driver);
        createInfo(extent_test_case, "Print NPWP value AppNo : "+no_app4+" dan AppNo : "+no_app5);
        verifyValueData1Data2(value2.replace(".", "").replace("-", "")
                              ,value3.replace(".", "").replace("-", ""));
        menuExposureDebt();
        takeScreenshots.capture(driver);
        menuProductProfile();
        takeScreenshots.capture(driver);
        menuApprovalForm();
    }
    public void verifyDataNpwpSama2Partner() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] arr = readCSVFormApproval.fileCSVAppPartner();

        writeText(driver, txtSearch, no_app5);
        click(driver, rwDatafirstApp1);
        value    = getText(driver, txtDetail_npwp);
        expected = arr[42];
        value3   = arr[47];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "NPWP AppNo Partner 1 "+no_app5+" : "+value);
        createInfo(extent_test_case, "Plafon AppNo "+no_app5+" : "+value3);
        verifyValue(value.replace(".", "").replace("-", "")
                    ,expected);
        value2 = value;
        takeScreenshots.capture(driver);

        String[] arrDiff = readCSVFormApproval.fileCSVAppDiffPartner();
        click(driver, btnBackToTable);
        writeText(driver, txtSearch, arrDiff[8]);
        click(driver, rwDatafirstApp1);
        value    = getText(driver, txtDetail_npwp);
        expected = arrDiff[10];
        value3   = arrDiff[15];
        createInfo(extent_test_case, "NPWP AppNo Partner 2 "+arrDiff[10]+" : "+value);
        createInfo(extent_test_case, "Plafon AppNo "+arrDiff[10]+" : "+value3);
        verifyValue(value.replace(".", "").replace("-", "")
                    ,expected);
        value3 = value;
        takeScreenshots.capture(driver);
        createInfo(extent_test_case, "Print NPWP value AppNo Partner 1 : "+no_app5+" dan AppNo Partner 2 : "+arrDiff[10]);
        verifyValueData1Data2(value2.replace(".", "").replace("-", "")
                              ,value3.replace(".", "").replace("-", ""));
        menuExposureDebt();
        takeScreenshots.capture(driver);
        menuProductProfile2Partner();
        takeScreenshots.capture(driver);
        menuApprovalForm();
    }

    public void changeAllAppIdStatusApproved() throws IOException, InterruptedException {

        String[] arr;
        ReadCSVFormApproval readCSVFormApproval = new ReadCSVFormApproval();
        arr = readCSVFormApproval.fileCSVAppPartner();
        Long getCount = Arrays.stream(arr).count();

        int index = 8;
        for (int i = index; i < 25; i++) {
            if (i % index == 0) {
                clearText(driver, txtSearch);
                isPresent(driver, rwDatafirstApp1);
                writeText(driver, txtSearch, arr[i]);
                value = getText(driver, txtTbl_status).toLowerCase();
                if (value.equals("waiting for review")) {
                    click(driver, rwDatafirstApp1);

                    scrollDown(driver, txtArea_recommend);
                    scrollDown(driver, txtArea_recommend);
                    click(driver, optionlist_recommend);
                    click(driver, option_recommend);
                    click(driver, optionlist_recommend);Thread.sleep(Const.delay);
                    writeText(driver, txtAreaInput_recommend, "TEST AT Approval Form Recommended");

                    scrollUp(driver, body);Thread.sleep(100);
                    click(driver, btnSubmitApp);
                    index = index + 8;
                } else {
                    index = index + 8;
                }
            }
        }

        changeUserToApprove();
        index = 8;
        for (int i = index; i < 25; i++) {
            if (i % index == 0) {
                clearText(driver, txtSearch);
                isPresent(driver, rwDatafirstApp1);
                writeText(driver, txtSearch, arr[i]);
                value = getText(driver, txtTbl_status).toLowerCase();
                if (value.equals("waiting approval")) {
                    click(driver, rwDatafirstApp1);

                    scrollPageDown(driver, btnBackToTable);
                    scrollDown(driver, btnBackToTable);
                    scrollDown(driver, btnBackToTable);

                    writeText(driver, approval_note, "TEST AT Approval Form Approved");
                    value = getText(driver, option_approved);
                    click(driver, optionlist_approve);
                    click(driver, option_approved);
                    click(driver, By.xpath("//span[@data-select2-id=1]"));

                    scrollUp(driver, body);Thread.sleep(1000);
                    click(driver, btnSubmitApp);
                    index = index + 8;
                } else {
                    index = index + 8;
                }
            }
            clearText(driver, txtSearch);
        }
    }
    public void runJobRealization(){
        FileReaForm_BU connServer = new FileReaForm_BU();
        connServer.serverAkses();
    }

    // Rea Badan Usaha =================================================================================================
    public void verifyDataReaFormNoApp() throws IOException {
        String[] arrRea = readCSVFormApproval.fileCSVReaPartner();
        no_app1 = arrRea[30];
        no_app2 = arrRea[60];
        no_app3 = arrRea[90];

        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = 19;

        writeText(driver, inputSearch, no_app1);
        value    = getText(driver, txtTblNoApp);
        expected = arr[30];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[30], arr[30].length(),17);
        verifyValue(value,expected);
        takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormNama60Karakter() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        click(driver, rwDatafirstApp1);
        isPresent(driver, dtlAppId);

        value    = getText(driver, dtlDebtName);
        expected = arr[31];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[31], arr[31].length(),60);
        verifyValue(value,expected);
        takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormJenisDebitur() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCtgDebt);
        expected = arr[32];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[32], arr[32].length(),1);
        verifyValue(value,expected.trim()+"adan Usaha");takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormAlamat50Karakter() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlAddress);
        expected = arr[33];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[33], arr[33].length(),50);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormKelurahan40Karakter() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlAddWard);
        expected = arr[34];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[34], arr[34].length(),40);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormKecamatan40Karakter() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlAddDistrict);
        expected = arr[35];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[35], arr[35].length(),40);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormKodePos5Karakter() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlAddPostalCode);
        expected = arr[36];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[36], arr[36].length(),5);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormKodeDati4Karakter() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlAddCodeDATI_II);
        expected = readTestData.enumerasiDatiII(arr[37]);
//        expected = readTestData.testDataMaintananceTable()[5];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[37], arr[37].length(),4);
        verifyValue(value,expected);takeScreenshots.capture(driver);
//        value    = readTestData.testDataMaintananceTable()[4];
//        expected = arr[37];
//        verifyValue(value,expected);
    }
    public void verifyDataReaFormNoTelp13Karakter() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlTelp);
        expected = arr[38];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[38], arr[38].length(),13);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormNoAkteAwal30Karakter() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCertNO);
        expected = arr[39];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[39], arr[39].length(),30);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormTanggalBerdiri() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCertPublish);
        expected = arr[40];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[40], arr[40].length(),8);
        verifyValue(value.replace("/",""),expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormNoAkteTerahir30Karakter() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCertNOLatest);
        expected = arr[41];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[41], arr[41].length(),30);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormTanggalAkteTerakhir() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCertDeadline);
        expected = arr[42];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[42], arr[42].length(),8);
        verifyValue(value.replace("/",""),expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormBidangUsaha() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlFields);
        expected = readTestData.enumerasiBidangUsaha(arr[43]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[43], arr[43].length(),6);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormNoNpwp() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlNPWP);
        expected = arr[44];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[44], arr[44].length(),15);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormJangkaWaktu() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[45]));
        value    = getText(driver, dtlDuration);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[45], arr[45].length(),3);
        verifyValue(value,expected.trim()+" Bulan");takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormJenisKredit() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCtgCredit);
        expected = readTestData.enumerasiJenisKredit(arr[46]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[46], arr[46].length(),3);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPlafon() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[47]));
        value    = getText(driver, dtlLoanAmount);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[47], arr[47].length(),15);
        value    = getText(driver, dtlLoanAmount)
                   .replace(".", "")
                   .replace("Rp", "")
                   .replace(",", "");
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormInterestRate() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[48]));
        value    = getText(driver, dtlInterestRate);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[48], arr[48].length(),5);
        value    = getText(driver, dtlInterestRate)
                    .replace("%", "")
                    .replace(".", "")
                    .replace(",","");
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormNoPK100Karkter() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlPKNo);
        expected = arr[49];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[49], arr[49].length(),100);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormTanggalAkad() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlContact);
        expected = arr[50];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[50], arr[50].length(),8);
        verifyValue(value.replace("/",""),expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormTanggalAngsuran() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlInstalment_1);
        expected = arr[51];

        scrollDown(driver, dtlBtnApprove);Thread.sleep(100);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[51], arr[51].length(),8);
        verifyValue(value.replace("/",""),expected);takeScreenshots.capture(driver);

        scrollPageUp(driver, dtlBtnApprove);Thread.sleep(100);
        scrollUp(driver, dtlBtnApprove);Thread.sleep(100);
    }
    public void verifyDataReaFormJenisPenggunaan() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlUtil);
        expected = readTestData.enumerasiJenisPenggunaan(arr[52]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[52], arr[52].length(),1);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormSektorEkonomi() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlSector);
        expected = readTestData.enumerasiSektorEkonomi(arr[53]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[53], arr[53].length(),6);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormOmzet() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[54]));
        value    = getText(driver, dtlTurnOver);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[54], arr[54].length(),17);
        verifyValue(value.replace(".", "")
                         .replace("Rp", "")
                         .replace(",", "")
                    ,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormGoPublic() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlGoPublic);
        expected = readTestData.enumerasiGoPublic(arr[55]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[55], arr[55].length(),1);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormSandiGolongan() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlGroupDebt);
        expected = readTestData.enumerasiSandiGolongan(arr[56]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[56], arr[56].length(),9);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPenghasilanKotor() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[57]));
        value    = getText(driver, dtlIncomePerYear);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[57], arr[57].length(),15);
        verifyValue(value.replace(".", "")
                         .replace("Rp", "")
                         .replace(",", "")
                    ,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormBentukBadanUsaha() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlEntity);
        expected = readTestData.enumerasiBentukBadanUsaha(arr[58]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[58], arr[58].length(),1);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormTempatBeridiri30Karakter() throws InterruptedException, IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCertPlaces);
        expected = arr[59];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[59], arr[59].length(),30);
        verifyValue(value,expected);takeScreenshots.capture(driver);

        scrollPageUp(driver, dtlBtnApprove);Thread.sleep(100);
        scrollUp(driver, dtlBtnApprove);Thread.sleep(100);
        click(driver, dtlBtnBack);
    }

    public void verifyDataReaFormNama59Karakter() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        writeText(driver, inputSearch, no_app2);
        click(driver, rwDatafirstApp1);
        isPresent(driver, dtlAppId);

        value    = getText(driver, dtlDebtName);
        expected = arr[61];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[61], arr[61].length(),59);
        verifyValue(value,expected);
        takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormAlamat49Karakter() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlAddress);
        expected = arr[63];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[63], arr[63].length(),49);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormKelurahan39Karakter() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlAddWard);
        expected = arr[64];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[64], arr[64].length(),39);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormKecamatan39Karakter() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlAddDistrict);
        expected = arr[65];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[65], arr[65].length(),39);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormNoTelp12Karakter() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlTelp);
        expected = arr[68];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[68], arr[68].length(),12);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormNoAkteAwal29Karakter() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCertNO);
        expected = arr[69];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[69], arr[69].length(),29);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormNoAkteTerahir29Karakter() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCertNOLatest);
        expected = arr[71];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[71], arr[71].length(),29);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormNoPK99Karakter() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlPKNo);
        expected = arr[79];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[79], arr[79].length(),99);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormTempatBeridiri29Karakter() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVReaPartner();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCertPlaces);
        expected = arr[89];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[89], arr[89].length(),29);
        verifyValue(value,expected);takeScreenshots.capture(driver);

        scrollPageUp(driver, dtlBtnApprove);Thread.sleep(100);
        scrollUp(driver, dtlBtnApprove);Thread.sleep(100);
        click(driver, dtlBtnBack);
    }

    public void verifyDataReaFormNpwpKosong() throws IOException {
//        String[] arr = readCSVFormApproval.fileCSVReaPartner();
//        iRowPictName = iRowPictName + iSeq;
//
//        writeText(driver, inputSearch, no_app3);
//        click(driver, rwDatafirstApp1);
//        isPresent(driver, dtlAppId);
//
//        value    = getText(driver, dtlNPWP);
//        expected = arr[104];
//        status_testCase(iRowPictName, true, value);
//        createTest(iRowPictName, extent_test_case, extent);
//        verifyValue(value,expected);
//
//        long parse = Long.parseLong(removeZero(arr[107]));
//        value    = getText(driver, dtlLoanAmount);
//      expected = String.valueOf(parse);
//        value    = getText(driver, dtlLoanAmount)
//                                  .replace(".", "")
//                                  .replace("Rp", "")
//                                  .replace(",", "");
//        verifyValue(value,expected);
//        takeScreenshots.capture(driver);
        //        click(driver, dtlBtnBack);
        iRowPictName = iRowPictName + iSeq;

        status_testCase_skip(iRowPictName, true, "Skip");
        createTestSkip(iRowPictName, extent_test_case, extent);


    }

    // Rea Pengurus ====================================================================================================
    public void verifyDataReaFormPengurusNoApp() throws IOException {
        String[] arrRea = readCSVFormApproval.fileCSVPengurus();
        no_app1 = arrRea[21];
        no_app2 = arrRea[41];
        no_app3 = arrRea[61];

        iRowPictName = 60;

        writeText(driver, inputSearch, no_app1);
        click(driver, rwDatafirstApp1);
        isPresent(driver, dtlAppId);
        value    = getText(driver, txtDetail_NoApp);
        expected = arrRea[21];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arrRea[21], arrRea[21].length(),17);
        verifyValue(value,expected);
        takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusDataPengurus() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = iRowPictName + iSeq;

        scrollDown(driver, dtlBtnApprove); scrollDown(driver, dtlBtnApprove);Thread.sleep(100);
        List<WebElement> lists = driver.findElements(dtlListNoDataPengurus);
        value = "";
        for (WebElement webelement : lists) {
            if (webelement.getText().contains("3"))
              value = webelement.getText();
        }
        expected = "3";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Total Pengurus = "+value);
        verifyValue(value,expected);
        takeScreenshots.capture(driver);
    }

    public void verifyDataReaFormPengurusNoUrut() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = iRowPictName + iSeq;

        click(driver, dtlLabelDataPengurus);
        long parse = Long.parseLong(removeZero(arr[22]));
        value    = getText(driver, dtlValueNoUrut);
        expected = String.valueOf(parse);
        value2   = String.valueOf(arr[22].length());
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Total karakter nomor urut = "+value2+", Value from CSV = "+arr[22]);
        verifyValue(value,expected);
        takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusJumlahPengurus() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[23]));
        value    = getText(driver, dtlValueJmlPengurus);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[23], arr[23].length(),2);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusSandiJabatan1() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlValueSandiJabatan);
        expected = readTestData.enumerasiSandiJabatan(arr[24]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[24], arr[24].length(),1);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusPangsaKepemilikan() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[25]));
        value    = getText(driver, dtlValuePangsaPemilik);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[25], arr[25].length(),5);
        verifyValue(value.replace(".","").replace("%",""),expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusBentukPengurus() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = iRowPictName + iSeq;

        scrollPageDown(driver, dtlBtnApprove); Thread.sleep(100);
        value    = getText(driver, dtlValueBentukPengurus);
        expected = readTestData.enumerasiBentukPengurus(arr[26]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[26], arr[26].length(),1);
        verifyValue(value,expected);
        takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusModalDasar13() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[27]));
        value    = getText(driver, dtlValueModalDasar);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        value    = getText(driver, dtlValueModalDisetor)
                                   .replace(".", "")
                                   .replace("Rp", "")
                                   .replace(",", "")
                                   .trim();
        verifyLength(arr[27], arr[27].length(),13);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusModalDisetor13() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[28]));
        value    = getText(driver, dtlValueModalDisetor);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        value    = getText(driver, dtlValueModalDisetor)
                                   .replace(".", "")
                                   .replace("Rp", "")
                                   .replace(",", "")
                                   .trim();
        verifyLength(arr[28], arr[28].length(),13);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusModalDitempatkan13() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[29]));
        value    = getText(driver, dtlValueModalDitempat);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        value    = getText(driver, dtlValueModalDitempat)
                                   .replace(".", "")
                                   .replace("Rp", "")
                                   .replace(",", "")
                                   .trim();
        verifyLength(arr[29], arr[29].length(),13);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusNpwp() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlValueNpwp);
        expected = arr[30];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[30], arr[30].length(),15);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusNama60() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlValueNama);
        expected = arr[31];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[31], arr[31].length(),60);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusAlamat40() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlValueAlamat);
        expected = arr[32];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[32], arr[32].length(),40);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusKelurahan40() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlValueKelurahan);
        expected = arr[33];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[33], arr[33].length(),40);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPenguruskecamatan40() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlValueKecamatan);
        expected = arr[34];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[34], arr[34].length(),40);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusKodeDati() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlValueKdDati);
        expected = readTestData.enumerasiDatiII(arr[35]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[35], arr[35].length(),4);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusNoKtp() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlValueNoKtp);
        expected = arr[36];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[36], arr[36].length(),16);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusNoAkte30() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlValueNoAkte);
        expected = arr[37];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[37], arr[37].length(),30);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusTanggalLahir() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlValueTanggalLahir);
        expected = arr[38];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[38], arr[38].length(),8);
        verifyValue(value.replace("/",""),expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusTglAkte() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = iRowPictName + iSeq;

        scrollPageDown(driver, dtlBtnApprove); Thread.sleep(100);
        value    = getText(driver, dtlValueTanggalAkte);
        expected = arr[39];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[39], arr[39].length(),8);
        verifyValue(value.replace("/",""),expected);
        takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusKodeDatiTempatLahir() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlValueKdDatiLahir);
        expected = readTestData.enumerasiDatiII(arr[40]);
        value2   = String.valueOf(arr[40].length());
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[40], arr[40].length(),4);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusJenisKelaminB() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlValueJenisKel);
        expected = arr[41];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[41], arr[41].length(),1);
        verifyValue(value.substring(0,1),expected);takeScreenshots.capture(driver);
    }

    public void verifyDataReaFormPengurusSandiJabatan2() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurus2();
        no_app1 = arr[21];
        iRowPictName = iRowPictName + iSeq;

        scrollUp(driver, dtlBtnApprove);
        scrollUp(driver, dtlBtnBackRea);Thread.sleep(500);
        click(driver, dtlBtnBackRea);
        writeText(driver, inputSearch, no_app1);
        click(driver, rwDatafirstApp1);
        isPresent(driver, dtlAppId);
        scrollPageDown(driver, dtlBtnApprove);
        scrollPageDown(driver, dtlBtnApprove); Thread.sleep(100);

        click(driver, dtlLabelDataPengurus);
        value    = getText(driver, dtlValueSandiJabatan);
        expected = readTestData.enumerasiSandiJabatan(arr[24]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[24], arr[24].length(),2);
        verifyValue(value,expected);
        takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusModalDasar12() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurus2();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[27]));
        scrollPageDown(driver, dtlBtnApprove); Thread.sleep(100);
        value    = getText(driver, dtlValueModalDasar);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        value    = getText(driver, dtlValueModalDisetor)
                .replace(".", "")
                .replace("Rp", "")
                .replace(",", "")
                .trim();
        verifyLength(arr[27], arr[27].length(),12);
        verifyValue(value,expected);
        takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusModalDisetor12() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus2();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[28]));
        value    = getText(driver, dtlValueModalDisetor);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        value    = getText(driver, dtlValueModalDisetor)
                .replace(".", "")
                .replace("Rp", "")
                .replace(",", "")
                .trim();
        verifyLength(arr[28], arr[28].length(),12);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusModalDitempatkan12() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus2();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[29]));
        value    = getText(driver, dtlValueModalDitempat);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        value    = getText(driver, dtlValueModalDitempat)
                .replace(".", "")
                .replace("Rp", "")
                .replace(",", "")
                .trim();
        verifyLength(arr[29], arr[29].length(),12);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusNama59() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus2();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlValueNama);
        expected = arr[31];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[31], arr[31].length(),59);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusAlamat39() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus2();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlValueAlamat);
        expected = arr[32];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[32], arr[32].length(),39);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusKelurahan39() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus2();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlValueKelurahan);
        expected = arr[33];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[33], arr[33].length(),39);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPenguruskecamatan39() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus2();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlValueKecamatan);
        expected = arr[34];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[34], arr[34].length(),39);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusNoAkte29() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus2();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlValueNoAkte);
        expected = arr[37];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[37], arr[37].length(),29);
        verifyValue(value,expected);takeScreenshots.capture(driver);
    }
    public void verifyDataReaFormPengurusJenisKelaminM() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurus2();
        iRowPictName = iRowPictName + iSeq;

        scrollPageDown(driver, dtlBtnApprove); Thread.sleep(100);
        value    = getText(driver, dtlValueJenisKel);
        expected = arr[41];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[41], arr[41].length(),1);
        verifyValue(value.substring(0,1),expected);
        takeScreenshots.capture(driver);

        scrollUp(driver, dtlBtnApprove);Thread.sleep(500);
        scrollUp(driver, dtlBtnBackRea);Thread.sleep(500);
        click(driver, dtlBtnBackRea);
    }

    /*
    before :
    1. capture product profile kedua partner
    2. update exposure debt & capture

    test   :
    1. cek notif & capture
    2. cek reject by system & capture
    3. in test scenario ...

    after :
    1. update exposure to default
     */

}
