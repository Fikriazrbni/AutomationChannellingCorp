package definitions;

import com.opencsv.exceptions.CsvException;
import elementsPage.RealizationFormPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import runner.FormRealizationRunner;
import java.io.IOException;


public class RealizationFormBU {

    private final WebDriver driver = FormRealizationRunner.driver;
    RealizationFormPage reaFile = new RealizationFormPage();

    @Given("open browser and login as a role ldap maker")
    public void open_browser_and_login_as_a_role_ldap_maker() throws IOException {
        reaFile.login();
    }


    @Then("click icon notifikasi and verify notifikasi saat data realisasi masuk LOS")
    public void verifyNotifikasiSaatDataRealisasiMasukLOS() {
        reaFile.menuNotification();
    }

    @And("verify notifikasi setelah file masuk")
    public void verifyNotifikasiSetelahFileMasuk() {
//        reaFile.NotificationFile();
        reaFile.verifyNotification();
    }

    @Then("click menu realization")
    public void clickMenuRealization() {
        reaFile.menuRealizationForm();
    }

    @Then("verify data form table realization dan search application number berdasarkan status")
    public void verifyDataFormTableRealizationDanSearchApplicationNumberBerdasarkanStatus() {

    }

    @And("verify data realisasi form dengan status waiting approval")
    public void verifyDataRealizationFormDenganStatusWaitingApproval() {
        reaFile.verifyWaitingApproval();
    }

    @And("verify data realisasi form dengan status pending")
    public void verifyDataRealizationFormDenganStatusPending() {
        reaFile.verifyPending();
    }

    @And("verify data realisasi form dengan status approval expired")
    public void verifyDataRealizationFormDenganStatusApprovalExpired() {
        reaFile.verifyApprovalExpired();
    }

    @Then("verify data form table realisasi")
    public void verifyDataFormTableRealisasi() {
        reaFile.tableApprovalForm();
    }

    @And("verify data realisasi source")
    public void verifyDataRealisasiSource() {
        reaFile.verifySource();
    }

    @And("verify data realisasi application no")
    public void verifyDataRealisasiApplicationNo() throws IOException {
        reaFile.verifyAppNo();
    }

    @And("verify data realisasi debtor name")
    public void verifyDataRealisasiDebtorName() throws IOException {
        reaFile.verifyDebtorName();
    }

    @And("verify data realisasi partner")
    public void verifyDataRealisasiPartner() {
        reaFile.verifyPartner();
    }

    @And("verify data realisasi date")
    public void verifyDataRealisasiDate() {
        reaFile.verifyDate();
    }

    @And("verify data realisasi loan amount")
    public void verifyDataRealisasiLoanAmount() throws IOException {
        reaFile.verifyLoanAmount();
    }

    @And("verify data realisasi rate")
    public void verifyDataRealisasiRate() throws IOException {
        reaFile.verifyRate();
    }

    @Then("click debtor name realisasi")
    public void clickDebtorNameRealisasi() {
        reaFile.debtorDetail();
    }

    @And("verify data detail realisasi partner")
    public void verifyDataDetailRealisasiPartner(){
        reaFile.detailPartnerName();
    }

    @And("verify data detail realisasi debtor name")
    public void verifyDataDetailRealisasiDebtorName() throws IOException {
        reaFile.detailDebtorName();
    }

    @And("verify data detail realisasi status")
    public void verifyDataDetailRealisasiStatus() {
        reaFile.detailStatus();
    }

    @And("verify data detail realisasi app no")
    public void verifyDataDetailRealisasiAppNo() throws IOException {
        reaFile.detailAppNo();
    }

    @And("verify data detail realisasi tanggal pengajuan")
    public void verifyDataDetailRealisasiTanggalPengajuan() throws IOException {
        reaFile.detailTanggalPengajuan();
    }

    @And("verify data detail realisasi jenis debitur")
    public void verifyDataDetailRealisasiJenisDebitur() throws IOException {
        reaFile.detailJenisDebitur();
    }

