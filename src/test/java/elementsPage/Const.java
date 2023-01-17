package elementsPage;

import org.openqa.selenium.By;

public class Const {
    public static final String e2e_environment = "E2E";
    public static final String uat_environment = "UAT";
    public static final String urlE2E = "https://10.27.62.156:7053/login";//e2e
    public static final String urlUAT = "https://10.27.62.157:7053/login";//UAT
    public static final String e2e_userMaker = "u_ATMaker";
    public static final String e2e_userApprover = "u_ATApprov";
    public static final String e2e_password = "P@ssw0rd";
    public static final String uat_userMaker = "u_ATMaker";
    public static final String uat_userApprover = "u_ATApprov";
    public static final String uat_password = "P@ssw0rd";
    public static final String e2e_user_ldap_maker = "u_ATMaker";
    public static final String e2e_pwd_ldap_maker = "P@ssw0rd";
    public static final String e2e_user_ldap_approveRecomend = "surya.simarmata";
    public static final String e2e_pwd_ldap_approveRecomend = "Surya2022";
    public static final String e2e_user_ldap_approveRealisasi = "riani.amalia"; //riani.amalia sukron.mamun
    public static final String e2e_pwd_ldap_approveRealisasi = "Riani2022"; //Riani2022 Sukron1234

    public static final String noMatch = "No matching records found";
    public static final String noData = "No data available in table";
    public static final String pthFileValidation = ".//fileValidation//";
    public static final String resultDataDummyFile = ".//resultDataDummyFile//";
    public static final String resultApprovalFile = ".//resultApprovalFile//";
    public static final String resultApprovalFileDiffPartner = ".//resultApprovalFileDiffPartner//";
    public static final String resultDataDummySuppDocZip = ".//dummy_SuppDoc//";
    public static final String pthResultScenario = ".//resultScenario//";
    public static final String pthDummyZIP = ".//dummyZIP//";
    public static final String pthResultScenario2 = "C://Users//" + System.getProperty("user.name") + "//Desktop//resultScenario//";
//    public static final String fileNMScenario = "Scenario Chanelling Badan Usaha - Positif.xlsx";
    public static final String fileNMScenario = "Badan Usaha - Positif.xlsx";
    public static final String fileNMScenario2 = "Sample Badan Usaha.xlsx";
    public static final String nameFileScenario = "Scenario Chanelling Badan Usaha - Positif ";
    public static final String pthTestData = ".//testData.xlsx";
//    public static final String pthFileImage = ".//temp//captureImages//pict_";
    public static final String pthFileImage = ".//test-output//Selenix-Spark//pict_";
    public static final String pthTemp = ".//temp//";
    public static final String pthImages = "./test-output/Selenix-Spark/";
    public static final String sheetTestData = "Data Testing";
    public static final String sheetTestDataMaintananceTable = "maintananceTable";
//    public static final String sheetApprovalFormBU = "Approval Form Badan Usaha";
    public static final String sheetTCApprovFormBU = "TC - Approval Form Badan Usaha";
    public static final String scSheetApp = "Approval File";
    public static final String scSheetRea = "Realisasi File";
    public static final String scSheetPengurus = "Pengurus File";
    public static final String scSheetPercentages = "Persentase";
    public static final String nFileScenario = "Negatif";
    public static final String pFileScenario = "Positif";
    public static final String pFileTC = "Sample Badan Usaha";
    public static final String sheetImages = "Capture Images";

    //public static final String sheetCaptureApproval = "Sample";
    public static final String sheetCaptureApprovFile = "Capture Validasi File BU";
    public static final String sheetCaptureApproval = "Capture Approval Badan Usaha";
    public static final String sheetCaptureRealization = "Capture Realization Badan Usaha";

    public static final String sheetBadanUsahaTable = "Table Application Form";
    public static final String sheetBadanUsahaDetail = "Application Form Detail";
    public static final String sheetBadanUsahaRecommentation = "Recommendation";
    public static final String sheetBadanUsahaApprove = "approve";

    public static final String attachmentName = "Cek screenshoot di report html Approval Badan Usaha)";
    public static final String attachmentNameRea = "Cek screenshoot di report html Capture Realization Badan Usaha";
    public static final String attachmentNameValidateAppFile = "Cek screenshoot di report html Capture Approval File BU";
    public static final String attachmentNameValidateReaFile = "Cek screenshoot di report html Capture Realisasi File BU";

