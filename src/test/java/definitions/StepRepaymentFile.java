package definitions;

import elementsPage.ApprovalFormPage;
import elementsPage.RealizationFormPage;
import elementsPage.RepaymentFilePage;
import io.cucumber.java.en.When;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.regexp.RE;

import java.io.IOException;
import java.text.ParseException;

public class StepRepaymentFile {

    RepaymentFilePage repay = new RepaymentFilePage();
    ApprovalFormPage app = new ApprovalFormPage();
    RealizationFormPage rea = new RealizationFormPage();

    public StepRepaymentFile() throws IOException {
    }

    @Given("user open browser and user login application repaymentFile")
    public void user_open_browser_and_user_login_application_repaymentFile() {
    }

    @And("Nomor Aplikasi diisi sesuai format")
    public void nomor_Aplikasi_diisi_sesuai_format() throws InterruptedException, IOException {
        repay.noAppSesuai();

    }

    @Then("Nomor Pembayaran diisi sesuai format")
    public void nomor_Pembayaran_diisi_sesuai_format() throws IOException {
        repay.noBayarSesuai();

    }

    @And("Tanggal Pembayaran diisi sesuai format ddmmyyyy")
    public void tanggal_Pembayaran_diisi_sesuai_format_ddmmyyyy() throws IOException {
        repay.tglBayarSesuai();

    }

    @And("Nominal Pokok diisi15 13_2 digit dengan 2desimal dan bukan_0")
    public void nominal_Pokok_diisi15_13_2_digit_dengan_2desimal_dan_bukan_0() throws IOException {
        repay.noPokNot0();

    }

    @And("Nominal Pokok diisi15 13_2 digit dengan 2desimal dan terisi_0")
    public void nominal_Pokok_diisi15___digit_dengan_2desimal_dan_terisi_0() throws IOException {
        repay.noPok0();

    }

    @And("Nominal Bunga diisi15 13_2 digit dengan 2desimal dan bukan_0")
    public void nominal_Bunga_diisi15___digit_dengan_2desimal_dan_bukan_0() throws IOException {
        repay.noBungNot0();

    }

    @And("Nominal Bunga diisi15 13_2 digit dengan 2desimal dan terisi_0")
    public void nominal_Bunga_diisi15___digit_dengan_2desimal_dan_terisi_0() throws IOException {
        repay.noBung0();

    }

    @And("Nominal Denda diisi15 13_2 digit dengan 2desimal dan bukan_0")
    public void nominal_Denda_diisi15___digit_dengan_2desimal_dan_bukan_0() throws IOException {
        repay.noDenNot0();

    }

    @And("Nominal Denda diisi15 13_2 digit dengan 2desimal dan terisi_0")
    public void nominal_Denda_diisi15___digit_dengan_2desimal_dan_terisi_0() throws IOException {
        repay.noDen0();

    }

    @And("Pelunasan diisi Y")
    public void pelunasan_diisi_Y() throws IOException {
        repay.pel_Y();

    }

    @And("Pelunasan diisi N")
    public void pelunasan_diisi_N() throws IOException {
        repay.pel_N();

    }

    @And("Pelunasan diisi I")
    public void pelunasan_diisi_I() throws IOException {
        repay.pel_I();

    }

    @And("Pelunasan diisiA")
    public void pelunasan_diisiA() {
        repay.pel_A();

    }

    @And("Additional Interest diisi15 13_2 digit dengan 2desimal dan bukan_0")
    public void additional_Interest_diisi15_13_2_digit_dengan_2desimal_dan_bukan_0() {
        repay.addIntNot0();

    }

    @And("Additional Interest diisi15 13_2 digit dengan 2desimal dan terisi_0")
    public void additional_Interest_diisi15_13_2_digit_dengan_2desimal_dan_terisi_0() {
        repay.addInt0();

    }

    @And("Verifikasi Data File Berhasil Dari Fineract-loan_id")
    public void verifikasi_Data_File_Berhasil_Dari_Fineract_loan_id() throws IOException {
        repay.finLoanId();
    }

    @And("Verifikasi Data File Berhasil Dari Fineract-company_code")
    public void verifikasi_Data_File_Berhasil_Dari_Fineract_company_code() throws IOException {
        repay.finCompCode();
    }

    @And("Verifikasi Data File Berhasil Dari Fineract-repayment_number")
    public void verifikasi_Data_File_Berhasil_Dari_Fineract_repayment_number() throws IOException {
        repay.finRepayNum();
    }

    @And("Verifikasi Data File Berhasil Dari Fineract-Partner_Date")
    public void verifikasi_Data_File_Berhasil_Dari_Fineract_Partner_Date() throws IOException {
        repay.finPartDate();
    }

    @And("Verifikasi Data File Berhasil Dari Fineract-Partner_Pokok")
    public void verifikasi_Data_File_Berhasil_Dari_Fineract_Partner_Pokok() throws IOException {
        repay.finPartPok();
    }

    @And("Verifikasi Data File Berhasil Dari Fineract-Partner_Bunga")
    public void verifikasi_Data_File_Berhasil_Dari_Fineract_Partner_Bunga() throws IOException {
        repay.finPartBung();
    }

    @And("Verifikasi Data File Berhasil Dari Fineract-Partner_Denda")
    public void verifikasi_Data_File_Berhasil_Dari_Fineract_Partner_Denda() throws IOException {
        repay.finPartDen();
    }

    @And("Verifikasi Data File Berhasil Dari Fineract-Partner_Pelunasan")
    public void verifikasi_Data_File_Berhasil_Dari_Fineract_Partner_Pelunasan() throws IOException {
        repay.finPartPelnas();
    }

    @And("Verifikasi Data File Berhasil Dari Fineract-BCAD_Outstanding")
    public void verifikasi_Data_File_Berhasil_Dari_Fineract_BCAD_Outstanding() throws IOException {
        repay.finBcadOutstand();
    }

