package elementsPage;

import capture.TakeScreenshot;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mongodb.client.model.ValidationAction;
import com.mongodb.client.model.ValidationLevel;
import createDataCSV.DataRepayment;
import jobs.DummyExpiredAppForm_BU;
import jobs.DummySuppDocAppForm_BU;
import lombok.SneakyThrows;
import org.apache.poi.ss.formula.ptg.Area2DPtgBase;
import org.junit.Ignore;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import readFile.ReadCSVFormApproval;
import readFile.ReadRepayFileCSV;
import runner.FormApprovalRunner;
import runner.FormRepaymentRunner;
import testData.ReadTestData;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
    ReadCSVFormApproval readCSVFormApproval = new ReadCSVFormApproval();

    String[] arrReq = readRepayFileCSV.fileCSVRepayReq();
    String[] arrSucc = readRepayFileCSV.fileCSVRepaySuccess();
    String[] arrErr = readRepayFileCSV.fileCSVRepayError();
    String[] arrApp = readCSVFormApproval.fileCSVAppForm();
    String expected, expected2, value, value2, value3, value4, value5, expected5, expected3, expected4, appEdited1, appEdited2, appEdited3, noapp1Reject, noapp2Reject, no_app1, no_app2, no_app3, no_app4, no_app5, no_app6, no_app7, no_app8, no_app9, no_app10;

    public static final By fieldUserName = By.xpath("//*[@id= 'uid']");
    public static final By fieldPassword = By.xpath("//*[@id= 'pwd']");
    public static final By login = By.xpath("//*[@id='login-button']");
    public static final By akunActive = By.xpath("//b[text()= 'Akun sedang aktif']");
    public static final By search = By.xpath("//*[@id='search']");
    public static final By mifDebName = By.xpath("//li[@ng-show= 'loandetails.clientName']/a");
    public static final By repayment = By.xpath("//div[@class= 'treeview-animated-element' and contains(., 'Repayment')]");
    public static final By resultSearch = By.xpath("(//div[@class= 'blockquoteresult']/span/a)[1]");
    public static final By appNum = By.xpath("(//th[text()= 'External Id']//following-sibling::td)[2]");
    public static final By loanId = By.xpath("//li[@class = 'active ng-binding'  and contains(text(), 'Akseleran') or contains(text(), 'Komunal')]");
    public static final By bcadOutstand = By.xpath("(//table [@class = 'table table-striped']/tbody/tr/td[5])[1]");
    public static final By bcadPokok = By.xpath("(//table [@class = 'table table-striped']/tbody/tr/td[1])[1]");
    public static final By bcadDate = By.xpath("(//th[contains(text(), 'Disbursement Date')]//following-sibling::td)[2]");
    public static final By user = By.xpath("//a[@class= 'nav-link waves-effect waves-light']/b");

    //repayment form list
    public static final By tglMskFileList = By.xpath("(//tr[@class = 'odd']/td[13])[1]");
    public static final By batchNoList = By.xpath("(//tr[@class = 'odd']/td[14])[1]");
    public static final By sourcelist = By.xpath("(//tr[@class = 'odd']/td[2])[1]");
    public static final By appNolist = By.xpath("(//tr[@class = 'odd']/td[3])[1]/a");
    public static final By appnoBulkRw1 = By.xpath("(//tr[@class = 'odd' or @class = 'even']/td[4])[1]/a");
    public static final By appnoBulkRw2 = By.xpath("(//tr[@class = 'odd' or @class = 'even']/td[4])[2]/a");
    public static final By partnerlist = By.xpath("(//tr[@class = 'odd']/td[4])[1]");
    public static final By partnerInBulk = By.xpath("(//tr[@class = 'odd']/td[5])[1]");
    public static final By partnerInModalBulk = By.xpath("//div[@id= 'content-approval']/table/tbody/tr[3]/th[2]/h5");
    public static final By modalBulk = By.xpath("//div[@class= 'modal-content']");
    public static final By debNamelist = By.xpath("(//tr[@class = 'odd']/td[5])[1]");
    public static final By statBayarlist = By.xpath("(//tr[@class = 'odd']/td[6])[1]");
    public static final By statuslist = By.xpath("(//tr[@class = 'odd']/td[7])[1]");
    public static final By tglBayarlist = By.xpath("(//tr[@class = 'odd']/td[8])[1]");
    public static final By totalBayarlist = By.xpath("(//tr[@class = 'odd']/td[9])[1]");
    public static final By totalTagihlist = By.xpath("(//tr[@class = 'odd']/td[10])[1]");
    public static final By statAmountlist = By.xpath("(//tr[@class = 'odd']/td[11])[1]");
    public static final By reasonlist = By.xpath("(//tr[@class = 'odd']/td[12])[1]");
    public static final By searchRepay = By.xpath("//input[@class= 'form-control search-custom fa-fa-search']");
    public static final By listNotFound = By.xpath("//td[@class= 'dataTables_empty']");
    public static final By btnBulk = By.xpath("//a[@class= 'btn btn-primary btn-circle waves-effect waves-light']");
    public static final By bulkRow1 = By.xpath("(//div[@class= 'round'])[2]");
    public static final By bulkCheckAll = By.xpath("(//div[@class= 'round'])[1]");
    public static final By bulkRow2 = By.xpath("(//div[@class= 'round'])[3]");
    public static final By navTotNomApprv = By.id("totalNominalApproved");
    public static final By totNomBlkAppr = By.xpath("(//h5[@class= 'font-weight-bold'])[4]");
    public static final By totAppBlkAppr = By.xpath("(//h5[@class= 'font-weight-bold'])[2]");
    public static final By dtlPrtnerBlkAppr = By.xpath("(//h5[@class= 'font-weight-bold'])[6]");
    public static final By bulkApprove = By.id("recommended");
    public static final By bulkReject = By.id("notRecommended");
    public static final By bulkApproveYes = By.id("submit-action");
    public static final By bulkApproveNo = By.xpath("//button[@class= 'btn btn-secondary cancel-action waves-effect waves-light']");
    public static final By bulkRejectNo = By.xpath("//button[@class= 'btn btn-secondary cancel-action waves-effect waves-light']");
    public static final By bulkRejectYes = By.xpath("//button[@class= 'btn btn-primary waves-effect waves-light']");
    public static final By statusDrop = By.xpath("//*[@id= 'select2-filter-status-container']");
    public static final By statWFA = By.xpath("//li[text()= 'Waiting for approval']");
    public static final By statPBR = By.xpath("//li[text()= 'Pending Batch Run']");
    public static final By statAPPR = By.xpath("//li[text()= 'Approved']");
    public static final By statRej = By.xpath("//li[text()= 'Rejected']");
    public static final By statApEx = By.xpath("//li[text()= 'Approval Expired']");
    public static final By statAll = By.xpath("//li[text()= 'All']");
    public static final By todayDateRepayment = By.xpath("//div[@title= 'Tanggal hari ini']");
    public static final By totalNomApprv = By.id("totalSummaryAmount");
    public static final By totNomBayar = By.id("totalAmountPayment");
    private static final By next = By.xpath("//a[@class='page-link' and text()= 'Next']");
    private static final By prev = By.xpath("//a[@class='page-link' and text()= 'Previous']");
    private static final By page2 = By.xpath("//a[@class= 'page-link' and text()= '2']");
    private static final By page1 = By.xpath("//a[@class= 'page-link' and text()= '1']");


    //repayment form detail
    public static final By dtlTglMsk = By.xpath("//label[text()= 'Tanggal Masuk File']//following-sibling::div/label");
    public static final By btnBackDtl = By.xpath("//i[@class= 'fa fa-arrow-left']");
    public static final By dtlBatchNo = By.xpath("//label[text()= 'Batch No.']//following-sibling::div/label");
    public static final By dtlNoApp = By.xpath("//label[text()= 'Nomor Aplikasi']//following-sibling::div/label");
    public static final By dtlDebName = By.xpath("//label[text()= 'Nama Debitur']//following-sibling::div/label");
    public static final By dtlPartner = By.xpath("//label[text()= 'Partner']//following-sibling::div/label");
    public static final By dtlNoBayar = By.xpath("//label[text()= 'Nomor Pembayaran']//following-sibling::div/label");
    public static final By dtlStatAmount = By.xpath("//label[text()= 'Status Amount Repayment']//following-sibling::div/button");
    public static final By dtlStatus = By.xpath("//label[text()= 'Status']//following-sibling::div/label");
    public static final By dtlApprvBy = By.xpath("//label[text()= 'Approved by']//following-sibling::div/label");
    public static final By dtltglApprv = By.xpath("//label[text()= 'Tanggal Approval']//following-sibling::div/label");
    public static final By dtlRejReason = By.xpath("//label[text()= 'Type Reject Reason']//following-sibling::div/label");
    public static final By dtlDesc = By.xpath("//label[text()= 'Deskripsi']//following-sibling::div/label");
    public static final By dtlTglBayar = By.xpath("//label[text()= 'Tanggal Pembayaran']//following-sibling::div/label");
    public static final By dtlTotBayar = By.xpath("//label[text()= 'Total Pembayaran']//following-sibling::div/label");
    public static final By dtlBayarPok = By.xpath("//label[text()= 'Pembayaran Pokok']//following-sibling::div/label");
    public static final By dtlBayarBunga = By.xpath("//label[text()= 'Pembayaran Bunga']//following-sibling::div/label");
    public static final By dtlBayarDendaPartner = By.xpath("(//label[text()= 'Pembayaran Denda']//following-sibling::div/label)[1]");
    public static final By dtlBayarDendaBcad = By.xpath("(//label[text()= 'Pembayaran Denda']//following-sibling::div/label)[2]");
    public static final By dtlAddInt = By.xpath("//label[text()= 'Additional Interest']//following-sibling::div/label");
    public static final By dtlStatBayar = By.xpath("//label[text()= 'Status Pembayaran']//following-sibling::div/button");
    public static final By dtlTglBerjalan = By.xpath("//label[text()= 'Tanggal Pembayaran Bulan Berjalan']//following-sibling::div/label");
    public static final By dtlTotTagih = By.xpath("//label[text()= 'Total Tagihan']//following-sibling::div/label");
    public static final By dtlPokBerjalan = By.xpath("//label[text()= 'Pembayaran Pokok Bulan Berjalan']//following-sibling::div/label");
    public static final By dtlBungBerjalan = By.xpath("//label[text()= 'Pembayaran Bunga Bulan Berjalan']//following-sibling::div/label");
    public static final By dtlDendBerjalan = By.xpath("//label[text()= 'Pembayaran Denda']//following-sibling::div/label");
    public static final By dtlDendaBcad = By.xpath("(//label[text()= 'Pembayaran Denda']//following-sibling::div/label)[2]");
    public static final By dtlAddIntBcad = By.xpath("(//label[text()= 'Additional Interest']//following-sibling::div/label)[2]");
    public static final By btnApprove = By.xpath("//button[text()= 'Approve']");
    public static final By btnApproveYa = By.xpath("//button[@class= 'btn btn-sm btn-circle btn-primary btn-lg splash waves-effect waves-light']");
    public static final By btnApproveTidak = By.xpath("//button[@class= 'btn btn-sm btn-circle btn-outline-primary btn-lg waves-effect waves-light']");
    public static final By btnReject = By.xpath("//button[text()= 'Reject']");
    public static final By btnRejectYa = By.xpath("//button[@class= 'btn btn-lg btn-circle btn-primary waves-effect waves-light']");
    public static final By btnRejectTidak = By.xpath("//button[@class='btn btn-lg btn-circle btn-outline-primary waves-effect waves-light']");
    public static final By formRejectReas = By.xpath("(//div[@class= 'form-group']/label)[1]");
    public static final By formRejectDesc = By.xpath("(//div[@class= 'form-group']/label)[2]");
    public static final By optiRejectRea = By.id("rejectReasons");
    public static final By rejectDescField = By.id("rejectDescription");
    public static final By optiRejectRea1 = By.xpath("//*[@id= 'select2-rejectReasons-results']/li[2]");
    public static final By optiRejectReaNull = By.xpath("//*[@id= 'select2-rejectReasons-results']/li[1]");
    public static final By editBayarDendaField = By.xpath("//input[@name= 'finePartner']");
    public static final By optiRejectReaDropdown = By.id("select2-rejectReasons-container");
    public static final By editRepayment = By.id("editRepayment");
    public static final By updateRepayment = By.id("updateRepayment");
    public static final String char100 = "100CHARACTERkjnkajsnkjdansdaidnadnasiudnauiwdiaunwdiuafkahwfaiowujdijaiwfjwioaefhuiwhefiuwueifhuiwfi";
    public static final String char99 = "99CHARACTERkjnkajsnkjdansdaidnadnasiudnauiwdiaunwdiuafkahwfaiowujdijaiwfjwioaefhuiwhefiuwueifhuiwfi";
    public static final String listReject = "Choose TypeNominal Pokok Tidak ValidNominal Bunga Tidak ValidData Repayment Tidak ValidTanggal Pembayaran Tidak Valid (Lebih kecil dari tanggal pembayaran terakhir)Nomor Pembayaran Sudah pernah TercatatAplikasi Tidak Valid (Pinjaman sudah tidak aktif)Nominal Pembayaran Lebih Besar dari Nominal PinjamanPembayaran Bunga Tidak Sesuai Jadwal Pembayaran";

    //Mifos
    public static final By bottomMifos = By.xpath("//a[contains(text(), ' Release Version:  18.03.01.RELEASE | Mifos X Release Date:  30/Mar/2018 ')]");
    public static final By mifTrx = By.xpath("//a[contains(text(), 'Transactions')]");
    public static final By mifRepSche = By.xpath("//a[contains(text(), 'Repayment Schedule')]");
    public static final By mifTrxDate = By.xpath("//td[@class= 'pointer ng-binding'][3]");
    public static final By mifPokJln = By.xpath("//td[@class= 'pointer ng-binding'][5]");
    public static final By mifBungaJln = By.xpath("//td[@class= 'pointer ng-binding'][7]");
    public static final By mifDenJln = By.xpath("//td[@class= 'pointer ng-binding'][9]");
    public static final By mifTotTagih = By.xpath("//td[@class= 'pointer ng-binding'][10]");
    public static final By head = By.xpath("//head");
    public static final By bulkEdit = By.xpath("//a[@class= 'btn btn-outline-primary btn-circle waves-effect waves-light']");
    public static final By bulkEditChange = By.id("recommended");
    public static final By bulkEditChangeYes = By.id("submit-action");
    public static final By bulkEditChangeNo = By.xpath("//button[@class= 'btn btn-secondary cancel-action waves-effect waves-light']");
    public static final By mifCheckAccrual = By.xpath("//div[@class= 'pull-right ng-scope']//input");
    public static final By fullScreenTimeWeb = By.id("full-clk");

    //repayment Page
    public static final By sourceDropDown = By.xpath("//span[@id='select2-source-container']");
    public static final By sortByStatus = By.xpath("//th[text()= 'Status']");
    public static final By sortByTglByr = By.xpath("//th[text()= 'Tanggal Pembayaran']");

    public static final By sourceAll = By.xpath("//li[@role=\"option\"][text()=\"All\"]");
    public static final By sourceLos = By.xpath("//li[@role=\"option\"][text()=\"LOS\"]");
    public static final By sourceNikel = By.xpath("//li[@role=\"option\"][text()=\"NIKEL\"]");
    public static final By sourceByAll = By.xpath("//span[@id='select2-source-container'][text() = 'All']");
    public static final By sourceByNikel = By.xpath("//span[@id='select2-source-container'][text() = 'NIKEL']");
    public static final By sourceByLOS = By.xpath("//span[@id='select2-source-container'][text() = 'LOS']");
    public static final By sourceRow1 = By.xpath("//tr[@class = 'odd'][1]//td[2]");
    public static final By pelunasanDropDown = By.xpath("//span[@id='select2-filter-payment-container']");

    public static final By pelunasanByYes = By.xpath("//span[@id='select2-filter-payment-container'][text() = 'Yes']");
    public static final By pelunasanByNo = By.xpath("//span[@id='select2-filter-payment-container'][text() = 'No']");
    public static final By pelunasanByInsurance = By.xpath("//span[@id='select2-filter-payment-container'][text() = 'Insurance']");
    public static final By pelunasanByAdvance = By.xpath("//span[@id='select2-filter-payment-container'][text() = 'Advance']");
    public static final By pelunasanAll = By.xpath("//li[@role='option'][text()='All']");
    public static final By pelunasanYes = By.xpath("//li[@role='option'][text()='Yes']");
    public static final By pelunasanNo = By.xpath("//li[@role='option'][text()='No']");
    public static final By pelunasanInsu = By.xpath("//li[@role='option'][text()='Insurance']");
    public static final By pelunasanAdvan = By.xpath("//li[@role='option'][text()='Advance']");
    public static final By pelunasanBy = By.xpath("//span[@id = 'select2-filter-payment-container']");
    public static final By statusDropDown = By.xpath("//span[@id='select2-filter-status-container']");
    public static final By statusAll = By.xpath("//li[@role='option'][text()='All']");
    public static final By statusWait = By.xpath("//li[@role='option'][text()='Waiting for approval']");
    public static final By statusPending = By.xpath("//li[@role='option'][text()='Pending Batch Run']");
    public static final By statusApproved = By.xpath("//li[@role='option'][text()='Approved']");
    public static final By statusRejected = By.xpath("//li[@role='option'][text()='Rejected']");
    public static final By statusAppExp = By.xpath("//li[@role='option'][text()='Approval Expired']");
    public static final By statAmountDropDown = By.xpath("//span[@id='select2-filter-status-repayment-container']");
    public static final By statAmountAll = By.xpath("//li[@role='option'][text()='All']");
    public static final By statAmountSesuai = By.xpath("//li[@role='option'][text()='Sesuai']");
    public static final By statAmountKurangBayar = By.xpath("//li[@role='option'][text()='Kurang Bayar']");
    public static final By statAmountLebihBayar = By.xpath("//li[@role='option'][text()='Lebih Bayar']");
    public static final By searchField = By.xpath("//input[@placeholder='Search'][@type='text']");
    public static final By sourceTbl = By.xpath("(//tr[@class='odd']//td[2])[1]");
    public static final By appNoTbl = By.xpath("(//tr[@class='odd']//td[3]/a)[1]");
    public static final By partnerTbl = By.xpath("(//tr[@class='odd']//td[4])[1]");
    public static final By debNameTbl = By.xpath("(//tr[@class='odd']//td[5])[1]");
    public static final By pembayaranTbl = By.xpath("(//tr[@class='odd']//td[5])[1]");
    public static final By statusTbl = By.xpath("(//tr[@class='odd']//td[5])[1]");
    public static final By datePembayaranTbl = By.xpath("(//tr[@class='odd']//td[5])[1]");
    public static final By totalPembayaranTbl = By.xpath("(//tr[@class='odd']//td[5])[1]");
    public static final By totalTagihanTbl = By.xpath("(//tr[@class='odd']//td[5])[1]");
    public static final By statusAmountTbl = By.xpath("(//tr[@class='odd']//td[5])[1]");
    public static final By dateCosumeTbl = By.xpath("(//tr[@class='odd']//td[5])[1]");
    public static final By batchNoTbl = By.xpath("(//tr[@class='odd']//td[5])[1]");
    public static final By partnerOption = By.xpath("//ul[@id ='select2-filterSource-results']");
    public static final By partnerDropDown = By.xpath("//span[@id ='select2-filterSource-container']");
    public static final By partnerAll = By.xpath("//li[@role='option'][text()='All']");
    public static final By partnerAkseleran = By.xpath("//li[contains(@data-select2-id,'L000001')]");
    public static final By partnerIndodana = By.xpath("//li[contains(@data-select2-id,'L000007')]");
    public static final By amountRepaymentDropDown = By.xpath("//*[@id ='select2-filter-status-repayment-container']");
    public static final By amountRepaymentOption = By.xpath("//ul[@id='select2-filter-status-repayment-results']");
    public static final By amountRepaymentAll = By.xpath("//li[@role='option'][text()='All']");
    public static final By amountRepaymentSesuai = By.xpath("//li[@role='option'][text()='Sesuai']");
    public static final By amountRepaymentKurangBayar = By.xpath("//li[@role='option'][text()='Kurang Bayar']");
    public static final By amountRepaymentLebihBayar = By.xpath("//li[@role='option'][text()='Lebih Bayar']");
    public static final By batchNoDropDown = By.xpath("//*[@id='select2-filter-batch-number-container']");
    public static final By batchNoOption = By.xpath("//ul[@id='select2-filter-batch-number-results']");
    public static final By batchNoAll = By.xpath("[//li[@role='option'][text()='All']");
    public static final By batchNo1 = By.xpath("//ul[@id='select2-filter-batch-number-results']//li[2]");
    public static final By batchNo2 = By.xpath("//ul[@id='select2-filter-batch-number-results']//li[3]");
    public static final By batchNo3 = By.xpath("//ul[@id='select2-filter-batch-number-results']//li[4]");
    public static final By batchNo4 = By.xpath("//ul[@id='select2-filter-batch-number-results']//li[5]");
    public static final By batchNo5 = By.xpath("//ul[@id='select2-filter-batch-number-results']//li[6]");
    public static final By nextPage = By.xpath("//li[@id = 'dataTable_next']//a");
    public static final By previousPage = By.xpath("//li[@id = 'dataTable_previous']//a");
    int barisReq = 7;
    int barisErr = 9;
    int barisSucc = 13;
    int barisAp = 8;
    private static WebDriver driver = FormRepaymentRunner.driver;
    int iSeq = 1;
    int iRowPictName;
    TakeScreenshot takeScreenshot = new TakeScreenshot();
    ReadTestData readTestData = new ReadTestData();

    public RepaymentFilePage() throws IOException {
    }

    public void loginRepayment(WebDriver conn) throws InterruptedException {
        driver = conn;
        driver.get(mifosE2ESup);
        driver.manage().window().maximize();
        driver.findElement(Const.btnDetails).click();
        driver.findElement(Const.btnUnsafe).click();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(mifosE2E);
        driver.findElement(Const.btnDetails).click();
        driver.findElement(Const.btnUnsafe).click();
        driver.findElement(fieldUserName).sendKeys("uat");
        driver.findElement(fieldPassword).sendKeys("uat");
        driver.findElement(login).click();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(urlE2E);
        driver.findElement(Const.btnDetails).click();
        driver.findElement(Const.btnUnsafe).click();
        driver.findElement(Const.userId).sendKeys(Const.e2eAllIn_u);
        driver.findElement(Const.pwd).sendKeys(Const.e2eAllIn_pw);
        driver.findElement(Const.btnLogin).click();
        try {
            WebElement accOn = driver.findElement(akunActive);
            if (accOn.isDisplayed()) {
                driver.findElement(Const.userId).sendKeys(Const.e2eAllIn_u);
                driver.findElement(Const.pwd).sendKeys(Const.e2eAllIn_pw);
                driver.findElement(Const.btnLogin).click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("login sukses");
        }
//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.get("https://www.timeanddate.com/worldclock/indonesia/jakarta");
//        click(driver, fullScreenTimeWeb);
//        changeTab(driver, 2);
    }

    public void changeTab(WebDriver driver, int tab) {
        ArrayList<String> newTb = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(tab));
    }

    public void searchAppID(String arrReq) {
        clearText(driver, search);
        writeText(driver, search, arrReq);
        driver.findElement(search).sendKeys(Keys.ENTER);
        click(driver, resultSearch);
    }

    public void noAppSesuai() throws InterruptedException, IOException {
        loginRepayment(driver);
        changeTab(driver, 1);
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

        if (getText(driver, loanId).contains("Akseleran")) {
            value = String.valueOf(Long.parseLong(getText(driver, loanId).substring(10, 19)));
        } else if (getText(driver, loanId).contains("Komunal")) {
            value = String.valueOf(Long.parseLong(getText(driver, loanId).substring(9, 18)));
        }
        expected = arrSucc[14];
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
        Long interest = Long.parseLong(arrSucc[25].replace(".000000", "").replace("-", ""));
        Long outValue = Long.parseLong(getText(driver, bcadOutstand).replace(",", ""));
        Long result = outValue + interest;
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

        Long val1 = Long.parseLong(arrSucc[24].replace(".000000", ""));
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
    public void openRepayMenu() throws InterruptedException {


//        loginAllIn(driver);
        loginRepayment(driver);
        click(driver, repayment);

    }

    public void dtlTgMskFile() {
        iRowPictName = iRowPictName + iSeq;
        scrollIntoView(driver, appNolist);
        click(driver, appNolist);
        createTest(iRowPictName, extent_test_case, extent);
        String format = "dd MMM yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        expected = simpleDateFormat.format(new Date());
        value = getText(driver, dtlTglMsk).substring(0, 11);
        createInfo(extent_test_case, "Tanggal hari ini : " + expected);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);

    }

    public void dtlBatchNo() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