    //    public static final String pthFileImage = ".//target//captureImages/pict_";
    public static final String pPattern = "ddMMyyy-HHmmss";

    public static final String extPict = ".png";
    public static final String glPattern = "ddMMyyyy";
    public static final String timePattern = "HHmmss";

    public static final String extCSV = ".csv";
    public static final String extExcel = ".xlsx";
    public static final String appFile = "APPFILE";
    public static final String reaFile = "REAFILE";
    public static final String txtAppIDV = "AppIDV";
    public static final String txtReaIDV = "RealisasiIDV";
    public static final String csvApp = "APP";
    public static final String csvRea = "REA";
    public static final String csvPengurus = "PENGURUS";
    public static final String txtRea = "Realisasi";
    public static final String txtApp = "App";
    public static final String chartTitleP = "Perseorangan";
    public static final String chartTitleB = "Badan Usaha";
    public static final String tStatus = "Passed";
    public static final String sStatus = "Skip";
    public static final String fStatus = "Failed";
    public static final String sNull = "null";
    public static final String rBerhasil = "BERHASIL";
    public static final String sheetApprovalFormBU = "TC - Approval Form Badan Usaha";
    public static final String sheetRealizationFormBU = "TC - Realization Badan Usaha";
    public static final String sheetApprovalFileBU = "TC - Validasi File Badan Usaha";
    public static final String sheetRealisasiFileBU = "TC - Validate File Badan Usaha";
    //common
    public static final int delay = 1500;
    public static final int seconds = 30;
    public static final String scrollIntoview = "arguments[0].scrollIntoView();";
    public static final By btnDetails = By.id("details-button");
    public static final By btnUnsafe = By.id("proceed-link");
    public static final By userId = By.id("username");
    public static final By pwd = By.id("password");
    public static final By btnLogin = By.xpath("//button[contains(.,'Sign In')]");
    public static final By btnProfile = By.xpath("//a[@id='header-foto-profil']");
    public static final By btnLogout = By.linkText("Logout");
    public static final By menuApproval = By.xpath("//li[11]/a/div");
    public static final By btnBulkRecomend = By.linkText("Bulk Recommendation");
    public static final By txtSearch = By.id("search-filter");
    public static final By radiobtnAppAll = By.xpath("//table[@id='channelingApprovalDataTable']/thead/tr/th/div/label");
    public static final By recomended = By.xpath("//button[@id='recommended']");
    public static final By noDataTable = By.xpath("//td[contains(.,'No matching records found')]");
    public static final By statusForReview = By.xpath("//*[@id='select-status']/option[3]");
    public static final By statusForApproval = By.xpath("//*[@id='select-status']/option[4]");
    //app rea
    public static final By rwDatafirstApp1 = By.xpath("//*[@id='dataTable']/tbody/tr[1]/td[4]/a");

    public static final By txtTbl_nomorAplikasi = By.xpath("//*[@id='dataTable']/tbody/tr/td[3]");
    public static final By txtTbl_namaDebitur = By.xpath("//*[@id='dataTable']/tbody/tr/td[4]/a");
    public static final By txtTbl_partner = By.xpath("//*[@id='dataTable']/tbody/tr/td[5]");
    public static final By txtTbl_date = By.xpath("//*[@id='dataTable']/tbody/tr/td[6]");
    public static final By txtTbl_palfon = By.xpath("//*[@id='dataTable']/tbody/tr/td[7]");
    public static final By txtTbl_interestRate = By.xpath("//*[@id='dataTable']/tbody/tr/td[8]");

    public static final By txtDetail_partner = By.xpath("/html/body/div[2]/form/div[2]/div/div[2]/div/div/div[2]");
    public static final By txtDetail_namaDebitur = By.xpath("/html/body/div[2]/form/div[2]/div/div[2]/div/div/div[4]");
    public static final By txtDetail_status = By.xpath("/html/body/div[2]/form/div[2]/div/div[2]/div/div/div[6]/div");

