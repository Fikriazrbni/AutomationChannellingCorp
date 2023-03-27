package elementsPage;

import capture.TakeScreenshot;
import com.opencsv.exceptions.CsvException;
import createDataCSV.DataCSVPending;
import jobs.*;
import org.openqa.selenium.*;
import org.testng.annotations.IFactoryAnnotation;
import readFile.ReadCSVFormApproval;
import readFile.UpdateCSV;
import runner.FormRealizationRunner;
import testData.ReadTestData;
import writeFile.MoveFileScenario;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static badanUsaha.LoginAsMaker.*;
import static badanUsaha.LoginAsApprover.*;
import static badanUsaha.LibUtils.*;
import static elementsPage.ApprovalFormPage.*;
import static elementsPage.ApprovalFormPage.rwDatafirstApp1;
import static runner.FormRealizationRunner.extent;
import static runner.FormRealizationRunner.extent_test_case;

public class RealizationFormPage extends BaseAction{

    public static final By body                        = By.cssSelector("body");
    public static final By notif                       = By.xpath("//img[contains(@class, 'Attach')]");
    public static final By notifSeeAll                 = By.xpath("//span[contains(@class, 'See-All-Notification')]");
    public static final By menuApprovalForm            = By.xpath("//a[contains(@href, 'approval-form-process')]");
    public static final By txtSearchAppForm            = By.id("search-filter");
    public static final By rowApp1AppForm              = By.xpath("//tr[@class='odd']//td[4]/a");
    public static final By menuReaForm                 = By.xpath("(//a[contains(@href, 'approval-form')])[1]");
    public static final By txtSearch                   = By.id("myInput");
    public static final By filterStatus                = By.id("select2-filterStatus-container");
    public static final By filterWaitApproval          = By.xpath("//li[text()= 'Waiting Approval']");
    public static final By filterPending               = By.xpath("//li[text()= 'Pending']");
    public static final By filterPartner               = By.id("select2-filterSource-container");
    public static final By partnerTesPending           = By.xpath("//li[text()= 'PT Tes Pending']");
    public static final By rwDatafirstApp1             = By.xpath("//tr[@class='odd']//td[4]/a");
    public static final By rwDatafirstApp2             = By.xpath("//tr[@class='even']//td[4]/a");
    public static final By txtTbl_source               = By.xpath("//tr[@class='odd']//td[2]");
    public static final By txtTbl_nomorAplikasi        = By.xpath("//tr[@class='odd']//td[3]");
    public static final By txtTbl_namaDebitur          = By.xpath("//tr[@class='odd']//td[4]");
    public static final By txtTbl_partner              = By.xpath("//tr[@class='odd']//td[5]");
    public static final By txtTbl_date                 = By.xpath("//tr[@class='odd']//td[6]");
    public static final By txtTbl_loanAmount           = By.xpath("//tr[@class='odd']//td[7]");
    public static final By txtTbl_rate                 = By.xpath("//tr[@class='odd']//td[8]");
    public static final By txtTbl_statusRea            = By.xpath("//tr[@class='odd']//td[9]");
    public static final By txtTbl_statusRea2            = By.xpath("//tr[@class='even']//td[9]");
    public static final By txtTbl_statusApp            = By.xpath("//tr[@class='odd']//td[14]");

    public static final By dtlBtnBack                  = By.xpath("//a/img[@class='Arrow-Left']");
    public static final By dtlBtnApprove               = By.xpath("//*[@id='approved']");
    public static final By dtlBtnReject                = By.xpath("//*[@id='rejected-form']");
    public static final By dtlTextConfirmApprove      = By.xpath("//*[@id=\"modal-body\"]/h6");
    public static final By dtlBtnConfirmYes            = By.xpath("//*[@id='formSubmit']");
    public static final By dtlBtnConfirmNo             = By.xpath("//*[@id='modal-cancel']");
    public static final By dtlModalConfirmReject       = By.xpath("//*[@id='modal-rejected']");
    public static final By dtlModalConfirmRejectType   = By.xpath("//*[@id='select2-rejectDescription-container']");
    public static final By dtlModalConfirmRejectList   = By.xpath("//*[@id='rejectDescription']");
    public static final By dtlModalConfirmRejectType_0 = By.xpath("//*[@id='rejectDescription']/option[1]");
    public static final By dtlModalConfirmRejectType_1 = By.xpath("//*[@id='rejectDescription']/option[2]");
    public static final By dtlModalConfirmRejectType_2 = By.xpath("//*[@id='rejectDescription']/option[3]");
    public static final By dtlModalConfirmRejectReason = By.xpath("//*[@name='rejectReason']");
    public static final By dtlBtnRejectYes             = By.xpath("(//*[@id='formSubmit'])[2]");
    public static final By dtlBtnRejectNo              = By.xpath("//*[@id='modal-cancel-reject']");
    public static final By tblPengurus                 = By.xpath("//table[@id='datatable']/tbody");
    public static final By dtlPartner                  = By.xpath("(//label[@class='col-form-label'])[1]");
    public static final By dtlDebtName                 = By.xpath("(//label[@class='col-form-label'])[2]");
    public static final By dtlStatus                   = By.xpath("//label[ @class='col-form-label btn-info btn-circle  btn-sm text-white text-center ']");
    public static final By dtlAppId                    = By.xpath("(//label[@class='col-form-label'])[3]");
    public static final By dtlDate                     = By.xpath("(//label[@class='col-form-label'])[4]");
    public static final By dtlCtgDebt                  = By.xpath("(//label[@class='col-form-label'])[5]");
    public static final By dtlLoanAmount               = By.xpath("(//label[@class='col-form-label'])[6]");
    public static final By dtlDuration                 = By.xpath("(//label[@class='col-form-label'])[7]");
    public static final By dtlInterestRate             = By.xpath("(//label[@class='col-form-label'])[8]");
    public static final By dtlCtgCredit                = By.xpath("(//label[@class='col-form-label'])[9]");
    public static final By dtlUtil                     = By.xpath("(//label[@class='col-form-label'])[10]");
    public static final By dtlPKNo                     = By.xpath("(//label[@class='col-form-label'])[11]");
    public static final By dtlContact                  = By.xpath("(//label[@class='col-form-label'])[12]");
    public static final By dtlInstalment_1             = By.xpath("(//label[@class='col-form-label'])[13]");
    public static final By dtlNPWP                     = By.xpath("(//label[@class='col-form-label'])[14]");
    public static final By dtlTelp                     = By.xpath("(//label[@class='col-form-label'])[15]");
    public static final By dtlAddress                  = By.xpath("(//label[@class='col-form-label'])[16]");
    public static final By dtlAddWard                  = By.xpath("(//label[@class='col-form-label'])[17]");
    public static final By dtlAddDistrict              = By.xpath("(//label[@class='col-form-label'])[18]");
    public static final By dtlAddPostalCode            = By.xpath("(//label[@class='col-form-label'])[19]");
    public static final By dtlAddCodeDATI_II           = By.xpath("(//label[@class='col-form-label'])[20]");
    public static final By dtlFields                   = By.xpath("(//label[@class='col-form-label'])[21]");
    public static final By dtlEntity                   = By.xpath("(//label[@class='col-form-label'])[22]");
    public static final By dtlSector                   = By.xpath("(//label[@class='col-form-label'])[23]");
    public static final By dtlGoPublic                 = By.xpath("(//label[@class='col-form-label'])[24]");
    public static final By dtlGroupDebt                = By.xpath("(//label[@class='col-form-label'])[25]");
    public static final By dtlIncomePerYear            = By.xpath("(//label[@class='col-form-label'])[26]");
    public static final By dtlTurnOver                 = By.xpath("(//label[@class='col-form-label'])[27]");
    public static final By dtlCertNO                   = By.xpath("(//label[@class='col-form-label'])[28]");
    public static final By dtlCertNOLatest             = By.xpath("(//label[@class='col-form-label'])[29]");
    public static final By dtlCertDeadline             = By.xpath("(//label[@class='col-form-label'])[30]");
    public static final By dtlCertPublish              = By.xpath("(//label[@class='col-form-label'])[31]");
    public static final By dtlCertPlaces               = By.xpath("(//label[@class='col-form-label'])[32]");
    public static final By noAplikasi                    = By.xpath("//label[text() = 'Nomor Aplikasi :']//following-sibling::div");
    public static final By noUrutPengurus             = By.xpath("//tr[td='Nomor Urut Pengurus:']//following-sibling::td");
    public static final By jmlPengurus              =By.xpath("//tr[td='Jumlah Pengurus:']//following-sibling::td");
    public static final By sandiJbtBI               = By.xpath("//tr[td='Sandi Jabatan BI:']//following-sibling::td");
    public static final By pangsaKepemilikan        = By.xpath("//tr[td='Pangsa Kepemilikan:']//following-sibling::td");
    public static final By bentukPengurus           = By.xpath("//tr[td='Bentuk Pengurus:']//following-sibling::td");
    public static final By mdlDasar               = By.xpath("//tr[td='Modal Dasar:']//following-sibling::td");
    public static final By mdlDisetor             = By.xpath("//tr[td='Modal Disetor:']//following-sibling::td");
    public static final By mdlDitempatkan         = By.xpath("//tr[td='Modal Ditempatkan:']//following-sibling::td");
    public static final By npwpPeng                 = By.xpath("//tr[td='NPWP Pengurus:']//following-sibling::td");
    public static final By namaPeng                 = By.xpath("//tr[td='Nama Pengurus:']//following-sibling::td");
    public static final By altPeng                  = By.xpath("//tr[td='Alamat Pengurus:']//following-sibling::td");
    public static final By altKelurahan             = By.xpath("//tr[td='Alamat_Kelurahan:']//following-sibling::td");
    public static final By altKecamatan             = By.xpath("//tr[td='Alamat_Kecamatan:']//following-sibling::td");
    public static final By altDatiII                = By.xpath("//tr[td='Alamat_Dati II:']//following-sibling::td");
    public static final By noKtp                    = By.xpath("//tr[td='No. KTP:']//following-sibling::td");
    public static final By noAkte                   = By.xpath("//tr[td='No. Akte:']//following-sibling::td");
    public static final By tglLahir                 = By.xpath("//tr[td='Tanggal Lahir:']//following-sibling::td");
    public static final By tglAkte                  = By.xpath("//tr[td='Tanggal Akte:']//following-sibling::td");
    public static final By datiIILahir              = By.xpath("//tr[td='Dati II tempat lahir:']//following-sibling::td");
    public static final By jnsKelamin               = By.xpath("//tr[td='Jenis Kelamin:']//following-sibling::td");
    public static final By expand1               = By.xpath("//td[text() = '1']//following-sibling::td[1]");
    public static final By expand2               = By.xpath("//td[text() = '2']//following-sibling::td[1]");
    public static final By expand3               = By.xpath("//td[text() = '3']//following-sibling::td[1]");
    public static final By expand4               = By.xpath("//td[text() = '4']//following-sibling::td[1]");
    public static final By listSorting              = By.xpath("//td[@class='details-control sorting_1']");
    public static final By txtDetail_NoApp         = By.xpath("(//label[@class='col-form-label'])[3]");
    public static final By inputSearch             = By.id("myInput");
    public static final By pangsaList1               = By.xpath("//td[text()='1']//following-sibling::td[4]");
    public static final By pangsaList2               = By.xpath("//td[text()='2']//following-sibling::td[4]");
    public static final By pangsaList3               = By.xpath("//td[text()='3']//following-sibling::td[4]");
    public static final By pangsaList4               = By.xpath("//td[text()='4']//following-sibling::td[4]");


