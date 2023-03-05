package createDataCSV;

import com.opencsv.CSVWriter;
import elementsPage.Const;
import formatFile.CSVFileName;
import randomValue.GeneratePengurus;
import randomValue.GenerateRandomDataApp;
//import randomValue.GenerateRandomDataPengurus;
import randomValue.GenerateRandomDataRea;
import testData.ReadTestData;
import writeFile.MoveFileScenario;
import writeFile.WriteTestData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataCSV {
    private String pthResultDataDummyFile = Const.resultDataDummyFile;
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
        name_company                      = String.valueOf(readTestData.cellDataValue[2]);
        code_company                      = String.valueOf(readTestData.cellDataValue[3]);
        kode_produk                       = String.valueOf(readTestData.cellDataValue[4]);
        tanggal                           = fdate;
        jumlahData                        = String.valueOf(readTestData.cellDataValue[5]);
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
            for (int idxApp = 1; idxApp <= Integer.parseInt(jumlahData); idxApp++) {
                    dataApp.add(new String[]{
                            code_company + generateRandomDataApp.nomorAplikasi(4),
                            generateRandomDataApp.nik(),
                            generateRandomDataApp.npwp(),
                            generateRandomDataApp.jenisDebitur(),
                            "PT " + nama_debitur + " " + generateRandomDataApp.namaDebitur(),
                            generateRandomDataApp.jangkaWaktu(code_company),
                            generateRandomDataApp.interestRate(code_company),
                            generateRandomDataApp.plafonKredit(code_company)});
//                        generateRandomDataApp.interestRate(code_company),"000070000000000"});
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
//                            "2", generateRandomDataRea.cd_sektorEkonomi(environment), "00000010000000000", "1", "S125012529L", "000002300000000", "18", "Jakarta Selatan"});
                            "2", generateRandomDataRea.cd_sektorEkonomi(environment), "00000010000000000", "1", "S125012529L", "000002300000000", "18", "Jakarta Selatan"});

                    System.out.println("Nama Debitur                : " + reaData[4]);
                    System.out.println("Plafon Kredit               : " + reaData[7]);
                    System.out
                            .println("========================================================");
                }
                jW = reaData[5];
                ix++;ixi++;
            }

            // call class generate random pengurus
            GeneratePengurus gp = new GeneratePengurus();
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
                        int i = 1;
                        while (i <= 4) {
                            switch (i) {

                                // pengurus row 1
                                case 1:
                                    String[] dataPengurus = {pengurusData[0], gp.nomorUrutPengurus("01"), "0" + gp.jumlahPengurus(),
                                            gp.sandiJabatanBI(2), "0" + gp.pangsaKepemilikan("1913"), gp.bentukPengurus("1"), gp.modalDasar(12), gp.modalDisetor(12),
                                            gp.modalDitempatkan(12), gp.npwp(), gp.namaPengurus(59), "Jalan" + gp.alamatPengurus(34), "Kelurahan" + gp.alamatKelurahan(30),
                                            "Kecamatan" + gp.alamatKecamatan(30), gp.alamatDati(), gp.noKtp(), gp.noAkte(29), gp.tglLahir(), gp.tglAkte(),
                                            gp.alamatDatiLhr(), gp.jnsKelamin("B")};
                                    writer.writeNext(dataPengurus);
                                    break;


                                // pengurus row 2
                                case 2:
                                    dataPengurus = new String[]{pengurusData[0], gp.nomorUrutPengurus("02"), "0" + gp.jumlahPengurus(),
                                            gp.sandiJabatanBI(1), "0" + gp.pangsaKepemilikan("5049"), gp.bentukPengurus("1"), gp.modalDasar(13), gp.modalDisetor(13),
                                            gp.modalDitempatkan(13), gp.npwp(), gp.namaPengurus(60), "Jalan" + gp.alamatPengurus(35), "Kelurahan" + gp.alamatKelurahan(31),
                                            "Kecamatan" + gp.alamatKecamatan(31), gp.alamatDati(), gp.noKtp(), gp.noAkte(30), gp.tglLahir(), gp.tglAkte(),
                                            gp.alamatDatiLhr(), gp.jnsKelamin("M")};
                                    writer.writeNext(dataPengurus);
                                    break;


                                // pengurus row 3
                                case 3:
                                    dataPengurus = new String[]{pengurusData[0], gp.nomorUrutPengurus("03"), "0" + gp.jumlahPengurus(),
                                            gp.sandiJabatanBI(1), "0" + gp.pangsaKepemilikan("1389"), gp.bentukPengurus("2"), gp.modalDasar(13), gp.modalDisetor(13),
                                            gp.modalDitempatkan(13), gp.npwp(), gp.namaPengurus(60), "Jalan" + gp.alamatPengurus(35), "Kelurahan" + gp.alamatKelurahan(31),
                                            "Kecamatan" + gp.alamatKecamatan(31), gp.alamatDati(), gp.noKtp(), gp.noAkte(30), gp.tglLahir(), gp.tglAkte(),
                                            gp.alamatDatiLhr(), gp.jnsKelamin("L")};
                                    writer.writeNext(dataPengurus);
                                    break;


                                // pengurus row 4
                                case 4:
                                    dataPengurus = new String[]{pengurusData[0], gp.nomorUrutPengurus("04"), "0" + gp.jumlahPengurus(),
                                            gp.sandiJabatanBI(1), "0" + gp.pangsaKepemilikan("1649"), gp.bentukPengurus("2"), gp.modalDasar(13), gp.modalDisetor(13),
                                            gp.modalDitempatkan(13), gp.npwp(), gp.namaPengurus(60), "Jalan" + gp.alamatPengurus(35), "Kelurahan" + gp.alamatKelurahan(31),
                                            "Kecamatan" + gp.alamatKecamatan(31), gp.alamatDati(), gp.noKtp(), gp.noAkte(30), gp.tglLahir(), gp.tglAkte(),
                                            gp.alamatDatiLhr(), gp.jnsKelamin("P")};
                                    writer.writeNext(dataPengurus);
                                    break;

                                default:
                                    System.out.println("Data Error");
                                    break;
                            }
                            i++;
                        }
                        // closing writer connection
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Jumlah Data          : " + jumlahData);
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

            WriteTestData writeTestData = new WriteTestData();
            writeTestData.writeData(generateRandomDataApp.timeStamp);
            // call class format file
            CSVFileName csvFileName = new CSVFileName();
            csvFileName.parseData(case1, case2, code_company, kode_produk, tanggal);
            csvFileName.zipData(code_company,arrayData);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // for 30 character
        try {
            code_company = "L000005";
            kode_produk = "24BL001";
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
                            code_company + generateRandomDataApp.nomorAplikasi(17),
                            generateRandomDataApp.nik(),
                            generateRandomDataApp.npwp(),
                            generateRandomDataApp.jenisDebitur(),
                            "PT " + nama_debitur + " " + generateRandomDataApp.namaDebitur(),
                            generateRandomDataApp.jangkaWaktu(code_company),
                            generateRandomDataApp.interestRate(code_company),
                            generateRandomDataApp.plafonKredit(code_company)});
