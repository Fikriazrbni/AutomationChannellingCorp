package elementsPage;

import org.openqa.selenium.By;

public class ReaTable {

    //Top Bar
    public static final By notif        = By.xpath("//img[contains(@class, 'Attach')]");
    public static final By notifSeeAll  = By.xpath("//span[contains(@class, 'See-All-Notification')]");


    //Table
    public static final By menuRealization = By.xpath("(//a[contains(@href, 'approval-form')])[1]");
    public static final By tableDebtNameLink = By.xpath("//*[@id=\"channelingTable\"]/tr[1]/td[4]/a");
    public static final By tblSearch = By.xpath("//*[@id=\"myInput\"]");
    public static final By tblSource = By.xpath("//*[@id=\"channelingTable\"]/tr/td[2]");
    public static final By tblAppId = By.xpath("//*[@id=\"channelingTable\"]/tr/td[3]");
    public static final By tblDebtName = By.xpath("//*[@id=\"channelingTable\"]/tr/td[4]");
    public static final By tblPartner = By.xpath("//*[@id=\"channelingTable\"]/tr/td[5]");
    public static final By tblDate = By.xpath("//*[@id=\"channelingTable\"]/tr/td[6]");
    public static final By tblLoanAmount = By.xpath("//*[@id=\"channelingTable\"]/tr/td[7]");
    public static final By tblInterestRate = By.xpath("//*[@id=\"channelingTable\"]/tr/td[8]");
    public static final By tblStatus = By.xpath("//*[@id=\"channelingTable\"]/tr[1]/td[9]/a");

    //Detail
    public static final By dtlBtnBack                = By.xpath("/html/body/div[2]/div/div[1]/div/div[1]/a/img");
    public static final By dtlBtnApprove             = By.xpath("//*[@id=\"approved\"]");
    public static final By dtlBtnReject              = By.xpath("//*[@id=\"rejected-form\"]");
    public static final By dtlModalConfirmApprove    = By.xpath("//*[@id=\"form-approve\"]");
    public static final By dtlBtnConfirmYes          = By.xpath("//*[@id=\"formSubmit\"]");
    public static final By dtlBtnConfirmNo           = By.xpath("//*[@id=\"modal-cancel\"]");
    public static final By dtlModalConfirmReject     = By.xpath("//*[@id=\"rejectReason\"]");
    public static final By dtlModalConfirmRejectType = By.xpath("//*[@id=\"select2-rejectDescription-container\"]");
    public static final By dtlModalConfirmRejectList = By.xpath("//*[@id=\"rejectDescription\"]");
    public static final By dtlModalConfirmRejectType_0 = By.xpath("//*[@id=\"rejectDescription\"]/option[1]");
    public static final By dtlModalConfirmRejectType_1 = By.xpath("//*[@id=\"rejectDescription\"]/option[2]");
    public static final By dtlModalConfirmRejectType_2 = By.xpath("//*[@id=\"rejectDescription\"]/option[3]");
    public static final By dtlModalConfirmRejectReason = By.xpath("//*[@name=\"rejectReason\"]");
    public static final By dtlBtnRejectYes          = By.xpath("(//*[@id=\"formSubmit\"])[2]");
    public static final By dtlBtnRejectNo           = By.xpath("//*[@id=\"modal-cancel-reject\"]");


    public static final By dtlPartner       = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/div/div[1]/div/label");
    public static final By dtlDebtName      = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div/label");
    public static final By dtlStatus        = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/div/div[3]/div/label");
    public static final By dtlAppId         = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/div/div[4]/div/label");
    public static final By dtlDate          = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/div/div[5]/div/label");
    public static final By dtlCtgDebt       = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/div/div[6]/div/label");
    public static final By dtlLoanAmount    = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/div/div[7]/div/label");
    public static final By dtlDuration      = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/div/div[8]/div/label");
    public static final By dtlInterestRate  = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/div/div[9]/div/label");
    public static final By dtlCtgCredit     = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/div/div[10]/div/label");
    public static final By dtlUtil          = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/div/div[11]/div/label");
    public static final By dtlPKNo          = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/div/div[12]/div/label");
    public static final By dtlContact       = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/div/div[13]/div/label");
    public static final By dtlInstalment_1   = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/div/div[14]/div/label");
    public static final By dtlNPWP           = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/label");
    public static final By dtlTelp           = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/label");
    public static final By dtlAddress        = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/div[3]/div/label");
    public static final By dtlAddWard        = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/div[4]/div/label");
    public static final By dtlAddDistrict    = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/div[5]/div/label");
    public static final By dtlAddPostalCode  = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/div[6]/div/label");
    public static final By dtlAddCodeDATI_II = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/div[7]/div/label");
    public static final By dtlFields         = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/div[8]/div/label");
    public static final By dtlEntity         = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/div[9]/div/label");
    public static final By dtlSector         = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/div[10]/div/label");
    public static final By dtlGoPublic       = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/div[11]/div/label");
    public static final By dtlGroupDebt      = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/div[12]/div/label");
    public static final By dtlIncomePerYear  = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/div[13]/div/label");
    public static final By dtlTurnOver       = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/div[14]/div/label");
    public static final By dtlCertNO         = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/div[15]/div/label");
    public static final By dtlCertNOLatest   = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/div[16]/div/label");
    public static final By dtlCertDeadline   = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/div[17]/div/label");
    public static final By dtlCertPublish    = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/div[18]/div/label");
    public static final By dtlCertPlaces     = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div/div[19]/div/label");



}