    public static final By txtDetail_nomorAplikasi = By.xpath("/html/body/div[2]/form/div[2]/div/div[2]/div/div/div[8]");
    public static final By txtDetail_tglPengajuan = By.xpath("/html/body/div[2]/form/div[2]/div/div[2]/div/div/div[10]");
    public static final By txtDetail_jenisDebitur = By.xpath("/html/body/div[2]/form/div[2]/div/div[2]/div/div/div[12]");
    public static final By txtDetail_plafon = By.xpath("/html/body/div[2]/form/div[2]/div/div[2]/div/div/div[14]");
    public static final By txtDetail_jangkaWaktu = By.xpath("/html/body/div[2]/form/div[2]/div/div[2]/div/div/div[16]");
    public static final By txtDetail_interestRate = By.xpath("/html/body/div[2]/form/div[2]/div/div[2]/div/div/div[18]");
    public static final By txtDetail_nik = By.xpath("/html/body/div[2]/form/div[2]/div/div[2]/div/div/div[20]");
    public static final By txtDetail_npwp = By.xpath("/html/body/div[2]/form/div[2]/div/div[2]/div/div/div[22]");

    public static final By txtDetail_suppDoc = By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/div/div[28]");

    public static final By txtDetail_pendukung = By.xpath("/html/body/div[2]/form/div[2]/div/div[2]/div/div/div[28]/a");

    public static final By list_source = By.xpath("//span[@id='select2-select-source-container']");
    public static final By list_sourceLOS = By.xpath("//*[starts-with(@id, 'select2-select-source-result-') and contains(@id,'-LOS')]");
    public static final By list_status = By.xpath("//span[@id='select2-select-status-container']");
    public static final By list_statusApprovalExpired = By.xpath("//*[@id='select2-select-status-results']/li[6]");
    public static final By list_statusApprovalExpired2 = By.xpath("//*[starts-with(@id, 'select2-select-status-result-') and contains(@id,'-Approval Expired')]");
    public static final By list_statusApproved = By.xpath("//*[starts-with(@id, 'select2-select-status-result-') and contains(@id,'-Approved')]");
    public static final By list_partner = By.xpath("//span[@id='select2-select-partner-container']");
    public static final By list_partnerAll = By.xpath("//*[@id='select2-select-partner-results']/li[1]");
    public static final By pageNumber = By.xpath("//*[@id='dataTable_paginate']");
    public static final By nextPage = By.xpath("//*[@id='dataTable_next']/a");
    public static final By previousPage = By.xpath("//*[@id='dataTable_previous']/a");
    public static final By specificPage = By.xpath("//*[@id='dataTable_paginate']/ul/li[4]/a");
    public static final By shortColumn_debtorName = By.xpath("//*[@id='dataTable']/thead/tr/th[4]");
    public static final By shortColumn_date = By.xpath("//*[@id='dataTable']/thead/tr/th[6]");
    public static final By shortColumn_status = By.xpath("//*[@id='dataTable']/thead/tr/th[9]");
    public static final By radioButtonFirst = By.xpath("//*[@id='channelingApprovalDataTable']/tbody/tr[1]/td[1]/div/label");

    public static final By rwDatafirstApp = By.xpath("//*[@id='dataTable']/tbody/tr[1]/td[3]/a");
    public static final By dropDwRecomendation = By.xpath("//*[@id='dropdown-choice']/option[2]");
    public static final By txtFieldRecomendation = By.xpath("//*[@id='recomendation-field']");
    public static final String textRecomendation = "Recomended Automation";
    public static final By btnSubmitApp = By.xpath("//*[@id='btn-submit-recomendation']");
    public static final By dropDwApprove = By.xpath("//*[@id='select2-dropdown-choice-container']");
    public static final By valueApprove = By.xpath("//*[starts-with(@id, 'select2-dropdown-choice-result-') and contains(@id, '-1')]");
    public static final By txtFieldNotes = By.xpath("//*[@id='notes-field']");
    //rea
    public static final By menuRealization = By.xpath("//li[4]/a/div");
    public static final By btnBulkApprove = By.linkText("Bulk Approve");
    public static final By rwDataFirstRea = By.xpath("//*[@id='channelingTable']/tr[1]/td[4]/a");
    public static final By btnApproveRea = By.xpath("//*[@id='approved']");
    public static final By btnYa = By.id("formSubmit");
    public static final By txtSearchRea = By.id("myInput");
    public static final By filterStatusRea = By.xpath("//*[@id='filterStatus']/option[2]");
    public static final By radiobtnReaAll = By.id("selectAll");
    public static final By btnSubmitApprove = By.id("btnSubmitRealization");
}
