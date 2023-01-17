package elementsPage;

import capture.TakeScreenshot;
import org.openqa.selenium.*;
import readFile.ReadCSVFormApproval;
import runner.FormApprovalRunner;
import testData.ReadTestData;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static badanUsaha.LoginAsApprover.*;
import static badanUsaha.LoginAsMaker.*;
import static badanUsaha.LibUtils.*;
import static runner.FormApprovalRunner.extent;
import static runner.FormApprovalRunner.extent_test_case;

public class ApprovalFormPage extends BaseAction{

    public static final String PatternDate          = "dd/MM/yyyy HH:mm:ss";

    public static final By userId                   = By.id("username");
    public static final By pwd                      = By.id("password");
    public static final By btnLogin                 = By.xpath("//button[contains(.,'Sign In')]");
    public static final By btnProfile               = By.xpath("//a[@id='header-foto-profil']");
    public static final By btnLogout                = By.linkText("Logout");

    public static final By body                     = By.cssSelector("body");
    public static final By menuApprovalForm         = By.xpath("//a[contains(@href, 'approval-form-process')]");
    public static final By txtSearch                = By.id("search-filter");
    public static final By rwDatafirstApp1          = By.xpath("//tr[@class='odd']//td[4]/a");
    public static final By txtTbl_source            = By.xpath("//tr[@class='odd']//td[2]");
    public static final By txtTbl_nomorAplikasi     = By.xpath("//tr[@class='odd']//td[3]");
    public static final By txtTbl_namaDebitur       = By.xpath("//tr[@class='odd']//td[4]");
    public static final By txtTbl_partner           = By.xpath("//tr[@class='odd']//td[5]");
    public static final By txtTbl_date              = By.xpath("//tr[@class='odd']//td[6]");
    public static final By txtTbl_loanAmount        = By.xpath("//tr[@class='odd']//td[7]");
    public static final By txtTbl_rate              = By.xpath("//tr[@class='odd']//td[8]");
    public static final By txtTbl_status            = By.xpath("//tr[@class='odd']//td[9]");
    public static final By txtTbl_reason            = By.xpath("//tr[@class='odd']//td[10]");

    public static final By btnBackToTable           = By.xpath("//h1/a[contains(@href,'approval-form')]");
    public static final By txtDetail_partner        = By.xpath("(//div[contains(@class, 'pt-0')])[1]");
    public static final By txtDetail_namaDebitur    = By.xpath("(//div[contains(@class, 'pt-0')])[2]");
    public static final By txtDetail_status         = By.xpath("(//div[contains(@class, 'pt-0')])[3]");
    public static final By txtDetail_nomorAplikasi  = By.xpath("(//div[contains(@class, 'pt-0')])[4]");
    public static final By txtDetail_tglPengajuan   = By.xpath("(//div[contains(@class, 'pt-0')])[5]");
    public static final By txtDetail_jenisDebitur   = By.xpath("(//div[contains(@class, 'pt-0')])[6]");
    public static final By txtDetail_plafon         = By.xpath("(//div[contains(@class, 'pt-0')])[7]");
    public static final By txtDetail_jangkaWaktu    = By.xpath("(//div[contains(@class, 'pt-0')])[8]");
    public static final By txtDetail_interestRate   = By.xpath("(//div[contains(@class, 'pt-0')])[9]");
    public static final By txtDetail_nik            = By.xpath("(//div[contains(@class, 'pt-0')])[10]");
    public static final By txtDetail_npwp           = By.xpath("(//div[contains(@class, 'pt-0')])[11]");
    public static final By txtDetail_suppDoc        = By.xpath("(//div[contains(@class, 'pt-0')])[14]");
    public static final By txtArea_recommend        = By.cssSelector("textarea");
    public static final By txtAreaInput_recommend   = By.name("recomendationNotes");
    public static final By optionlist_recommend     = By.id("select2-dropdown-choice-container");
    public static final By option_recommend         = By.xpath("//*[@id=\"dropdown-choice\"]/option[2]");
    public static final By option_NotRecommend      = By.xpath("//*[@id=\"dropdown-choice\"]/option[3]");
    public static final By btnSubmitApp             = By.id("btn-submit-recomendation");
    public static final By txtDetailH5_HasilRekomen = By.xpath("//h5[contains(text(),'Hasil Rekomendasi')]");
    public static final By txtDetailCatatan         = By.xpath("(//div[contains(@class,'col-9')])[4]");
    public static final By approval_note            = By.id("notes-field");
    public static final By optionlist_approve       = By.xpath("//span[@id='select2-dropdown-choice-container' and //span[contains(text(), 'Pilih Keputusan')]]");
    public static final By option_approved          = By.xpath("//*[@id=\"dropdown-choice\"]/option[text()='Approve']");
    public static final By option_rejected          = By.xpath("//*[@id=\"dropdown-choice\"]/option[text()='Reject']");
    public static final By txtDetailH5_HasilKeputusan = By.xpath("//h5[contains(text(),'Hasil Keputusan')]");
    public static final By txtStrongUserApprove     = By.xpath("//strong[contains(text(),'Reviewer dan Approver tidak boleh user yang sama')]");
    public static final By option_selectapproved    = By.xpath("//span[text()='Approve']");
    public static final By formContentHeader        = By.xpath("//h1[contains(@class,'page-name')]");