    private static final WebDriver driver = FormRealizationRunner.driver;
    int iSeq = 1;
    int iRowPictName;
    int row2 = 21;
    int row3 = 42;
    int row4 = 63;
    TakeScreenshot takeScreenshot = new TakeScreenshot();
    ReadTestData readTestData = new ReadTestData();
    ReadCSVFormApproval readCSVFormApproval = new ReadCSVFormApproval();
    DummyReaForm_BU connServer = new DummyReaForm_BU();
    String expected,expected2 ,value, value2, value3, value4, value5, value6, value7, value8, no_app1, no_app2, no_app3, no_app4, no_app5, no_app6, no_app7, no_app8, no_app9, no_app10;
    String Karakter5000 = "ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP fPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnhd";
    String Karakter4999 = "ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP fPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnh";

    DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDateTime localDate   = LocalDateTime.now();
    LocalDateTime PastDate    = localDate.minusDays(1);
    String formattedToday     = localDate.format(dateTime);
    String formattedYesterday = PastDate.format(dateTime);

    public void login() throws IOException {
        readTestData.testData();
        readTestData.testDataMaintananceTable();
        loginApproverLdap(driver);

        String[] arr = readCSVFormApproval.fileCSVRea();
        no_app1 = arr[30];
        no_app2 = arr[60];
        no_app3 = arr[90];
        no_app4 = arr[120];
        no_app5 = arr[150];
        no_app6 = arr[180];
        no_app7 = arr[210];
        no_app8 = arr[240];
    }
    public void logout(WebDriver conn) throws InterruptedException {
        logoutApprover(driver);
    }
    public void changeUserToApprove() throws InterruptedException {
        logoutMaker(driver);
        loginApprover(driver);
        click(driver,menuApprovalForm);
    }
    public void changeUserToMaker() throws InterruptedException {
        logoutApprover(driver);
        loginMaker(driver);
        click(driver,menuApprovalForm);
    }

