package createDataCSV;

import com.opencsv.CSVWriter;
import elementsPage.Const;
import formatFile.CSVFileName;
import randomValue.GenerateRandomDataApp;
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

public class DataCSVPending {

    private String pthResultDataDummyFile = Const.resultDataDummyFilePending;
    ArrayList<String[]> arrayData = new ArrayList<>();
    String jW;

    public void dataDummy(String case1, String case2, String input_jumlah_data) throws IOException {

        String nama_debitur, name_company, code_company, kode_produk, tanggal, jumlahData;

        // call class generate random data
        GenerateRandomDataApp generateRandomDataApp = new GenerateRandomDataApp();

        // call class read excel
        ReadTestData readTestData        = new ReadTestData();
        readTestData.testData();

        //date now
        String pattern                    = Const.glPattern;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String fdate                      = simpleDateFormat.format(new Date());

        String environment                = String.valueOf(readTestData.cellDataValue[0]);
        nama_debitur                      = String.valueOf(readTestData.cellDataValue[1]);
        name_company                      = "PT Tes Pending"; //String.valueOf(readTestData.cellDataValue[2]);
        code_company                      = "L000060"; //String.valueOf(readTestData.cellDataValue[3]);
        kode_produk                       = "24BL001"; //String.valueOf(readTestData.cellDataValue[4]);
        tanggal                           = fdate;
//        jumlahData                        = "2"; //String.valueOf(readTestData.cellDataValue[5]);
//        jumlahData                        = input_jumlah_data;

        // first create file object for file placed at location
        // specified by filepath
        File fileApp                     = new File(pthResultDataDummyFile + case1 + Const.extCSV);
        File fileRea                     = new File(pthResultDataDummyFile + case2 + Const.extCSV);

        try {
            // create FileWriter object with file as parameter
            FileWriter outputfileApp     = new FileWriter(fileApp);
            FileWriter outputfileRea     = new FileWriter(fileRea);

            // create CSVWriter with '|' as separator
            CSVWriter writerApp          = new CSVWriter(outputfileApp, '|', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
            CSVWriter writerRea          = new CSVWriter(outputfileRea, '|', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

            // create a List which contains String array
            ArrayList<String[]> dataApp  = new ArrayList<>();
            dataApp.add(new String[]{
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
            for (int idxApp = 1; idxApp <= 1; idxApp++) {
                dataApp.add(new String[]{
                        code_company + generateRandomDataApp.nomorAplikasi(),
                        generateRandomDataApp.nik(),
                        generateRandomDataApp.npwp(),
                        generateRandomDataApp.jenisDebitur(),
                        "Badan Usaha Corporation Jakarta " + nama_debitur + " " + generateRandomDataApp.namaDebitur(),
                        "003",
                        "01378",
                        "000000800000000"});
                dataApp.add(new String[]{
                        code_company + generateRandomDataApp.nomorAplikasi(),
                        generateRandomDataApp.nik(),
                        generateRandomDataApp.npwp(),
                        generateRandomDataApp.jenisDebitur(),
                        "Badan Usaha Corporation Jakarta " + nama_debitur + " " + generateRandomDataApp.namaDebitur(),
                        "001",
                        "01699",
                        "000000400000000"});
            }

            // write data csv realisi
            arrayData = dataApp;
            GenerateRandomDataRea generateRandomDataRea = new GenerateRandomDataRea();
            int ix  = 2; int ixi = 5;

            for (String[] reaData : arrayData) {
                int zz = 2; int iz = ix%zz;
                if (iz!=0){iz=ix;} else{iz=ixi;}
                String fs     = String.format("%012d", ix);
                String fz     = String.format("%012d", iz);
                String kPos   = String.format("%04d", ix);
                String noTlpn = String.format("%03d", ix);

                //System.out.println(reaData[ix]);
                if (reaData[0] != "Nomor_Aplikasi" && reaData[1] != "NIK" && reaData[2] != "NPWP" && reaData[3] != "Jenis_Debitur" && reaData[4] != "Nama_Debitur" && reaData[5] != "Jangka_Waktu" && reaData[6] != "Interest_Rate" && reaData[7] != "Plafon_Kredit") {
                    dataRea.add(new String[]{reaData[0], reaData[4], reaData[3], "Jalan Bahyang " + ix, "Kelurahan Bahyang " + ix,
                            "Kecamatan Bahyang " + ix, "1" + kPos, "0112", "081900009" + noTlpn,
                            "17-AKTA PERUSAHAAN" + fs,
                            generateRandomDataRea.TglBerdiriAwal(),
                            "17-AKTA PERUSAHAAN" + fz,
                            generateRandomDataRea.TglBerdiriAkir(),
                            "550000", reaData[2], reaData[5], "P01", reaData[7], reaData[6],
                            "00000000000000090051", generateRandomDataRea.tanggalAkad(), generateRandomDataRea.angsuranPertama(code_company, reaData[5]),
                            "2", generateRandomDataRea.cd_sektorEkonomi(environment), "00000010000000000", "1", "S125012529L", "000002300000000", "18", "Jakarta Selatan"});

                    System.out.println("Nama Debitur                : " + reaData[4]);
                    System.out.println("Plafon Kredit               : " + reaData[7]);
                    System.out.println("========================================================");
                }
                jW = reaData[5];
                ix++;ixi++;
            }

            // call class generate random pengurus
            GenerateRandomDataPengurus generateRandomDataPengurus = new GenerateRandomDataPengurus();
            //write data csv pengurus
            for (String[] pengurusData : dataRea) {
                if (pengurusData[0] != "Nomor_Aplikasi") {
                    try {
                        File file = new File(pthResultDataDummyFile + "PENGURUS_" + code_company + "_" + kode_produk + "_" + pengurusData[0] + "_" + tanggal + Const.extCSV);
                        // create FileWriter object with file as parameter
                        FileWriter outputfile = new FileWriter(file);

                        // create CSVWriter object filewriter object as parameter
                        CSVWriter writer = new CSVWriter(outputfile, '|', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

                        // adding header to csv
                        writer.writeNext(dataPengurusHeader);

                        // add data to csv
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
//            System.out.println("Jumlah Data          : " + jumlahData);
            System.out.println("Company Code         : " + code_company);
            System.out.println("Product Code         : " + kode_produk);
            System.out.println("Jangka Waktu         : " + generateRandomDataApp.jangkaWaktu(code_company));
            System.out.println("Angsuran Pertama     : " + generateRandomDataRea.angsuranPertama(code_company, generateRandomDataApp.jangkaWaktu(code_company)));
            System.out.println("Keyword              : " + generateRandomDataApp.timeStamp);
            System.out
                    .println("========================================================");

            writerApp.writeAll(dataApp);
            writerRea.writeAll(dataRea);
            // closing writer connection
            writerApp.close();
            writerRea.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        WriteTestData writeTestData = new WriteTestData();
        writeTestData.writeData(generateRandomDataApp.timeStamp);
        // call class format file
        CSVFileName csvFileName = new CSVFileName();
        csvFileName.parseDataPending(case1, case2, code_company, kode_produk, tanggal);
        csvFileName.zipData(name_company,arrayData);
    }
}