    private static final WebDriver driver = FormApprovalRunner.driver;
    int iSeq = 1;
    int iRowPictName;
    TakeScreenshot takeScreenshot = new TakeScreenshot();
    ReadTestData readTestData = new ReadTestData();
    ReadCSVFormApproval readCSVFormApproval = new ReadCSVFormApproval();
    String expected, value, value2, value3, no_app1, no_app2, no_app3, no_app4, no_app5, no_app6, no_app7, no_app8, no_app9, no_app10;
    String Karakter5000 = "ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP fPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnhd";
    String Karakter4999 = "ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP fPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnh";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PatternDate);
    String formattedToday = simpleDateFormat.format(new Date());

    public void login() throws IOException {
        readTestData.testData();
        loginMaker(driver);

        String[] arr = readCSVFormApproval.fileCSVApp();
        no_app1 = arr[8];
        no_app2 = arr[16];
        no_app3 = arr[24];
        no_app4 = arr[32];
        no_app5 = arr[40];
        no_app6 = arr[48];
        no_app7 = arr[56];
        no_app8 = arr[64];
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

    public void menuApprovalForm()   {
        click(driver, menuApprovalForm);
    }
    public void tableApprovalForm(){
        isPresent(driver, rwDatafirstApp1);
    }

    public void verifySource() {
        iRowPictName = iRowPictName + iSeq;

        writeText(driver, txtSearch, no_app1);
        value    = getText(driver, txtTbl_source);
        expected = "LOS";

        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void verifyAppNo() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVApp();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, txtTbl_nomorAplikasi);
        expected = arr[8];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected); takeScreenshot.capture(driver);
    }
    public void verifyDebtorName() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVApp();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, txtTbl_namaDebitur);
        expected = arr[12];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected); takeScreenshot.capture(driver);
    }
    public void verifyPartner() {
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, txtTbl_partner);
        expected = readTestData.companyName;
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);

        verifyValue(value,expected); takeScreenshot.capture(driver);
    }
    public void verifyDate() {
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, txtTbl_date);
        expected = formattedToday.substring(0, 10);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value.substring(0, 10),expected); takeScreenshot.capture(driver);
    }
    public void verifyLoanAmount() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVApp();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[15])) / 100;
        value    = getText(driver, txtTbl_loanAmount);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);

        value = getText(driver, txtTbl_loanAmount)
                .replace(".", "")
                .replace("Rp", "")
                .replace(",", "")
                .replace(" ", "")
                .trim();
        verifyValue(value,expected); takeScreenshot.capture(driver);
    }
    public void verifyRate() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVApp();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[14]));
        value    = getText(driver, txtTbl_rate);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        value = getText(driver, txtTbl_rate)
                .replace("%", "")
                .replace(".", "");
        verifyValue(value,expected); takeScreenshot.capture(driver);
    }
    public void debtorDetail(){
        click(driver, rwDatafirstApp1);
        isPresent(driver, txtDetail_nomorAplikasi);
    }

    public void detailPartnerName() {
        iRowPictName = 8;

        value    = getText(driver, txtDetail_partner);
        expected = readTestData.companyName;
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);
//       if (readTestData.environment.equals("E2E")) {
//            verifyValue(value.replace("NEW ","").toUpperCase(),expected.replace("New ","").toUpperCase()); takeScreenshot.capture(driver);
//        } else{
        verifyValue(value,expected); takeScreenshot.capture(driver);