    @And("verify data detail realisasi plafon")
    public void verifyDataDetailRealisasiPlafon() throws IOException {
        reaFile.detailPlafon();
    }

    @And("verify data detail realisasi jangka waktu")
    public void verifyDataDetailRealisasiJangkaWaktu() throws IOException {
        reaFile.detailJangkaWaktu();
    }

    @And("verify data detail realisasi interest rate")
    public void verifyDataDetailRealisasiInterestRate() throws IOException {
        reaFile.detailInterestRate();
    }

    @And("verify data detail realisasi jenis kredit")
    public void verifyDataDetailRealisasiJenisKredit() throws IOException {
        reaFile.detailJenisKredit();
    }

    @And("verify data detail realisasi jenis penggunaan")
    public void verifyDataDetailRealisasiJenisPenggunaan() throws IOException {
        reaFile.detailJenisPenggunaan();
    }

    @And("verify data detail realisasi nomor PK")
    public void verifyDataDetailRealisasiNomorPK() throws IOException {
        reaFile.detailNomorPK();
    }

    @And("verify data detail realisasi tanggal akad")
    public void verifyDataDetailRealisasiTanggalAkad() throws IOException {
        reaFile.detailTanggalAkad();
    }

    @And("verify data detail realisasi tanggal angsuran I")
    public void verifyDataDetailRealisasiTanggalAngsuranI() throws IOException, InterruptedException {
        reaFile.detailTanggalAngsuranI();
    }

    @And("verify data detail realisasi nomor NPWP")
    public void verifyDataDetailRealisasiNomorNPWP() throws IOException {
        reaFile.detailNomorNPWP();
    }

    @And("verify data detail realisasi no telp")
    public void verifyDataDetailRealisasiNoTelp() throws IOException {
        reaFile.detailNoTelp();
    }

    @And("verify data detail realisasi alamat")
    public void verifyDataDetailRealisasiAlamat() throws IOException {
        reaFile.detailAlamat();
    }

    @And("verify data detail realisasi alamat kelurahan")
    public void verifyDataDetailRealisasiAlamatKelurahan() throws IOException {
        reaFile.detailAlamatKelurahan();
    }

    @And("verify data detail realisasi alamat kecamatan")
    public void verifyDataDetailRealisasiAlamatKecamatan() throws IOException {
        reaFile.detailAlamatKecamatan();
    }

    @And("verify data detail realisasi alamat kode pos")
    public void verifyDataDetailRealisasiAlamatKodePos() throws IOException {
        reaFile.detailAlamatKodePos();
    }

    @And("verify data detail realisasi alamat kode DATI II")
    public void verifyDataDetailRealisasiAlamatKodeDATIII() throws IOException {
        reaFile.detailAlamatKodeDatiII();
    }

    @And("verify data detail realisasi bidang usaha")
    public void verifyDataDetailRealisasiBidangUsaha() throws IOException {
        reaFile.detailBidangUsaha();
    }

    @And("verify data detail realisasi bentuk badan usaha")
    public void verifyDataDetailRealisasiBentukBadanUsaha() throws IOException {
        reaFile.detailBentukBadanUsaha();
    }

    @And("verify data detail realisasi sektor ekonomi")
    public void verifyDataDetailRealisasiSektorEkonomi() throws IOException {
        reaFile.detailSektorEkonomi();
    }

    @And("verify data detail realisasi go public")
    public void verifyDataDetailRealisasiGoPublic() throws IOException {
        reaFile.detailGoPublic();
    }

    @And("verify data detail realisasi sandi golongan debitur")
    public void verifyDataDetailRealisasiSandiGolonganDebitur() throws IOException {
        reaFile.detailSandiGolonganDebtitur();
    }

    @And("verify data detail realisasi penghasilan kotor per tahun")
    public void verifyDataDetailRealisasiPenghasilanKotorPerTahun() throws IOException{
        reaFile.detailPenghasilanPertahun();
    }

