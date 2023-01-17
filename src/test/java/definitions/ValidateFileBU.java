package definitions;

import elementsPage.ValidateFilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import jobs.FileAppForm_BU;
import jobs.FileDiffPartnerAppForm_BU;
import org.openqa.selenium.WebDriver;
import runner.ValidateFileRunner;
import java.io.IOException;

public class ValidateFileBU {

    private final WebDriver driver = ValidateFileRunner.driver;
    ValidateFilePage valFile = new ValidateFilePage();

    @Given("open browser and login as role maker")
    public void openbrowserandloginasrolemaker() throws IOException {
        valFile.login();
    }

    @Then("change exposure debitur and run jobs approval form")
    public void changeExposureDebitur() throws InterruptedException {
        valFile.setProductProfile();
        valFile.setExposureDebt();

        FileAppForm_BU partner1                = new FileAppForm_BU();
        FileDiffPartnerAppForm_BU partner2     = new FileDiffPartnerAppForm_BU();
        partner1.serverAkses();
        partner2.serverAkses();

        valFile.logout();
    }

    @Then("click button notifikasi")
    public void clickButtonNotifikasi() throws IOException {
        valFile.loginLdap();
        valFile.menuNotification();
    }

    @And("verify notifikasi setelah proses file approval")
    public void verifyNotifikasiSetelahProsesFileApproval() throws IOException, InterruptedException {
        valFile.verifyNotification();
        valFile.logout();
        valFile.login();
    }

    @Then("verify data application form dan search application number status waiting for review dan click debtor detail")
    public void verifyDataApplicationFormDanSearchApplicationNumberStatusWaitingForReviewDanClickDebtorDetail() throws InterruptedException {
        valFile.menuApprovalForm();
    }

    @And("verify data no applikasi 17karakter varchar appform")
    public void verifyDataNoApplikasiKarakterVarcharAppform() throws IOException {
        valFile.verifyDataAppFormNoApp();
    }
    @And("verify data NPWP 15karakter numerik")
    public void verifyDataNPWP15KarakterNumerik() throws IOException {
        valFile.verifyDataAppFormNpwp();
    }
    @And("verify data jenis debitur B appform")
    public void verifyDataJenisDebiturB() throws IOException {
        valFile.verifyDataAppFormJenisDebitur();
    }

    @And("verify data nama debitur 40karakter appform")
    public void verifyDataNamaDebitur40Karakterappform() throws IOException {
        valFile.verifyDataAppFormNamaDebitur40karakter();
    }
    @And("verify data jangka waktu kredit batas bawah range")
    public void verifyDataJangkaWaktuKreditBatasBawahRange() throws IOException {
        valFile.verifyDataAppFormJangkaWaktuBawah();
    }
    @And("verify data interest rate batas bawah range")
    public void verifyDataInterestRateBatasBawahRange() throws IOException {
        valFile.verifyDataAppFormInterestRateBawah();
    }
    @And("verify data plafon batas bawah range")
    public void verifyDataPlafonBatasBawahRange() throws IOException {
        valFile.verifyDataAppFormPlafonBawah();
    }

    @And("verify data nama debitur 39karakter appform")
    public void verifyDataNamaDebitur39Karakterappform() throws IOException {
        valFile.verifyDataAppFormNamaDebitur39karakter();
    }
    @And("verify data jangka waktu kredit antara batas atas dan bawah range")
    public void verifyDataJangkaWaktuKreditAntaraBatasAtasDanBawahRange() throws IOException {
        valFile.verifyDataAppFormJangkaWaktuTengah();
    }
    @And("verify data interest rate antara batas atas dan bawah range")
    public void verifyDataInterestRateAntaraBatasAtasDanBawahRange() throws IOException {
        valFile.verifyDataAppFormInterestRateTengah();
    }
    @And("verify data plafon antara batas atas dan bawah range")
    public void verifyDataPlafonAntaraBatasAtasDanBawahRange() throws IOException {
        valFile.verifyDataAppFormPlafonTengah();
    }

    @And("verify data jangka waktu kredit batas atas range")
    public void verifyDataJangkaWaktuKreditBatasAtasRange() throws IOException {
        valFile.verifyDataAppFormJangkaWaktuAtas();
    }
    @And("verify data interest rate batas atas range")
    public void verifyDataInterestRateBatasAtasRange() throws IOException {
        valFile.verifyDataAppFormInterestRateAtas();
    }
    @And("verify data plafon batas atas range")
    public void verifyDataPlafonBatasAtasRange() throws IOException {
        valFile.verifyDataAppFormPlafonAtas();
    }