    public void menuNotification() {
        click(driver, notif);
        click(driver, notifSeeAll);
    }
    public void NotificationFile() {
        List<WebElement> ListRow = driver.findElements(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),\"Approval\")][contains(text(),\"Akseleran\")] "));
        String times             = driver.findElement(By.xpath("//tr[1][@class='pointer'] //td[4][contains(text(),'mins ago ')]")).getText();
        String rowValue          = "";
        String getTimeNotify     = "";
        for (WebElement webElement : ListRow) {
            if (webElement.getText().contains("Akseleran")) {
                rowValue = webElement.getText();
            }
        }
        System.out.println(rowValue+"_"+times);
    }
    public void verifyNotification() {
        iRowPictName = 1;
//        createTestSkip(iRowPictName, extent_test_case, extent);

        List<WebElement> ListRow = driver.findElements(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'KOMUNAL')] | //tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'AKSELERAN')] "));
        value                    = "";
        boolean dataConsume      = driver.findElement(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'KOMUNAL')] | //tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'AKSELERAN')] ")).isDisplayed();
        for (WebElement webElement : ListRow) {
            if (webElement.getText().contains("KOMUNAL")) {
                value            = webElement.getText();
            } else if (webElement.getText().contains("AKSELERAN")) {
                value            = webElement.getText();
            }
        }

        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValueDisplay(dataConsume,true, "Consume data berhasil"+value);
        takeScreenshot.capture(driver);
    }

    public void verifyWaitingApproval() {
        iRowPictName = 2;

        writeText(driver, txtSearch, no_app1);//noapp1
        value = getText(driver, txtTbl_statusRea);
        expected = "Waiting Approval";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }

    public void menuRealizationForm()   {
        click(driver, menuReaForm);
    }
    public void rejectPending() throws InterruptedException {

        click(driver, filterStatus);
        scrollIntoView(driver, filterPending);
        click(driver, filterPending);

        click(driver, filterPartner);
        scrollIntoView(driver, partnerTesPending);
        click(driver, partnerTesPending); Thread.sleep(500);
        List<WebElement> rows = driver.findElements(By.xpath("//tr[@class= 'odd' or @class= 'even']"));

        for (int i =1; i <= rows.size(); i++ ) {
            click(driver, filterStatus);
            scrollIntoView(driver, filterWaitApproval);
            click(driver, filterWaitApproval);
            click(driver, filterPartner);
            scrollIntoView(driver, partnerTesPending);
            click(driver, partnerTesPending);

            List<WebElement> rowNull = driver.findElements(By.xpath("//td[text()= 'No matching records found']"));
            if (rowNull.isEmpty()) {
                click(driver, rwDatafirstApp1);
                click(driver, dtlBtnReject);
                click(driver, dtlModalConfirmRejectType);
                click(driver, dtlModalConfirmRejectType_2);
                click(driver, dtlModalConfirmRejectType);
                writeText(driver, dtlModalConfirmRejectReason, "Reject For Pending");
                click(driver, dtlModalConfirmReject);
                Thread.sleep(500);
                click(driver, dtlBtnRejectYes);
                Thread.sleep(1000);
            }else {
                break;
            }
        }
    }

    public void tableApprovalForm(){
        isPresent(driver, rwDatafirstApp1);
    }

    public void verifySource() {
        iRowPictName = 3;

        value    = getText(driver, txtTbl_source);
        expected = "LOS";

        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void verifyAppNo() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, txtTbl_nomorAplikasi);
        expected = arr[30];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void verifyDebtorName() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, txtTbl_namaDebitur);
        expected = arr[31];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void verifyPartner() {
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, txtTbl_partner);
        expected = readTestData.companyName;
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);

        if (readTestData.environment.equals("E2E")) {
            verifyValue(value,expected);
        } else{
            verifyValue(value,expected);
        }
        takeScreenshot.capture(driver);
    }
    public void verifyDate() {
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, txtTbl_date);
        expected = formattedToday;
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value.substring(0, 10),expected);
        takeScreenshot.capture(driver);
    }
    public void verifyLoanAmount() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[47]));
        value    = getText(driver, txtTbl_loanAmount);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);

        value = getText(driver, txtTbl_loanAmount)
                .replace(".", "")
                .replace("Rp", "")
                .replace(",", "")
                .trim();
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void verifyRate() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, txtTbl_rate);
        expected = arr[48];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        value = getText(driver, txtTbl_rate)
                .replace("%", "")
                .replace(".", "");
        verifyValue(0+value,expected);
        takeScreenshot.capture(driver);
    }

    public void debtorDetail() {
        click(driver, rwDatafirstApp1);
        isPresent(driver, dtlAppId);
    }
    public void detailPartnerName() {
        iRowPictName = 10;

        scrollIntoView(driver, dtlPartner);
        value    = getText(driver, dtlPartner);
        expected = readTestData.companyName;
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        if (readTestData.environment.equals("E2E")) {
            verifyValue(value,expected);
        } else{
            verifyValue(value,expected);
        }
        takeScreenshot.capture(driver);
    }
    public void detailDebtorName() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlDebtName);
        expected = arr[31];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailStatus() {
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlStatus);
        expected = "Waiting Approval";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailAppNo() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlAppId);
        expected = arr[30];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailTanggalPengajuan() throws IOException {
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlDate);
        expected = formattedToday;
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value.substring(0, 10),expected);takeScreenshot.capture(driver);
    }
    public void detailJenisDebitur() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCtgDebt);
        expected = arr[32];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected.trim()+"adan Usaha");takeScreenshot.capture(driver);
    }
    public void detailPlafon() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[47]));
        value    = getText(driver, dtlLoanAmount);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        value    = getText(driver, dtlLoanAmount)
                   .replace(".", "")
                   .replace("Rp", "")
                   .replace(",", "");
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailJangkaWaktu() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[45]));
        value    = getText(driver, dtlDuration);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected.trim()+" Bulan");takeScreenshot.capture(driver);
    }
    public void detailInterestRate() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[48]));
        value    = getText(driver, dtlInterestRate);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        value    = getText(driver, dtlInterestRate)
                   .replace("%", "")
                   .replace(".", "")
                   .replace(",","");
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailJenisKredit() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCtgCredit);
        expected = ReadTestData.enumerasiJenisKredit(arr[46]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailJenisPenggunaan() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlUtil);
        expected = readTestData.testDataMaintananceTable()[3];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);

        value    = readTestData.testDataMaintananceTable()[2];
        expected = arr[52];
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailNomorPK() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlPKNo);
        expected = arr[49];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailTanggalAkad() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlContact);
        expected = arr[50];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value.replace("/",""),expected);takeScreenshot.capture(driver);
    }
    public void detailTanggalAngsuranI() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlInstalment_1);
        expected = arr[51];

        scrollDown(driver, body);Thread.sleep(300);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value.replace("/",""),expected);takeScreenshot.capture(driver);
        scrollUp(driver, body);Thread.sleep(300);
    }
    public void detailNomorNPWP() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlNPWP);
        expected = arr[44];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailNoTelp() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlTelp);
        expected = arr[38];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailAlamat() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlAddress);
        expected = arr[33];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailAlamatKelurahan() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlAddWard);
        expected = arr[34];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailAlamatKecamatan() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlAddDistrict);
        expected = arr[35];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailAlamatKodePos() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlAddPostalCode);
        expected = arr[36];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailAlamatKodeDatiII() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlAddCodeDATI_II);
        expected = ReadTestData.enumerasiDatiII(arr[37]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailBidangUsaha() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlFields);
        expected = ReadTestData.enumerasiBidangUsaha(arr[43]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailBentukBadanUsaha() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlEntity);
        expected = ReadTestData.enumerasiBentukBadanUsaha(arr[58]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailSektorEkonomi() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlSector);
        expected = ReadTestData.enumerasiSektorEkonomi(arr[53]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailGoPublic() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlGoPublic);
        expected = ReadTestData.enumerasiGoPublic(arr[55]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailSandiGolonganDebtitur() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlGroupDebt);
        expected = ReadTestData.enumerasiSandiGolongan(arr[56]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailPenghasilanPertahun() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[57]));
        value    = getText(driver, dtlIncomePerYear);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value.replace(".", "")
                         .replace("Rp", "")
                         .replace(",", "")
                    ,expected);takeScreenshot.capture(driver);
    }
    public void detailOmzet() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[54]));
        value    = getText(driver, dtlTurnOver);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value.replace(".", "")
                         .replace("Rp", "")
                         .replace(",", "")
                    ,expected);takeScreenshot.capture(driver);
    }
    public void detailNoAkte() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCertNO);
        expected = arr[39];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailNoAkteTerakhir() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCertNOLatest);
        expected = arr[41];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailTanggalAkteTerakhir() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCertDeadline);
        expected = arr[42];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value.replace("/",""),expected);takeScreenshot.capture(driver);
    }
    public void detailTanggalBerdiri() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCertPublish);
        expected = arr[40];
        scrollDown(driver, body);Thread.sleep(300);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value.replace("/",""),expected);takeScreenshot.capture(driver);
    }
    public void detailTempatBerdiriBadanUsaha() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCertPlaces);
        expected = arr[59];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