    @And("verify data detail realisasi omzet")
    public void verifyDataDetailRealisasiOmzet() throws IOException {
        reaFile.detailOmzet();
    }

    @And("verify data detail realisasi no akte")
    public void verifyDataDetailRealisasiNoAkte() throws IOException {
        reaFile.detailNoAkte();
    }

    @And("verify data detail realisasi no akte terakhir")
    public void verifyDataDetailRealisasiNoAkteTerakhir() throws IOException {
        reaFile.detailNoAkteTerakhir();
    }

    @And("verify data detail realisasi tanggal akte terakhir")
    public void verifyDataDetailRealisasiTanggalAkteTerakhir() throws IOException {
        reaFile.detailTanggalAkteTerakhir();
    }

    @And("verify data detail realisasi tanggal berdiri")
    public void verifyDataDetailRealisasiTanggalBerdiri() throws IOException, InterruptedException {
        reaFile.detailTanggalBerdiri();
    }

    @And("verify data detail realisasi tempat berdiri badan usaha")
    public void verifyDataDetailRealisasiTempatBerdiriBadanUsaha() throws IOException, InterruptedException {
        reaFile.detailTempatBerdiriBadanUsaha();
    }

    @Then("verify no akte dan tangggal akte")
    public void verifyNoAkteDanTangggalAkte() {
        reaFile.tableApprovalForm();
    }

    @And("verify tanggal akte terakhir sama dengan hari ini")
    public void verifyTanggalAkteTerakhirSamaDenganHariIni() throws IOException, InterruptedException {
        reaFile.detailTanggalAkteToday();
    }

    @And("verify tanggal akte terakhir kemarin")
    public void verifyTanggalAkteTerakhirKemarin() throws IOException, InterruptedException {
        reaFile.detailTanggalAkteYesterday();
    }

    @And("verify tanggal berdiri dan tanggal akte terakhir sama serta no akte dan no akte terakhir sama")
    public void verifyTanggalBerdiriDanTanggalAkteTerakhirSamaSertaNoAkteDanNoAkteTerakhirSama() throws IOException, InterruptedException {
        reaFile.detailTanggalAkteSamaNoAkteSama();
    }

    @And("verify tanggal berdiri dan tanggal akte terakhir berbeda serta no akte dan no akte terakhir berbeda")
    public void verifyTanggalBerdiriDanTanggalAkteTerakhirBerbedaSertaNoAkteDanNoAkteTerakhirBerbeda() throws IOException, InterruptedException {
        reaFile.detailTanggalAkteBedaNoAkteBeda();
    }

    @And("verify tanggal berdiri dan tanggal akte terakhir berbeda serta no akte dan no akte terakhir sama")
    public void verifyTanggalBerdiriDanTanggalAkteTerakhirBerbedaSertaNoAkteDanNoAkteTerakhirSama() throws IOException, InterruptedException {
        reaFile.detailTanggalAkteBedaNoAkteSama();
    }

    @Then("click debtor name rea merubah status waiting approval")
    public void clickDebtorNameReaMerubahStatusWaitingApproval() {
        reaFile.tableApprovalForm();
    }

    @And("click debtor name rea status waiting approval dengan klik approve")
    public void clickDebtorNameReaStatusWaitingApprovalDenganKlikApprove() {
        reaFile.klikApprove();
    }

    @And("click debtor name rea status waiting approval dengan klik approve lalu saat confirm box klik tidak")
    public void clickDebtorNameReaStatusWaitingApprovalDenganKlikApproveLaluSaatConfirmBoxKlikTidak() throws InterruptedException {
        reaFile.klikApproveNo();
    }

    @And("click debtor name rea status waiting approval dengan klik approve lalu saat confirm box klik ya")
    public void clickDebtorNameReaStatusWaitingApprovalDenganKlikApproveLaluSaatConfirmBoxKlikYa() {
        reaFile.klikApproveYes();
    }