//        createTest(iRowPictName, extent_test_case, extent);
//        value = getText(driver, batchNoList);
//        expected = "BELOM";
//
    }

    public void dtlNoApp() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        value = getText(driver, dtlNoApp);
        expected = arrReq[7];
        takeScreenshot.capture(driver);
        verifyValue(expected, value);

    }

    public void dtlNoDebitur() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        value = getText(driver, dtlDebName);
        takeScreenshot.capture(driver);
        changeTab(driver, 1);
        searchAppID(arrReq[7]);
        expected = getText(driver, mifDebName);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
        changeTab(driver, 2);
    }

    public void dtlPartner() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        value = getText(driver, dtlPartner);
        expected = "AKSELERAN";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void dtlNoBayar() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        value = getText(driver, dtlNoBayar);
        expected = arrReq[8];
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void dtlStatKurangBayar() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, btnBackDtl);
        writeText(driver, searchRepay, arrReq[7 + barisReq]);
        click(driver, appNolist);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(2, "suc");
        value = getText(driver, dtlStatAmount);
        expected = "Kurang Bayar";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void dtlStatPasBayar() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, btnBackDtl);
        writeText(driver, searchRepay, arrReq[7 + barisReq * 2]);
        click(driver, appNolist);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(3, "suc");
        value = getText(driver, dtlStatAmount);
        expected = "Sesuai";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void dtlStatLebihBayar() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, btnBackDtl);
        writeText(driver, searchRepay, arrReq[7]);
        click(driver, appNolist);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "suc");
        value = getText(driver, dtlStatAmount);
        expected = "Lebih Bayar";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void verifyStatAfterConsume() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, btnBackDtl);
        writeText(driver, searchRepay, arrReq[7]);
        click(driver, appNolist);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        value = getText(driver, dtlStatus);
        expected = "Waiting for Approval";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void verifyApprovedbyAfterConsume() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        value = getText(driver, dtlApprvBy);
        expected = "-";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void verifyTglApprovalAfterCons() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        value = getText(driver, dtltglApprv);
        expected = "-";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void verifyTypeRejectReason() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        value = getText(driver, dtlRejReason);
        expected = "-";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void verifyDescAfterConsume() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        value = getText(driver, dtlDesc);
        expected = "-";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void verifyTglBayar() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        String inputDate = getText(driver, dtlTglBayar);
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDate date = LocalDate.parse(inputDate, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String outputDate = outputFormatter.format(date);
        value = outputDate;
        expected = arrReq[9];
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void cardTotPem() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        value = getText(driver, dtlTotBayar).replace("Rp ", "").replace(".", "").replace(",", "");
        long pokok = Long.parseLong(arrReq[10]);
        long bunga = Long.parseLong(arrReq[11]);
        expected = String.valueOf(pokok + bunga);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void cardTotPemDend0() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        createTable(2, "req");
        value = getText(driver, dtlTotBayar).replace("Rp ", "").replace(".", "").replace(",", "");
        long pokok = Long.parseLong(arrReq[10 + barisReq]);
        long bunga = Long.parseLong(arrReq[11 + barisReq]);
        expected = String.valueOf(pokok + bunga);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void cardPempok() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        value = getText(driver, dtlBayarPok).replace("Rp ", "").replace(".", "").replace(",", "");
        long pokok = Long.parseLong(arrReq[10]);
        expected = String.valueOf(pokok);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void cardPempoknopok0() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, btnBackDtl);
        writeText(driver, searchRepay, arrReq[7 + barisReq]);
        click(driver, appNolist);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(2, "req");
        value = getText(driver, dtlBayarPok).replace("Rp ", "").replace(".", "").replace(",", "");
        long pokok = Long.parseLong(arrReq[10 + barisReq]);
        expected = String.valueOf(pokok);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void cardPempokbung() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        value = getText(driver, dtlBayarBunga).replace("Rp ", "").replace(".", "").replace(",", "");
        long bunga = Long.parseLong(arrReq[11]);
        expected = String.valueOf(bunga);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void cardPempokbung0() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        createTable(2, "req");
        value = getText(driver, dtlBayarBunga).replace("Rp ", "").replace(".", "").replace(",", "");
        long bunga = Long.parseLong(arrReq[11 + barisReq]);
        expected = String.valueOf(bunga);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void cardPempokden() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        value = getText(driver, dtlBayarDendaPartner).replace("Rp ", "").replace(".", "").replace(",", "");
        long denda = Long.parseLong(arrReq[12]);
        expected = String.valueOf(denda);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void cardPempokden0() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        createTable(2, "req");
        value = getText(driver, dtlBayarDendaPartner).replace("Rp ", "").replace(".", "").replace(",", "");
        long denda = Long.parseLong(arrReq[12 + barisReq]);
        expected = String.valueOf(denda);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void cardPempokaddInt() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "additional Interest tidak ada pada partner akseleran");
    }

    public void cardPempokaddInt0() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "additional interest tidak ada pada partner akseleran");
    }

    public void cardPemN() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, btnBackDtl);
        writeText(driver, searchRepay, arrReq[7 + barisReq * 3]);
        click(driver, appNolist);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(4, "req");
        value = getText(driver, dtlStatBayar);
        expected = "No";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void cardPemY() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        value = getText(driver, dtlStatBayar);
        expected = "Yes";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void cardPemI() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, btnBackDtl);
        writeText(driver, searchRepay, arrReq[7 + barisReq * 6]);
        click(driver, appNolist);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(7, "req");
        value = getText(driver, dtlStatBayar);
        expected = "Insurance";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void cardPemA() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Pembayaran Advance belum terealisasi pada partner ini!");