//        scrollUp(driver, body);Thread.sleep(300);
//        click(driver, dtlBtnBack);
    }

    public void detailTanggalAkteToday() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app1);//noapp1
        click(driver, rwDatafirstApp1);

        value = getText(driver, dtlCertDeadline);
        expected = formattedToday;
        scrollDown(driver, body);Thread.sleep(300);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
        scrollUp(driver, body);Thread.sleep(300);
        click(driver, dtlBtnBack);
    }
    public void detailTanggalAkteYesterday() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app2);
        click(driver, rwDatafirstApp1);

        value    = getText(driver, dtlCertDeadline);
        expected = formattedYesterday;
        scrollDown(driver, body);Thread.sleep(300);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
        scrollUp(driver, body);Thread.sleep(300);
        click(driver, dtlBtnBack);
    }
    public void detailTanggalAkteSamaNoAkteSama() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app3);
        click(driver, rwDatafirstApp1);

        value    = getText(driver, dtlCertPublish);
        expected = getText(driver, dtlCertDeadline);
        scrollIntoView(driver, tblPengurus); Thread.sleep(300);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        scrollUp(driver, body);Thread.sleep(300);
        value    = getText(driver, dtlCertNO);
        expected = getText(driver, dtlCertNOLatest);
        verifyValue(value,expected);
        scrollIntoView(driver, dtlBtnBack);
        click(driver, dtlBtnBack);
    }
    public void detailTanggalAkteBedaNoAkteBeda() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app4);
        value = getText(driver, txtTbl_statusRea);
        click(driver, rwDatafirstApp1);

        value    = getText(driver, dtlCertPublish);
        expected = getText(driver, dtlCertDeadline);
        scrollIntoView(driver, tblPengurus); Thread.sleep(300);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValueNotEquals(value,expected, "Not Equals ______________ : Tanggal Akte berdiri dan Tanggal Akte terakhir berbeda");
        takeScreenshot.capture(driver);

        scrollUp(driver, body);Thread.sleep(300);
        value    = getText(driver, dtlCertNO);
        expected = getText(driver, dtlCertNOLatest);
        verifyValueNotEquals(value,expected, "Not Equals ______________ : No Akte awal dan No Akte terakhir berbeda");
        scrollIntoView(driver, dtlBtnBack);
        click(driver, dtlBtnBack);
    }
    public void detailTanggalAkteBedaNoAkteSama() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app5);
        value = getText(driver, txtTbl_statusRea);
        click(driver, rwDatafirstApp1);

        value    = getText(driver, dtlCertPublish);
        expected = getText(driver, dtlCertDeadline);
        scrollIntoView(driver, tblPengurus); Thread.sleep(300);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValueNotEquals(value,expected, "Not Equals ______________ : Tanggal Akte berdiri dan Tanggal Akte terakhir berbeda");
        takeScreenshot.capture(driver);

        scrollUp(driver, body);Thread.sleep(300);
        value    = getText(driver, dtlCertNO);
        expected = getText(driver, dtlCertNOLatest);
        verifyValue(value,expected);
        scrollIntoView(driver, dtlBtnBack);
        click(driver, dtlBtnBack);
    }

    public void klikApprove() {
        iRowPictName = 83;
//        createTestSkip(iRowPictName, extent_test_case, extent);
        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app1);//noapp1
        click(driver, rwDatafirstApp1);

        value    = getText(driver, dtlStatus);
        expected = "Waiting Approval";
        click(driver, dtlBtnApprove);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);

        takeScreenshot.capture(driver);
        verifyValue(value,expected);

        value    = getText(driver, dtlTextConfirmApprove);
        expected = "Apakah kamu yakin melakukan approval?";
        verifyValue(value,expected);
        boolean btnApproveYes = driver.findElement(dtlBtnConfirmYes).isDisplayed();
        verifyValueDisplay(btnApproveYes,true, "Button Approve 'Ya' IsDisplay");
        boolean btnApproveNo  = driver.findElement(dtlBtnConfirmNo).isDisplayed();
        verifyValueDisplay(btnApproveNo,true, "Button Approve 'Tidak' IsDisplay");
    }
    public void klikApproveNo() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent);

        value = getText(driver, dtlStatus);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);

        Thread.sleep(500);
        click(driver, dtlBtnConfirmNo);
        boolean btnApproveNo  = driver.findElement(dtlBtnConfirmNo).isEnabled();
        verifyValueDisplay(btnApproveNo,true, "Button Approve 'Tidak' diklik");
        takeScreenshot.capture(driver);
    }
    public void klikApproveYes() {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent);

        value    = getText(driver, dtlStatus);
        expected = "Waiting Approval";
        click(driver, dtlBtnApprove);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnConfirmYes);

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app1);//noapp1
        value    = getText(driver, txtTbl_statusRea);
        expected = "Approved";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value    = getText(driver, dtlStatus);
        expected = "Approved";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }
    public void klikReject() throws InterruptedException {
        iRowPictName = 86;
//        createTestSkip(iRowPictName, extent_test_case, extent);

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app2);
        click(driver, rwDatafirstApp1);

        value    = getText(driver, dtlStatus);
        expected = "Waiting Approval";
        click(driver, dtlBtnReject);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        boolean textAreaReject  = driver.findElement(dtlModalConfirmRejectReason).isDisplayed();
        verifyValueDisplay(textAreaReject,true, "Element textarea rejected IsDisplay");
        click(driver, dtlModalConfirmRejectType);

        Thread.sleep(500);
        List<WebElement> lists = driver.findElements(dtlModalConfirmRejectList);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i).getText());
            value  = lists.get(i).getText().replace("\n", "");
        }
        expected = "select an optionDokumen pendukung tidak sesuaiPengajuan ditolak";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnRejectNo);
    }
    public void klikReject_I() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent);

        value    = getText(driver, dtlStatus);
        expected = "Waiting Approval";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnReject);
        writeText(driver, dtlModalConfirmRejectReason, Karakter5000);
        click(driver, dtlModalConfirmRejectType);
        takeScreenshot.capture(driver);

        click(driver, dtlModalConfirmRejectType_1);
        click(driver, dtlModalConfirmRejectType);
        click(driver,dtlModalConfirmReject);
        takeScreenshot.capture(driver);
        Thread.sleep(500);
        value    = getText(driver, dtlModalConfirmRejectReason);
        expected = Karakter5000;
//        verifyValue(value,expected);
        createInfo(extent_test_case, "Deskripsi 5000 karakter: "+Karakter5000);

        click(driver, dtlBtnRejectYes);

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app2);
        Thread.sleep(500);
        value    = getText(driver, txtTbl_statusRea);
        expected = "Rejected by Analyst";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value    = getText(driver, dtlStatus);
        expected = "Rejected";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }
    public void klikReject_II() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent);

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app3);
        click(driver, rwDatafirstApp1);

        value    = getText(driver, dtlStatus);
        expected = "Waiting Approval";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnReject);
        click(driver, dtlModalConfirmRejectType);
        takeScreenshot.capture(driver);

        click(driver, dtlModalConfirmRejectType_2);
        click(driver, dtlModalConfirmRejectType);
        writeText(driver, dtlModalConfirmRejectReason, Karakter4999);
        click(driver,dtlModalConfirmReject);
        takeScreenshot.capture(driver);
        Thread.sleep(500);
        value    = getText(driver, dtlModalConfirmRejectReason);
        expected = Karakter4999;
//        verifyValue(value,expected);
        createInfo(extent_test_case, "Deskripsi 4999 karakter: "+Karakter4999);

        click(driver, dtlBtnRejectYes);

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app3);
        Thread.sleep(500);
        value    = getText(driver, txtTbl_statusRea);
        expected = "Rejected by Analyst";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value    = getText(driver, dtlStatus);
        expected = "Rejected";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }
    public void klikReject_III() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent);

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app4);
        click(driver, rwDatafirstApp1);

        value    = getText(driver, dtlStatus);
        expected = "Waiting Approval";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnReject);
        click(driver, dtlModalConfirmRejectType);
        Thread.sleep(500);
        takeScreenshot.capture(driver);

        click(driver, dtlModalConfirmRejectType_1);
        click(driver, dtlModalConfirmRejectType);
        takeScreenshot.capture(driver);
        createInfo(extent_test_case, "Deskripsi kosong");
        value    = getText(driver, dtlModalConfirmRejectReason);
        expected = "";
        verifyValue(value,expected);

        click(driver, dtlBtnRejectYes);

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app4);
        Thread.sleep(500);
        value    = getText(driver, txtTbl_statusRea);
        expected = "Rejected by Analyst";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value    = getText(driver, dtlStatus);
        expected = "Rejected";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }

    public void klikStatusWaitingApproval() {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent);

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app5);

        value = getText(driver, txtTbl_statusRea);
        expected = "Waiting Approval";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        expected = "Waiting Approval";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }
    public void klikStatusApproved() {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent);

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app1);//noapp1
        expected = "Approved";
        value = getText(driver, txtTbl_statusRea);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        expected = "Approved";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }
    public void klikStatusRejected() {
        iRowPictName = iRowPictName + iSeq;
//        createTestSkip(iRowPictName, extent_test_case, extent);

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app2);

        value = getText(driver, txtTbl_statusRea);
        expected = "Rejected by Analyst";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        expected = "Rejected";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }


    public void reconsumeAlamatRejected() throws IOException, CsvException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = 93;