    @And("click debtor name rea status waiting approval dengan klik reject")
    public void clickDebtorNameReaStatusWaitingApprovalDenganKlikReject() throws InterruptedException {
        reaFile.klikReject();
    }

    @And("click debtor name rea status waiting approval dengan klik dan pilih reject reason dokumen pendukung tidak sesuai dan deskripsi 5000karakter lalu klik reject")
    public void clickDebtorNameReaStatusWaitingApprovalDenganKlikDanPilihRejectReasonDanDeskripsiKarakterLaluKlikReject() throws InterruptedException {
        reaFile.klikReject_I();
    }

    @And("click debtor name rea status waiting approval dengan klik dan pilih reject reason pengajuan ditolak dan deskripsi 49999karakter lalu klik reject")
    public void clickDebtorNameReaStatusWaitingApprovalDenganKlikDanPilihRejectReasonPengajuanDitolakDanDeskripsiKarakterLaluKlikReject() throws InterruptedException {
        reaFile.klikReject_II();
    }

    @And("click debtor name rea status waiting approval dengan klik dan pilih reject reason dan deskripsi kosong lalu klik reject")
    public void clickDebtorNameReaStatusWaitingApprovalDenganKlikDanPilihRejectReasonDanDeskripsiKosongLaluKlikReject() throws InterruptedException {
        reaFile.klikReject_III();
    }

    @Then("click debtor name rea untuk melihat status waiting approval & approved & rejected &  pending & expired")
    public void clickDebtorNameReaUntukMelihatStatusWaitingApprovalApprovedRejectedPendingExpired() {
        reaFile.tableApprovalForm();
    }

    @And("click debtor name rea dengan status waiting approval")
    public void clickDebtorNameReaDenganStatusWaitingApproval() {
        reaFile.klikStatusWaitingApproval();
    }

    @And("click debtor name rea dengan status approved")
    public void clickDebtorNameReaDenganStatusApproved() {
        reaFile.klikStatusApproved();
    }

    @And("click debtor name rea dengan status rejected")
    public void clickDebtorNameReaDenganStatusRejected() {
        reaFile.klikStatusRejected();
    }

    @And("click debtor name rea dengan status pending")
    public void clickDebtorNameReaDenganStatusPending() {
        reaFile.klikStatusPending();
    }

    @And("click debtor name rea dengan status expired")
    public void clickDebtorNameReaDenganStatusExpired() {
        reaFile.klikStatusApprovalExpired();
    }

    @Then("reconsume data dengan merubah data alamat setiap status")
    public void reconsumeDataDenganMerubahDataAlamatSetiapStatus() {
        reaFile.menuRealizationForm();
    }

    @And("reconsume dengan no aplikasi status rejected")
    public void reconsumeDenganNoAplikasiStatusRejected() throws IOException, CsvException {
        reaFile.reconsumeAlamatRejected();
    }
    @And("reconsume dengan no aplikasi status approved")
    public void reconsumeDenganNoAplikasiStatusApproved() throws IOException, CsvException {
        reaFile.reconsumeAlamatApproved();
    }
    @And("reconsume dengan no aplikasi status waiting approval")
    public void reconsumeDenganNoAplikasiStatusWaitingApproval() throws IOException, CsvException {
        reaFile.reconsumeAlamatWaitingApproval();
    }
    @And("reconsume dengan no aplikasi status expired")
    public void reconsumeDenganNoAplikasiStatusExpired() throws IOException {
        reaFile.reconsumeAlamatApprovalExpired();
    }
    @And("reconsume dengan no aplikasi status pending")
    public void reconsumeDenganNoAplikasiStatusPending() throws IOException {
        reaFile.reconsumeAlamatPending();
    }

    @Then("user ldap logout")
    public void userLdapLogout() throws InterruptedException {
        reaFile.logout(driver);
        driver.close();
    }
}