    @And("verify data dua data menggunakan NPWP sama di 1partner dengan plafon gabungan")
    public void verifyDataDuaDataMenggunakanNPWPSamaDiPartnerDenganPlafonGabungan() throws IOException {
        valFile.verifyDataNpwpSama1Partner();
    }

    @And("verify data data approval menggunakan NPWP sama di 2partner dengan plafon gabungan")
    public void verifyDataDataApprovalMenggunakanNPWPSamaDiPartnerDenganPlafonGabungan() throws IOException {
        valFile.verifyDataNpwpSama2Partner();
    }

    @Then("Approve status and run jobs reaForm")
    public void approveStatusAndRunJobsReaForm() throws IOException, InterruptedException {
        valFile.changeAllAppIdStatusApproved();
        valFile.runJobRealization();
        valFile.setExposureDebtRevert();
    }

    @Then("user role maker logout")
    public void userRoleMakerLogout() throws InterruptedException {
        valFile.logout();
        driver.close();
    }

    // Rea Badan Usaha =================================================================================================
    @Given("open browser and login as a role maker rea")
    public void openBrowserAndLoginAsARoleMakerRea() throws IOException {
        valFile.loginLdap();
    }
    @Then("click menu realisasi form")
    public void clickMenuRealisasiForm() {
        valFile.menuRealizationForm();
    }
    @Then("verify data realisasi form dan search application number status waiting for review dan click debtor detail")
    public void verifyDataRealisasiFormDanSearchApplicationNumberStatusWaitingForReviewDanClickDebtorDetail() {
    }
    @And("verify data no applikasi 17karakter varchar")
    public void verifyDataNoApplikasiKarakterVarchar() throws IOException {
        valFile.verifyDataReaFormNoApp();
    }
    @And("verify data nama debitur 60karakter reabu")
    public void verifyDataNamaDebitur60Karakterreabu() throws IOException  {
        valFile.verifyDataReaFormNama60Karakter();
    }
    @And("verify data jenis debitur B reabu")
    public void verifyDataJenisDebiturBreabu() throws IOException  {
        valFile.verifyDataReaFormJenisDebitur();
    }
    @And("verify data alamat 50karakter varchar")
    public void verifyDataAlamat50KarakterVarchar() throws IOException  {
        valFile.verifyDataReaFormAlamat50Karakter();
    }
    @And("verify data alamat kelurahan 40karakter varchar")
    public void verifyDataAlamatKelurahanKarakterVarchar() throws IOException  {
        valFile.verifyDataReaFormKelurahan40Karakter();
    }
    @And("verify data alamat kecamatan 40karakter varchar")
    public void verifyDataAlamatKecamatan40KarakterVarchar() throws IOException  {
        valFile.verifyDataReaFormKecamatan40Karakter();
    }
    @And("verify data alamat kode pos 5karakter numerik")
    public void verifyDataAlamatKodePosKarakterNumerik() throws IOException  {
        valFile.verifyDataReaFormKodePos5Karakter();
    }
    @And("verify data alamat kode dati 4karakter sesuai maintenance table")
    public void verifyDataAlamatKodeDatiKarakterSesuaiMaintenanceTable() throws IOException  {
        valFile.verifyDataReaFormKodeDati4Karakter();
    }
    @And("verify data nomor telepon 13karakter numerik")
    public void verifyDataNomorTelepon13KarakterNumerik() throws IOException  {
        valFile.verifyDataReaFormNoTelp13Karakter();
    }
    @And("verify data nomor akte 30karakter varchar reabu")
    public void verifyDataNomorAkte30KarakterVarchar() throws IOException  {
        valFile.verifyDataReaFormNoAkteAwal30Karakter();
    }
    @And("verify data tanggal berdiri 8karakter ddmmyyyy")
    public void verifyDataTanggalBerdiriKarakterDdmmyyyy() throws IOException  {
        valFile.verifyDataReaFormTanggalBerdiri();
    }
    @And("verify data nomor akte terakhir 30karakter varchar")
    public void verifyDataNomorAkteTerakhir30KarakterVarchar() throws IOException  {
        valFile.verifyDataReaFormNoAkteTerahir30Karakter();
    }
    @And("verify data tanggal akte terakhir 8karakter ddmmyyyy")
    public void verifyDataTanggalAkteTerakhirKarakterDdmmyyyy() throws IOException  {
        valFile.verifyDataReaFormTanggalAkteTerakhir();
    }
    @And("verify data bidang usaha 6karakter numerik sesuai maintenance table")
    public void verifyDataBidangUsahaKarakterNumerikSesuaiMaintenanceTable() throws IOException  {
        valFile.verifyDataReaFormBidangUsaha();
    }
    @And("verify data NPWP 15karakter numerik dengan plafon")
    public void verifyDataNPWPKarakterNumerikDenganPlafon() throws IOException  {
        valFile.verifyDataReaFormNoNpwp();
    }
    @And("verify data jangka waktu 3karakter numerik maintanance table")
    public void verifyDataJangkaWaktuKarakterNumerikMaintananceTable() throws IOException  {
        valFile.verifyDataReaFormJangkaWaktu();
    }
    @And("verify data jangka kredir 3karakter varchar seuai maintenance table")
    public void verifyDataJangkaKredirKarakterVarcharSeuaiMaintenanceTable() throws IOException  {
        valFile.verifyDataReaFormJenisKredit();
    }
    @And("verify data plafon 15karakter numerik")
    public void verifyDataPlafonKarakterNumerik() throws IOException  {
        valFile.verifyDataReaFormPlafon();
    }
    @And("verify data interest rate 5karakter numerik")
    public void verifyDataInterestRateKarakterNumerik() throws IOException  {
        valFile.verifyDataReaFormInterestRate();
    }
    @And("verify data nomor PK 100karakter varchar")
    public void verifyDataNomorPK100KarakterVarchar() throws IOException  {
        valFile.verifyDataReaFormNoPK100Karkter();
    }
    @And("verify data tanggal akad 8karakter ddmmyyyy")
    public void verifyDataTanggalAkad8KarakterDdmmyyyy() throws IOException  {
        valFile.verifyDataReaFormTanggalAkad();
    }
    @And("verify data tanggal angsuran I 8karakter ddmmyyyy")
    public void verifyDataTanggalAngsuranIKarakterDdmmyyyy() throws IOException, InterruptedException {
        valFile.verifyDataReaFormTanggalAngsuran();
    }
    @And("verify data jenis penggunaan 1karakter char sesuai maintenance table")
    public void verifyDataJenisPenggunaanKarakterCharSesuaiMaintenanceTable() throws IOException  {
        valFile.verifyDataReaFormJenisPenggunaan();
    }
    @And("verify data sektor ekonomi 6karakter sesuai maintenance table")
    public void verifyDataSektorEkonomiKarakterSesuaiMaintenanceTable() throws IOException  {
        valFile.verifyDataReaFormSektorEkonomi();
    }
    @And("verify data omzet 17karakter numerik")
    public void verifyDataOmzet17KarakterNumerik() throws IOException  {
        valFile.verifyDataReaFormOmzet();
    }
    @And("verify data go public 1karakter sesuai maintenance table")
    public void verifyDataGoPublicKarakterSesuaiMaintenanceTable() throws IOException  {
        valFile.verifyDataReaFormGoPublic();
    }
    @And("verify data sandi golongan debitur sesuai maintenance table")
    public void verifyDataSandiGolonganDebiturSesuaiMaintenanceTable() throws IOException  {
        valFile.verifyDataReaFormSandiGolongan();
    }
    @And("verify data penghasilan kotor per tahun 15karakter numerik")
    public void verifyDataPenghasilanKotorPerTahunKarakterNumerik() throws IOException  {
        valFile.verifyDataReaFormPenghasilanKotor();
    }
    @And("verify data bentuk badan usaha sesuai maintenance table")
    public void verifyDataBentukBadanUsahaSesuaiMaintenanceTable() throws IOException {
        valFile.verifyDataReaFormBentukBadanUsaha();
    }
    @And("verify data tempat berdiri badan usaha 30karakter varchar")
    public void verifyDataTempatBerdiriBadanUsaha30KarakterVarchar() throws IOException, InterruptedException {
        valFile.verifyDataReaFormTempatBeridiri30Karakter();
    }