//        createTest(iRowPictName, extent_test_case, extent);
//        value = getText(driver, dtlStatBayar);
//        expected = "Advance";
//        takeScreenshot.capture(driver);
//        verifyValue(expected, value);
    }

    public void listTglbayar() throws InterruptedException, IOException {
        iRowPictName = 1;
        writeText(driver, searchRepay, arrReq[7]);
        Thread.sleep(300);
        createTest(iRowPictName, extent_test_case, extent);
        scrollIntoView(driver, tglBayarlist);
        String inputDate = getText(driver, tglBayarlist);
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(inputDate, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String outputDate = outputFormatter.format(date);
        createTable(1, "req");
        expected = arrReq[9];
        value = outputDate;
        takeScreenshot.capture(driver);
        verifyValue(expected, value);

    }

    public void listTotPem() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        scrollIntoView(driver, totalBayarlist);
        value = getText(driver, totalBayarlist).replace("Rp. ", "").replace(".", "").replace(",", "");
        long pokok = Long.parseLong(arrReq[10]) / 100;
        long bunga = Long.parseLong(arrReq[11]) / 100;
        createTable(1, "req");
        expected = String.valueOf(pokok + bunga);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void listTotPemDen0() throws InterruptedException, IOException {
        iRowPictName = iRowPictName + iSeq;
        clearText(driver, searchRepay);
        writeText(driver, searchRepay, arrReq[7 + barisReq * 5]);
        Thread.sleep(300);
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        value = getText(driver, totalBayarlist).replace("Rp. ", "").replace(".", "").replace(",", "");
        long pokok = Long.parseLong(arrReq[10 + barisReq * 5]) / 100;
        long bunga = Long.parseLong(arrReq[11 + barisReq * 5]) / 100;
        createTable(6, "req");
        expected = String.valueOf(pokok + bunga);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void listTotTagihan() throws InterruptedException, IOException {
        iRowPictName = iRowPictName + iSeq;
        clearText(driver, searchRepay);
        writeText(driver, searchRepay, arrReq[7]);
        Thread.sleep(300);
        scrollIntoView(driver, batchNoList);
        createTest(iRowPictName, extent_test_case, extent);
        value = getText(driver, totalTagihlist).replace("Rp. ", "").replace(".", "").replace(",", "");
        long outstand = Long.parseLong(arrReq[10].replace(".000000", "")) / 100;
        createTable(1, "req");
        expected = String.valueOf(outstand);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
        changeTab(driver, 1);
        searchAppID(arrReq[7]);scrollIntoView(driver, bottomMifos);
        click(driver, mifRepSche);
        takeScreenshot.capture(driver);
        createInfo(extent_test_case, "Schedule pada Mifos");
    }

    public void listStatKurangBayar() throws InterruptedException, IOException {
        iRowPictName = iRowPictName + iSeq;
        clearText(driver, searchRepay);
        writeText(driver, searchRepay, arrReq[7 + barisReq]);
        Thread.sleep(300);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(2, "suc");
        value = getText(driver, statAmountlist);
        expected = "Kurang Bayar";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void listStatSesuai() throws InterruptedException, IOException {
        iRowPictName = iRowPictName + iSeq;
        clearText(driver, searchRepay);
        writeText(driver, searchRepay, arrReq[7 + barisReq * 2]);
        Thread.sleep(300);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(3, "suc");
        value = getText(driver, statAmountlist);
        expected = "Sesuai";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void listStatLebih() throws InterruptedException, IOException {
        iRowPictName = iRowPictName + iSeq;
        clearText(driver, searchRepay);
        writeText(driver, searchRepay, arrReq[7]);
        Thread.sleep(300);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "suc");
        value = getText(driver, statAmountlist);
        expected = "Lebih Bayar";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void listTglMasukFile() throws InterruptedException, IOException {
        iRowPictName = iRowPictName + iSeq;
        clearText(driver, searchRepay);
        writeText(driver, searchRepay, arrReq[7]);
        Thread.sleep(300);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        String format = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        expected = simpleDateFormat.format(new Date());
        value = getText(driver, tglMskFileList).substring(0, 10);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void listBatchNo() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
//        createTest(iRowPictName, extent_test_case, extent);
//        value = getText(driver, batchNoList);
//        expected = "BELOM";

    }

    public void listStatWaitforApp() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        value = getText(driver, statuslist);
        expected = "Waiting for Approval";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void cardTglPemBulBerjalan() throws ParseException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        value = getText(driver, dtlTglBerjalan);
        takeScreenshot.capture(driver);
        changeTab(driver, 1);
//        String input = "09 April 2023";
        String input2 = getText(driver, mifTrxDate);
        System.out.println(input2);
        SimpleDateFormat simpleDateIn = new SimpleDateFormat("dd MMMM yyyy");
        SimpleDateFormat simpleDateOut = new SimpleDateFormat("dd MMM yyyy");
        try {
            Date date = simpleDateIn.parse(input2);
            expected = simpleDateOut.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
        click(driver, mifRepSche);
        scrollIntoView(driver, bottomMifos);
        takeScreenshot.capture(driver);
        createInfo(extent_test_case, "Schedule pada Mifos");
        changeTab(driver, 2);
    }

    public void cardTotTagih() {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        long totTagihLos = Long.parseLong(getText(driver, dtlTotTagih).replace("Rp ", "").replace(".", "").replace(",", "")) / 100;
        value = String.valueOf(totTagihLos);
        takeScreenshot.capture(driver);
        changeTab(driver, 1);
        expected = getText(driver, mifTotTagih).replace(",", "");
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
        changeTab(driver, 2);
    }

    public void cardPemPokBulBerjalan() {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        long pokLos = Long.parseLong(getText(driver, dtlPokBerjalan).replace("Rp ", "").replace(".", "").replace(",", "")) / 100;
        value = String.valueOf(pokLos);
        takeScreenshot.capture(driver);
        changeTab(driver, 1);
        expected = getText(driver, mifPokJln).replace(",", "");
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
        scrollIntoView(driver, bottomMifos);
        click(driver, mifRepSche);
        takeScreenshot.capture(driver);
        createInfo(extent_test_case, "Schedule pada Mifos");
        changeTab(driver, 2);
    }

    public void cardPemBungBulBerjalan() {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        long bungLos = Long.parseLong(getText(driver, dtlDendaBcad).replace("Rp ", "").replace(".", "").replace(",", "")) / 100;
        value = String.valueOf(bungLos);
        takeScreenshot.capture(driver);
        changeTab(driver, 1);
        expected = getText(driver, mifBungaJln).replace(",", "");
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
        scrollIntoView(driver, bottomMifos);
        click(driver, mifRepSche);
        takeScreenshot.capture(driver);
        createInfo(extent_test_case, "Schedule pada Mifos");
        changeTab(driver, 2);
    }

    public void cardPemDenBulBerjalan() {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        long dendaLos = Long.parseLong(getText(driver, dtlDendaBcad).replace("Rp ", "").replace(".", "").replace(",", "")) / 100;
        value = String.valueOf(dendaLos);
        value2 = getText(driver, dtlNoApp);
        takeScreenshot.capture(driver);
        changeTab(driver, 1);
        searchAppID(value2);
        scrollIntoView(driver, bottomMifos);
        click(driver, mifTrx);
        expected = getText(driver, mifDenJln);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
        changeTab(driver, 2);
    }

    public void cardAddIntBulBerjalan() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Tidak Terdapat AddInt...");
    }

    public void klikApprv() throws InterruptedException {
        iRowPictName = 46;
        click(driver, btnBackDtl);
        clearText(driver, searchRepay);
        writeText(driver, searchRepay, arrReq[7 + barisReq * 7]);
        click(driver, appNolist);
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, btnApprove);
//        List<WebElement> list = driver.findElements(By.xpath("//div[@class= 'mt-5 float-sm-right p-3']/button"));
//        for (WebElement button : list) {
//            value = button.getText().replace("\n", "");
//            System.out.println(button.getText());
//        }
        By buttonNo = By.xpath("//div[@class= 'mt-5 float-sm-right p-3']/button[1]");
        By buttonYes = By.xpath("//div[@class= 'mt-5 float-sm-right p-3']/button[2]");
        value = getText(driver, buttonNo) + getText(driver, buttonYes);
        expected = "TidakYa";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void klikApprvNo() {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);
        click(driver, btnApproveTidak);
        expected = "Waiting for Approval";
        value = getText(driver, dtlStatus);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void klikApprvYes() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        value2 = getText(driver, dtlNoApp);
        click(driver, btnApprove);
        takeScreenshot.capture(driver);
        click(driver, btnApproveYa);
        writeText(driver, searchRepay, value2);
        Thread.sleep(300);
        expected = "Approved";
        value = getText(driver, statuslist);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void verifyApprovedData() {
        iRowPictName = iRowPictName + iSeq;
        clearText(driver, searchRepay);
        writeText(driver, searchRepay, arrReq[7 + barisReq * 7]);
        click(driver, appNolist);
        createTest(iRowPictName, extent_test_case, extent);
        String format = "dd MMM yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        expected3 = simpleDateFormat.format(new Date());
        value = getText(driver, dtlStatus);
        value2 = getText(driver, user).substring(0, 15);
        value3 = getText(driver, dtltglApprv).substring(0, 17);
        value4 = getText(driver, dtlRejReason);
        value5 = getText(driver, dtlDesc);
        expected = "Approved";
        expected2 = getText(driver, dtlApprvBy);
        expected4 = "-";
        expected5 = "OK";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
        verifyValue(expected2, value2);
        changeTab(driver, 3); takeScreenshot.capture(driver);
        verifyValue(expected3, value3);
        changeTab(driver,2);
        verifyValue(expected4, value4);
        verifyValue(expected5, value5);
        click(driver, btnBackDtl);
    }

    public void klikReject() {
        iRowPictName = 50;
        click(driver, repayment);
        writeText(driver, searchRepay, arrReq[7]);
        click(driver, appNolist);
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);
        click(driver, btnReject);
        takeScreenshot.capture(driver);
        value = getText(driver, formRejectReas);
        value2 = getText(driver, formRejectDesc);
        expected = "Type Reject Reason";
        expected2 = "Descriptions";
        verifyValue(expected, value);
        verifyValue(expected2, value2);
    }

    public void verifyTypeofReject() {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, optiRejectReaDropdown);
        List<WebElement> list = driver.findElements(optiRejectRea);
        for (WebElement webElement : list) {
            value = webElement.getText().replace("\n", "");
        }
        expected = listReject;
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void klikRejectCancel() {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, optiRejectRea1);
        writeText(driver, rejectDescField, "Reject then No");
        takeScreenshot.capture(driver);
        click(driver, btnRejectTidak);
        value = getText(driver, dtlStatus);
        expected = "Waiting for Approval";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void rejectwithoutDesc() {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, btnReject);
        click(driver, optiRejectReaDropdown);
        click(driver, optiRejectRea1);
        clearText(driver, rejectDescField);
        takeScreenshot.capture(driver);
        click(driver, btnRejectYa);
        takeScreenshot.capture(driver);
        verifyDisplay(true, driver.findElement(rejectDescField).isDisplayed(), "Modal Reject");
    }

    public void rejectWoutTypeReject() {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, optiRejectReaDropdown);
        click(driver, optiRejectReaNull);
        writeText(driver, rejectDescField, "Reject without Type of Rejection");
        takeScreenshot.capture(driver);
        click(driver, btnRejectYa);
        takeScreenshot.capture(driver);
        verifyDisplay(true, driver.findElement(rejectDescField).isDisplayed(), "Modal Reject");
    }

    public void rejectDesc100() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, optiRejectReaDropdown);
        click(driver, optiRejectRea1);
        clearText(driver, rejectDescField);
        writeText(driver, rejectDescField, char100);
        verifyLength(char100, char100.length(), 100);
        takeScreenshot.capture(driver);
        click(driver, btnRejectYa);
        Thread.sleep(1000);
        writeText(driver, searchRepay, arrReq[7]);
        value = getText(driver, statuslist);
        expected = "Rejected";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
        click(driver, btnBackDtl);
        clearText(driver, searchRepay);
    }

    public void rejectDesc99() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        writeText(driver, searchRepay, arrReq[7 + barisReq * 2]);
        click(driver, appNolist);
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, btnReject);
        click(driver, optiRejectReaDropdown);
        click(driver, optiRejectRea1);
        writeText(driver, rejectDescField, char99);
        verifyLength(char99, char99.length(), 99);
        takeScreenshot.capture(driver);
        click(driver, btnRejectYa);
        Thread.sleep(1000);
        writeText(driver, searchRepay, arrReq[7 + barisReq * 2]);
        value = getText(driver, statuslist);
        expected = "Rejected";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
        click(driver, btnBackDtl);
    }

    public void rejectedData() {
        iRowPictName = iRowPictName + iSeq;
        clearText(driver, searchRepay);
        writeText(driver, searchRepay, arrReq[7]);
        click(driver, appNolist);
        createTest(iRowPictName, extent_test_case, extent);
        String format = "dd MMM yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        expected3 = simpleDateFormat.format(new Date());
        value = getText(driver, dtlStatus);
        value2 = getText(driver, user).substring(0, 15);
        value3 = getText(driver, dtltglApprv).substring(0, 11);
        value4 = getText(driver, dtlRejReason);
        value5 = getText(driver, dtlDesc);
        expected = "Rejected by Analyst";
        expected2 = getText(driver, dtlApprvBy);
        expected4 = "Nominal Pokok Tidak Valid";
        expected5 = char100;
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
        verifyValue(expected2, value2);
        verifyValue(expected3, value3);
        verifyValue(expected4, value4);
        verifyValue(expected5, value5);
        click(driver, btnBackDtl);
    }

    public void bulkApprv() throws InterruptedException {
        iRowPictName = 58;
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, repayment);//nanti hapus
        click(driver, btnBulk);
        click(driver, amountRepaymentDropDown);
        click(driver, amountRepaymentKurangBayar);
        writeText(driver, searchRepay, arrReq[7].substring(11, 17));
        click(driver, bulkRow1);
        Thread.sleep(300);
        click(driver, bulkRow2);
        Thread.sleep(500);
        click(driver, bulkApprove);
        value2 = getText(driver, dtlPrtnerBlkAppr).substring(2);
        expected = getText(driver, totNomBlkAppr).replace("Rp. ", "").replace(".", "").replace(": ", "");
        expected2 = getText(driver, partnerInBulk) + getText(driver, totAppBlkAppr);
        takeScreenshot.capture(driver);
        List<WebElement> button = driver.findElements(By.xpath("//div[@class= 'modal-footer']"));
        for (WebElement webElement : button) {
            value3 = webElement.getText().replace(" ", "").replace("\n", "");
        }

        List<WebElement> listItems = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']/td[10]"));
        long sum = 0;
        for (int i = 0; i < 2; i++) {
            String itemText = listItems.get(i).getText().replace("Rp. ", "").replace(".", "");
            long itemValue = Long.parseLong(itemText); // assuming values are decimal numbers
            sum += itemValue;
        }
        value = String.valueOf(sum);
        expected3 = "BatalSubmit";
        verifyValue(expected, value);
        verifyValue(expected2, value2);
        verifyValue(expected3, value3);
    }

    public void bulkApprvBatal() {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);
        click(driver, bulkApproveNo);
        takeScreenshot.capture(driver);
        boolean expectedVisibility = false;
        boolean actualVisibility = driver.findElement(By.xpath("//div[@class= 'modal-content']")).isDisplayed();
        verifyDisplay(expectedVisibility, actualVisibility, "Modal Bulk Form");

    }

    public void bulkApprvSubmit() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        value = getText(driver, appnoBulkRw1);
        value2 = getText(driver, appnoBulkRw2);
        click(driver, bulkApprove);
        takeScreenshot.capture(driver);
        click(driver, bulkApproveYes);
        Thread.sleep(1000);
        click(driver, repayment);
        writeText(driver, searchRepay, value);
        value3 = getText(driver, statuslist);
        expected = "Pending Batch Run";
        takeScreenshot.capture(driver);
        verifyValue(expected, value3);