//        }
    }
    public void detailDebtorName() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVApp();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, txtDetail_namaDebitur);
        expected = arr[12];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected); takeScreenshot.capture(driver);
    }
    public void detailStatus() {
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, txtDetail_status);
        expected = "Waiting for review";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected); takeScreenshot.capture(driver);
    }
    public void detailAppNo() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVApp();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, txtDetail_nomorAplikasi);
        expected = arr[8];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected); takeScreenshot.capture(driver);
    }
    public void detailTanggalPengajuan() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVApp();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, txtDetail_tglPengajuan);
        expected = formattedToday.substring(0, 10);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value.substring(0, 10),expected); takeScreenshot.capture(driver);
    }
    public void detailJenisDebitur() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVApp();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, txtDetail_jenisDebitur);
        expected = arr[11];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected.trim()+"adan Usaha"); takeScreenshot.capture(driver);
    }
    public void detailPlafon() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVApp();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[15])) / 100;
        value    = getText(driver, txtDetail_plafon);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);

        value    = getText(driver, txtDetail_plafon)
                   .replace(".", "")
                   .replace("Rp", "")
                   .replace(",", "")
                   .replace(" ", "")
                   .trim();
        verifyValue(value,expected); takeScreenshot.capture(driver);
    }
    public void detailJangkaWaktu() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVApp();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[13]));
        value    = getText(driver, txtDetail_jangkaWaktu);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value.replace(" Bulan", "")
                   ,expected); takeScreenshot.capture(driver);
    }
    public void detailInterestRate() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVApp();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[14]));
        value    = getText(driver, txtDetail_interestRate);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        value    = getText(driver, txtDetail_interestRate)
                  .replace("%", "")
                  .replace(".", "");
        verifyValue(value,expected); takeScreenshot.capture(driver);
    }
    public void detailNIK() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVApp();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, txtDetail_nik);
        expected = arr[9];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected); takeScreenshot.capture(driver);
    }
    public void detailNPWP() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVApp();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, txtDetail_npwp);
        expected = arr[10] ;
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value.replace(".", "").replace("-", "")
                    ,expected); takeScreenshot.capture(driver);
    }
    public void detailSupportDoc() {
        iRowPictName = iRowPictName + iSeq;

        boolean supDoc = driver.findElement(txtDetail_suppDoc).isDisplayed();
        value          = getText(driver, txtDetail_suppDoc);
        expected       = "";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValueDisplay(supDoc,true, "Element file suppDoc kosong"); takeScreenshot.capture(driver);
    }
    public void detailSupportDocUploadFile() {
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, txtDetail_suppDoc);
        status_testCase_skip(iRowPictName, true, "Skip");
        createTestSkip(iRowPictName, extent_test_case, extent);
    }
    public void detailSupportDocReUploadFile() {
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, txtDetail_suppDoc);
        status_testCase_skip(iRowPictName, true, "Skip");
        createTestSkip(iRowPictName, extent_test_case, extent);

        click(driver, btnBackToTable);
    }

    public void debtorDetailWaitingReview() {

        writeText(driver, txtSearch, no_app1);
        isPresent(driver, rwDatafirstApp1);
        value = getText(driver, txtTbl_status);
        click(driver, rwDatafirstApp1);
        value2  = getText(driver, txtDetail_status);
        scrollDown(driver, txtArea_recommend);
    }
    public void debtorDetailListDropdownRecommend() throws InterruptedException {
        iRowPictName = 22;

        scrollDown(driver, txtArea_recommend);
        click(driver, optionlist_recommend);
        List<WebElement> lists = driver.findElements(By.id("dropdown-choice"));
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i).getText());
            value  = lists.get(i).getText().replace("\n", "");
        }
        boolean textAreaRecommendation = driver.findElement(txtAreaInput_recommend).isDisplayed();
        expected = "-Pilih Rekomendasi-RecommendedNot Recommended";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);Thread.sleep(1000);
        takeScreenshot.capture(driver);
        
        verifyValue(value,expected);

        click(driver, option_recommend);
        click(driver, optionlist_recommend);
        takeScreenshot.capture(driver);
        
        verifyValueDisplay(textAreaRecommendation,true, "Element textarea recommend IsDisplay");
    }
    public void submitRecommended() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;

        writeText(driver, txtAreaInput_recommend, Karakter5000);
        click(driver, txtDetail_status);
        value    = getText(driver, txtDetail_status);
        expected = "Waiting Approval";

        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);

        scrollUp(driver, body);Thread.sleep(100);
        click(driver, btnSubmitApp);
        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app1);
        value = getText(driver, txtTbl_status);
        verifyValue(value,expected);Thread.sleep(100);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        isPresent(driver, txtDetail_nomorAplikasi);
        value = getText(driver, txtDetail_status);Thread.sleep(100);
        takeScreenshot.capture(driver);

        value    = getText(driver, txtDetailCatatan);
        expected = Karakter5000;

        scrollPageDown(driver, btnBackToTable);Thread.sleep(100);
        takeScreenshot.capture(driver);

        scrollDown(driver, btnBackToTable);Thread.sleep(1000);
        takeScreenshot.capture(driver);

        verifyValue(value,expected);
        scrollUp(driver, btnBackToTable);scrollUp(driver, btnBackToTable);Thread.sleep(1000);
        click(driver, btnBackToTable);Thread.sleep(1000);
    }
    public void submitNotRecommended() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app8);
        click(driver, rwDatafirstApp1);

        isPresent(driver, txtDetail_nomorAplikasi);
        scrollDown(driver, txtArea_recommend);
        click(driver, optionlist_recommend);
        click(driver, option_NotRecommend);
        click(driver, optionlist_recommend);
        scrollUp(driver, body);Thread.sleep(100);

        value    = getText(driver, txtDetail_status);
        expected = "Waiting Approval";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        scrollDown(driver, txtArea_recommend);
        writeText(driver, txtAreaInput_recommend, Karakter4999);
        click(driver, txtDetail_status);
        takeScreenshot.capture(driver);

        scrollUp(driver, body);Thread.sleep(100);
        click(driver, btnSubmitApp);
        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app8);
        value = getText(driver, txtTbl_status);
        verifyValue(value,expected);Thread.sleep(100);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        isPresent(driver, txtDetail_nomorAplikasi);
        value = getText(driver, txtDetail_status);
        takeScreenshot.capture(driver);

        value    = getText(driver, txtDetailCatatan);
        expected = Karakter4999;

        scrollPageDown(driver, btnBackToTable);Thread.sleep(100);
        takeScreenshot.capture(driver);

        scrollDown(driver, btnBackToTable);Thread.sleep(1000);
        takeScreenshot.capture(driver);

        verifyValue(value,expected);
        scrollUp(driver, btnBackToTable);scrollUp(driver, btnBackToTable);Thread.sleep(1000);
        click(driver, btnBackToTable);Thread.sleep(1000);
    }

    public void debtorDetailListApproval() throws InterruptedException {
        iRowPictName = 25;

        writeText(driver, txtSearch, no_app1);
        isPresent(driver, rwDatafirstApp1);
        click(driver, rwDatafirstApp1);

        value = getText(driver, txtDetail_status);
        scrollPageDown(driver, btnBackToTable);
        scrollDown(driver, btnBackToTable);
        Thread.sleep(3000);
        click(driver, optionlist_approve);
        List<WebElement> lists = driver.findElements(By.id("dropdown-choice"));
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i).getText());
            value  = lists.get(i).getText().replace("\n", "");
        }
        boolean textAreaApproval = driver.findElement(approval_note).isDisplayed();
        expected = "-Pilih Keputusan-ApproveReject";

        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);Thread.sleep(100);
        takeScreenshot.capture(driver);
        Thread.sleep(Const.delay);
        verifyValue(value,expected);

        click(driver, option_approved);
        click(driver, txtDetailH5_HasilKeputusan);
        takeScreenshot.capture(driver);
        Thread.sleep(Const.delay);
        verifyValueDisplay(textAreaApproval,true, "Element textarea approval IsDisplay");
    }
    public void submitApproved() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;

        writeText(driver, approval_note, "RanString3");
        value = getText(driver, txtDetail_status);

        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);

        scrollUp(driver, body);Thread.sleep(1000);
        click(driver, btnSubmitApp);
        value = getText(driver, txtStrongUserApprove);
        takeScreenshot.capture(driver);
        
        if (isPresent(driver, txtStrongUserApprove)){
            System.out.println("Change Account...");
            changeUserToApprove();
        }else {
            value = getText(driver, txtDetail_status);
            takeScreenshot.capture(driver);
        }
        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app1);
        value = getText(driver, txtTbl_status);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        isPresent(driver, txtDetail_nomorAplikasi);
        value = getText(driver, txtDetail_status);
        takeScreenshot.capture(driver);

        scrollPageDown(driver, btnBackToTable);Thread.sleep(100);
        takeScreenshot.capture(driver);

        scrollDown(driver, btnBackToTable);Thread.sleep(100);
        takeScreenshot.capture(driver);
        
        writeText(driver, approval_note, Karakter5000);
        value = getText(driver, txtDetail_status);
        click(driver, optionlist_approve);
        click(driver, option_approved);
        click(driver, txtDetailH5_HasilKeputusan);
        takeScreenshot.capture(driver);
        
        scrollUp(driver, body);Thread.sleep(1000);
        click(driver, btnSubmitApp);Thread.sleep(1000);

        writeText(driver, txtSearch, no_app1);
        value    = getText(driver, txtTbl_status);
        expected = "Approved";
        verifyValue(value,expected);Thread.sleep(100);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        isPresent(driver, txtDetail_nomorAplikasi);
        value    = getText(driver, txtDetail_status);
        expected = Karakter5000;
        takeScreenshot.capture(driver);

        click(driver, btnBackToTable);
    }
    public void submitRejected() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app8);
        click(driver, rwDatafirstApp1);
        value = getText(driver, txtDetail_status);
        scrollDown(driver, btnBackToTable);Thread.sleep(100);
        scrollDown(driver, btnBackToTable);Thread.sleep(100);
        click(driver, optionlist_approve);
        click(driver, option_rejected);
        click(driver, txtDetailH5_HasilKeputusan);
        scrollUp(driver, body);Thread.sleep(1000);
        click(driver, btnBackToTable);

        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app8);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        takeScreenshot.capture(driver);

        scrollDown(driver, btnBackToTable);Thread.sleep(100);
        scrollDown(driver, btnBackToTable);Thread.sleep(100);
        click(driver, optionlist_approve);
        click(driver, option_rejected);
        click(driver, txtDetailH5_HasilKeputusan);

        writeText(driver, approval_note, Karakter4999);
        value = getText(driver, option_approved);
        takeScreenshot.capture(driver);

        scrollUp(driver, body);Thread.sleep(1000);
        click(driver, btnSubmitApp);Thread.sleep(1000);

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app8);
        value = getText(driver, txtTbl_status);
        expected = "Rejected";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        isPresent(driver, txtDetail_nomorAplikasi);
        expected = Karakter4999;
        takeScreenshot.capture(driver);

        click(driver, btnBackToTable);
    }

    public void statusApproved() {
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app1);
        value    = getText(driver, txtTbl_status);
        expected = "Approved";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        isPresent(driver, txtDetail_nomorAplikasi);
        value = getText(driver, txtDetail_status);
        takeScreenshot.capture(driver);

        click(driver, btnBackToTable);
    }
    public void statusRejected() {
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app8);
        value    = getText(driver, txtTbl_status);
        expected = "Rejected";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        isPresent(driver, txtDetail_nomorAplikasi);
        value = getText(driver, txtDetail_status);
        takeScreenshot.capture(driver);

        click(driver, btnBackToTable);
    }
    public void statusExpired() {
        iRowPictName = 30;

        status_testCase_skip(iRowPictName, true, "Skip");
        createTestSkip(iRowPictName, extent_test_case, extent);

//        isPresent(driver, rwDatafirstApp1);
//        writeText(driver, txtSearch, no_app7);
//        value    = getText(driver, txtTbl_status);
//        expected = "Waiting for Review";
//        status_testCase(iRowPictName, true, value);
//        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Data sebelum run job expired, saat status waiting for review");
//        verifyValue(value,expected);
//        takeScreenshot.capture(driver);
//        click(driver, rwDatafirstApp1);
//        isPresent(driver, txtDetail_nomorAplikasi);
//        value    = getText(driver, txtDetail_status);
//        expected = "Waiting for review";
//        verifyValue(value,expected);
//        takeScreenshot.capture(driver);
//        click(driver, btnBackToTable);
//
//        isPresent(driver, rwDatafirstApp1);
//        writeText(driver, txtSearch, no_app6);
//        value    = getText(driver, txtTbl_status);
//        expected = "Waiting Approval";
//        createInfo(extent_test_case, "Data sebelum run job expired, saat status waiting approval");
//        verifyValue(value,expected);
//        takeScreenshot.capture(driver);//
//        click(driver, rwDatafirstApp1);
//        isPresent(driver, txtDetail_nomorAplikasi);
//        value    = getText(driver, txtDetail_status);
//        expected = "Waiting Approval";
//        verifyValue(value,expected);
//        takeScreenshot.capture(driver);
//        click(driver, btnBackToTable);
//
//        createInfo(extent_test_case, "Run job approval expired ...........");
//        ExpiredAppForm_BU expiredAppForm_bu = new ExpiredAppForm_BU();
//        expiredAppForm_bu.serverAkses();
//        click(driver, menuApprovalForm);
//
//        isPresent(driver, rwDatafirstApp1);
//        writeText(driver, txtSearch, no_app7);
//        value    = getText(driver, txtTbl_status);
//        expected = "Approval Expired";
//        createInfo(extent_test_case, "Data setelah run job expired, saat status waiting for review");
//        verifyValue(value,expected);
//        takeScreenshot.capture(driver);
//        click(driver, rwDatafirstApp1);
//        isPresent(driver, txtDetail_nomorAplikasi);
//        value    = getText(driver, txtDetail_status);
//        expected = "Approval Expired";
//        verifyValue(value,expected);
//        takeScreenshot.capture(driver);
//        click(driver, btnBackToTable);
//
//        isPresent(driver, rwDatafirstApp1);
//        writeText(driver, txtSearch, no_app6);
//        value    = getText(driver, txtTbl_status);
//        expected = "Approval Expired";
//        createInfo(extent_test_case, "Data setelah run job expired, saat status waiting approval");
//        verifyValue(value,expected);
//        takeScreenshot.capture(driver);//
//        click(driver, rwDatafirstApp1);
//        isPresent(driver, txtDetail_nomorAplikasi);
//        value    = getText(driver, txtDetail_status);
//        expected = "Approval Expired";
//        verifyValue(value,expected);
//        takeScreenshot.capture(driver);
//        click(driver, btnBackToTable);
    }

    public void changeAllAppIdStatusApproved() throws IOException, InterruptedException {

        changeUserToMaker();
        menuApprovalForm();

        String[] arr;
        ReadCSVFormApproval readCSVFormApproval = new ReadCSVFormApproval();
        arr = readCSVFormApproval.fileCSVApp();
        Long getCount = Arrays.stream(arr).count();

        int index = 16;
        for (int i = index; i < 49; i++) {
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
        index = 16;
        for (int i = index; i < 41; i++) {
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
}