//        createTestSkip(iRowPictName, extent_test_case, extent);

//        menuNotification();
//        List<WebElement> ListRow = driver.findElements(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'KOMUNAL')] | //tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'AKSELERAN')] "));
//        value                    = "";
//        boolean dataConsume      = driver.findElement(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'KOMUNAL')] | //tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'AKSELERAN')] ")).isDisplayed();
//        for (WebElement webElement : ListRow) {
//            if (webElement.getText().contains("KOMUNAL")) {
//                value            = webElement.getText();
//            } else if (webElement.getText().contains("AKSELERAN")) {
//                value            = webElement.getText();
//            }
//        }
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Data saat consume pertama, saat status rejected");
//        verifyValueDisplay(dataConsume,true, "Consume pertama data berhasil : "+value);
//        takeScreenshot.capture(driver);
        menuRealizationForm();
        tableApprovalForm();

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app2);
        value = getText(driver, txtTbl_statusRea);
        expected = "Rejected by Analyst";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        expected = "Rejected";
        verifyValue(value,expected);
        value2 = getText(driver, dtlAddress);
        expected = arr[63];
        verifyValue(value2,expected);
        takeScreenshot.capture(driver);

        createInfo(extent_test_case, "Run job reconsume ganti alamat ........");
        String alamat3 = arr[63];
        UpdateCSV.updateFieldReaFileCSV(alamat3,"Jalan Bahyang update status rejected");
        connServer.serverAkses();

        click(driver, dtlBtnBack);
        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app2);
        value = getText(driver, txtTbl_statusRea);
        expected = "Rejected by Analyst";
//        verifyValue(value,expected);
        verifyValueNotEquals(value,expected, "data table akan duplikasi dengan status berbeda ketika ganti alamat berhasil menjadi waiting approval");
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        expected = "Rejected";
//        verifyValue(value,expected);
        verifyValueNotEquals(value,expected, "data detail akan duplikasi dengan status berbeda ketika ganti alamat berhasil menjadi waiting approval");
        value3 = getText(driver, dtlAddress);
        expected = arr[63];
        createInfo(extent_test_case, "Data baru reconsume masuk berhasil, data alamat tidak sama sebelum reconsume dan data berhasil ke replace");
        verifyValueNotEquals(value3,expected, "data alamat consume pertama dan kedua berbeda");
        createInfo(extent_test_case, "Data alamat sebelum reconsume : "+value2);
        createInfo(extent_test_case, "Data alamat sesudah reconsume : "+value3);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }
    public void reconsumeAlamatApproved() throws IOException, CsvException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = 94;
//        createTestSkip(iRowPictName, extent_test_case, extent);

        menuNotification();
        List<WebElement> ListRow = driver.findElements(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'KOMUNAL')] | //tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'AKSELERAN')] "));
        value                    = "";
        boolean dataConsume      = driver.findElement(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'KOMUNAL')] | //tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'AKSELERAN')] ")).isDisplayed();
        for (WebElement webElement : ListRow) {
            if (webElement.getText().contains("KOMUNAL")) {
                value            = webElement.getText();
            } else if (webElement.getText().contains("AKSELERAN")) {
                value            = webElement.getText();
            }
        }
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Data saat consume pertama, saat status approved");
//        verifyValueDisplay(dataConsume,true, "Consume pertama data berhasil : "+value);
//        takeScreenshot.capture(driver);

        menuRealizationForm();
        tableApprovalForm();

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app1);//noapp1
        expected = "Approved";
        value = getText(driver, txtTbl_statusRea);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        expected = "Approved";
        verifyValue(value,expected);
        value2 = getText(driver, dtlAddress);
        expected = arr[33];
        verifyValue(value2,expected);
        takeScreenshot.capture(driver);

        createInfo(extent_test_case, "Run job reconsume ganti alamat ........");
        String alamat1 = arr[33];
        UpdateCSV.updateFieldReaFileCSV(alamat1,"Jalan Bahyang update status approved");
        connServer.serverAkses();

        click(driver, dtlBtnBack);
        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app1);//noapp1
        expected = "Approved";
        value = getText(driver, txtTbl_statusRea);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        expected = "Approved";
        verifyValue(value,expected);
        value3 = getText(driver, dtlAddress);
        expected = arr[33];
        createInfo(extent_test_case, "Data baru reconsume masuk ke reject by system, data tidak berubah");
        verifyValue(value3,expected);
        createInfo(extent_test_case, "Data alamat sebelum reconsume : "+value2);
        createInfo(extent_test_case, "Data alamat sesudah reconsume : "+value3);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }
    public void reconsumeAlamatWaitingApproval() throws IOException, CsvException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = 95;
//        createTestSkip(iRowPictName, extent_test_case, extent);

       List<WebElement> ListRow = driver.findElements(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'KOMUNAL')] | //tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'AKSELERAN')] "));
        value                    = "";
        boolean dataConsume      = driver.findElement(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'KOMUNAL')] | //tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'AKSELERAN')] ")).isDisplayed();
        for (WebElement webElement : ListRow) {
            if (webElement.getText().contains("KOMUNAL")) {
                value            = webElement.getText();
            } else if (webElement.getText().contains("AKSELERAN")) {
                value            = webElement.getText();
            }
        }
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Data saat consume pertama, saat status waiting approval");
//        verifyValueDisplay(dataConsume,true, "Consume pertama data berhasil : "+value);
//        takeScreenshot.capture(driver);

        menuRealizationForm();
        tableApprovalForm();

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app5);
        expected = "Waiting Approval";
        value = getText(driver, txtTbl_statusRea);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        expected = "Waiting Approval";
        verifyValue(value,expected);
        value2 = getText(driver, dtlAddress);
        expected = arr[153];
        verifyValue(value2,expected);
        takeScreenshot.capture(driver);

        createInfo(extent_test_case, "Run job reconsume ganti alamat ........");
        String alamat2 = arr[153];
        UpdateCSV.updateFieldReaFileCSV(alamat2,"Jalan Bahyang update status waiting approval");
        connServer.serverAkses();

        click(driver, dtlBtnBack);
        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app5);
        expected = "Waiting Approval";
        value = getText(driver, txtTbl_statusRea);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        expected = "Waiting Approval";
        verifyValue(value,expected);
        value3 = getText(driver, dtlAddress);
        expected = arr[153];
        createInfo(extent_test_case, "Data baru reconsume masuk berhasil, data alamat tidak sama sebelum reconsume dan data berhasil ke replace");
        verifyValueNotEquals(value3,expected, "data alamat consume pertama dan kedua berbeda");
        createInfo(extent_test_case, "Data alamat sebelum reconsume : "+value2);
        createInfo(extent_test_case, "Data alamat sesudah reconsume : "+value3);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }

    public void reconsumeAlamatApprovalExpired() throws IOException, CsvException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = 96;