//        clearText(driver, searchRepay);
//        writeText(driver, searchRepay, value2);
//        value4 = getText(driver, statuslist);
//        expected = "Pending Batch Run";
//        takeScreenshot.capture(driver);
//        verifyValue(expected, value4);
    }

    public void checkDataWaitforAppr() throws InterruptedException {
        logoutApprover(driver);
        loginJCO(driver);

        iRowPictName = 61;
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, repayment);
        click(driver, statusDrop);
        scrollIntoView(driver, statWFA);
        click(driver, statWFA);
        Thread.sleep(800);
        click(driver, appNolist);
        boolean expected = true;
        boolean value = driver.findElement(editRepayment).isDisplayed();
        boolean value2 = driver.findElement(updateRepayment).isDisplayed();
        takeScreenshot.capture(driver);
        verifyDisplay(expected, value, "Button Edit");
        verifyDisplay(expected, value2, "Button Update");
        click(driver, btnBackDtl);

    }

    public void checkDataApprov() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, statusDrop);
        scrollIntoView(driver, statAPPR);
        click(driver, statAPPR);
        Thread.sleep(500);
        click(driver, appNolist);
        boolean expected = false;
        takeScreenshot.capture(driver);
        try {
            boolean value = driver.findElement(editRepayment).isDisplayed();
            // If element is displayed, perform necessary actions
            // If element is undisplayed, throw an exception
            if (value) {
                verifyDisplay(expected, true, "Button Edit");
            } else {
                System.out.println("Element is undisplayed");
            }
        } catch (NoSuchElementException e) {
            verifyDisplay(expected, false, "Button Edit");
            // Element not found in DOM
            System.out.println("Element not found");
        }
        try {
            boolean value = driver.findElement(updateRepayment).isDisplayed();
            // If element is displayed, perform necessary actions
            // If element is undisplayed, throw an exception
            if (driver.findElement(updateRepayment).isDisplayed()) {
                verifyDisplay(expected, true, "Button Update");
            } else {
                verifyDisplay(expected, false, "Button Update");
            }
        } catch (NoSuchElementException e) {
            verifyDisplay(expected, false, "Button Update");
            // Element not found in DOM
            System.out.println("Element not found");
        }

        click(driver, btnBackDtl);
    }

    public void checkDataRejected() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, statusDrop);
        scrollIntoView(driver, statRej);
        click(driver, statRej);
        Thread.sleep(500);
        click(driver, appNolist);
        boolean expected = true;
        boolean value = driver.findElement(editRepayment).isDisplayed();
        boolean value2 = driver.findElement(updateRepayment).isDisplayed();
        takeScreenshot.capture(driver);
        verifyDisplay(expected, value, "Button Edit");
        verifyDisplay(expected, value2, "Button Update");
        click(driver, btnBackDtl);
    }

    public void checkDataPBR() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, statusDrop);
        scrollIntoView(driver, statPBR);
        click(driver, statPBR);
        Thread.sleep(500);
        click(driver, appNolist);
        boolean expected = true;
        boolean value = driver.findElement(editRepayment).isDisplayed();
        boolean value2 = driver.findElement(updateRepayment).isDisplayed();
        takeScreenshot.capture(driver);
        verifyDisplay(expected, value, "Button Edit");
        verifyDisplay(expected, value2, "Button Update");
        click(driver, btnBackDtl);
    }

    public void checkDataApprvExp() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon !");
//        createTest(iRowPictName, extent_test_case, extent);
//        click(driver, statusDrop);
//        scrollIntoView(driver, statApEx); click(driver, statApEx);Thread.sleep(500);
//        click(driver, appNolist);
//        boolean expected = false;
//        boolean value = driver.findElement(editRepayment).isDisplayed();
//        boolean value2 = driver.findElement(updateRepayment).isDisplayed();
//        takeScreenshot.capture(driver);
//        verifyDisplay(expected, value, "Button Edit");
//        verifyDisplay(expected, value2, "Button Update");
//        click(driver, btnBackDtl);
    }

    public void editWaiting() throws InterruptedException {
        iRowPictName = 66; //66
        createTest(iRowPictName, extent_test_case, extent);
//        click(driver, statusDrop);
//        scrollIntoView(driver, statWFA); click(driver, statWFA);Thread.sleep(200);
        clearText(driver, searchRepay);
        writeText(driver, searchRepay, arrReq[7 + barisReq * 8]);
        click(driver, appNolist);
        value = getText(driver, dtlBayarDendaPartner);
        Thread.sleep(200);
        appEdited1 = getText(driver, dtlNoApp);
        takeScreenshot.capture(driver);
        click(driver, editRepayment);
        clearText(driver, editBayarDendaField);
        writeText(driver, editBayarDendaField, "25000");
        click(driver, updateRepayment);
        Thread.sleep(500);
        value2 = getText(driver, dtlBayarDendaPartner);
        takeScreenshot.capture(driver);
        verifyValueNotEquals2(value2, value, "Update Pembayaran Denda");
        click(driver, btnBackDtl);
    }

    public void editRejected() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
//        click(driver, statusDrop);
//        scrollIntoView(driver, statRej);
//        click(driver, statRej);
//        Thread.sleep(200);
        clearText(driver, searchRepay);
        writeText(driver, searchRepay, arrReq[7]);
        Thread.sleep(300);
        click(driver, appNolist);
        value = getText(driver, dtlBayarDendaPartner);
        Thread.sleep(200);
//        appEdited2 = getText(driver, dtlNoApp);
        takeScreenshot.capture(driver);
        click(driver, editRepayment);
        clearText(driver, editBayarDendaField);
        writeText(driver, editBayarDendaField, "25000");
        click(driver, updateRepayment);
        Thread.sleep(500);
        value2 = getText(driver, dtlBayarDendaPartner);
        takeScreenshot.capture(driver);
        verifyValueNotEquals2(value2, value, "Update Pembayaran Denda");
        click(driver, btnBackDtl);
    }

    public void editPBR() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, statusDrop);
        scrollIntoView(driver, statPBR);
        click(driver, statPBR);
        Thread.sleep(200);
        click(driver, appNolist);
        value = getText(driver, dtlBayarDendaPartner);
        Thread.sleep(200);
        appEdited3 = getText(driver, dtlNoApp);
        takeScreenshot.capture(driver);
        click(driver, editRepayment);
        clearText(driver, editBayarDendaField);
        writeText(driver, editBayarDendaField, "25000");
        click(driver, updateRepayment);
        Thread.sleep(500);
        value2 = getText(driver, dtlBayarDendaPartner);
        takeScreenshot.capture(driver);
        verifyValueNotEquals2(value2, value, "Update Pembayaran Denda");
        click(driver, btnBackDtl);
    }

    public void approvEditData() throws InterruptedException {
        logoutApprover(driver);
        loginAllIn(driver);
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, repayment);
        writeText(driver, searchRepay, arrReq[7 + barisReq * 8]);
        click(driver, appNolist);
        takeScreenshot.capture(driver);
        click(driver, btnApprove);
        click(driver, btnApproveYa);
        writeText(driver, searchRepay, appEdited1);
        click(driver, appNolist);
        value = getText(driver, dtlStatus);
        expected = "Approved";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
        changeTab(driver, 1);
        searchAppID(arrReq[7 + barisReq * 8]);
        scrollIntoView(driver, bottomMifos);
        click(driver, mifTrx);
        click(driver, btnBackDtl);
    }

    public void rejectEditData() throws InterruptedException {
        iRowPictName = 70; //70
        createTest(iRowPictName, extent_test_case, extent);
//        writeText(driver, searchRepay, appEdited2);
        clearText(driver, searchRepay);
        writeText(driver, searchRepay, arrReq[7]);
        Thread.sleep(300);
        click(driver, appNolist);
        takeScreenshot.capture(driver);
        click(driver, btnReject);
        click(driver, optiRejectReaDropdown);
        click(driver, optiRejectRea1);
        writeText(driver, rejectDescField, "Reject Edited Data");
        click(driver, btnRejectYa);
//        writeText(driver, searchRepay, appEdited2);
        clearText(driver, searchRepay);
        writeText(driver, searchRepay, arrReq[7]);
        Thread.sleep(300);
        click(driver, appNolist);
        takeScreenshot.capture(driver);
        value = getText(driver, dtlStatus);
        expected = "Rejected by Analyst";
        verifyValue(expected, value);
        click(driver, btnBackDtl);
    }

    public void checkButtonWaitforApprv() throws InterruptedException {
        iRowPictName = 71;
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, statusDrop);
        scrollIntoView(driver, statWFA);
        click(driver, statWFA);
        Thread.sleep(800);
        click(driver, appNolist);
        boolean expected = true;
        boolean value = driver.findElement(btnApprove).isEnabled();
        boolean value2 = driver.findElement(btnReject).isEnabled();
        takeScreenshot.capture(driver);
        verifyDisplay(expected, value, "Button Approve");
        verifyDisplay(expected, value2, "Button Reject");
        click(driver, btnBackDtl);
    }

    public void checkButtonApproved() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, statusDrop);
        scrollIntoView(driver, statAPPR);
        click(driver, statAPPR);
        Thread.sleep(300);
        click(driver, appNolist);
        boolean expected = false;
        boolean value = driver.findElement(btnApprove).isEnabled();
        boolean value2 = driver.findElement(btnReject).isEnabled();
        takeScreenshot.capture(driver);
        verifyDisplay(expected, value, "Button Approve");
        verifyDisplay(expected, value2, "Button Reject");
        click(driver, btnBackDtl);
    }

    public void checkButtonRejected() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, statusDrop);
        scrollIntoView(driver, statRej);
        click(driver, statRej);
        Thread.sleep(300);
        click(driver, appNolist);
        boolean expected = false;
        boolean value = driver.findElement(btnApprove).isEnabled();
        boolean value2 = driver.findElement(btnReject).isEnabled();
        takeScreenshot.capture(driver);
        verifyDisplay(expected, value, "Button Approve");
        verifyDisplay(expected, value2, "Button Reject");
        click(driver, btnBackDtl);
    }

    public void checkButtonPBR() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, statusDrop);
        scrollIntoView(driver, statPBR);
        click(driver, statPBR);
        Thread.sleep(300);
        click(driver, appNolist);
        boolean expected = false;
        boolean value = driver.findElement(btnApprove).isEnabled();
        boolean value2 = driver.findElement(btnReject).isEnabled();
        takeScreenshot.capture(driver);
        verifyDisplay(expected, value, "Button Approve");
        verifyDisplay(expected, value2, "Button Reject");
        click(driver, btnBackDtl);
    }

    public void checkButtonApprvExp() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon!");