    @And("verify data nama debitur 59karakter reabu")
    public void verifyDataNamaDebitur59Karakterreabu() throws IOException {
        valFile.verifyDataReaFormNama59Karakter();
    }
    @And("verify data alamat 49karakter varchar")
    public void verifyDataAlamat49KarakterVarchar() throws IOException {
        valFile.verifyDataReaFormAlamat49Karakter();
    }
    @And("verify data alamat kelurahan 39karakter varchar")
    public void verifyDataAlamatKelurahan39KarakterVarchar() throws IOException {
        valFile.verifyDataReaFormKelurahan39Karakter();
    }
    @And("verify data alamat kecamatan 39karakter varchar")
    public void verifyDataAlamatKecamatanKarakterVarchar() throws IOException {
        valFile.verifyDataReaFormKecamatan39Karakter();
    }
    @And("verify data nomor telepon 12karakter numerik")
    public void verifyDataNomorTelepon12KarakterNumerik() throws IOException {
        valFile.verifyDataReaFormNoTelp12Karakter();
    }
    @And("verify data nomor akte 29karakter varchar reabu")
    public void verifyDataNomorAkte29KarakterVarchar() throws IOException {
        valFile.verifyDataReaFormNoAkteAwal29Karakter();
    }
    @And("verify data nomor akte terakhir 29karakter varchar")
    public void verifyDataNomorAkteTerakhir29KarakterVarchar() throws IOException {
        valFile.verifyDataReaFormNoAkteTerahir29Karakter();
    }
    @And("verify data nomor PK 99karakter varchar")
    public void verifyDataNomorPK99KarakterVarchar() throws IOException {
        valFile.verifyDataReaFormNoPK99Karakter();
    }
    @And("verify data tempat berdiri badan usaha 29karakter varchar")
    public void verifyDataTempatBerdiriBadanUsaha29KarakterVarchar() throws IOException, InterruptedException {
        valFile.verifyDataReaFormTempatBeridiri29Karakter();
    }