//        createTestSkip(iRowPictName, extent_test_case, extent);

        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Data saat consume pertama, saat status approval expired");

        menuRealizationForm();

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app5);
        value = getText(driver, txtTbl_statusRea);
        expected = "Waiting Approval";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        expected = "Waiting Approval";
        verifyValue(value,expected);
        value2 = getText(driver, dtlAddress);
        expected = arr[153];
        verifyValue(value2,expected);
        takeScreenshot.capture(driver);

        createInfo(extent_test_case, "Run job reconsume ganti alamat ........");
        String alamat2 = arr[153];
        UpdateCSV.updateFieldReaFileCSV(alamat2,"Jalan Bahyang update status approval expired");
        DummyExpiredReaForm_BU expiredReaForm_bu = new DummyExpiredReaForm_BU();
        expiredReaForm_bu.serverAkses();
        connServer.serverAkses();

        click(driver, dtlBtnBack);
        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app5);
        value = getText(driver, txtTbl_statusRea);
        expected = "Waiting Approval";
        value3 = getText(driver, txtTbl_statusRea2);
        expected2 = "Approval Expired";
        verifyValue(value,expected);
        verifyValue(value3, expected2);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value4 = getText(driver, dtlAddress);
        expected = arr[153];
        createInfo(extent_test_case, "Data baru reconsume masuk berhasil, data alamat tidak sama sebelum reconsume dan data berhasil ke replace");
        verifyValueNotEquals(value4,expected, "data alamat consume pertama dan kedua berbeda");
        createInfo(extent_test_case, "Data alamat sebelum reconsume : "+value2);
        createInfo(extent_test_case, "Data alamat sesudah reconsume : "+value4);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }
    public void verifyApprovalExpired() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = 97;
//        createTestSkip(iRowPictName, extent_test_case, extent);

        writeText(driver, txtSearch, no_app5);
        value    = getText(driver, txtTbl_nomorAplikasi);
        expected = arr[150];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);
        value    = getText(driver, txtTbl_statusRea2);
        expected = "Approval Expired";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void klikStatusApprovalExpired() {
        iRowPictName = 98;
//        createTestSkip(iRowPictName, extent_test_case, extent);

        click(driver, rwDatafirstApp2);
        isPresent(driver, dtlAppId);

        value = getText(driver, dtlStatus);
        expected = "Approval Expired";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }

    public void verifyPending() throws IOException, InterruptedException {
        iRowPictName = 99;
        status_testCase(iRowPictName, true, "Consume ApplicationNo baru untuk status pending ........");
//        createTestSkip(iRowPictName, extent_test_case, extent);
        createTest(iRowPictName, extent_test_case, extent);

        createInfo(extent_test_case, "Run job appForm ........");
        MoveFileScenario moveFileScenario = new MoveFileScenario();
        moveFileScenario.dltDummyExistPending();
        DataCSVPending dataCSV = new DataCSVPending();
        dataCSV.dataDummy(Const.appFile, Const.reaFile, "10");
        DummyPendingAppform_BU connServer2 = new DummyPendingAppform_BU();
        connServer2.serverAkses();
//
//        menuNotification();
//        List<WebElement> ListRow = driver.findElements(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'PT Tes Pending')] | //tr[1][@class='pointer'] //td[2][contains(text(),'Approval')][contains(text(),'PT Tes Pending')] "));
//        String getColPartnerNotif= "";
//        boolean dataConsume      = driver.findElement(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'PT Tes Pending')] | //tr[1][@class='pointer'] //td[2][contains(text(),'Approval')][contains(text(),'PT Tes Pending')] ")).isDisplayed();
//        for (WebElement webElement : ListRow) {
//            if (webElement.getText().contains("PT Tes Pending")) {
//                getColPartnerNotif = webElement.getText();
//            }
//        }
//        verifyValueDisplay(dataConsume,true, "Consume data berhasil "+getColPartnerNotif);
//        takeScreenshot.capture(driver);

        createInfo(extent_test_case, "Ubah status appForm menjadi approved ........");
        changeAllAppIdStatusApprovedAppForm();

        createInfo(extent_test_case, "Run job reaForm ........");
        DummyPendingReaForm_BU connServer3 = new DummyPendingReaForm_BU();
        connServer3.serverAkses();

        menuRealizationForm();
        menuNotification();
//        verifyValueDisplay(dataConsume,true, "Consume data berhasil "+getColPartnerNotif);
        takeScreenshot.capture(driver);

        menuRealizationForm();

        String[] arr = readCSVFormApproval.fileCSVReaPending();
        writeText(driver, txtSearch, arr[60].substring(11,16));

//        List<WebElement> plafon = driver.findElements(By.xpath("//tbody[@id = 'channelingTable']/tr/td[7]"));
//        for (WebElement  listPlafon : plafon) {
//            if (listPlafon.getText().replace("Rp ","")
//                    .replace(".", "")
//                    .replace(",00", "")
//                    .equals(plafonRow1));{
//                        createInfo(extent_test_case,getText(driver, txtTbl_status));
//            }
//        }

        long plafonCsv1 = Long.parseLong(removeZero(arr[47]));
        if (!txtTbl_loanAmount.equals(plafonCsv1)) {
            expected = arr[60];
            value2 = getText(driver,txtTbl_statusRea);
        } else {
            expected = arr[30];
            value2 = getText(driver,txtTbl_statusRea2);
        }
        value    = getText(driver, txtTbl_nomorAplikasi);
        verifyValue(value,expected);
        expected = "Pending";
        verifyValue(value2,expected);
        takeScreenshot.capture(driver);

    }
    public void klikStatusPending() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVReaPending();
        iRowPictName = 100;
//        createTestSkip(iRowPictName, extent_test_case, extent);

        long plafonCsv1 = Long.parseLong(removeZero(arr[47]));
        if (!txtTbl_loanAmount.equals(plafonCsv1)) {
            click(driver, rwDatafirstApp1);
        } else {
            click(driver, rwDatafirstApp2);
        }
        isPresent(driver, dtlAppId);

        value = getText(driver, dtlStatus);
        expected = "Pending";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }
    public void reconsumeAlamatPending() throws IOException, CsvException {
        String[] arrPending = readCSVFormApproval.fileCSVReaPending();
        iRowPictName = 101;
//        createTestSkip(iRowPictName, extent_test_case, extent);

        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Data saat consume pertama, saat status pending");

        menuRealizationForm();

        String[] arr = readCSVFormApproval.fileCSVReaPending();
        writeText(driver, txtSearch, arr[60].substring(11,16));
        long plafonCsv1 = Long.parseLong(removeZero(arr[47]));
        if (!txtTbl_loanAmount.equals(plafonCsv1)) {
            expected = arr[60];
            value2 = getText(driver,txtTbl_statusRea);
            value3 = arrPending[60];
            value4 = arrPending[63]; //alamat
        } else {
            expected = arr[30];
            value2 = getText(driver,txtTbl_statusRea2);
            value3 = arrPending[30];
            value4 = arrPending[33];//alamat
        }

        clearText(driver, txtSearch);
        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, value3);
        expected = "Pending";