//        createTest(iRowPictName, extent_test_case, extent);
//        click(driver, statusDrop);
//        scrollIntoView(driver, statApEx); click(driver, statApEx);Thread.sleep(200);
//        click(driver, appNolist);
//        boolean expected = false;
//        boolean value = driver.findElement(btnApprove).isEnabled();
//        boolean value2 = driver.findElement(btnReject).isEnabled();
//        takeScreenshot.capture(driver);
//        verifyDisplay(expected, value, "Button Approve");
//        verifyDisplay(expected, value2, "Button Reject");
//        click(driver, btnBackDtl);
    }

    public void backdatedData() {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        writeText(driver, searchRepay, arrReq[7 + barisReq * 9]);
        scrollIntoView(driver, tglBayarlist);
        value = getText(driver, tglBayarlist);
        LocalDate currentDate = LocalDate.now();
        int daysToSubtract = +1;
        LocalDate desiredDate = currentDate.minusDays(daysToSubtract);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        expected = desiredDate.format(formatter);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void sysdateData() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        clearText(driver, searchRepay);
        writeText(driver, searchRepay, arrReq[7]);
        scrollIntoView(driver, tglBayarlist);
        String inputDate = getText(driver, tglBayarlist);
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(inputDate, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String outputDate = outputFormatter.format(date);
        createTable(1, "req");
        expected = arrReq[9];
        value = outputDate;
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void advanceData() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
//        createTest(iRowPictName, extent_test_case, extent);
//        clearText(driver, searchRepay);
//        writeText(driver, searchRepay, arrReq[7]);
//        scrollIntoView(driver, tglBayarlist);
//        String inputDate = getText(driver, tglBayarlist);
//        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDate date = LocalDate.parse(inputDate, inputFormatter);
//        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
//        String outputDate = outputFormatter.format(date);
//        createTable(1, "req");
//        expected = arrReq[9];
//        value   = outputDate;
//        takeScreenshot.capture(driver);
//        verifyValue(expected, value);
    }

    public void rejectBySystemData() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon!");
//        createTest(iRowPictName, extent_test_case, extent);
//        clearText(driver, searchRepay);
//        writeText(driver, searchRepay,arrErr[7]);
//        createTable(1, "err");
//        takeScreenshot.capture(driver);
//        value = getText(driver, noDataTable);
//        expected = "No matching records found";
//        verifyValue(expected, value);
    }

    public void waitforApprHmin1() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void approvDataHmin1() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void rejectByAnalystDataHmin1() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void PBRDataHmin1() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void apprExpDataHmin1() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void apprExpDataHmin2() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyIsiFilter() {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        clearText(driver, searchRepay);
        click(driver, sourceDropDown);
        expected = "AllLOSNIKEL";
        List<WebElement> lists = driver.findElements(By.id("source"));
        for (WebElement list : lists) {
            value = list.getText().replace("\n", "");
        }
        takeScreenshot.capture(driver);
        verifyValue(value, expected);
    }

    public void filterBySourceAll() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        String[] listSource = {"All", "LOS", "NIKEL"};
        click(driver, sourceAll);
        Thread.sleep(300);
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);
        value = getText(driver, sourceByAll);
        expected = "All";
        //Validate data table source list page 1
        List<WebElement> list1 = driver.findElements(By.xpath("//tr[@class='odd']//td[2] | //tr[@class='even']//td[2]"));
        createInfo(extent_test_case, "Jumlah Row Page 1   :" + list1.size());
        for (WebElement webElement : list1) {
            value = webElement.getText();
            verifyListAll(Arrays.stream(listSource).anyMatch(value::equals), value);
        }
    }

    public void filterBySourceLos() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, sourceDropDown);
        click(driver, sourceLos);
        expected = "LOS";
        Thread.sleep(500);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Ekspektasi data list : " + expected);
        takeScreenshot.capture(driver);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[2] | //tr[@class='even']//td[2]"));
        createInfo(extent_test_case, "Jumlah Row    :" + list.size());
        System.out.println(list.size());
        for (WebElement webElement : list) {
            value = webElement.getText();
            verifyValue(expected, value);
        }
    }

    public void filterBySourceNikel() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Tidak ada data NIKEL !");
//        click(driver, sourceDropDown);
//        click(driver, sourceNikel);
//        expected = "NIKEL";
//        Thread.sleep(500);
//        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Value ekspektasi data list : "+expected);
//        takeScreenshot.capture(driver);
//        //Validate data table source list
//        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd' or @class='even']//td[2] | //td[@class='dataTables_empty']"));
//        createInfo(extent_test_case,"Jumlah Row    :" +list.size());
//        System.out.println(list.size());
//        for (WebElement webElement : list) {
//            value = webElement.getText();
//            verifyValue(expected, value);
//        }
    }

    public void verifyIsiFilterPelunasan() {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, repayment);
        click(driver, pelunasanDropDown);
        List<WebElement> list = driver.findElements(By.id("filter-payment"));
        for (WebElement webElement : list) {
            value = webElement.getText().replace("\n", "");
        }
        expected = "AllYesNoInsuranceAdvance";
        verifyValue(expected, value);
        takeScreenshot.capture(driver);
    }

    public void filterPelAll() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        String[] listSource = {"All", "Yes", "No", "Insurance", "Advance"};
        click(driver, pelunasanAll);
        Thread.sleep(300);
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);
        value = getText(driver, sourceByAll);
        expected = Arrays.toString(listSource);
        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[6] | //tr[@class='even']//td[6]"));
        createInfo(extent_test_case, "Jumlah Row    :" + list.size());
        for (WebElement webElement : list) {
            value = webElement.getText();
            verifyListAll(Arrays.stream(listSource).anyMatch(value::equals), value);
        }
    }

    public void filterPelYes() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, pelunasanDropDown);
        click(driver, pelunasanYes);
        expected = getText(driver, pelunasanByYes);
        Thread.sleep(500);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Value source data list : " + expected);
        takeScreenshot.capture(driver);
        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[6] | //tr[@class='even']//td[6]"));
        createInfo(extent_test_case, "Jumlah Row    :" + list.size());
        for (WebElement webElement : list) {
            String value = webElement.getText();
            verifyValue(expected, value);
        }
    }

    public void filterPelNo() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, pelunasanDropDown);
        click(driver, pelunasanNo);
        expected = getText(driver, pelunasanByNo);
        Thread.sleep(500);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Value source data list : " + expected);
        takeScreenshot.capture(driver);
        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[6] | //tr[@class='even']//td[6]"));
        createInfo(extent_test_case, "Jumlah Row    :" + list.size());
        for (WebElement webElement : list) {
            value = webElement.getText();
            verifyValue(expected, value);
        }
    }

    public void filterPelInsurance() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, pelunasanDropDown);
        click(driver, pelunasanInsu);
        expected = getText(driver, pelunasanByInsurance);
        Thread.sleep(500);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Value source data list : " + expected);
        takeScreenshot.capture(driver);
        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[6] | //tr[@class='even']//td[6]"));
        createInfo(extent_test_case, "Jumlah Row    :" + list.size());
        for (WebElement webElement : list) {
            value = webElement.getText();
            verifyValue(expected, value);
        }
    }

    public void filterPelAdvance() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyIsiFilterStatus() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, repayment);
        click(driver, statusDropDown);
        List<WebElement> list = driver.findElements(By.xpath("//ul[@id = 'select2-filter-status-results']"));
        for (WebElement webElement : list) {
            value = webElement.getText().replace("\n", "");
        }
        expected = "AllWaiting for approvalPending Batch RunApprovedRejectedApproval Expired";
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void filterByStatusAll() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, statusAll);
        String[] listStatus = {"All", "Waiting for Approval", "Pending Batch Run", "Approved", "Rejected", "Approval Expired"};
        expected = Arrays.toString(listStatus);
        Thread.sleep(500);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Value source data list : " + expected);
        takeScreenshot.capture(driver);
        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[7] | //tr[@class='even']//td[7]"));
        createInfo(extent_test_case, "Jumlah Row    :" + list.size());
        for (WebElement webElement : list) {
            value = webElement.getText();
            verifyListAll(Arrays.stream(listStatus).anyMatch(value::equals), value);
        }
    }

    public void filterByStatusWaitforApprov() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, statusDropDown);
        click(driver, statusWait);
        expected = "Waiting for Approval";
        Thread.sleep(500);
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);
        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[7] | //tr[@class='even']//td[7]"));
        createInfo(extent_test_case, "Jumlah Row    :" + list.size());
        for (WebElement webElement : list) {
            value = webElement.getText();
            verifyValue(expected, value);
        }
    }

    public void filterByStatusPBR() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, statusDropDown);
        click(driver, statusPending);
        expected = "Pending Batch Run";
        Thread.sleep(500);
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);
        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[7] | //tr[@class='even']//td[7] | //td[@class='dataTables_empty']"));
        createInfo(extent_test_case, "Jumlah Row    : " + list.size());
        for (WebElement webElement : list) {
            String value = webElement.getText();
            verifyValue(expected, value);
        }
    }

    public void filterByStatusApproved() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, statusDropDown);
        scrollIntoView(driver, statusApproved);
        click(driver, statusApproved);
        expected = "Approved";
        Thread.sleep(500);
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);
        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[7] | //tr[@class='even']//td[7] | //td[@class='dataTables_empty']"));
        createInfo(extent_test_case, "Jumlah Row    : " + list.size());
        for (WebElement webElement : list) {
            String value = webElement.getText();
            verifyValue(expected, value);
        }
    }

    public void filterByStatusRejected() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, statusDropDown);
        scrollIntoView(driver, statusRejected);
        click(driver, statusRejected);
        expected = "Rejected";
        Thread.sleep(500);
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[7] | //tr[@class='even']//td[7] | //td[@class='dataTables_empty']"));
        createInfo(extent_test_case, "Jumlah Row    : " + list.size());
        for (WebElement webElement : list) {
            String value = webElement.getText();
            verifyValue(expected, value);
        }
    }

    public void filterByStatusApprvExp() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "status approval expired not ready yet");