    @And("verify data NPWP kosong dengan plafon dibawah 50juta")
    public void verifyDataNPWPKosongDenganPlafonDibawahJuta() throws IOException {
        valFile.verifyDataReaFormNpwpKosong();
    }

    // Rea Pengurus ====================================================================================================
    @And("verify data nomor aplikasi 17karakter varchar")
    public void verifyDataNomorAplikasiKarakterVarchar() throws IOException {
        valFile.verifyDataReaFormPengurusNoApp();
    }
    @And("verify data nomor urut pengurus 2karakter numerik")
    public void verifyDataNomorUrutPengurusKarakterNumerik() throws IOException, InterruptedException {
        valFile.verifyDataReaFormPengurusNoUrut();
    }
    @And("verify data jumlah pengurus 2karakter numerik")
    public void verifyDataJumlahPengurusKarakterNumerik() throws IOException {
        valFile.verifyDataReaFormPengurusJumlahPengurus();
    }
    @And("verify data sandi jabatan BI 1karakter numerik")
    public void verifyDataSandiJabatanBI1KarakterNumerik() throws IOException {
        valFile.verifyDataReaFormPengurusSandiJabatan1();
    }
    @And("verify data pangsa kepemilikan 5karakter numerik")
    public void verifyDataPangsaKepemilikanKarakterNumerik() throws IOException {
        valFile.verifyDataReaFormPengurusPangsaKepemilikan();
    }
    @And("verify data bentuk pengurus1")
    public void verifyDataBentukPengurus() throws IOException, InterruptedException {
        valFile.verifyDataReaFormPengurusBentukPengurus();
    }
    @And("verify data modal dasar 13karakter numerik")
    public void verifyDataModalDasar13KarakterNumerik() throws IOException {
        valFile.verifyDataReaFormPengurusModalDasar13();
    }
    @And("verify data modal disetor 13karakter numerik")
    public void verifyDataModalDisetor13KarakterNumerik() throws IOException {
        valFile.verifyDataReaFormPengurusModalDisetor13();
    }
    @And("verify data modal ditempatkan 13karakter numerik")
    public void verifyDataModalDitempatkan13KarakterNumerik() throws IOException {
        valFile.verifyDataReaFormPengurusModalDitempatkan13();
    }
    @And("verify data NPWP pengurus 15karakter numerik")
    public void verifyDataNPWPPengurusKarakterNumerik() throws IOException {
        valFile.verifyDataReaFormPengurusNpwp();
    }
    @And("verify data nama pengurus 60karakter varchar")
    public void verifyDataNamaPengurus60KarakterVarchar() throws IOException {
        valFile.verifyDataReaFormPengurusNama60();
    }
    @And("verify data alamat pengurus 40karakter varchar")
    public void verifyDataAlamatPengurus40KarakterVarchar() throws IOException {
        valFile.verifyDataReaFormPengurusAlamat40();
    }
    @And("verify data alamat kelurahan pengurus 40karakter varchar")
    public void verifyDataAlamatKelurahanPengurus40KarakterVarchar() throws IOException {
        valFile.verifyDataReaFormPengurusKelurahan40();
    }
    @And("verify data alamat kecamatan pengurus 40karakter varchar")
    public void verifyDataAlamatKecamatanPengurus40KarakterVarchar() throws IOException {
        valFile.verifyDataReaFormPenguruskecamatan40();
    }
    @And("verify data alamat kode dati 4karakter numerik")
    public void verifyDataAlamatKodeDatiKarakterNumerik() throws IOException {
        valFile.verifyDataReaFormPengurusKodeDati();
    }
    @And("verify data nomor KTP 16karakter numerik")
    public void verifyDataNomorKTPKarakterNumerik() throws IOException {
        valFile.verifyDataReaFormPengurusNoKtp();
    }
    @And("verify data nomor akte 30karakter varchar pengurus")
    public void verifyNomorAkte30Karakter() throws IOException {
        valFile.verifyDataReaFormPengurusNoAkte30();
    }
    @And("verify data tanggal lahir 8karakter numerik ddmmyyyy")
    public void verifyDataTanggalLahirKarakterNumerikDdmmyyyy() throws IOException {
        valFile.verifyDataReaFormPengurusTanggalLahir();
    }
    @And("verify data tanggal akte 8karakter numerik ddmmyyyy")
    public void verifyDataTanggalAkteKarakterNumerikDdmmyyyy() throws IOException, InterruptedException {
        valFile.verifyDataReaFormPengurusTglAkte();
    }
    @And("verify data kode dati II tempat lahir 4karakter numerik")
    public void verifyDataKodeDatiIITempatLahirKarakterNumerik() throws IOException {
        valFile.verifyDataReaFormPengurusKodeDatiTempatLahir();
    }
    @And("verify data jenis kelamin pengurus B")
    public void verifyDataJenisKelaminPengurusB() throws IOException {
        valFile.verifyDataReaFormPengurusJenisKelaminB();
    }
    @And("verify data data pengurus lebih dari 1 dalam 1file pengurus")
    public void verifyDataDataPengurusLebihDariDalamFilePengurus() throws IOException, InterruptedException {
        valFile.verifyDataReaFormPengurusDataPengurus();
    }

