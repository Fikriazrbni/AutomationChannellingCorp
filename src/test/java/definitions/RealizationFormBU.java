package definitions;

import com.opencsv.exceptions.CsvException;
import elementsPage.RealizationFormPage;
import io.cucumber.java.bs.A;
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

    @Then("click debtor name rea untuk melihat status waiting approval & approved & rejected")
    public void clickDebtorNameReaUntukMelihatStatusWaitingApprovalApprovedRejected() {
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
        reaFile.menuNotification();
        reaFile.reconsumeAlamatWaitingApproval();
    }


    @Then("user ldap logout")
    public void userLdapLogout() throws InterruptedException {
        reaFile.logout(driver);
        driver.close();
    }

    @Then("verify status expired")
    public void verifyStatusExpired() {
        reaFile.menuRealizationForm();
    }
    @And("reconsume dengan no aplikasi status expired")
    public void reconsumeDenganNoAplikasiStatusExpired() throws IOException, CsvException {
        reaFile.reconsumeAlamatApprovalExpired();
    }
    @And("verify data realisasi form dengan status approval expired")
    public void verifyDataRealizationFormDenganStatusApprovalExpired() throws IOException {
        reaFile.verifyApprovalExpired();
    }
    @And("click debtor name rea dengan status expired")
    public void clickDebtorNameReaDenganStatusExpired() {
        reaFile.klikStatusApprovalExpired();
    }

    @Then("verify status pending")
    public void verifyStatusPending() throws InterruptedException {
        reaFile.menuRealizationForm();
        reaFile.rejectPending();
    }
    @And("verify data realisasi form dengan status pending")
    public void verifyDataRealizationFormDenganStatusPending() throws IOException, InterruptedException {
        reaFile.verifyPending();
    }
    @And("click debtor name rea dengan status pending")
    public void clickDebtorNameReaDenganStatusPending() throws IOException {
        reaFile.klikStatusPending();
    }
    @And("reconsume dengan no aplikasi status pending")
    public void reconsumeDenganNoAplikasiStatusPending() throws IOException, CsvException {
        reaFile.reconsumeAlamatPending();
    }
    @Then("verify detail pengurus")
    public void verifyDetailPengurus() throws IOException, InterruptedException {
        reaFile.menuRealizationForm();
        reaFile.searchAppNo();
    }
    @And("verifikasi data No Aplikasi 17karakter")
    public void verifikasi_data_No_Aplikasi_17karakter() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyNoApp17Char();
    }

    @And("verifikasi data no jumlah pengurus 2karakter numerik")
    public void verifikasi_data_no_jumlah_pengurus_2karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyJmlPeng2Char();
    }

    @And("verifikasi data sandi jabatan BI 1karakter numerik")
    public void verifikasi_data_sandi_jabatan_BI_1karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyJbtnBI1Char();
    }

    @And("verifikasi data pangsa kepemilikan 5karakter numerik")
    public void verifikasi_data_pangsa_kepemilikan_5karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyPangsa5Char();
    }

    @And("verifikasi data bentuk pengurus 1karakter")
    public void verifikasi_data_bentuk_pengurus_1karakter() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyBentukPengurus1Char();
    }

    @And("verifikasi data modal dasar 13karakter numerik")
    public void verifikasi_data_modal_dasar_13karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyModalDasar13Num();
    }

    @And("verifikasi data modal disetor 13karakter numerik")
    public void verifikasi_data_modal_disetor_13karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyModalDisetor13Num();
    }

    @And("verifikasi data modal ditempatkan 13karakter numerik")
    public void verifikasi_data_modal_ditempatkan_13karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyModalDitempatkan13Num();
    }

    @And("verifikasi data NPWP pengurus 15karakter numerik")
    public void verifikasi_data_NPWP_pengurus_15karakter_numerik() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyNPWP15Char();
    }

    @And("verifikasi data nama pengurus 60karakter varchar")
    public void verifikasi_data_nama_pengurus_60karakter_varchar() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifNamaPengurus60Char();
    }

    @And("verifikasi data alamat pengurus 40karakter varchar")
    public void verifikasi_data_alamat_pengurus_40karakter_varchar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyAltPeng40Char();
    }

    @And("verifikasi data alamat kelurahan 40karakter varchar")
    public void verifikasi_data_alamat_kelurahan_40karakter_varchar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyAltKelurahan40Char();
    }

    @And("verifikasi data alamat kecamatan 40karakter varchar")
    public void verifikasi_data_alamat_kecamatan_40karakter_varchar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyAltKecamatan40Char();
    }

    @And("verifikasi data alamat datiII 4karakter numerik")
    public void verifikasi_data_alamat_datiII_4karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyAltDatiII4Num();
    }

    @And("verifikasi data no akte 30karakter varchar")
    public void verifikasi_data_no_akte_30karakter_varchar() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyNoAkte30Char();
    }

    @And("verifikasi data tgl akte 8karakter varchar")
    public void verifikasi_data_tgl_akte_8karakter_varchar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyTglAkte8Num();
    }

    @And("verifikasi jenis kelamin pengurusB bentuk pengurus1")
    public void verifikasi_jenis_kelamin_pengurusB_bentuk_pengurus1() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyJnsKelPengB();
    }

    @And("verifikasi input ktp 16karakter numerik")
    public void verifikasi_input_ktp_16karakter_numerik() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyNoKTP16Char();
    }

    @And("verifikasi tgl lahir 8karakter numerik ddmmyyyy")
    public void verifikasi_tgl_lahir_8karakter_numerik_ddmmyyyy() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyTglLhr8Num();
    }

    @And("verifikasi dati 11tempat lahir 4karakter numerik")
    public void verifikasi_dati_11tempat_lahir_4karakter_numerik() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyDatiIITmptLahir4Char();
    }

    @And("verifikasi data no urut pengurus 2karakter numerik")
    public void verifikasi_data_no_urut_pengurus_2karakter_numerik() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyNoUrutPeng2Char();
    }

    @And("verifikasi data sandi jabatan BI 2karakter numerik")
    public void verifikasi_data_sandi_jabatan_BI_2karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyJbtnBI2Char();
    }

    @And("verifikasi data modal dasar 12karakter numerik")
    public void verifikasi_data_modal_dasar_12karakter_numerik() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyModalDasar12Num();
    }

    @And("verifikasi data modal disetor 12karakter numerik")
    public void verifikasi_data_modal_disetor_12karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyModalDisetor12Num();
    }

    @And("verifikasi data modal ditempatkan 12karakter numerik")
    public void verifikasi_data_modal_ditempatkan_12karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyModalDitempatkan12Num();
    }

    @And("verifikasi data nama pengurus 59karakter varchar")
    public void verifikasi_data_nama_pengurus_59karakter_varchar() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyNamaPengurus59Char();
    }

    @And("verifikasi data alamat pengurus 39karakter varchar")
    public void verifikasi_data_alamat_pengurus_39karakter_varchar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyAltPeng39Char();
    }

    @And("verifikasi data alamat keluarahn 39karakter varchar")
    public void verifikasi_data_alamat_keluarahn_39karakter_varchar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyAltKelurahan39Char();
    }

    @And("verifikasi data alamat kecamatan 39karakter varchar")
    public void verifikasi_data_alamat_kecamatan_39karakter_varchar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyAltKecamatan39();
    }

    @And("verifikasi data no akte 29karakter varchar")
    public void verifikasi_data_no_akte_29karakter_varchar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyNoAkter29Char();
    }

    @And("verifikasi jenis kelamin pengurusM bentuk pengurus1")
    public void verifikasi_jenis_kelamin_pengurusM_bentuk_pengurus1() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyJnsKelPengM();
    }

    @And("verifikasi no aplikasi 30karakter")
    public void verifikasi_no_aplikasi_30karakter() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyNoApp30Char();
    }

    @And("verifikasi jenis kelamin pengurusL bentuk pengurus2")
    public void verifikasi_jenis_kelamin_pengurusL_bentuk_pengurus2() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyJnsKelPengL();
    }

    @And("verifikasi jenis kelamin pengurusP bentuk pengurus2")
    public void verifikasi_jenis_kelamin_pengurusP_bentuk_pengurus2() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyJnsKelPengP();
    }

    @And("verifikasi pengurus>1 dalam 1file pengurus")
    public void verifikasi_pengurus_1_dalam_1file_pengurus() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.verifyDataPengLebihDari1();
    }

    @Then("user logout from Web")
    public void user_logout_from_Web() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        reaFile.logout(driver);
    }

    @Then("change all status for repayment")
    public void changeAllStatusForRepayment() throws IOException, InterruptedException {
        reaFile.changeAllStatus();

    }
}