//        click(driver, statusDropDown);
//        scrollIntoView(driver, statusAppExp);
//        click(driver, statusAppExp);
//        expected = "Approval Expired";
//        Thread.sleep(500);
//        createTest(iRowPictName, extent_test_case, extent);
//        takeScreenshot.capture(driver);
//        //Validate data table source list
//        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[7] | //tr[@class='even']//td[7] | //td[@class='dataTables_empty']"));
//        createInfo(extent_test_case, "Jumlah Row    : "+list.size());
//        for (WebElement webElement : list) {
//            String value = webElement.getText();
//            verifyValue(expected, value);
//        }
    }

    public void verifyIsiFilterPartner() {
        iRowPictName = iRowPictName + iSeq;
        click(driver, repayment);
        click(driver, partnerDropDown);
        List<WebElement> list = driver.findElements(partnerOption);
        for (WebElement webElement : list) {
            value = webElement.getText().replace("\n", "").replace(" ", "");
            System.out.println(value);
        }
        expected = "AllAKSELERANNEWKOMUNALKOPNUSCekBugsVerificatioKOMUNALMODALANDALANRUMAHMODALDANABARUDANABIJAKDANAKOINKOINANDALANKopnusALAMILEMINERALECek123" + "RealmeRealmeRealmeKOMUNALWingsLenovoIndofoodMIYAKOKOPNUSDOMPETPINJAMSHARPTOSHIBAMINISOCompanycompany2UANGKUIndodanaIndodanaPTTesAutoApproveTesAutoApproveIDVIndodana" + "KLIKA2CPTTesPendingTesPendingIDVAmartaSeaMoney-CFinanceSeaMoney-LDNAmartaSeaMoney-CFinanceSeaMoney-LDNtestCBAScheckingKlikA2CKLIKA2CTANPASLIKIDVRevolvingNoPTRevolvingNoIDVRevolvingYes" + "PTRevolvingYesKOPNUSapiindodanaapi1indodanaapi2amartaapiseamoneyapi1seamoneyapi2klika2capi1klika2capi2moraapi1amartaapi1AlamiDanamasXynexis";
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void filterByPartnerAll() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, partnerAll);
        String[] listStatus = {"All", "Indodana", "AKSELERAN", "NEW KOMUNAL", "KOPNUS", "SeaMoney"};
        expected = Arrays.toString(listStatus);
        Thread.sleep(500);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Value source data list : " + expected);
        takeScreenshot.capture(driver);
        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[4] | //tr[@class='even']//td[4]"));
        createInfo(extent_test_case, "Jumlah Row    :" + list.size());
        for (WebElement webElement : list) {
            String value = webElement.getText();
            verifyListAll(Arrays.stream(listStatus).anyMatch(value::equals), value);
        }
    }

    public void filterByPartnerPilih1() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, partnerDropDown);
        click(driver, partnerAkseleran);
        expected = "AKSELERAN";
        Thread.sleep(500);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Value source data list : " + expected);
        takeScreenshot.capture(driver);
        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[4] | //tr[@class='even']//td[4]"));
        createInfo(extent_test_case, "Jumlah Row    :" + list.size());
        for (WebElement webElement : list) {
            String value = webElement.getText();
            verifyValue(expected, value);
        }
    }

    public void verifyIsiStatAmountRepay() {
        iRowPictName = iRowPictName + iSeq;
        click(driver, repayment);
        click(driver, amountRepaymentDropDown);

        List<WebElement> list = driver.findElements(amountRepaymentOption);
        for (WebElement webElement : list) {
            value = webElement.getText().replace("\n", "").replace(" ", "");
            System.out.println(value);
        }
        expected = "AllSesuaiKurangBayarLebihBayar";
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void filterAmountRepayByAll() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, amountRepaymentAll);
        String[] listStatus = {"All", "Sesuai", "Kurang Bayar", "Lebih Bayar"};
        expected = Arrays.toString(listStatus);
        Thread.sleep(500);
        scrollIntoView(driver, statAmountlist);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Value source data list : " + expected);
        takeScreenshot.capture(driver);
        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[11] | //tr[@class='even']//td[11]"));
        createInfo(extent_test_case, "Jumlah Row    :" + list.size());
        for (WebElement webElement : list) {
            String value = webElement.getText();
            verifyListAll(Arrays.asList(listStatus).contains(value), value);
        }
    }

    public void filterAmountRepayBySesuai() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, amountRepaymentDropDown);
        click(driver, amountRepaymentSesuai);
        expected = "Sesuai";
        Thread.sleep(500);
        scrollIntoView(driver, statAmountlist);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Value source data list : " + expected);
        takeScreenshot.capture(driver);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[11] | //tr[@class='even']//td[11]"));
        createInfo(extent_test_case, "Jumlah Row    :" + list.size());
        for (WebElement webElement : list) {
            String value = webElement.getText();
            verifyValue(expected, value);
        }
    }

    public void filterAmountRepayByKurangBayar() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, amountRepaymentDropDown);
        click(driver, amountRepaymentKurangBayar);
        expected = "Kurang Bayar";
        Thread.sleep(500);
        scrollIntoView(driver, statAmountlist);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Value source data list : " + expected);
        takeScreenshot.capture(driver);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[11] | //tr[@class='even']//td[11]"));
        createInfo(extent_test_case, "Jumlah Row    :" + list.size());
        for (WebElement webElement : list) {
            value = webElement.getText();
            verifyValue(expected, value);
        }
    }

    public void filterAmountRepayByLebihBayar() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, amountRepaymentDropDown);
        scrollIntoView(driver, amountRepaymentLebihBayar);
        click(driver, amountRepaymentLebihBayar);
        expected = "Lebih Bayar";
        Thread.sleep(500);
        scrollIntoView(driver, statAmountlist);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Value source data list : " + expected);
        takeScreenshot.capture(driver);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[11] | //tr[@class='even']//td[11]"));
        createInfo(extent_test_case, "Jumlah Row    :" + list.size());
        for (WebElement webElement : list) {
            String value = webElement.getText();
            verifyValue(expected, value);
        }
    }

    public void verifyIsiFilterBatchNo() {
        iRowPictName = iRowPictName + iSeq;
        click(driver, repayment);
        click(driver, batchNoDropDown);

        List<WebElement> list = driver.findElements(batchNoOption);
        for (WebElement webElement : list) {
            value = webElement.getText().replace("\n", "").replace(" ", "");
            System.out.println(value);
        }
        expected = "All12345678910";
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void filterByBatchnoPilih1() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, batchNo1);

        expected = "1";
        Thread.sleep(500);
        scrollIntoView(driver, batchNoList);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Value source data list : " + expected);
        takeScreenshot.capture(driver);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[14] | //tr[@class='even']//td[14]"));
        createInfo(extent_test_case, "Jumlah Row    :" + list.size());
        for (int i = 0; i < list.size(); i++) {
            value = list.get(i).getText();
            verifyValue(expected, value);
        }
    }

    public void verifyfilterSearch() {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, repayment);
        writeText(driver, searchRepay, arrReq[7]);
        value = getText(driver, appNolist);
        expected = arrReq[7];
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void verifySourceLOS() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifySourceNIKEL() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyAppNo() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        expected = arrReq[7];
        value = getText(driver, appNolist);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        verifyCustom(value, expected, "CSV Request | Data Los");
        takeScreenshot.capture(driver);
    }

    public void verifyPartner() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        if (getText(driver, appNolist).contains("L000001")) {
            expected = "AKSELERAN";
        } else {
            expected = "NEW KOMUNAL";
        }

        value = getText(driver, partnerlist);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        verifyCustom(expected, value, "CSV Request | Data Los");
        takeScreenshot.capture(driver);
    }

    public void verifyDebtorName() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        expected = arrApp[12];
        value = getText(driver, debNamelist);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        verifyCustom(value, expected, "CSV Request | Data Los");
        takeScreenshot.capture(driver);
    }

    public void verifyPelN() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        clearText(driver, searchRepay);
        writeText(driver, searchRepay, arrReq[7 + barisReq * 3]);
        expected = arrReq[13 + barisReq * 3];
        value = getText(driver, statBayarlist).substring(0, 1);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(4, "req");
        verifyCustom(expected, value, "CSV Request | Data Los");
        takeScreenshot.capture(driver);
    }

    public void verifyPelY() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        clearText(driver, searchRepay);
        writeText(driver, searchRepay, arrReq[7]);
        expected = arrReq[13];
        value = getText(driver, statBayarlist).substring(0, 1);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(1, "req");
        verifyCustom(expected, value, "CSV Request | Data Los");
        takeScreenshot.capture(driver);
    }

    public void verifyPelI() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        clearText(driver, searchRepay);
        writeText(driver, searchRepay, arrReq[7 + barisReq * 6]);
        expected = arrReq[13 + barisReq * 6];
        value = getText(driver, statBayarlist).substring(0, 1);
        createTest(iRowPictName, extent_test_case, extent);
        createTable(7, "req");
        verifyCustom(expected, value, "CSV Request | Data Los");
        takeScreenshot.capture(driver);
    }

    public void verifyPelA() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void sortStatus() {
        iRowPictName = 123; //123
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, repayment);
        takeScreenshot.capture(driver);
        // Get data from the column as a list
        click(driver, sortByStatus);
        //Ascending
        int baris = 0;
        List<String> dataList = new ArrayList<>();
        while (true) {
            // Get all rows in the data table
            List<WebElement> dataCells = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']/td[7]"));
            for (WebElement dataCell : dataCells) {
                dataList.add(dataCell.getText());
                baris++;
            }
            takeScreenshot.capture(driver);
            scrollIntoView(driver, next);
            WebElement nextButton = driver.findElement(next);

            try {
                if (nextButton.isEnabled()) {
                    driver.findElement(next).click();
                }
            } catch (Exception e) {
                System.out.println("Finish!, Rows = " + baris);
                break;
            }

        }
        verifySortOrder(dataList, baris, 1);

        //Descending
        scrollIntoView(driver, sortByStatus);
        click(driver, sortByStatus);
        int baris2 = 0;
        List<String> dataList2 = new ArrayList<>();
        while (true) {
            // Get all rows in the data table
            List<WebElement> dataCells2 = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']/td[7]"));
            for (WebElement dataCell2 : dataCells2) {
                dataList2.add(dataCell2.getText());
                baris2++;
            }
            takeScreenshot.capture(driver);
            scrollIntoView(driver, next);
            WebElement nextButton = driver.findElement(next);

            try {
                if (nextButton.isEnabled()) {
                    driver.findElement(next).click();
                }
            } catch (Exception e) {
                System.out.println("Finish!, Rows = " + baris2);
                break;
            }
        }
        verifySortOrder(dataList2, baris2, 2);
    }

    public void sortTglBayar() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        driver.navigate().refresh();
        Thread.sleep(500);
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);
        // Get data from the column as a list
        click(driver, sortByTglByr);
        //Ascending
        int baris = 0;
        List<String> dataList = new ArrayList<>();
        while (true) {
            // Get all rows in the data table
            List<WebElement> dataCells = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']/td[8]"));
            for (WebElement dataCell : dataCells) {
                dataList.add(dataCell.getText());
                baris++;
            }
            takeScreenshot.capture(driver);
            scrollIntoView(driver, next);
            WebElement nextButton = driver.findElement(next);

            try {
                if (nextButton.isEnabled()) {
                    driver.findElement(next).click();
                }
            } catch (Exception e) {
                System.out.println("Finish!, Rows = " + baris);
                break;
            }

        }
        verifySortOrder(dataList, baris, 1);

        //Descending
        scrollIntoView(driver, sortByStatus);
        click(driver, sortByTglByr);
        int baris2 = 0;
        List<String> dataList2 = new ArrayList<>();
        while (true) {
            // Get all rows in the data table
            List<WebElement> dataCells2 = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']/td[8]"));
            for (WebElement dataCell2 : dataCells2) {
                dataList2.add(dataCell2.getText());
                baris2++;
            }
            takeScreenshot.capture(driver);
            scrollIntoView(driver, next);
            WebElement nextButton = driver.findElement(next);

            try {
                if (nextButton.isEnabled()) {
                    driver.findElement(next).click();
                }
            } catch (Exception e) {
                System.out.println("Finish!, Rows = " + baris2);
                break;
            }
        }
        verifySortOrder(dataList2, baris2, 2);
    }

    public void nextPage() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        driver.navigate().refresh();
        Thread.sleep(500);
        createTest(iRowPictName, extent_test_case, extent);
        int baris = 0;
        List<String> dataList = new ArrayList<>();
        while (true) {
            // Get all rows in the data table
            List<WebElement> dataCells = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']/td[1]"));
            for (WebElement dataCell : dataCells) {
                dataList.add(dataCell.getText());
                baris++;
            }
            scrollIntoView(driver, next);
            WebElement nextButton = driver.findElement(next);
            takeScreenshot.capture(driver);

            try {
                if (nextButton.isEnabled()) {
                    driver.findElement(next).click();
                }
            } catch (Exception e) {
                System.out.println("Finish!, Rows = " + baris);
                break;
            }
        }
        verifyNextPage(dataList, baris);
    }

    public void clickNumPage() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        driver.navigate().refresh();
        Thread.sleep(500);
        createTest(iRowPictName, extent_test_case, extent);
        scrollIntoView(driver, page2);
        takeScreenshot.capture(driver);
        createInfo(extent_test_case, "Data pada page 1");
        // Get all rows in the data table
        List<String> dataList = new ArrayList<>();
        int baris = 0;
        List<WebElement> dataCells = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']/td[1]"));
        for (WebElement dataCell : dataCells) {
            dataList.add(dataCell.getText());
            baris++;
        }
        click(driver, page2);
        dataCells = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']/td[1]"));
        for (WebElement dataCell : dataCells) {
            dataList.add(dataCell.getText());
            baris++;
        }
        takeScreenshot.capture(driver);
        createInfo(extent_test_case, "Data pada page 2");
        verifyNextPage(dataList, baris);
    }

    public void previousPage() {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        scrollIntoView(driver, previousPage);
        takeScreenshot.capture(driver);
        createInfo(extent_test_case, "Page Before");
        // Get all rows in the data table
        List<String> dataList = new ArrayList<>();
        int baris = 0;
        List<WebElement> dataCells = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']/td[1]"));
        for (WebElement dataCell : dataCells) {
            dataList.add(dataCell.getText());
            baris++;
        }
        click(driver, previousPage);
        dataCells = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']/td[1]"));
        for (WebElement dataCell : dataCells) {
            dataList.add(dataCell.getText());
            baris++;
        }
        takeScreenshot.capture(driver);
        createInfo(extent_test_case, "Page After");
        verifyNextPage(dataList, baris);

    }

    public void sortStatus2() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        driver.navigate().refresh();
        Thread.sleep(500);
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, repayment);
        // Get data from the column as a list
        click(driver, sortByStatus);
        //Ascending
        int baris = 0;
        List<String> dataList = new ArrayList<>();
        while (true) {
            // Get all rows in the data table
            List<WebElement> dataCells = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']/td[7]"));
            for (WebElement dataCell : dataCells) {
                dataList.add(dataCell.getText());
                baris++;
            }
            takeScreenshot.capture(driver);
            scrollIntoView(driver, next);
            WebElement nextButton = driver.findElement(next);

            try {
                if (nextButton.isEnabled()) {
                    driver.findElement(next).click();
                }
            } catch (Exception e) {
                System.out.println("Finish!, Rows = " + baris);
                break;
            }

        }
        verifySortOrder(dataList, baris, 1);

        //Descending
        scrollIntoView(driver, sortByStatus);
        click(driver, sortByStatus);
        int baris2 = 0;
        List<String> dataList2 = new ArrayList<>();
        while (true) {
            // Get all rows in the data table
            List<WebElement> dataCells2 = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']/td[7]"));
            for (WebElement dataCell2 : dataCells2) {
                dataList2.add(dataCell2.getText());
                baris2++;
            }
            takeScreenshot.capture(driver);
            scrollIntoView(driver, next);
            WebElement nextButton = driver.findElement(next);

            try {
                if (nextButton.isEnabled()) {
                    driver.findElement(next).click();
                }
            } catch (Exception e) {
                System.out.println("Finish!, Rows = " + baris2);
                break;
            }
        }
        verifySortOrder(dataList2, baris2, 2);
    }

    public void sortTglBayarHmin1() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void verifyTglMenuRepayment() {
        iRowPictName = 130; //130
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, repayment);
        String format = "dd MMMM yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String date = simpleDateFormat.format(new Date());
        value = getText(driver, todayDateRepayment).substring(9);
        expected = date;
        takeScreenshot.capture(driver);
        changeTab(driver, 3); takeScreenshot.capture(driver); changeTab(driver, 2);
        verifyValue(expected, value);
    }

    public void totNomApproved() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, statusDropDown);
        scrollIntoView(driver, statAPPR);
        click(driver, statAPPR);
        Thread.sleep(500);
        WebElement inputTot1 = driver.findElement(By.id("totalSummaryAmount"));
        Long tot1 = Long.valueOf(inputTot1.getAttribute("value").replace("Rp. ", "").replace(".", ""));
        scrollIntoView(driver, batchNoList);
        long sum = 0;
        while (true) {

            // Get all rows in the data table
            List<WebElement> listItems = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']/td[9]"));
            for (WebElement listItem : listItems) {
                String itemText = listItem.getText().replace("Rp. ", "").replace(".", "");
                long itemValue = Long.parseLong(itemText); // assuming values are decimal numbers
                sum += itemValue;
            }
            scrollIntoView(driver, next);
            WebElement nextButton = driver.findElement(next);

            try {
                if (nextButton.isEnabled()) {
                    driver.findElement(next).click();
                    takeScreenshot.capture(driver);
                }
            } catch (Exception e) {
                System.out.println("Finish!" + sum);
                break;
            }

        }

        scrollIntoView(driver, totalNomApprv);
        click(driver, statusDropDown);
        scrollIntoView(driver, statPBR);
        click(driver, statPBR);
        Thread.sleep(500);
        WebElement inputTotpbr = driver.findElement(By.id("totalSummaryAmount"));
        Long totpbr = Long.valueOf(inputTotpbr.getAttribute("value").replace("Rp. ", "").replace(".", ""));
        takeScreenshot.capture(driver);
        long sum2 = 0;
        while (true) {

            // Get all rows in the data table
            List<WebElement> listItems = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']/td[9]"));
            for (WebElement listItem : listItems) {
                String itemText = listItem.getText().replace("Rp. ", "").replace(".", "");
                long itemValue = Long.parseLong(itemText); // assuming values are decimal numbers
                sum2 += itemValue;
            }
            scrollIntoView(driver, next);
            WebElement nextButton = driver.findElement(next);

            try {
                if (nextButton.isEnabled()) {
                    driver.findElement(next).click();
                    takeScreenshot.capture(driver);
                }
            } catch (Exception e) {
                System.out.println("Finish!" + sum2);
                break;
            }

        }
        value = String.valueOf(sum + sum2);
        expected = String.valueOf(tot1 + totpbr);
        verifyValue(expected, value);
    }

    public void totNomPembayaran() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, repayment);
        click(driver, statusDropDown);
        scrollIntoView(driver, statAll);
        click(driver, statAll);
        Thread.sleep(2000);
        WebElement inputTot2 = driver.findElement(By.id("totalAmountPayment"));
        Long tot2 = Long.valueOf(inputTot2.getAttribute("value").replace("Rp. ", "").replace(".", ""));
        takeScreenshot.capture(driver);
        System.out.println(tot2);
        scrollIntoView(driver, batchNoList);
        long sum = 0;
        while (true) {
            // Get all rows in the data table
            List<WebElement> listItems = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']/td[9]"));
            for (WebElement listItem : listItems) {
                String itemText = listItem.getText().replace("Rp. ", "").replace(".", "");
                long itemValue = Long.parseLong(itemText);
                sum += itemValue;
            }
            scrollIntoView(driver, next);
            WebElement nextButton = driver.findElement(next);

            try {
                if (nextButton.isEnabled()) {
                    driver.findElement(next).click();
                    takeScreenshot.capture(driver);
                }
            } catch (Exception e) {
                System.out.println("Finish!" + sum);
                break;
            }
        }
        value = String.valueOf(sum);
        expected = String.valueOf(tot2);
        verifyValue(expected, value);
    }

    public void bulkApproveCheck2Data() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, repayment);//nanti hapus
        click(driver, btnBulk);
        writeText(driver, searchRepay, arrReq[7].substring(11, 17));
        click(driver, bulkRow1);
        Thread.sleep(300);
        click(driver, bulkRow2);
        Thread.sleep(500);
        takeScreenshot.capture(driver);
        WebElement inputTot = driver.findElement(By.id("totalNominalApproved"));
        Long tot = Long.valueOf(inputTot.getAttribute("value").replace("Rp. ", "").replace(".", ""));
        expected = String.valueOf(tot);

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type= 'checkbox']"));
        long total = 0;

        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                WebElement row = checkbox.findElement(By.xpath("./ancestor::tr[1]"));
                WebElement valueCell = row.findElement(By.xpath("./td[10]")); // assuming value is in the second column
                String valueString = valueCell.getText().trim().replace("Rp. ", "").replace(".", "");
                long value = Long.parseLong(valueString); // assuming value is a decimal number
                total += value;
            }
        }

        System.out.println("Total value of checked items: " + total);
        value = String.valueOf(total);
        verifyValue(expected, value);
    }

    public void bulkApprovUncheck2Data() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);
        WebElement inputTot = driver.findElement(By.id("totalNominalApproved"));
        Long tot = Long.valueOf(inputTot.getAttribute("value").replace("Rp. ", "").replace(".", "").trim());
        expected = String.valueOf(tot);

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type= 'checkbox']"));
        long total = 0;

        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                WebElement row = checkbox.findElement(By.xpath("./ancestor::tr[1]"));
                WebElement valueCell = row.findElement(By.xpath("./td[10]")); // assuming value is in the second column
                String valueString = valueCell.getText().trim().replace("Rp. ", "").replace(".", "");
                long num = Long.parseLong(valueString); // assuming value is a decimal number
                total += num;
            }
        }
        value = String.valueOf(total);
        verifyValue(expected, value);

        //1 row selected
        click(driver, bulkRow2);
        takeScreenshot.capture(driver);
        Thread.sleep(500);
        WebElement inputTot2 = driver.findElement(By.id("totalNominalApproved"));
        Long tot2 = Long.valueOf(inputTot2.getAttribute("value").replace("Rp. ", "").replace(".", "").trim());
        expected2 = String.valueOf(tot2);

        List<WebElement> checkboxes2 = driver.findElements(By.xpath("//input[@type= 'checkbox']"));
        long total2 = 0;

        for (WebElement checkbox2 : checkboxes2) {
            if (checkbox2.isSelected()) {
                WebElement row = checkbox2.findElement(By.xpath("./ancestor::tr[1]"));
                WebElement valueCell = row.findElement(By.xpath("./td[10]")); // assuming value is in the second column
                String valueString = valueCell.getText().trim().replace("Rp. ", "").replace(".", "");
                long num2 = Long.parseLong(valueString); // assuming value is a decimal number
                total2 += num2;
            }
        }
        value2 = String.valueOf(total2);
        verifyValue(expected2, value2);
        verifyValueNotEquals2(expected, expected2, "2 Row Selected | 1 Row Selected");
    }

    public void bulkApprvCheckAll() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