//        value = getText(driver, txtTbl_statusRea);
        verifyValue(value2,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        expected = "Pending";
        verifyValue(value,expected);
        value2 = getText(driver, dtlAddress);
        expected = value4;
        verifyValue(value2,expected);
        takeScreenshot.capture(driver);

        createInfo(extent_test_case, "Run job reconsume ganti alamat ........");
        String alamat2 = value4;
        UpdateCSV.updateFieldReaPendingCSV(alamat2,"Jalan Bahyang update status pending");
        DummyPendingReaForm_BU connServer3 = new DummyPendingReaForm_BU();
        connServer3.serverAkses();

        click(driver, dtlBtnBack);
        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, value3);
        expected = "Pending";
        value = getText(driver, txtTbl_statusRea);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        expected = "Pending";
        verifyValue(value,expected);
        value3 = getText(driver, dtlAddress);
        expected = value4;
        createInfo(extent_test_case, "Data baru reconsume masuk berhasil, data alamat tidak sama sebelum reconsume dan data berhasil ke replace");
        verifyValueNotEquals(value3,expected, "data alamat consume pertama dan kedua berbeda");
        createInfo(extent_test_case, "Data alamat sebelum reconsume : "+value2);
        createInfo(extent_test_case, "Data alamat sesudah reconsume : "+value3);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }

    public void changeAllAppIdStatusApprovedAppForm() throws IOException, InterruptedException {

        String[] arr = readCSVFormApproval.fileCSVAppPending();
//        ReadCSVFormApproval readCSVFormApproval = new ReadCSVFormApproval();
//        arr = readCSVFormApproval.fileCSVAppPending();
//        Long getCount = Arrays.stream(arr).count();

        changeUserToMaker();
        click(driver, menuApprovalForm);
        System.out.println("change status recomend...");

        //myCode
        int index = 8;
        for (int i = index; i < arr.length; i++) {
            if (i % index == 0) {
                clearText(driver, txtSearchAppForm);
                isPresent(driver, rwDatafirstApp1);
                writeText(driver, txtSearchAppForm, arr[i]);
                value = getText(driver, txtTbl_statusApp).toLowerCase();
                if (value.equals("waiting for review")) {
                    click(driver, rwDatafirstApp1);

                    scrollIntoView(driver, bottomRecomend);
                    click(driver, optionlist_recommend);
                    click(driver, option_recommend);
                    click(driver, optionlist_recommend);
                    Thread.sleep(Const.delay);
                    writeText(driver, txtAreaInput_recommend, "TEST AT Approval Form Recommended");

                    scrollUp(driver, body);
                    scrollIntoView(driver, btnSubmitApp);
                    Thread.sleep(100);
                    click(driver, btnSubmitApp);
                    index = index + 8;
                } else {
                    index = index + 8;
                }
            }
        }
        changeUserToApprove();
        index = 8;
        for (int i = index; i < arr.length; i++) {
            if (i % index == 0) {
                clearText(driver, txtSearchAppForm);
                isPresent(driver, rwDatafirstApp1);
                writeText(driver, txtSearchAppForm, arr[i]);
                value = getText(driver, txtTbl_statusApp).toLowerCase();
                if (value.equals("waiting approval")) {
                    click(driver, rwDatafirstApp1);
                    scrollIntoView(driver, bottomApprov);
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
            clearText(driver, txtSearchAppForm);
        }
        logout(driver);
        login();
    }
    public void searchAppNo() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVAppForm();

        writeText(driver, inputSearch, no_app1);
        click(driver, rwDatafirstApp1);
        isPresent(driver, dtlAppId);
        value    = getText(driver, txtDetail_NoApp);
        expected = arr[16];

    }
    public void verifyNoApp17Char() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, noAplikasi);
        expected = arr[21];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[21], arr[21].length(),17 );
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
        scrollIntoView(driver, expand1);
        click(driver, expand1);
        scrollPageUp(driver, dtlBtnApprove);Thread.sleep(500);
    }
    public void verifyNoUrutPeng2Char() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

