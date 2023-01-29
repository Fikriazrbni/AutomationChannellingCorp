package createDataCSV;

import com.opencsv.CSVWriter;
import elementsPage.Const;
import formatFile.CSVFileName;
import org.apache.commons.lang3.RandomStringUtils;
import randomValue.GenerateDataFileBadanUsaha;
import randomValue.GenerateRandomDataPengurus;
import randomValue.GenerateRandomDataRea;
import testData.ReadTestData;
import writeFile.WriteTestData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataFileBadanUsahaDiffPartner {

    private String pthResultDataFile = Const.resultApprovalFileDiffPartner; //resultApprovalFile   resultApprovalFileDiffPartner
    ArrayList<String[]> arrayData = new ArrayList<>();
    String jW;

    public void dataFile(String case1, String case2) throws IOException {

        String nama_debitur, name_company, code_company, kode_produk, tanggal, jumlahData;

        GenerateDataFileBadanUsaha generateRandomDataFile = new GenerateDataFileBadanUsaha();
        DataFileBadanUsaha dataFileBadanUsaha = new DataFileBadanUsaha();
        ReadTestData readTestData         = new ReadTestData();
        readTestData.testData();

        //date now
        String pattern                    = Const.glPattern;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String fdate                      = simpleDateFormat.format(new Date());
        String environment                = String.valueOf(readTestData.cellDataValue[0]);
        nama_debitur                      = String.valueOf(readTestData.cellDataValue[1]);
        name_company                      = String.valueOf(readTestData.cellDataValue[2]);
        if (readTestData.environment.equals("E2E") && readTestData.companyName.equals("AKSELERAN")) {
            code_company = "L000002";
            kode_produk  = "24BL002";
        } else if (readTestData.environment.equals("E2E") && readTestData.companyName.equals("NEW KOMUNAL")) {
            code_company = "L000001";
            kode_produk  = "24BL001";
        } else if (readTestData.environment.equals("UAT") && readTestData.companyName.equals("AKSELERAN")) {
            code_company = "L000053";
            kode_produk  = "24BL010";
        }else {
            code_company = "L000030";
            kode_produk  = "24BL008";
        }
        tanggal                           = fdate;
        File fileApp                     = new File(pthResultDataFile + case1 + Const.extCSV);
        File fileRea                     = new File(pthResultDataFile + case2 + Const.extCSV);

        try {
            FileWriter outputfileApp     = new FileWriter(fileApp);
            FileWriter outputfileRea     = new FileWriter(fileRea);
            CSVWriter writerApp          = new CSVWriter(outputfileApp, '|', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
            CSVWriter writerRea          = new CSVWriter(outputfileRea, '|', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
            ArrayList<String[]> dataApp  = new ArrayList<>();
            dataApp.add(new String[]{"" +
                    "Nomor_Aplikasi",
                    "NIK",
                    "NPWP",
                    "Jenis_Debitur",
                    "Nama_Debitur",
                    "Jangka_Waktu",
                    "Interest_Rate",
                    "Plafon_Kredit"});

            List<String[]> dataRea = new ArrayList<>();
            dataRea.add(new String[]{
                    "Nomor_Aplikasi",
                    "Nama_Debitur",
                    "Jenis_Debitur",
                    "Alamat",
                    "Alamat_Kelurahan",
                    "Alamat_Kecamatan",
                    "Alamat_Kode_Pos",
                    "Alamat_KODE_DATI_II",
                    "No_Telepon",
                    "No_Akte",
                    "Tanggal_Berdiri",
                    "No_Akte_Terakhir",
                    "Tanggal_Akte_Terakhir",
                    "Bidang_Usaha",
                    "Nomor_NPWP",
                    "Jangka_Waktu",
                    "Jenis_Kredit",
                    "Plafon",
                    "Interest_Rate",
                    "Nomor_PK",
                    "Tanggal_Akad",
                    "Tanggal_Angsuran_1",
                    "Jenis_Penggunaan",
                    "Sektor_Ekonomi",
                    "Omzet",
                    "Go_Public",
                    "Sandi_Golongan_Debitur",
                    "Penghasilan_Kotor_Per_Tahun",
                    "Bentuk_Badan_Usaha",
                    "Tempat_berdiri_badan_usaha"});

            //List<String[]> dataPengurus = new ArrayList<>();
            String[] dataPengurusHeader = {
                    "Nomor_Aplikasi",
                    "Nomor_Urut_Pengurus",
                    "Jumlah_Pengrus",
                    "Sandi_Jabatan_BI",
                    "Pangsa_Kepemilikan",
                    "Bentuk_Pengurus",
                    "Modal_Dasar",
                    "Modal_Disetor",
                    "Modal_Ditempatkan",
                    "NPWP_Pengurus",
                    "Nama_Pengurus",
                    "Alamat_Pengurus",
                    "Alamat_Kelurahan",
                    "Alamat_Kecamatan",
                    "Alamat_Dati_11",
                    "No_KTP",
                    "No_Akte",
                    "Tanggal_Lahir",
                    "Tanggal_Akte",
                    "Dati_11_Tempat_Lahir",
                    "Jenis_Kelamin"};

            // write data csv approval
            int no = 98;
            for (int idxApp = 1; idxApp <= 1; idxApp++) {
                dataApp.add(new String[]{
                        code_company + generateRandomDataFile.nomorAplikasi(),
                        generateRandomDataFile.nik(),
                        dataFileBadanUsaha.npwp(),
                        generateRandomDataFile.jenisDebitur(),
                        "PT Badan Usaha Corporation Jakarta " + nama_debitur + no + " " + generateRandomDataFile.namaDebitur(),
                        "005",
                        "01413",
                        "000200000000000"});
            }

            // write data csv realisasi
            arrayData = dataApp;
            GenerateRandomDataRea generateRandomDataRea = new GenerateRandomDataRea();
            int ix  = 2; int ixi = 5; int no_numeric = 11; int no_number = 1;
            for (String[] reaData : arrayData) {
                int zz = 2; int iz = ix%zz;
                if (iz!=0){iz=ix;} else{iz=ixi;}
                String fs     = String.format("%012d", ix);
                String fz     = String.format("%012d", iz);
                String kPos   = String.format("%04d", ix);
                String RanString = RandomStringUtils.randomNumeric(97);

                if (reaData[0] != "Nomor_Aplikasi" && reaData[1] != "NIK" && reaData[2] != "NPWP" && reaData[3] != "Jenis_Debitur" && reaData[4] != "Nama_Debitur" && reaData[5] != "Jangka_Waktu" && reaData[6] != "Interest_Rate" && reaData[7] != "Plafon_Kredit") {
                    dataRea.add(new String[]{
                            reaData[0], reaData[4], reaData[3], "Jalan pondok indah Sedikit Barat Patriot:V3/I.Z " + no_numeric, "Kelurahan Bayang Semu : K/3.agung#a_n " + no_numeric,
                            "Kecamatan Bayang Semu : K/3.agung#a_n " + no_numeric, "1" + kPos, "351" + generateRandomDataRea.RandomValue(), "08190000911" + no_numeric,
                            no_numeric+"-AKTA PERUSAHAAN" + fs, generateRandomDataRea.TglBerdiriAwal(),
                            no_numeric+"-AKTA PERUSAHAAN" + fz, generateRandomDataRea.TglBerdiriAkir(),
                            no_number + "00000", reaData[2], reaData[5], "P0" + no_number, reaData[7], reaData[6],
                            RanString + "V" + no_numeric,
                            generateRandomDataRea.tanggalAkad(), generateRandomDataRea.angsuranPertama(code_company, reaData[5]),
                            generateRandomDataRea.JenisPenggunaan(), generateRandomDataRea.cd_sektorEkonomi(environment), "00000010000000000", "1", "S150030" + generateRandomDataRea.RandomValue() + "L", "000002300000000", generateRandomDataRea.RandomValue(), "Jkt Selatan Barat Timur Pusa" + no_numeric});

                    System.out.println("Nama Debitur                : " + reaData[4]);
                    System.out.println("Plafon Kredit               : " + reaData[7]);
                    System.out.println("========================================================");
                }
                jW = reaData[5];
                ix++;ixi++;no_numeric--;no_number++;
            }

            // call class generate random pengurus
            GenerateRandomDataPengurus generateRandomDataPengurus = new GenerateRandomDataPengurus();
            //write data csv pengurus
            for (String[] pengurusData : dataRea) {
                if (pengurusData[0] != "Nomor_Aplikasi") {
                    try {
                        File file = new File(pthResultDataFile + "PENGURUS_" + code_company + "_" + kode_produk + "_" + pengurusData[0] + "_" + tanggal + Const.extCSV);
                        FileWriter outputfile = new FileWriter(file);
                        CSVWriter writer = new CSVWriter(outputfile, '|', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
                        writer.writeNext(dataPengurusHeader);
                        String[] dataPengurus = {pengurusData[0], "0" + generateRandomDataPengurus.nomorUrutPengurus(), "0" + generateRandomDataPengurus.jumlahPengurus(),
                                generateRandomDataPengurus.sandiJabatanBI(), generateRandomDataPengurus.pangsaKepemilikan() + "0000",
                                generateRandomDataPengurus.bentukPengurus(), generateRandomDataPengurus.modalDasar(), generateRandomDataPengurus.modalDisetor(),
                                generateRandomDataPengurus.modalDitempatkan(), generateRandomDataPengurus.npwpPengurus(),
                                "Winter " + generateRandomDataPengurus.namaPengurus(), "Jalan Sumenep " + generateRandomDataPengurus.alamatPengurus(),
                                "Jalan Bahyangs " + generateRandomDataPengurus.alamatKelurahan(), "Jalan Bougenvile " + generateRandomDataPengurus.alamatKecamatan(),
                                "011" + generateRandomDataPengurus.alamatDatiII(), "5" + generateRandomDataPengurus.noKTP(),
                                "000000000000000000000000000" + generateRandomDataPengurus.noAkte(), "06062001", "06062001", "011" + generateRandomDataPengurus.DatiIITempatLahr(),
                                generateRandomDataPengurus.jenisKelamin()};
                        writer.writeNext(dataPengurus);
                        // closing writer connection
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            //System.out.println("Jumlah Data          : " + jumlahData);
            System.out.println("Company Code         : " + code_company);
            System.out.println("Product Code         : " + kode_produk);
            System.out.println("Jangka Waktu         : " + generateRandomDataFile.jangkaWaktu(code_company));
            System.out.println("Keyword              : " + generateRandomDataFile.timeStamp);
            System.out.println("========================================================");

            writerApp.writeAll(dataApp);
            writerRea.writeAll(dataRea);
            // closing writer connection
            writerApp.close();
            writerRea.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        WriteTestData writeTestData = new WriteTestData();
        writeTestData.writeData(generateRandomDataFile.timeStamp);
        CSVFileName csvFileName = new CSVFileName();
        csvFileName.parseDataFileDiffPartner(case1, case2, code_company, kode_produk, tanggal);
        //csvFileName.zipDataDummy(name_company,arrayData);
    }
}
