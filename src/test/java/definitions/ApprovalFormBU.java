package definitions;

import elementsPage.ApprovalFormPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import runner.FormApprovalRunner;
import java.io.IOException;


public class ApprovalFormBU {

    private final WebDriver driver = FormApprovalRunner.driver;
    ApprovalFormPage appFile = new ApprovalFormPage();

    @Given("open browser and login as a role maker")
    public void openBrowserAndLoginAsARoleMaker() throws IOException {
        appFile.login();
    }

    @Then("click menu approval form")
    public void clickMenuApprovalForm() {
        appFile.menuApprovalForm();
    }

    @Then("verify data form table")
    public void verifyDataFormTable() {
        appFile.tableApprovalForm();
    }

    @And("verify data source")
    public void verifyDataSource() {
        appFile.verifySource();
    }

    @And("verify data application no")
    public void verifyDataApplicationNo() throws IOException {
        appFile.verifyAppNo();
    }

    @And("verify data debtor name")
    public void verifyDataDebtorName() throws IOException {
        appFile.verifyDebtorName();
    }

    @And("verify data partner")
    public void verifyDataPartner() {
        appFile.verifyPartner();
    }

    @And("verify data date")
    public void verifyDataDate() {
        appFile.verifyDate();
    }

    @And("verify data loan amount")
    public void verifyDataLoan() throws IOException {
        appFile.verifyLoanAmount();
    }

    @And("verify data rate")
    public void verifyDataRate() throws IOException {
        appFile.verifyRate();
    }

    @Then("click debtor name")
    public void clickDebtorName() {
        appFile.debtorDetail();
    }

    @And("verify data detail partner name")
    public void verifyDataDetailPartnerName() {
        appFile.detailPartnerName();
    }

    @And("verify data detail debtor name")
    public void verifyDataDetailDebtorName() throws IOException {
        appFile.detailDebtorName();
    }

    @And("verify data detail status")
    public void verifyDataDetailStatus() {
        appFile.detailStatus();
    }

    @And("verify data detail application no")
    public void verifyDataDetailApplicationNo() throws IOException {
        appFile.detailAppNo();
    }

    @And("verify data detail tanggal pengajuan")
    public void verifyDataDetailTanggalPengajuan() throws IOException {
        appFile.detailTanggalPengajuan();
    }

    @And("verify data detail jenis debitur")
    public void verifyDataDetailJenisDebitur() throws IOException {
        appFile.detailJenisDebitur();
    }

    @And("verify data detail plafon")
    public void verifyDataDetailPlafon() throws IOException {
        appFile.detailPlafon();
    }

    @And("verify data detail jangka waktu")
    public void verifyDataDetailJangkaWaktu() throws IOException {
        appFile.detailJangkaWaktu();
    }

    @And("verify data detail interest rate")
    public void verifyDataDetailInterestRate() throws IOException {
        appFile.detailInterestRate();
    }

    @And("verify data detail NIK")
    public void verifyDataDetailNIK() throws IOException {
        appFile.detailNIK();
    }

    @And("verify data detail NPWP")
    public void verifyDataDetailNPWP() throws IOException {
        appFile.detailNPWP();
    }

    @And("verify data detail Dokumen Pendukung\\(Tidak Upload Dokumen)")
    public void verifyDataDetailDokumenPendukungTidakUploadDokumen() {
        appFile.detailSupportDoc();
    }

    @And("verify data detail Dokumen Pendukung\\(Upload Dokumen > 1file.zip)")
    public void verifyDataDetailDokumenPendukungUploadDokumenFileZip() {
        appFile.detailSupportDocUploadFile();
    }

    @And("verify data detail Dokumen Pendukung\\(Upload Dokumen 2kali isi file berbeda)")
    public void verifyDataDetailDokumenPendukungUploadDokumenXIsiFileBerbeda() {
        appFile.detailSupportDocReUploadFile();
    }

    @Then("click debtor name untuk merubah status recommended & not recommended")
    public void clickDebtorNameUntukMerubahStatusRecommendedNotRecommended() {
        appFile.debtorDetailWaitingReview();
    }

    @And("click debtor name dengan status waiting for review")
    public void clickDebtorNameDenganStatusWaitingForReview() throws InterruptedException {
        appFile.debtorDetailListDropdownRecommend();
    }

    @And("memilih option recommended dan mengisi 5000karakter dan submit")
    public void memilihOptionRecommendedDanMengisiKarakterDanSubmit() throws InterruptedException {
        appFile.submitRecommended();
    }

    @And("memilih option not recommended dan mengisi 4999karakter dan submit")
    public void memilihOptionNotRecommendedDanMengisiKarakterDanSubmit() throws InterruptedException {
        appFile.submitNotRecommended();

    }

    @Then("click debtor name untuk merubah status approved & rejected")
    public void clickDebtorNameUntukMerubahStatusApprovedRejected() {
        appFile.tableApprovalForm();
    }

    @And("click debtor name dengan status waiting approval")
    public void clickDebtorNameDenganStatusWaitingApproval() throws InterruptedException {
        appFile.debtorDetailListApproval();
    }

    @And("memilih option keputusan approve dan mengisi 5000karakter dan submit")
    public void memilihOptionKeputusanApproveDanMengisiKarakterDanSubmit() throws InterruptedException {
        appFile.submitApproved();
    }

    @And("memilih option keputusan rejected dan mengisi 4999karakter dan submit")
    public void memilihOptionKeputusanRejectedDanMengisiKarakterDanSubmit() throws InterruptedException {
        appFile.submitRejected();
    }

    @Then("click debtor name dengan status approved & rejected & approval expired")
    public void clickDebtorNameDenganStatusApprovedDanRejectedDanApprovalExpired() {
        appFile.tableApprovalForm();
    }

    @And("click debtor name dengan status approved")
    public void clickDebtorNameDenganStatusApproved() {
        appFile.statusApproved();
    }

    @And("click debtor name dengan status rejected")
    public void clickDebtorNameDenganStatusRejected() {
        appFile.statusRejected();
    }

    @Then("approved yang status waiting approval untuk persiapan data realisasi")
    public void approvedYangStatusWaitingApprovalUntukPersiapanDataRealisasi()throws IOException, InterruptedException {
        appFile.changeAllAppIdStatusApproved();
    }
    @And("click debtor name dengan status approval expired")
    public void clickDebtorNameDenganStatusApprovalExpired() {
        appFile.statusExpired();
    }


    @Then("user maker logout")
    public void userMakerLogout() throws InterruptedException {
        appFile.logout();
        driver.close();
    }

}