//        scrollPageDown(driver, dtlBtnApprove);
        scrollIntoView(driver, noUrutPengurus);
        value = getText(driver,noUrutPengurus);
        int expected2 = Integer.parseInt(removeZero(arr[22]));
        expected = String.valueOf(expected2);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[22],arr[22].length(),2 );
        verifyValue(value, expected);
        takeScreenshot.capture(driver);

    }
    public void verifyJmlPeng2Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, jmlPengurus);
        int expected2 = Integer.parseInt(removeZero(arr[23]));
        expected = String.valueOf(expected2);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[23],arr[23].length(),2);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyJbtnBI1Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        click(driver, expand2);
        scrollIntoView(driver, noUrutPengurus);
        value = getText(driver, sandiJbtBI);
        expected = ReadTestData.enumerasiSandiJabatan(arr[24+row2]);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[24+row2], arr[24+row2].length(),1);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyJbtnBI2Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, sandiJbtBI);
        expected = ReadTestData.enumerasiSandiJabatan(arr[24]);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[24],arr[24].length(),2);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyPangsa5Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        int ui = Integer.parseInt(getText(driver, pangsaKepemilikan).replace("%","").replace(".",""));
        value = String.valueOf(ui);
        long expected2 = Long.parseLong(arr[25]);
        expected = String.valueOf(expected2);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[25],arr[25].length(),5);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyBentukPengurus1Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, bentukPengurus);
        expected = ReadTestData.enumerasiBentukPengurus(arr[26]);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[26],arr[26].length(),1);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyModalDasar13Num() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, mdlDasar);
        expected = String.valueOf(Integer.parseInt(arr[27+row2]));
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[27+row2],arr[27+row2].length(),13);
        verifyValue(value
                        .replace("Rp. ","")
                        .replace(".","")
                , expected);
        takeScreenshot.capture(driver);
    }
    public void verifyModalDasar12Num() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, mdlDasar);
        expected = String.valueOf(Integer.parseInt(arr[27]));
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[27],arr[27].length(),12);
        verifyValue(value
                        .replace("Rp. ","")
                        .replace(".","")
                , expected);
        takeScreenshot.capture(driver);
    }
    public void verifyModalDisetor13Num() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, mdlDisetor);
        expected = String.valueOf(Integer.parseInt(arr[28+row2]));
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[28+row2],arr[28+row2].length(),13);
        verifyValue(value
                        .replace("Rp. ","").replace(".","")
                , expected);
        takeScreenshot.capture(driver);
    }
    public void verifyModalDisetor12Num() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, mdlDisetor);
        expected = String.valueOf(Integer.parseInt(arr[28]));
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[28],arr[28].length(),12);
        verifyValue(value
                        .replace("Rp. ","")
                        .replace(".","")
                , expected);
        takeScreenshot.capture(driver);
    }
    public void verifyModalDitempatkan13Num() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, mdlDitempatkan);
        expected = String.valueOf(Integer.parseInt(arr[29+row2]));
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[29+row2],arr[29+row2].length(),13);
        verifyValue(value
                        .replace("Rp. ","")
                        .replace(".","")
                , expected);
        takeScreenshot.capture(driver);
    }
    public void verifyModalDitempatkan12Num() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, mdlDitempatkan);
        expected = String.valueOf(Integer.parseInt(arr[29]));
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[29],arr[29].length(),12);
        verifyValue(value
                        .replace("Rp. ","")
                        .replace(".","")
                , expected);
        takeScreenshot.capture(driver);
    }
    public void verifyNPWP15Char() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, npwpPeng);
        expected = arr[30];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[30],arr[30].length(),15);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifNamaPengurus60Char() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, namaPeng);
        expected = arr[31+row2];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[31+row2],arr[31+row2].length(),60);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyNamaPengurus59Char() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;


        value = getText(driver, namaPeng);
        expected = arr[31];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[31],arr[31].length(),59);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyAltPeng40Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, altPeng);
        expected = arr[32+row2];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[32+row2],arr[32+row2].length(),40);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyAltPeng39Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, altPeng);
        expected = arr[32];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[32],arr[32].length(),39);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyAltKelurahan40Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, altKelurahan);
        expected = arr[33+row2];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[33+row2],arr[33+row2].length(),40);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyAltKelurahan39Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, altKelurahan);
        expected = arr[33];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[33],arr[33].length(),39);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyAltKecamatan40Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, altKecamatan);
        expected = arr[34+row2];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[34+row2],arr[34+row2].length(),40);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyAltKecamatan39() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, altKecamatan);
        expected = arr[34];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[34],arr[34].length(),39);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyAltDatiII4Num() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, altDatiII);
        expected = ReadTestData.enumerasiDatiII(arr[35]);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[35],arr[35].length(),4);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyNoAkte30Char() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        scrollPageDown(driver,dtlBtnApprove); Thread.sleep(500);
        value = getText(driver, noAkte);
        expected = arr[37+row2];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[37+row2],arr[37+row2].length(),30);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyNoAkter29Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, noAkte);
        expected = arr[37];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[37],arr[37].length(),29);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyTglAkte8Num() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;


        value = getText(driver, tglAkte);
        expected = arr[39];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[39],arr[39].length(),8);
        verifyValue(value
                .replace("/",""), expected);
        takeScreenshot.capture(driver);
    }
    public void verifyJnsKelPengB() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, jnsKelamin);
        expected = ReadTestData.enumerasiJnsKelPengurus(arr[41]);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[41],arr[41].length(),1);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyJnsKelPengM() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, jnsKelamin);
        expected = ReadTestData.enumerasiJnsKelPengurus(arr[41+row2]);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[41+row2],arr[41+row2].length(),1);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
        scrollPageUp(driver, dtlBtnApprove); Thread.sleep(500);
        click(driver, expand2);
    }
    public void verifyNoKTP16Char() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        scrollPageDown(driver, dtlBtnApprove);Thread.sleep(500);
        value = getText(driver, noKtp);
        expected = arr[36];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[36],arr[36].length(),16);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyTglLhr8Num() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, tglLahir);
        expected = arr[38];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[38],arr[38].length(),8);
        verifyValue(value
                .replace("/",""), expected);
        takeScreenshot.capture(driver);
    }
    public void verifyDatiIITmptLahir4Char() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, datiIILahir);
        expected = ReadTestData.enumerasiDatiII(arr[40]);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[40],arr[40].length(),4);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);

        scrollPageUp(driver,dtlBtnApprove); Thread.sleep(500);
        click(driver,expand1);
    }
    public void verifyDataPengLebihDari1() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;
        int pangsa1, pangsa2, pangsa3, pangsa4, totalPangsa;

        List<WebElement> list = driver.findElements(listSorting);
        value = "";
        for (WebElement webElement : list) {
            if (webElement.getText().contains("4"))
                value = webElement.getText();

        }
        expected = "4";
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Total Pengurus  :"+value);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);

        //evidence pangsa kepemilikan total = 100%

        scrollIntoView(driver, pangsaList1);

        pangsa1 = Integer.parseInt(getText(driver, pangsaList1).replace(".","").replace("%",""));
        pangsa2 = Integer.parseInt(getText(driver, pangsaList2).replace(".","").replace("%",""));
        pangsa3 = Integer.parseInt(getText(driver, pangsaList3).replace(".","").replace("%",""));
        pangsa4 = Integer.parseInt(getText(driver, pangsaList4).replace(".","").replace("%",""));
        totalPangsa = pangsa1+pangsa2+pangsa3+pangsa4;

        createInfo(extent_test_case,"Jumlah pangsa :" + pangsa1+" + "+pangsa2+" + "+pangsa3+" + "+pangsa4+ " Total : " + totalPangsa + " Atau 100%");
        takeScreenshot.capture(driver);

        scrollIntoView(driver, listSorting);


        //open detail pengurus 1
        click(driver, expand1);
        createInfo(extent_test_case, "Pengurus 1");
        scrollPageUp(driver, dtlBtnApprove); Thread.sleep(500);scrollPageDown(driver, dtlBtnApprove);Thread.sleep(500);
        takeScreenshot.capture(driver);
        scrollPageDown(driver, dtlBtnApprove);Thread.sleep(500);
        takeScreenshot.capture(driver);
        scrollPageUp(driver, dtlBtnApprove);Thread.sleep(500);
        click(driver, expand1);

        //open detail pengurus 2
        click(driver, expand2);
        createInfo(extent_test_case, "Pengurus 2");
        takeScreenshot.capture(driver);
        scrollPageDown(driver, dtlBtnApprove);Thread.sleep(500);
        takeScreenshot.capture(driver);
        scrollPageUp(driver, dtlBtnApprove);Thread.sleep(500);
        click(driver, expand2);

        //open detail pengurus 3
        click(driver, expand3);
        createInfo(extent_test_case, "Pengurus 3");
        takeScreenshot.capture(driver);
        scrollPageDown(driver, dtlBtnApprove);Thread.sleep(500);
        takeScreenshot.capture(driver);
        scrollPageUp(driver, dtlBtnApprove);Thread.sleep(500);
        click(driver, expand3);

        //open detail pengurus 4
        click(driver, expand4);
        createInfo(extent_test_case, "Pengurus 4");
        takeScreenshot.capture(driver);
        scrollPageDown(driver, dtlBtnApprove);Thread.sleep(500);
        takeScreenshot.capture(driver);
        scrollPageUp(driver, dtlBtnApprove);Thread.sleep(500);
        click(driver, expand4);

    }
    public void verifyNoApp30Char() throws IOException, InterruptedException {

//        createTestSkip(iRowPictName, FormRealizationRunner.extent_test_case, FormRealizationRunner.extent);

        iRowPictName = iRowPictName + iSeq;

        //Change appNo
        scrollPageUp(driver, body);
        scrollIntoView(driver, dtlBtnBack);
        click(driver,dtlBtnBack);

        String[] arrApp = readCSVFormApproval.fileCSVAppForm2();


        writeText(driver, inputSearch, arrApp[8]);
        click(driver, rwDatafirstApp1);
        isPresent(driver, dtlAppId);


        value = getText(driver, dtlAppId);
        expected = arrApp[8];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arrApp[8],arrApp[8].length(),30);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);

        scrollUp(driver, body);
        scrollIntoView(driver, dtlBtnBack);
        click(driver, dtlBtnBack);
    }
    public void verifyJnsKelPengL() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        click(driver, expand3);
        scrollIntoView(driver, noUrutPengurus);
        value = getText(driver, bentukPengurus);

        expected = ReadTestData.enumerasiJnsKelPengurus(arr[41+row3]);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Bentuk Badan Usaha :" + value);
        takeScreenshot.capture(driver);

        scrollPageDown(driver,dtlBtnApprove); Thread.sleep(500);
        String value2 = getText(driver, jnsKelamin);
        verifyValue(value2, expected);
        takeScreenshot.capture(driver);

        scrollPageUp(driver, dtlBtnApprove); Thread.sleep(500);
        click(driver, expand3);
    }
    public void verifyJnsKelPengP() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurusForm();
        iRowPictName = iRowPictName + iSeq;

        click(driver, expand4);
        value = getText(driver, bentukPengurus);

        expected = ReadTestData.enumerasiJnsKelPengurus(arr[41+row4]);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Bentuk Badan Usaha :" + value);
        takeScreenshot.capture(driver);

        scrollPageDown(driver,dtlBtnApprove); Thread.sleep(500);
        String value2 = getText(driver, jnsKelamin);
        verifyValue(value2, expected);
        takeScreenshot.capture(driver);

        scrollPageUp(driver, dtlBtnApprove); Thread.sleep(500);
        click(driver, expand4);
    }
    public void changeAllStatus() throws IOException, InterruptedException {
        String[] arr;
        ReadCSVFormApproval readCSVFormApproval = new ReadCSVFormApproval();
        arr = readCSVFormApproval.fileCSVAppForm();

        int index = 8;
        for (int i = index; i < arr.length; i++) { //40
            if (i % index == 0) {
                clearText(driver, txtSearch);
                isPresent(driver, rwDatafirstApp1);
                writeText(driver, txtSearch, arr[i]);
                value = getText(driver, txtTbl_statusRea).toLowerCase();
                if (value.equals("waiting approval")) {
                    click(driver, rwDatafirstApp1);
                    click(driver, dtlBtnApprove);
                    click(driver, dtlBtnConfirmYes);
                    index = index + 8;
                } else {
                    index = index + 8;
                }
            }
            clearText(driver, txtSearch);
        }
    }
}