//        clearText(driver, searchRepay);
        driver.navigate().refresh();
        Thread.sleep(1000);
        click(driver, bulkRow1);
        click(driver, bulkCheckAll);
        takeScreenshot.capture(driver);
        WebElement inputTot = driver.findElement(By.id("totalNominalApproved"));
        Long tot = Long.valueOf(inputTot.getAttribute("value").replace("Rp. ", "").replace(".", ""));
        expected = String.valueOf(tot);

        long sum = 0;
        while (true) {
            // Get all rows in the data table
            List<WebElement> listItems = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']/td[10]"));
            for (WebElement listItem : listItems) {
                String itemText = listItem.getText().replace("Rp. ", "").replace(".", "");
                long itemValue = Long.parseLong(itemText); // assuming values are decimal numbers
                sum += itemValue;
            }
            scrollIntoView(driver, next);
            WebElement nextButton = driver.findElement(next);
            try {
                if (nextButton.isEnabled()) {
                    driver.findElement(next).click();
                    takeScreenshot.capture(driver);
                }
            } catch (Exception e) {
                System.out.println("Finish!" + sum);
                break;
            }

        }
        value = String.valueOf(sum);
        verifyValue(expected, value);
    }

    public void bulkApprCheckAllandApprov() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        driver.navigate().refresh();
        Thread.sleep(1000);
        takeScreenshot.capture(driver);
        Set<String> partner = new HashSet<>();
        Set<String> statAmount = new HashSet<>();
        List<String> dataPartner = new ArrayList<>();
        int baris = 0;
        long sum = 0;
        while (true) {
            // Get all rows in the data table
            List<WebElement> rows = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']"));
            baris += rows.size();
            for (WebElement row : rows) {
                String getUnique1 = row.findElement(By.xpath("td[5]")).getText();
                partner.add(getUnique1);
                String getUnique2 = row.findElement(By.xpath("td[12]")).getText();
                statAmount.add(getUnique2);
                dataPartner.add(getUnique1);
            }
            List<WebElement> listItems = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']/td[10]"));
            for (WebElement listItem : listItems) {
                String itemText = listItem.getText().replace("Rp. ", "").replace(".", "");
                long itemValue = Long.parseLong(itemText); // assuming values are decimal numbers
                sum += itemValue;
            }
            scrollIntoView(driver, next);
            WebElement nextButton = driver.findElement(next);

            try {
                if (nextButton.isEnabled()) {
                    driver.findElement(next).click();
                    takeScreenshot.capture(driver);
                }
            } catch (Exception e) {
                System.out.println("partner : " + partner);
                System.out.println("Status Pembayaran : " + statAmount);
                System.out.println("Total Baris : " + baris);
                System.out.println("Semua Partner : " + dataPartner);
                System.out.println("Total nominal : " + sum);
                break;
            }
        }
        // Count the occurrence of each value in the list
        Map<String, Integer> counts = new HashMap<>();
        for (String data : dataPartner) {
            if (counts.containsKey(data)) {
                counts.put(data, counts.get(data) + 1);
            } else {
                counts.put(data, 1);
            }
        }

        // Print out the counts
        for (String values : counts.keySet()) {
            int count = counts.get(values);
            System.out.println(values + ": " + count);
            value4 = values + ": " + count;
        }

        scrollIntoView(driver, bulkApprove);
        click(driver, bulkCheckAll);
        click(driver, bulkApprove);
        takeScreenshot.capture(driver);
        List<WebElement> button = driver.findElements(By.xpath("//div[@class= 'modal-footer']"));
        for (WebElement webElement : button) {
            value3 = webElement.getText().replace(" ", "").replace("\n", "");
        }
        expected = getText(driver, totAppBlkAppr).replace(":", "").trim();
        expected2 = getText(driver, totNomBlkAppr).replace("Rp. ", "").replace(".", "").replace(": ", "");
        expected3 = "BatalSubmit";
        expected4 = getText(driver, partnerInModalBulk);
        value = String.valueOf(baris);
        value2 = String.valueOf(sum);
        verifyValue(expected, value);
        verifyValue(expected2, value2);
        verifyContain(expected4, value4);
        verifyValue(expected3, value3);

    }

    public void bulkApprCheckAllApprovandBatal() {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, bulkApproveNo);
        takeScreenshot.capture(driver);
        boolean expectedVisibility = false;
        boolean actualVisibility = driver.findElement(By.xpath("//div[@class= 'modal-content']")).isDisplayed();
        verifyDisplay(expectedVisibility, actualVisibility, "Modal Bulk Approve");
    }

    public void verifyAfterBulkAll() {
        iRowPictName = iRowPictName + iSeq;
        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
    }

    public void bulkBeberapaReject() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, repayment);//nanti hapus
        click(driver, btnBulk);
        writeText(driver, searchRepay, arrReq[7].substring(11, 17));
        click(driver, bulkRow1);
        Thread.sleep(300);
        click(driver, bulkRow2);
        Thread.sleep(500);
        takeScreenshot.capture(driver);
        WebElement inputTot = driver.findElement(By.id("totalNominalApproved"));
        Long tot = Long.valueOf(inputTot.getAttribute("value").replace("Rp. ", "").replace(".", ""));
        expected = String.valueOf(tot);

        Set<String> partner = new HashSet<>();
        Set<String> statAmount = new HashSet<>();
        List<String> dataPartner = new ArrayList<>();
        int baris = 0;
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type= 'checkbox']"));
        long total = 0;

        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                WebElement row = checkbox.findElement(By.xpath("./ancestor::tr[1]"));
                WebElement valueCell = row.findElement(By.xpath("./td[10]")); // assuming value is in the second column
                String valueString = valueCell.getText().trim().replace("Rp. ", "").replace(".", "");
                long value = Long.parseLong(valueString); // assuming value is a decimal number
                total += value;
                baris++;
                String getUnique1 = row.findElement(By.xpath("td[5]")).getText();
                partner.add(getUnique1);
                String getUnique2 = row.findElement(By.xpath("td[12]")).getText();
                statAmount.add(getUnique2);
                dataPartner.add(getUnique1);
            }
        }

        click(driver, bulkReject);
        takeScreenshot.capture(driver);
        List<WebElement> button = driver.findElements(By.xpath("//div[@class= 'modal-footer']"));
        for (WebElement webElement : button) {
            value3 = webElement.getText().replace(" ", "").replace("\n", "");
        }
        expected = getText(driver, totAppBlkAppr).replace(":", "").trim();
        expected2 = getText(driver, totNomBlkAppr).replace("Rp. ", "").replace(".", "").replace(": ", "");
        expected3 = "BatalSubmit";
        value = String.valueOf(baris);
        value2 = String.valueOf(total);
        verifyValue(expected, value);
        verifyValue(expected2, value2);
        verifyValue(expected3, value3);
    }

    public void bulkBeberapaRejectAndBatal() {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, bulkRejectNo);
        takeScreenshot.capture(driver);
        boolean expectedVisibility = false;
        boolean actualVisibility = driver.findElement(By.xpath("//div[@class= 'modal-content']")).isDisplayed();
        verifyDisplay(expectedVisibility, actualVisibility, "Modal Bulk Reject");
    }

    public void bulkBeberapaRejectAndSubmit() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        noapp1Reject = getText(driver, appnoBulkRw1).trim();
        noapp2Reject = getText(driver, appnoBulkRw2).trim();
        click(driver, bulkReject);
        Thread.sleep(500);
        takeScreenshot.capture(driver);
        click(driver, bulkRejectYes);
        Thread.sleep(500);
        click(driver, repayment);
        expected = "Rejected";
        writeText(driver, searchRepay, noapp1Reject);
        value = getText(driver, statuslist);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
        clearText(driver, searchRepay);
        writeText(driver, searchRepay, noapp2Reject);
        value2 = getText(driver, statuslist);
        takeScreenshot.capture(driver);
        verifyValue(expected, value2);
    }

    public void bulkAllReject() { //move here
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, repayment);
        click(driver, btnBulk);
        takeScreenshot.capture(driver);
        Set<String> partner = new HashSet<>();
        Set<String> statAmount = new HashSet<>();
        List<String> dataPartner = new ArrayList<>();
        int baris = 0;
        long sum = 0;
        while (true) {
            // Get all rows in the data table
            List<WebElement> rows = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']"));
            baris += rows.size();
            for (WebElement row : rows) {
                String getUnique1 = row.findElement(By.xpath("td[5]")).getText();
                partner.add(getUnique1);
                String getUnique2 = row.findElement(By.xpath("td[12]")).getText();
                statAmount.add(getUnique2);
                dataPartner.add(getUnique1);
            }
            List<WebElement> listItems = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']/td[10]"));
            for (WebElement listItem : listItems) {
                String itemText = listItem.getText().replace("Rp. ", "").replace(".", "");
                long itemValue = Long.parseLong(itemText); // assuming values are decimal numbers
                sum += itemValue;
            }
            scrollIntoView(driver, next);
            WebElement nextButton = driver.findElement(next);

            try {
                if (nextButton.isEnabled()) {
                    driver.findElement(next).click();
                    takeScreenshot.capture(driver);
                }
            } catch (Exception e) {
                System.out.println("partner             : " + partner);
                System.out.println("Status Pembayaran   : " + statAmount);
                System.out.println("Total Baris         : " + baris);
                System.out.println("Semua Partner       : " + dataPartner);
                System.out.println("Total nominal       : " + sum);
                break;
            }
        }
        // Count the occurrence of each value in the list
        Map<String, Integer> counts = new HashMap<>();
        for (String data : dataPartner) {
            if (counts.containsKey(data)) {
                counts.put(data, counts.get(data) + 1);
            } else {
                counts.put(data, 1);
            }
        }

        // Print out the counts
        for (String values : counts.keySet()) {
            int count = counts.get(values);
            System.out.println(values + ": " + count);
            value4 = values + ": " + count;
        }

        scrollIntoView(driver, bulkReject);
        click(driver, bulkCheckAll);
        click(driver, bulkReject);
        takeScreenshot.capture(driver);
        List<WebElement> button = driver.findElements(By.xpath("//div[@class= 'modal-footer']"));
        for (WebElement webElement : button) {
            value3 = webElement.getText().replace(" ", "").replace("\n", "");
        }
        expected = getText(driver, totAppBlkAppr).replace(":", "").trim();
        expected2 = getText(driver, totNomBlkAppr).replace("Rp. ", "").replace(".", "").replace(": ", "");
        expected3 = "BatalSubmit";
        expected4 = getText(driver, partnerInModalBulk);
        value = String.valueOf(baris);
        value2 = String.valueOf(sum);
        verifyValue(expected, value);
        verifyValue(expected2, value2);
        verifyContain(expected4, value4);
        verifyValue(expected3, value3);
    }

    public void bulkAllRejectAndBatal() {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, bulkRejectNo);
        takeScreenshot.capture(driver);
        boolean expectedVisibility = false;
        boolean actualVisibility = driver.findElement(By.xpath("//div[@class= 'modal-content']")).isDisplayed();
        verifyDisplay(expectedVisibility, actualVisibility, "Modal Bulk Reject");
    }

    public void bulkApprvAndTidakCheckDataKlikApprv() {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, repayment);
        click(driver, btnBulk);
        click(driver, bulkApprove);
        takeScreenshot.capture(driver);
        List<WebElement> button = driver.findElements(By.xpath("//div[@class= 'modal-footer']"));
        for (WebElement webElement : button) {
            value3 = webElement.getText().replace(" ", "").replace("\n", "");
        }
        value = getText(driver, totAppBlkAppr).replace(":", "").trim();
        value2 = getText(driver, totNomBlkAppr).replace("Rp. ", "").replace(".", "").replace(": ", "");

        expected = "0";
        expected3 = "BatalSubmit";
        verifyValue(expected, value);
        verifyValue(expected, value2);
        verifyValue(expected3, value3);
    }

    public void bulkApprvTidakCheckDataKlikReject() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, bulkApproveNo);
        click(driver, bulkReject);
        takeScreenshot.capture(driver);
        List<WebElement> button = driver.findElements(By.xpath("//div[@class= 'modal-footer']"));
        for (WebElement webElement : button) {
            value3 = webElement.getText().replace(" ", "").replace("\n", "");
        }
        value = getText(driver, totAppBlkAppr).replace(":", "").trim();
        value2 = getText(driver, totNomBlkAppr).replace("Rp. ", "").replace(".", "").replace(": ", "");

        expected = "0";
        expected3 = "BatalSubmit";
        verifyValue(expected, value);
        verifyValue(expected, value2);
        verifyValue(expected3, value3);

        //bulk all and approve
        click(driver, bulkApproveNo);
        click(driver, bulkCheckAll);
        click(driver, bulkApprove);
        click(driver, bulkApproveYes);
        Thread.sleep(500);
    }

    public void verifyBulkRejected() {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, repayment);
        writeText(driver, searchRepay, noapp1Reject);
        click(driver, appNolist);
        value = getText(driver, dtlStatus);
        value2 = getText(driver, dtlApprvBy);
        value3 = getText(driver, dtltglApprv).substring(0, 11);
        value4 = getText(driver, dtlRejReason);
        value5 = getText(driver, dtlDesc);
        expected = "Rejected by Analyst";
        expected2 = getText(driver, user).substring(0, 15);
        String format = "dd MMM yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        expected3 = simpleDateFormat.format(new Date());
        expected4 = "Bulk Rejection By Credit Ops";
        expected5 = "-";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
        verifyValue(expected2, value2);
        verifyValue(expected3, value3);
        verifyValue(expected4, value4);
        verifyValue(expected5, value5);
    }

    public void bulkEdit() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, repayment);
        click(driver, bulkEdit);
        writeText(driver, searchRepay, arrReq[7].substring(11, 17));
        click(driver, bulkRow1);
        Thread.sleep(300);
        click(driver, bulkRow2);
        Thread.sleep(500);
        takeScreenshot.capture(driver);
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type= 'checkbox']"));
        long total = 0;
        int baris = 0;
        Set<String> uniqPartner = new HashSet<>();
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                WebElement row = checkbox.findElement(By.xpath("./ancestor::tr[1]"));
                WebElement valueCell = row.findElement(By.xpath("./td[10]")); // assuming value is in the second column
                String valueString = valueCell.getText().trim().replace("Rp. ", "").replace(".", "");
                long value = Long.parseLong(valueString); // assuming value is a decimal number
                total += value;
                String partner = row.findElement(By.xpath("td[5]")).getText();
                uniqPartner.add(partner);
                baris++;
            }
        }

        click(driver, bulkEditChange);
        expected = getText(driver, totAppBlkAppr);
        expected2 = getText(driver, totNomBlkAppr).replace("Rp. ", "").replace(".", "");
        expected3 = getText(driver, partnerInBulk);

        System.out.println("Total value of checked items  : " + total);
        System.out.println("Partner                       : " + uniqPartner);
        value2 = String.valueOf(total);
        value = String.valueOf(baris);
        value3 = uniqPartner.toString().replace("[", "").replace("]", "");
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
        verifyValue(expected2, value2);
        verifyValue(expected3, value3);
        click(driver, bulkEditChangeNo);

    }

    public void bulkEditCheckall() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        clearText(driver, searchRepay);
        Thread.sleep(500);
        click(driver, bulkCheckAll);
        takeScreenshot.capture(driver);
        Set<String> partner = new HashSet<>();
        Set<String> statAmount = new HashSet<>();
        List<String> dataPartner = new ArrayList<>();
        int baris = 0;
        long sum = 0;
        while (true) {
            // Get all rows in the data table
            List<WebElement> rows = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']"));
            baris += rows.size();
            for (WebElement row : rows) {
                String getUnique1 = row.findElement(By.xpath("td[5]")).getText();
                partner.add(getUnique1);
                String getUnique2 = row.findElement(By.xpath("td[12]")).getText();
                statAmount.add(getUnique2);
                dataPartner.add(getUnique1);
            }
            List<WebElement> listItems = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']/td[10]"));
            for (WebElement listItem : listItems) {
                String itemText = listItem.getText().replace("Rp. ", "").replace(".", "");
                long itemValue = Long.parseLong(itemText); // assuming values are decimal numbers
                sum += itemValue;
            }
            scrollIntoView(driver, next);
            WebElement nextButton = driver.findElement(next);

            try {
                if (nextButton.isEnabled()) {
                    driver.findElement(next).click();
                    takeScreenshot.capture(driver);
                }
            } catch (Exception e) {
                System.out.println("partner : " + partner);
                System.out.println("Status Pembayaran : " + statAmount);
                System.out.println("Total Baris : " + baris);
                System.out.println("Semua Partner : " + dataPartner);
                System.out.println("Total nominal : " + sum);
                break;
            }
        }
        // Count the occurrence of each value in the list
        Map<String, Integer> counts = new HashMap<>();
        for (String data : dataPartner) {
            if (counts.containsKey(data)) {
                counts.put(data, counts.get(data) + 1);
            } else {
                counts.put(data, 1);
            }
        }

        // Print out the counts
        for (String values : counts.keySet()) {
            int count = counts.get(values);
            System.out.println(values + ": " + count);
            value4 = values + ": " + count;
        }

        scrollIntoView(driver, bulkApprove);
        WebElement checkboxes = driver.findElement(By.xpath("//input[@type= 'checkbox']"));
        if (!checkboxes.isSelected()) {
            click(driver, bulkCheckAll);
        }
        click(driver, bulkApprove);
        takeScreenshot.capture(driver);
        List<WebElement> button = driver.findElements(By.xpath("//div[@class= 'modal-footer']"));
        for (WebElement webElement : button) {
            value3 = webElement.getText().replace(" ", "").replace("\n", "");
        }
        expected = getText(driver, totAppBlkAppr).replace(":", "").trim();
        expected2 = getText(driver, totNomBlkAppr).replace("Rp. ", "").replace(".", "").replace(": ", "");
        expected3 = "BatalSubmit";
        expected4 = getText(driver, partnerInModalBulk);
        value = String.valueOf(baris);
        value2 = String.valueOf(sum);
        verifyValue(expected, value);
        verifyValue(expected2, value2);
        verifyContain(expected4, value4);
        verifyValue(expected3, value3);
        click(driver, bulkEditChangeNo);
        click(driver, bulkCheckAll);
    }

    public void bulkEditCheckbeberapaAndCancel() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, bulkRow1);
        Thread.sleep(300);
        click(driver, bulkRow2);
        Thread.sleep(500);
        takeScreenshot.capture(driver);
        click(driver, bulkEditChange);
        takeScreenshot.capture(driver);
        click(driver, bulkEditChangeNo);
        takeScreenshot.capture(driver);
        boolean expectedVisibility = false;
        boolean actualVisibility = driver.findElement(By.xpath("//div[@class= 'modal-content']")).isDisplayed();
        verifyDisplay(expectedVisibility, actualVisibility, "Modal Bulk Edit");
    }

    public void bulkEditCheckBeberapaAndChange() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);
        no_app1 = getText(driver, appnoBulkRw1);
        no_app2 = getText(driver, appnoBulkRw2);
        click(driver, bulkEditChange);
        Thread.sleep(500);
        takeScreenshot.capture(driver);
        click(driver, bulkEditChangeYes);
        Thread.sleep(500);
        click(driver, repayment);
        expected = "Waiting for Approval";
        writeText(driver, searchRepay, no_app1);
        value = getText(driver, statuslist);
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
        clearText(driver, searchRepay);
        writeText(driver, searchRepay, no_app2);
        value2 = getText(driver, statuslist);
        takeScreenshot.capture(driver);
        verifyValue(expected, value2);
    }

    public void bulkEditCheckAllAndCancel() {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, repayment);
        click(driver, bulkEdit);
        click(driver, bulkCheckAll);
        takeScreenshot.capture(driver);
        click(driver, bulkEditChange);
        takeScreenshot.capture(driver);
        click(driver, bulkEditChangeNo);
        takeScreenshot.capture(driver);
        boolean expectedVisibility = false;
        boolean actualVisibility = driver.findElement(By.xpath("//div[@class= 'modal-content']")).isDisplayed();
        verifyDisplay(expectedVisibility, actualVisibility, "Modal Bulk Edit");
    }

    public void apprvAfterEdited() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        logoutApprover(driver);
        loginApproverLdap(driver);
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, repayment);
        writeText(driver, searchRepay, no_app1);
        createInfo(extent_test_case, "This Edited data from Scenario before (Edit Data)");
        takeScreenshot.capture(driver);
        click(driver, appNolist);
        takeScreenshot.capture(driver);
        click(driver, btnApprove);
        click(driver, btnApproveYa);
        writeText(driver, searchRepay, no_app1);
        value = getText(driver, statuslist);
        expected = "Approved";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }

    public void rejectAfterEdited() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent, "Coming Soon...");
        createTest(iRowPictName, extent_test_case, extent);
        click(driver, repayment);
        writeText(driver, searchRepay, no_app2);
        createInfo(extent_test_case, "This Edited data from Scenario before (Edit Data)");
        takeScreenshot.capture(driver);
        click(driver, appNolist);
        takeScreenshot.capture(driver);
        click(driver, btnReject);
        click(driver, optiRejectReaDropdown);
        click(driver, optiRejectRea1);
        clearText(driver, rejectDescField);
        writeText(driver, rejectDescField, "Reject Edited Data !");
        takeScreenshot.capture(driver);
        click(driver, btnRejectYa);
        Thread.sleep(1000);
        writeText(driver, searchRepay, no_app2);
        value = getText(driver, statuslist);
        expected = "Rejected";
        takeScreenshot.capture(driver);
        verifyValue(expected, value);
    }
}