    @And("Verifikasi Data File Berhasil Dari Fineract-BCAD_Date")
    public void verifikasi_Data_File_Berhasil_Dari_Fineract_BCAD_Date() throws ParseException, IOException {
        repay.finBcadDate();
    }

    @And("Verifikasi Data File Berhasil Dari Fineract-BCAD_Pokok")
    public void verifikasi_Data_File_Berhasil_Dari_Fineract_BCAD_Pokok() throws IOException {
        repay.finBcadPok();
    }

    @And("Verifikasi Data File Berhasil Dari Fineract-BCAD_Bunga")
    public void verifikasi_Data_File_Berhasil_Dari_Fineract_BCAD_Bunga() throws IOException {
        repay.finBcadBung();
    }

    @And("Verifikasi Data File Berhasil Dari Fineract-Additional Interest")
    public void verifikasi_Data_File_Berhasil_Dari_Fineract_Additional_Interest() {
        repay.finBcadAddInt();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Nomor_Aplikasi")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Nomor_Aplikasi() throws IOException {
        repay.negFinNoAplikasi();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Nomor_Pembayaran")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Nomor_Pembayaran() throws IOException {
        repay.negFinNoPembayaran();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Tanggal_Pembayaran")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Tanggal_Pembayaran() throws IOException {
        repay.negFintglPembayaran();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Nominal_Pokok")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Nominal_Pokok() throws IOException {
        repay.negFinNomPok();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Nominal_Bunga")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Nominal_Bunga() throws IOException {
        repay.negFinNomBung();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Nominal_Denda")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Nominal_Denda() throws IOException {
        repay.negFinNomDen();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Pelunasan")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Pelunasan() throws IOException {
        repay.negFinPel();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Additional Interest")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Additional_Interest() {
        repay.negFinAddInt();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi No Aplikasi kosong")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_No_Aplikasi_kosong() throws IOException {
        repay.nullNoApp();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi No Pembayaran kosong")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_No_Pembayaran_kosong() throws IOException {
        repay.nullNoPembayaran();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi Tanggal Pembayaran kosong")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_Tanggal_Pembayaran_kosong() throws IOException {
        repay.nullTglBayar();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi Nominal Pokok kosong")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_Nominal_Pokok_kosong() throws IOException {
        repay.nullNomPok();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi Nominal Bunga kosong")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_Nominal_Bunga_kosong() throws IOException {
        repay.nullNomBung();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi Nominal Denda kosong")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_Nominal_Denda_kosong() throws IOException {
        repay.nullNomDen();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi Pelunasan kosong")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_Pelunasan_kosong() throws IOException {
        repay.nullPelnas();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi Additional Interest KOPNUS kosong")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_Additional_Interest_KOPNUS_kosong() {
        repay.nullAddInt();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length NoAplikasi kurang satu")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_length_NoAplikasi_kurang_satu() throws IOException {
        repay.oobNoApp();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length No Pembayaran kurang satu")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_length_No_Pembayaran_kurang_satu() throws IOException {
        repay.oobNoPembayaran();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length Tanggal Pembayaran kurang satu")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_length_Tanggal_Pembayaran_kurang_satu() throws IOException {
        repay.oobTglPembayaran();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length Nominal Pokok kurang satu")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_length_Nominal_Pokok_kurang_satu() throws IOException {
        repay.oobNomPok();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length Nominal Bunga kurang satu")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_length_Nominal_Bunga_kurang_satu() throws IOException {
        repay.oobNomBung();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length Nominal Denda kurang satu")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_length_Nominal_Denda_kurang_satu() throws IOException {
        repay.oobNomDen();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi Pelunasan tidak sesuai \\(diisi selain N_ Y_ I_ danA)")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_Pelunasan_tidak_sesuai_diisi_selain_N__Y__I__danA() throws IOException {
        repay.oobPelnas();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length Additional Interest KOPNUS kurang satu")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_length_Additional_Interest_KOPNUS_kurang_satu() {
        repay.oobAddInt();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length NoAplikasi lebih satu")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_length_NoAplikasi_lebih_satu() throws IOException {
        repay.oobNoApp2();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length No Pembayaran lebih satu")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_length_No_Pembayaran_lebih_satu() throws IOException {
        repay.oobNoPembayaran2();
    }


    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length Tanggal Pembayaran lebih satu")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_length_Tanggal_Pembayaran_lebih_satu() throws IOException {
        repay.oobTglPembayaran2();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length Nominal Pokok lebih satu")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_length_Nominal_Pokok_lebih_satu() throws IOException {
        repay.oobNomPok2();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length Nominal Bunga lebih satu")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_length_Nominal_Bunga_lebih_satu() throws IOException {
        repay.oobNomBung2();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length Nominal Denda lebih satu")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_length_Nominal_Denda_lebih_satu() throws IOException {
        repay.oobNomDen2();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length Additional Interest KOPNUS lebih satu")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_length_Additional_Interest_KOPNUS_lebih_satu() {
        repay.oobAddInt2();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length NoAplikasi tidak ditemukan")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_length_NoAplikasi_tidak_ditemukan() throws IOException {
        repay.notFoundNoApp();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length No Repayment sudah terdaftar")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_length_No_Repayment_sudah_terdaftar() throws IOException {
        repay.duplicatExistNoBayar();
    }

    @And("Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length No Repayment terulang dalam 1file")
    public void verifikasi_Data_File_Gagal_Dari_Fineract_Error_dengan_kondisi_length_No_Repayment_terulang_dalam_1file() throws IOException {
        repay.duplicatInFileNoBayar();
    }

    @And("bandingin Extent")
    public void bandinginExtent() throws IOException {
        repay.comparation();
    }

    //Repayment Form
    @Given("user open browser and user login application repaymentForm")
    public void user_open_browser_and_user_login_application_repaymentForm() throws InterruptedException {
        repay.openRepayMenu();
    }

    @And("Verifikasi card Detail -Tanggal Masuk File")
    public void verifikasi_card_Detail_Tanggal_Masuk_File() {
        repay.dtlTgMskFile();
    }

    @And("Verifikasi card Detail -Batch No")
    public void verifikasi_card_Detail_Batch_No() {
        repay.dtlBatchNo();
    }

    @And("Verifikasi card Detail -Nomor Aplikasi")
    public void verifikasi_card_Detail_Nomor_Aplikasi() throws IOException {
        repay.dtlNoApp();
    }

    @And("Verifikasi card Detail -Nama Debitur")
    public void verifikasi_card_Detail_Nama_Debitur() throws IOException {
        repay.dtlNoDebitur();
    }

    @And("Verifikasi card Detail -Partner")
    public void verifikasi_card_Detail_Partner() throws IOException {
        repay.dtlPartner();
    }

    @And("Verifikasi card Detail -Nomor Pembayaran")
    public void verifikasi_card_Detail_Nomor_Pembayaran() throws IOException {
        repay.dtlNoBayar();
    }

    @And("Verifikasi card Detail -Status Amount Repayment dengan kondisi total pembayaran pada file repayment< jumlah tagihan")
    public void verifikasi_card_Detail_Status_Amount_Repayment_dengan_kondisi_total_pembayaran_pada_file_repayment_jumlah_tagihan1() throws IOException {
        repay.dtlStatKurangBayar();
    }

    @And("Verifikasi card Detail -Status Amount Repayment dengan kondisi total pembayaran pada file repayment = jumlah tagihan")
    public void verifikasi_card_Detail_Status_Amount_Repayment_dengan_kondisi_total_pembayaran_pada_file_repayment_jumlah_tagihan2() throws IOException {
        repay.dtlStatPasBayar();
    }

    @And("Verifikasi card Detail -Status Amount Repayment dengan kondisi total pembayaran pada file repayment > jumlah tagihan")
    public void verifikasi_card_Detail_Status_Amount_Repayment_dengan_kondisi_total_pembayaran_pada_file_repayment_jumlah_tagihan3() throws IOException {
        repay.dtlStatLebihBayar();
    }

    @And("Verifikasi card Hasil Approval -Status \\(setelah job consume)")
    public void verifikasi_card_Hasil_Approval_Status_setelah_job_consume() throws IOException {
        repay.verifyStatAfterConsume();
    }

    @And("Verifikasi card Hasil Approval -Approved by \\(setelah job consume)")
    public void verifikasi_card_Hasil_Approval_Approved_by_setelah_job_consume() throws IOException {
        repay.verifyApprovedbyAfterConsume();
    }

    @And("Verifikasi card Hasil Approval -Tanggal Approval \\(setelah job consume)")
    public void verifikasi_card_Hasil_Approval_Tanggal_Approval_setelah_job_consume() throws IOException {
        repay.verifyTglApprovalAfterCons();
    }

    @And("Verifikasi card Hasil Approval -Type Reject Reason \\(setelah job consume)")
    public void verifikasi_card_Hasil_Approval_Type_Reject_Reason_setelah_job_consume() throws IOException {
        repay.verifyTypeRejectReason();
    }

    @And("Verifikasi card Hasil Approval -Deskripsi \\(setelah job consume)")
    public void verifikasi_card_Hasil_Approval_Deskripsi_setelah_job_consume() throws IOException {
        repay.verifyDescAfterConsume();
    }

    @And("Verifikasi card Data Partner -Tanggal Pembayaran")
    public void verifikasi_card_Data_Partner_Tanggal_Pembayaran() throws IOException {
        repay.verifyTglBayar();
    }

    @And("Verifikasi card Data Partner -Total Pembayaran dengan kondisi pada file repayment terisi nominal pokok, nominal bunga, nominal denda, dan additional interest")
    public void verifikasi_card_Data_Partner_Total_Pembayaran_dengan_kondisi_pada_file_repayment_terisi_nominal_pokok_nominal_bunga_nominal_denda_dan_additional_interest() throws IOException {
        repay.cardTotPem();
    }

    @And("Verifikasi card Data Partner -Total Pembayaran dengan kondisi pada file repayment terisi nominal pokok, nominal bunga, dan additional interest \\(nominal denda kosong)")
    public void verifikasi_card_Data_Partner_Total_Pembayaran_dengan_kondisi_pada_file_repayment_terisi_nominal_pokok_nominal_bunga_dan_additional_interest_nominal_denda_kosong() throws IOException {
        repay.cardTotPemDend0();
    }

    @And("Verifikasi card Data Partner -Pembayaran Pokok dengan kondisi pada file repayment terisi nominal pokok")
    public void verifikasi_card_Data_Partner_Pembayaran_Pokok_dengan_kondisi_pada_file_repayment_terisi_nominal_pokok() throws IOException {
        repay.cardPempok();
    }

    @And("Verifikasi card Data Partner -Pembayaran Pokok dengan kondisi pada file repayment nominal pokok null")
    public void verifikasi_card_Data_Partner_Pembayaran_Pokok_dengan_kondisi_pada_file_repayment_nominal_pokok_null() throws IOException {
        repay.cardPempoknopok0();
    }

    @And("Verifikasi card Data Partner -Pembayaran Bunga dengan kondisi pada file repayment terisi nominal bunga")
    public void verifikasi_card_Data_Partner_Pembayaran_Bunga_dengan_kondisi_pada_file_repayment_terisi_nominal_bunga() throws IOException {
        repay.cardPempokbung();
    }

    @And("Verifikasi card Data Partner -Pembayaran Bunga dengan kondisi pada file repayment nominal bunga null")
    public void verifikasi_card_Data_Partner_Pembayaran_Bunga_dengan_kondisi_pada_file_repayment_nominal_bunga_null() throws IOException {
        repay.cardPempokbung0();
    }

    @And("Verifikasi card Data Partner -Pembayaran Denda dengan kondisi pada file repayment terisi nominal denda")
    public void verifikasi_card_Data_Partner_Pembayaran_Denda_dengan_kondisi_pada_file_repayment_terisi_nominal_denda() throws IOException {
        repay.cardPempokden();
    }

    @And("Verifikasi card Data Partner -Pembayaran Denda dengan kondisi pada file repayment nominal denda null")
    public void verifikasi_card_Data_Partner_Pembayaran_Denda_dengan_kondisi_pada_file_repayment_nominal_denda_null() throws IOException {
        repay.cardPempokden0();
    }

    @And("Verifikasi card Data Partner -Additional Interest dengan kondisi pada file repayment terisi Additional Interest")
    public void verifikasi_card_Data_Partner_Additional_Interest_dengan_kondisi_pada_file_repayment_terisi_Additional_Interest() {
        repay.cardPempokaddInt();
    }

    @And("Verifikasi card Data Partner -Additional Interest dengan kondisi pada file repayment Additional Interest null")
    public void verifikasi_card_Data_Partner_Additional_Interest_dengan_kondisi_pada_file_repayment_Additional_Interest_null() {
        repay.cardPempokaddInt0();
    }

    @And("Verifikasi card Data Partner -Status Pembayaran dengan kondisi Pelunasan pada file Repayment = N")
    public void verifikasi_card_Data_Partner_Status_Pembayaran_dengan_kondisi_Pelunasan_pada_file_Repayment_N() throws IOException {
        repay.cardPemN();
    }

    @And("Verifikasi card Data Partner -Status Pembayaran dengan kondisi Pelunasan pada file Repayment = Y")
    public void verifikasi_card_Data_Partner_Status_Pembayaran_dengan_kondisi_Pelunasan_pada_file_Repayment_Y() throws IOException {
        repay.cardPemY();
    }

    @And("Verifikasi card Data Partner -Status Pembayaran dengan kondisi Pelunasan pada file Repayment = I")
    public void verifikasi_card_Data_Partner_Status_Pembayaran_dengan_kondisi_Pelunasan_pada_file_Repayment_I() throws IOException {
        repay.cardPemI();
    }

    @And("Verifikasi card Data Partner -Status Pembayaran dengan kondisi Pelunasan pada file Repayment = A")
    public void verifikasi_card_Data_Partner_Status_Pembayaran_dengan_kondisi_Pelunasan_pada_file_Repayment_A() {
        repay.cardPemA();
    }

    @And("Verifikasi kolom Tanggal Pembayaran")
    public void verifikasi_kolom_Tanggal_Pembayaran() throws InterruptedException, IOException {
        repay.listTglbayar();
    }

    @And("Verifikasi kolom Total Pembayaran dengan kondisi pada file repayment terisi nominal pokok, nominal bunga, nominal denda, dan additional interest")
    public void verifikasi_kolom_Total_Pembayaran_dengan_kondisi_pada_file_repayment_terisi_nominal_pokok_nominal_bunga_nominal_denda_dan_additional_interest() throws IOException {
        repay.listTotPem();
    }

    @And("Verifikasi kolom Total Pembayaran dengan kondisi pada file repayment terisi nominal pokok, nominal bunga, dan additional interest \\(nominal denda kosong)")
    public void verifikasi_kolom_Total_Pembayaran_dengan_kondisi_pada_file_repayment_terisi_nominal_pokok_nominal_bunga_dan_additional_interest_nominal_denda_kosong() throws InterruptedException, IOException {
        repay.listTotPemDen0();
    }

    @And("Verifikasi kolom Total Tagihan")
    public void verifikasi_kolom_Total_Tagihan() throws InterruptedException, IOException {
        repay.listTotTagihan();
    }

    @And("Verifikasi kolom Status Amount Pembayaran dengan kondisi total pembayaran pada file repayment< jumlah tagihan")
    public void verifikasi_kolom_Status_Amount_Pembayaran_dengan_kondisi_total_pembayaran_pada_file_repayment_jumlah_tagihan1() throws InterruptedException, IOException {
        repay.listStatKurangBayar();
    }

    @And("Verifikasi kolom Status Amount Pembayaran dengan kondisi total pembayaran pada file repayment = jumlah tagihan")
    public void verifikasi_kolom_Status_Amount_Pembayaran_dengan_kondisi_total_pembayaran_pada_file_repayment_jumlah_tagihan2() throws InterruptedException, IOException {
        repay.listStatSesuai();
    }

    @And("Verifikasi kolom Status Amount Pembayaran dengan kondisi total pembayaran pada file repayment > jumlah tagihan")
    public void verifikasi_kolom_Status_Amount_Pembayaran_dengan_kondisi_total_pembayaran_pada_file_repayment_jumlah_tagihan3() throws InterruptedException, IOException {
        repay.listStatLebih();
    }

    @And("Verifikasi kolom Tanggal Masuk File")
    public void verifikasi_kolom_Tanggal_Masuk_File() throws InterruptedException, IOException {
        repay.listTglMasukFile();
    }

    @And("Verifikasi kolom Batch No")
    public void verifikasi_kolom_Batch_No() {
        repay.listBatchNo();
    }

    @And("Verifikasi kolom Status setelah job repayment")
    public void verifikasi_kolom_Status_setelah_job_repayment() throws IOException {
        repay.listStatWaitforApp();
    }

    @And("Verifikasi card Data BCAD -Tanggal Pembayaran Bulan Berjalan")
    public void verifikasi_card_Data_BCAD_Tanggal_Pembayaran_Bulan_Berjalan() throws ParseException {
        repay.cardTglPemBulBerjalan();
    }

    @And("Verifikasi card Data BCAD -Total Tagihan")
    public void verifikasi_card_Data_BCAD_Total_Tagihan() {
        repay.cardTotTagih();
    }

    @And("Verifikasi card Data BCAD -Pembayaran Pokok Bulan Berjalan")
    public void verifikasi_card_Data_BCAD_Pembayaran_Pokok_Bulan_Berjalan() {
        repay.cardPemPokBulBerjalan();
    }

    @And("Verifikasi card Data BCAD -Pembayaran Bunga Bulan Berjalan")
    public void verifikasi_card_Data_BCAD_Pembayaran_Bunga_Bulan_Berjalan() {
        repay.cardPemBungBulBerjalan();
    }

    @And("Verifikasi card Data BCAD -Pembayaran Denda Bulan Berjalan")
    public void verifikasi_card_Data_BCAD_Pembayaran_Denda_Bulan_Berjalan() {
        repay.cardPemDenBulBerjalan();
    }

    @And("Verifikasi card Data BCAD -Additional Interest Bulan Berjalan")
    public void verifikasi_card_Data_BCAD_Additional_Interest_Bulan_Berjalan() {
        repay.cardAddIntBulBerjalan();
    }

    @And("Klik Approve button di Halaman detail Repayment")
    public void klik_Approve_button_di_Halaman_detail_Repayment() throws InterruptedException {
        repay.klikApprv();
    }

    @And("Klik Approve button di Halaman detail Repayment klik approve dan tidak")
    public void klik_Approve_button_di_Halaman_detail_Repayment_klik_approve_dan_tidak() {
        repay.klikApprvNo();
    }

    @And("Klik Approve button di Halaman detail Repayment klik approve dan ya")
    public void klik_Approve_button_di_Halaman_detail_Repayment_klik_approve_dan_ya() throws InterruptedException {
        repay.klikApprvYes();
    }

    @And("Verifikasi card Hasil Approval setelah Approve data")
    public void verifikasi_card_Hasil_Approval_setelah_Approve_data() {
        repay.verifyApprovedData();
    }

    @And("Klik Reject button di Halaman detail Repayment")
    public void klik_Reject_button_di_Halaman_detail_Repayment() {
        repay.klikReject();
    }

    @And("Verifikasi isi field Type Reject Reason")
    public void verifikasi_isi_field_Type_Reject_Reason() {
        repay.verifyTypeofReject();
    }

    @And("Klik Reject button di Halaman detail Repayment klik reject dan tidak")
    public void klik_Reject_button_di_Halaman_detail_Repayment_klik_reject_dan_tidak() {
        repay.klikRejectCancel();
    }

    @And("Klik Reject dan Mengisi Type Reject Reason dan Tidak mengisi Description dan Klik Submit")
    public void klik_Reject_dan_Mengisi_Type_Reject_Reason_dan_Tidak_mengisi_Description_dan_Klik_Submit() {
        repay.rejectwithoutDesc();
    }

    @And("Klik Reject dan Tidak Mengisi Type Reject Reason dan mengisi Description dan Klik Submit")
    public void klik_Reject_dan_Tidak_Mengisi_Type_Reject_Reason_dan_mengisi_Description_dan_Klik_Submit() {
        repay.rejectWoutTypeReject();
    }

    @And("Klik Reject dan Mengisi Type Reject Reason dan mengisi Description 100karakter dan Klik Submit")
    public void klik_Reject_dan_Mengisi_Type_Reject_Reason_dan_mengisi_Description_100karakter_dan_Klik_Submit() throws InterruptedException {
        repay.rejectDesc100();
    }

    @And("Klik Reject dan Mengisi Type Reject Reason dan mengisi Description 99karakter dan Klik Submit")
    public void klik_Reject_dan_Mengisi_Type_Reject_Reason_dan_mengisi_Description_99karakter_dan_Klik_Submit() throws InterruptedException {
        repay.rejectDesc99();
    }

    @And("Verifikasi card Hasil Approval setelah Reject data")
    public void verifikasi_card_Hasil_Approval_setelah_Reject_data() {
        repay.rejectedData();
    }

    @And("Klik Bulk Approve Check beberapa data Klik Approve")
    public void klik_Bulk_Approve_Check_beberapa_data_Klik_Approve() throws InterruptedException {
        repay.bulkApprv();
    }

    @And("Klik Bulk Approve Check beberapa data Klik Approve dan klik batal")
    public void klik_Bulk_Approve_Check_beberapa_data_Klik_Approve_dan_klik_batal() {
        repay.bulkApprvBatal();
    }

    @And("Klik Bulk Approve Check beberapa data Klik Approve dan klik submit")
    public void klik_Bulk_Approve_Check_beberapa_data_Klik_Approve_dan_klik_submit() throws InterruptedException {
        repay.bulkApprvSubmit();
    }

    @And("Cek data repayment dengan status Waiting for Approval")
    public void cek_data_repayment_dengan_status_Waiting_for_Approval() throws InterruptedException {
        repay.checkDataWaitforAppr();
    }

    @And("Cek data repayment dengan status Approved")
    public void cek_data_repayment_dengan_status_Approved() throws InterruptedException {
        repay.checkDataApprov();
    }

    @And("Cek data repayment dengan status Rejected")
    public void cek_data_repayment_dengan_status_Rejected() throws InterruptedException {
        repay.checkDataRejected();
    }

    @And("Cek data repayment dengan status Pending Batch Run")
    public void cek_data_repayment_dengan_status_Pending_Batch_Run() throws InterruptedException {
        repay.checkDataPBR();
    }

    @And("Cek data repayment dengan status Approval Expired")
    public void cek_data_repayment_dengan_status_Approval_Expired() throws InterruptedException {
        repay.checkDataApprvExp();
    }

    @And("Klik Edit pada data Waiting for ApprovalEdit pada data Klik Update")
    public void klik_Edit_pada_data_Waiting_for_ApprovalEdit_pada_data_Klik_Update() throws InterruptedException {
        repay.editWaiting();
    }

    @And("Klik Edit pada data Rejected Edit pada data Klik Update")
    public void klik_Edit_pada_data_Rejected_Edit_pada_data_Klik_Update() throws InterruptedException {
        repay.editRejected();
    }

    @And("Klik Edit pada data Pending Batch Run Edit pada data Klik Update")
    public void klik_Edit_pada_data_Pending_Batch_Run_Edit_pada_data_Klik_Update() throws InterruptedException {
        repay.editPBR();
    }

    @And("Approve data yang diedit")
    public void approve_data_yang_diedit() throws InterruptedException {
        repay.approvEditData();
    }

    @And("Reject data yang diedit")
    public void reject_data_yang_diedit() throws InterruptedException {
        repay.rejectEditData();
    }

    @And("Klik pada data status Waiting for Approval")
    public void klik_pada_data_status_Waiting_for_Approval() throws InterruptedException {
        repay.checkButtonWaitforApprv();
    }

    @And("Klik pada data status Approved")
    public void klik_pada_data_status_Approved() throws InterruptedException {
        repay.checkButtonApproved();
    }

    @And("Klik pada data status Rejected")
    public void klik_pada_data_status_Rejected() throws InterruptedException {
        repay.checkButtonRejected();
    }

    @And("Klik pada data status Pending Batch Run")
    public void klik_pada_data_status_Pending_Batch_Run() throws InterruptedException {
        repay.checkButtonPBR();
    }

    @And("Klik pada data status Approval Expired")
    public void klik_pada_data_status_Approval_Expired() throws InterruptedException {
        repay.checkButtonApprvExp();
    }

    @And("Consume repayment sysdate dengan tanggal pembayaran backdated \\(Akseleran, Indodana)")
    public void consume_repayment_sysdate_dengan_tanggal_pembayaran_backdated_Akseleran_Indodana() {
        repay.backdatedData();
    }

    @And("Consume repayment sysdate dengan tanggal pembayaran = sysdate")
    public void consume_repayment_sysdate_dengan_tanggal_pembayaran_sysdate() throws IOException {
        repay.sysdateData();
    }

    @And("Consume repayment sysdate dengan tanggal pembayaran future \\(advance)")
    public void consume_repayment_sysdate_dengan_tanggal_pembayaran_future_advance() throws IOException {
        repay.advanceData();
    }

    @And("Consume repayment sysdate dengan kondisi gagal validasi \\(rejected by system)")
    public void consume_repayment_sysdate_dengan_kondisi_gagal_validasi_rejected_by_system() throws IOException {
        repay.rejectBySystemData();
    }

    @And("Verifikasi data status Waiting for Approval dengan tanggal consume Hmin1")
    public void verifikasi_data_status_Waiting_for_Approval_dengan_tanggal_consume_Hmin1() {
        repay.waitforApprHmin1();
    }

    @And("Verifikasi data status Approved dengan tanggal consume Hmin1")
    public void verifikasi_data_status_Approved_dengan_tanggal_consume_Hmin1() {
        repay.approvDataHmin1();
    }

    @And("Verifikasi data status Rejected by Analyst dengan tanggal consume Hmin1")
    public void verifikasi_data_status_Rejected_by_Analyst_dengan_tanggal_consume_Hmin1() {
        repay.rejectByAnalystDataHmin1();
    }

    @And("Verifikasi data status Pending Batch Run dengan tanggal consume Hmin1")
    public void verifikasi_data_status_Pending_Batch_Run_dengan_tanggal_consume_Hmin1() {
        repay.PBRDataHmin1();
    }

    @And("Verifikasi data status Approval Expired dengan tanggal consume Hmin1")
    public void verifikasi_data_status_Approval_Expired_dengan_tanggal_consume_Hmin1() {
        repay.apprExpDataHmin1();
    }

    @And("Verifikasi data status Approval Expired dengan tanggal consume Hmin2")
    public void verifikasi_data_status_Approval_Expired_dengan_tanggal_consume_Hmin2() {
        repay.apprExpDataHmin2();
    }

    @And("Verifikasi isi filter Source")
    public void verifikasi_isi_filter_Source() {
        repay.verifyIsiFilter();
    }

    @And("View data dengan filter Source: All")
    public void view_data_dengan_filter_Source_All() throws InterruptedException {
        repay.filterBySourceAll();
    }

    @And("View data dengan filter Source: LOS")
    public void view_data_dengan_filter_Source_LOS() throws InterruptedException {
        repay.filterBySourceLos();
    }

    @And("View data dengan filter Source: NIKEL")
    public void view_data_dengan_filter_Source_NIKEL() throws InterruptedException {
        repay.filterBySourceNikel();
    }

    @And("Verifikasi isi filter Pelunasan")
    public void verifikasi_isi_filter_Pelunasan() {
        repay.verifyIsiFilterPelunasan();
    }

    @And("View data dengan filter Pelunasan: All")
    public void view_data_dengan_filter_Pelunasan_All() throws InterruptedException {
        repay.filterPelAll();
    }

    @And("View data dengan filter Pelunasan: Yes")
    public void view_data_dengan_filter_Pelunasan_Yes() throws InterruptedException {
        repay.filterPelYes();
    }

    @And("View data dengan filter Pelunasan: No")
    public void view_data_dengan_filter_Pelunasan_No() throws InterruptedException {
        repay.filterPelNo();
    }

    @And("View data dengan filter Pelunasan: Insurance")
    public void view_data_dengan_filter_Pelunasan_Insurance() throws InterruptedException {
        repay.filterPelInsurance();
    }

    @And("View data dengan filter Pelunasan: Advance")
    public void view_data_dengan_filter_Pelunasan_Advance() {
        repay.filterPelAdvance();
    }

    @And("Verifikasi isi filter Status")
    public void verifikasi_isi_filter_Status() throws InterruptedException {
        repay.verifyIsiFilterStatus();
    }

    @And("View data dengan filter Status: All")
    public void view_data_dengan_filter_Status_All() throws InterruptedException {
        repay.filterByStatusAll();
    }

    @And("View data dengan filter Status: Waiting for approval")
    public void view_data_dengan_filter_Status_Waiting_for_approval() throws InterruptedException {
        repay.filterByStatusWaitforApprov();
    }

    @And("View data dengan filter Status: Pending Batch Run")
    public void view_data_dengan_filter_Status_Pending_Batch_Run() throws InterruptedException {
        repay.filterByStatusPBR();
    }

    @And("View data dengan filter Status: Approved")
    public void view_data_dengan_filter_Status_Approved() throws InterruptedException {
        repay.filterByStatusApproved();
    }

    @And("View data dengan filter Status: Rejected")
    public void view_data_dengan_filter_Status_Rejected() throws InterruptedException {
        repay.filterByStatusRejected();
    }

    @And("View data dengan filter Status: Approval Expired")
    public void view_data_dengan_filter_Status_Approval_Expired() throws InterruptedException {
        repay.filterByStatusApprvExp();
    }

    @And("Verifikasi isi filter Partner")
    public void verifikasi_isi_filter_Partner() {
        repay.verifyIsiFilterPartner();
    }

    @And("View data dengan filter Partner: All")
    public void view_data_dengan_filter_Partner_All() throws InterruptedException {
        repay.filterByPartnerAll();
    }

    @And("View data dengan filter Partner: pilih salah satu")
    public void view_data_dengan_filter_Partner_pilih_salah_satu() throws InterruptedException {
        repay.filterByPartnerPilih1();
    }

    @And("Verifikasi isi filter Status Amount Repayment")
    public void verifikasi_isi_filter_Status_Amount_Repayment() {
        repay.verifyIsiStatAmountRepay();
    }

    @And("View data dengan filter Status Amount Repayment: All")
    public void view_data_dengan_filter_Status_Amount_Repayment_All() throws InterruptedException {
        repay.filterAmountRepayByAll();
    }

    @And("View data dengan filter Status Amount Repayment: Sesuai")
    public void view_data_dengan_filter_Status_Amount_Repayment_Sesuai() throws InterruptedException {
        repay.filterAmountRepayBySesuai();
    }

    @And("View data dengan filter Status Amount Repayment: Kurang Bayar")
    public void view_data_dengan_filter_Status_Amount_Repayment_Kurang_Bayar() throws InterruptedException {
        repay.filterAmountRepayByKurangBayar();
    }

    @And("View data dengan filter Status Amount Repayment: Lebih Bayar")
    public void view_data_dengan_filter_Status_Amount_Repayment_Lebih_Bayar() throws InterruptedException {
        repay.filterAmountRepayByLebihBayar();
    }

    @And("Verifikasi isi filter Status Batch No")
    public void verifikasi_isi_filter_Status_Batch_No() {
        repay.verifyIsiFilterBatchNo();
    }

    @And("View data dengan filter Batch No: pilih salah satu")
    public void view_data_dengan_filter_Batch_No_pilih_salah_satu() throws InterruptedException {
        repay.filterByBatchnoPilih1();
    }

    @And("Verifikasi filter search")
    public void verifikasi_filter_search() {
        repay.verifyfilterSearch();
    }

    @And("Verifikasi kolom Source untuk realisasi via LOS")
    public void verifikasi_kolom_Source_untuk_realisasi_via_LOS() {
        repay.verifySourceLOS();
    }

    @And("Verifikasi kolom Source untuk realisasi via NIKEL")
    public void verifikasi_kolom_Source_untuk_realisasi_via_NIKEL() {
        repay.verifySourceNIKEL();
    }

    @And("Verifikasi kolom Application No")
    public void verifikasi_kolom_Application_No() throws IOException {
        repay.verifyAppNo();
    }

    @And("Verifikasi kolom Partner")
    public void verifikasi_kolom_Partner() throws IOException {
        repay.verifyPartner();
    }

    @And("Verifikasi kolom Debtor Name")
    public void verifikasi_kolom_Debtor_Name() throws IOException {
        repay.verifyDebtorName();
    }

    @And("Verifikasi kolom Status Pembayaran dengan kondisi Pelunasan pada file Repayment = N")
    public void verifikasi_kolom_Status_Pembayaran_dengan_kondisi_Pelunasan_pada_file_Repayment_N() throws IOException {
        repay.verifyPelN();
    }

    @And("Verifikasi kolom Status Pembayaran dengan kondisi Pelunasan pada file Repayment = Y")
    public void verifikasi_kolom_Status_Pembayaran_dengan_kondisi_Pelunasan_pada_file_Repayment_Y() throws IOException {
        repay.verifyPelY();
    }

    @And("Verifikasi kolom Status Pembayaran dengan kondisi Pelunasan pada file Repayment = I")
    public void verifikasi_kolom_Status_Pembayaran_dengan_kondisi_Pelunasan_pada_file_Repayment_I() throws IOException {
        repay.verifyPelI();
    }

    @And("Verifikasi kolom Status Pembayaran dengan kondisi Pelunasan pada file Repayment = A")
    public void verifikasi_kolom_Status_Pembayaran_dengan_kondisi_Pelunasan_pada_file_Repayment_A() {
        repay.verifyPelA();
    }

    @And("Verifikasi sorting kolom Status")
    public void verifikasi_sorting_kolom_Status() {
        repay.sortStatus();
    }

    @And("Verifikasi sorting kolom Tanggal Pembayaran")
    public void verifikasi_sorting_kolom_Tanggal_Pembayaran() throws InterruptedException {
        repay.sortTglBayar();
    }

    @And("Klik Next pada Pagination")
    public void klik_Next_pada_Pagination() throws InterruptedException {
        repay.nextPage();
    }

    @And("Klik page tertentu pada Pagination")
    public void klik_page_tertentu_pada_Pagination() throws InterruptedException {
        repay.clickNumPage();
    }

    @And("Klik Previous pada Pagination")
    public void klik_Previous_pada_Pagination() {
        repay.previousPage();
    }

    @And("Sorting pada kolom Status Note: variasi status>=3")
    public void sorting_pada_kolom_Status_Note_variasi_status_3() throws InterruptedException {
        repay.sortStatus2();
    }

    @And("Sorting pada kolom Tanggal Pembayaran Note: terdapat data hari H dan Hmin1 \\(approval expired)")
    public void sorting_pada_kolom_Tanggal_Pembayaran_Note_terdapat_data_hari_H_dan_H_approval_expiredmin1() {
        repay.sortTglBayarHmin1();
    }

    @And("Verifikasi tanggal pada menu Repayment")
    public void verifikasi_tanggal_pada_menu_Repayment() {
        repay.verifyTglMenuRepayment();
    }

    @And("Verifikasi Total Nominal Approved")
    public void verifikasi_Total_Nominal_Approved() throws InterruptedException {
        repay.totNomApproved();
    }


    @And("Verifikasi Total Nominal Pembayaran")
    public void verifikasi_Total_Nominal_Pembayaran() throws InterruptedException {
        repay.totNomPembayaran();
    }

    @And("Klik Bulk Approve Check beberapa data")
    public void klik_Bulk_Approve_Check_beberapa_data() throws InterruptedException {
        repay.bulkApproveCheck2Data();
    }

    @And("Klik Bulk Approve Check beberapa data Uncheck beberapa data")
    public void klik_Bulk_Approve_Check_beberapa_data_Uncheck_beberapa_data() throws InterruptedException {
        repay.bulkApprovUncheck2Data();
    }

    @And("Klik Bulk Approve Check All")
    public void klik_Bulk_Approve_Check_All() throws InterruptedException {
        repay.bulkApprvCheckAll();
    }

    @And("Klik Bulk Approve Check All Klik Approve")
    public void klik_Bulk_Approve_Check_All_Klik_Approve() throws InterruptedException {
        repay.bulkApprCheckAllandApprov();
    }

    @And("Klik Bulk Approve Check All Klik Approve Klik Batal")
    public void klik_Bulk_Approve_Check_All_Klik_Approve_Klik_Batal() {
        repay.bulkApprCheckAllApprovandBatal();
    }

    @And("Verifikasi card Hasil Approval setelah Bulk Approve data")
    public void verifikasi_card_Hasil_Approval_setelah_Bulk_Approve_data() {
        repay.verifyAfterBulkAll();
    }

    @And("Klik Bulk Approve Check beberapa data Klik Reject")
    public void klik_Bulk_Approve_Check_beberapa_data_Klik_Reject() throws InterruptedException {
        repay.bulkBeberapaReject();
    }

    @And("Klik Bulk Approve Check beberapa data Klik Reject Klik Batal")
    public void klik_Bulk_Approve_Check_beberapa_data_Klik_Reject_Klik_Batal() {
        repay.bulkBeberapaRejectAndBatal();
    }

    @And("Klik Bulk Approve Check beberapa data Klik Reject Klik Submit")
    public void klik_Bulk_Approve_Check_beberapa_data_Klik_Reject_Klik_Submit() throws InterruptedException {
        repay.bulkBeberapaRejectAndSubmit();
    }

    @And("Klik Bulk Approve Check All Klik Reject")
    public void klik_Bulk_Approve_Check_All_Klik_Reject() {
        repay.bulkAllReject();
    }

    @And("Klik Bulk Approve Check All Klik Reject Klik Batal")
    public void klik_Bulk_Approve_Check_All_Klik_Reject_Klik_Batal() {
        repay.bulkAllRejectAndBatal();
    }

    @And("Klik Bulk Approve Tidak Check Data Klik Approve")
    public void klik_Bulk_Approve_Tidak_Check_Data_Klik_Approve() {
        repay.bulkApprvAndTidakCheckDataKlikApprv();
    }

    @And("Klik Bulk Approve Tidak Check Data Klik Reject")
    public void klik_Bulk_Approve_Tidak_Check_Data_Klik_Reject() throws InterruptedException {
        repay.bulkApprvTidakCheckDataKlikReject();
    }

    @And("Verifikasi card Hasil Approval setelah Bulk Reject data")
    public void verifikasi_card_Hasil_Approval_setelah_Bulk_Reject_data() {
        repay.verifyBulkRejected();
    }

    @And("Klik Bulk Edit Check pada beberapa data status Pending Batch Run")
    public void klik_Bulk_Edit_Check_pada_beberapa_data_status_Pending_Batch_Run() throws InterruptedException {
        repay.bulkEdit();
    }

    @And("Klik Bulk Edit Check All")
    public void klik_Bulk_Edit_Check_All() throws InterruptedException {
        repay.bulkEditCheckall();
    }

    @And("Klik Bulk Edit Check pada beberapa data status Pending Batch Run Klik Cancel")
    public void klik_Bulk_Edit_Check_pada_beberapa_data_status_Pending_Batch_Run_Klik_Cancel() throws InterruptedException {
        repay.bulkEditCheckbeberapaAndCancel();
    }

    @And("Klik Bulk Edit Check pada beberapa data status Pending Batch Run Klik Change Status")
    public void klik_Bulk_Edit_Check_pada_beberapa_data_status_Pending_Batch_Run_Klik_Change_Status() throws InterruptedException {
        repay.bulkEditCheckBeberapaAndChange();
    }

    @And("Klik Bulk Edit Check All Klik Cancel")
    public void klik_Bulk_Edit_Check_All_Klik_Cancel() {
        repay.bulkEditCheckAllAndCancel();
    }

    @And("Approve data yang telah di update statusnya")
    public void approve_data_yang_telah_di_update_statusnya() throws InterruptedException {
        repay.apprvAfterEdited();
    }

    @And("Reject data yang telah di update statusnya")
    public void reject_data_yang_telah_di_update_statusnya() throws InterruptedException {
        repay.rejectAfterEdited();
    }
}