//                        generateRandomDataApp.interestRate(code_company),"000070000000000"});
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
//                            "2", generateRandomDataRea.cd_sektorEkonomi(environment), "00000010000000000", "1", "S125012529L", "000002300000000", "18", "Jakarta Selatan"});
                            "2", generateRandomDataRea.cd_sektorEkonomi(environment), "00000010000000000", "1", "S125012529L", "000002300000000", "18", "Jakarta Selatan"});

                    System.out.println("Nama Debitur                : " + reaData[4]);
                    System.out.println("Plafon Kredit               : " + reaData[7]);
                    System.out
                            .println("========================================================");
                }
                jW = reaData[5];
                ix++;ixi++;
            }

            // call class generate random pengurus
            GeneratePengurus gp = new GeneratePengurus();
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
                        String[] dataPengurus = {pengurusData[0], gp.nomorUrutPengurus("01"), "01",
                                gp.sandiJabatanBI(2), gp.pangsaKepemilikan("10000"), gp.bentukPengurus("1"), gp.modalDasar(12), gp.modalDisetor(12),
                                gp.modalDitempatkan(12), gp.npwp(), gp.namaPengurus(59), "Jalan" + gp.alamatPengurus(34), "Kelurahan" + gp.alamatKelurahan(30),
                                "Kecamatan" + gp.alamatKecamatan(30), gp.alamatDati(), gp.noKtp(), gp.noAkte(29), gp.tglLahir(), gp.tglAkte(),
                                gp.alamatDatiLhr(), gp.jnsKelamin("B")};
                        writer.writeNext(dataPengurus);

                        // closing writer connection
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Jumlah Data          : 1"       );
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

            WriteTestData writeTestData = new WriteTestData();
            writeTestData.writeData(generateRandomDataApp.timeStamp);
            // call class format file
            CSVFileName csvFileName = new CSVFileName();
            csvFileName.parseData(case1, case2, "L000005", kode_produk, tanggal);
            csvFileName.zipData("L000005",arrayData);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        MoveFileScenario clean = new MoveFileScenario();
        clean.dltDummyExist();
        DataCSV csv = new DataCSV();
        csv.dataDummy(Const.appFile, Const.reaFile, "8");
    }
}