    @And("verify data sandi jabatan BI 2karakter numerik")
    public void verifyDataSandiJabatanBI2KarakterNumerik() throws IOException, InterruptedException {
        valFile.verifyDataReaFormPengurusSandiJabatan2();
    }
    @And("verify data modal dasar 12karakter numerik")
    public void verifyDataModalDasar12KarakterNumerik() throws IOException, InterruptedException {
        valFile.verifyDataReaFormPengurusModalDasar12();
    }
    @And("verify data modal disetor 12karakter numerik")
    public void verifyDataModalDisetor12KarakterNumerik() throws IOException {
        valFile.verifyDataReaFormPengurusModalDisetor12();
    }
    @And("verify data modal ditempatkan 12karakter numerik")
    public void verifyDataModalDitempatkan12KarakterNumerik() throws IOException {
        valFile.verifyDataReaFormPengurusModalDitempatkan12();
    }
    @And("verify data nama pengurus 59karakter varchar")
    public void verifyDataNamaPengurus59KarakterVarchar() throws IOException {
        valFile.verifyDataReaFormPengurusNama59();
    }
    @And("verify data alamat pengurus 39karakter varchar")
    public void verifyDataAlamatPengurus39KarakterVarchar() throws IOException {
        valFile.verifyDataReaFormPengurusAlamat39();
    }
    @And("verify data alamat kelurahan pengurus 39karakter varchar")
    public void verifyDataAlamatKelurahanPengurus39KarakterVarchar() throws IOException {
        valFile.verifyDataReaFormPengurusKelurahan39();
    }
    @And("verify data alamat kecamatan pengurus 39karakter varchar")
    public void verifyDataAlamatKecamatanPengurus39KarakterVarchar() throws IOException {
        valFile.verifyDataReaFormPenguruskecamatan39();
    }
    @And("verify data nomor akte 29karakter varchar pengurus")
    public void verifyNomorAkte29Karakter() throws IOException {
        valFile.verifyDataReaFormPengurusNoAkte29();
    }
    @And("verify data jenis kemanin pengurus M")
    public void verifyDataJenisKemaninPengurusM() throws IOException, InterruptedException {
        valFile.verifyDataReaFormPengurusJenisKelaminM();
    }
}
