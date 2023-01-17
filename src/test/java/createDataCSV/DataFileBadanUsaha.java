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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataFileBadanUsaha {

    private String pthResultDataFile = Const.resultApprovalFile;
    ArrayList<String[]> arrayData = new ArrayList<>();
    String jW;

    static GenerateDataFileBadanUsaha generateRandomDataFile = new GenerateDataFileBadanUsaha();
    static String npwp = generateRandomDataFile.npwp();
    public static final String noNpwp = npwp;

    public void dataFile(String case1, String case2, String case3) throws IOException {

        String nama_debitur, name_company, code_company, kode_produk, tanggal, waktu, jumlahData;

        // call class read excel
        ReadTestData readTestData        = new ReadTestData();
        readTestData.testData();

        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("HHmmss");
        LocalDateTime localDate   = LocalDateTime.now();

        //date now
        String pattern                    = Const.glPattern;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String fdate                      = simpleDateFormat.format(new Date());
        String ftime                      = localDate.format(dateTime);
        String environment                = String.valueOf(readTestData.cellDataValue[0]);
        nama_debitur                      = String.valueOf(readTestData.cellDataValue[1]);
        name_company                      = String.valueOf(readTestData.cellDataValue[2]);
        code_company                      = String.valueOf(readTestData.cellDataValue[3]);
        kode_produk                       = String.valueOf(readTestData.cellDataValue[4]);
        tanggal                           = fdate;
        waktu                             = ftime;
        //jumlahData                        = String.valueOf(readTestData.cellDataValue[5]);

        // first create file object for file placed at location
        // specified by filepath
        File fileApp                     = new File(pthResultDataFile + case1 + Const.extCSV);
        File fileRea                     = new File(pthResultDataFile + case2 + Const.extCSV);
        File filePengurus                = new File(pthResultDataFile + case3 + Const.extCSV);

        try {
            // create FileWriter object with file as parameter
            FileWriter outputfileApp     = new FileWriter(fileApp);
            FileWriter outputfileRea     = new FileWriter(fileRea);

            // create CSVWriter with '|' as separator
            CSVWriter writerApp          = new CSVWriter(outputfileApp, '|', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
            CSVWriter writerRea          = new CSVWriter(outputfileRea, '|', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

            // create a List which contains String array
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
            int no = 100;
            for (int idxApp = 1; idxApp <= 1; idxApp++) {
                dataApp.add(new String[]{
                        code_company + generateRandomDataFile.nomorAplikasi(),
                        generateRandomDataFile.nik(),
                        generateRandomDataFile.npwp(),
                        generateRandomDataFile.jenisDebitur(),
                        "PT Badan Usaha Corporation Jakarta " + nama_debitur + no + " " + generateRandomDataFile.namaDebitur(),
                        "001",
                        "01100", //uat komunal : 01000 | e2e komunal : 01100
                        "000005000000000"}); //uat komunal : 000005000000000 | e2e komunal : 000000100000000
                no--;
                dataApp.add(new String[]{
                        code_company + generateRandomDataFile.nomorAplikasi(),
                        generateRandomDataFile.nik(),
                        generateRandomDataFile.npwp(),
                        generateRandomDataFile.jenisDebitur(),
                        "PT Badan Usaha Corporation Jakarta " + nama_debitur + no + " " + generateRandomDataFile.namaDebitur(),
                        "003",
                        "01250",
                        "000005123456700"});
                no--;

                dataApp.add(new String[]{
                        code_company + generateRandomDataFile.nomorAplikasi(),
                        generateRandomDataFile.nik(),
                        generateRandomDataFile.npwp(),
                        generateRandomDataFile.jenisDebitur(),
                        "PT Badan Usaha Corporation Jakarta " + nama_debitur + no + " " + generateRandomDataFile.namaDebitur(),
                        "006",
                        "01500", //uat komunal : 01500 | e2e komunal : 01700
                        "000200000000000"});
                no--;
//                dataApp.add(new String[]{
//                        code_company + generateRandomDataFile.nomorAplikasi(),
//                        generateRandomDataFile.nik(),
//                        noNpwp,
//                        generateRandomDataFile.jenisDebitur(),
//                        "PT Badan Usaha Corporation Jakarta " + nama_debitur + no + " " + generateRandomDataFile.namaDebitur(),
//                        "002",
//                        "01357",
//                        "000200000000000"});
                dataApp.add(new String[]{
                        code_company + generateRandomDataFile.nomorAplikasi(),
                        generateRandomDataFile.nik(),
                        noNpwp,
                        generateRandomDataFile.jenisDebitur(),
                        "PT Badan Usaha Corporation Jakarta " + nama_debitur + no + " " + generateRandomDataFile.namaDebitur(),
                        "004",
                        "01475",
                        "000150000000000"});
                no--;
                dataApp.add(new String[]{
                        code_company + generateRandomDataFile.nomorAplikasi(),
                        generateRandomDataFile.nik(),
                        noNpwp,
                        generateRandomDataFile.jenisDebitur(),
                        "PT Badan Usaha Corporation Jakarta " + nama_debitur + no + " " + generateRandomDataFile.namaDebitur(),
                        "002",
                        "01350",
                        "000050000000000"});
                no--;
            }

            // write data csv realisi
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
            no_numeric = 11; int number = 1 ; int ar =0; int sandiJabatan = 8;
            for (String[] pengurusData : dataRea) {
                if (pengurusData[0] != "Nomor_Aplikasi") {
                    try {
                        File file = new File(pthResultDataFile + "PENGURUS_" + code_company + "_" + kode_produk + "_" + number + pengurusData[0] + "_" + tanggal + Const.extCSV);
                        // create FileWriter object with file as parameter
                        FileWriter outputfile = new FileWriter(file);

                        // create CSVWriter object filewriter object as parameter
                        CSVWriter writer = new CSVWriter(outputfile, '|', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

                        // adding header to csv
                        writer.writeNext(dataPengurusHeader);

                        String[] pangsaPemilik  = {"03013","10000","10000","10000","10000"};
                        String[] jumlahPengurus = {"3", "1", "1", "1","1"};

                        // add data to csv
                        String[] dataPengurus = {pengurusData[0], "0" + generateRandomDataPengurus.nomorUrutPengurus(), "0" + jumlahPengurus[ar],
                                String.valueOf(sandiJabatan), pangsaPemilik[ar] ,
                                generateRandomDataPengurus.bentukPengurus(), generateRandomDataPengurus.modalDasar() + no_numeric + "000000", generateRandomDataPengurus.modalDisetor() + no_numeric + "000000",
                                generateRandomDataPengurus.modalDitempatkan() + no_numeric + "000000", generateRandomDataPengurus.npwpPengurus(),
                                "Surya Prans Andreas Farhano Baguso Pengurus Badan Usaha " + generateRandomDataPengurus.namaPengurus() + no_numeric, "Jln Pondok Indah T,r Patriot:V3/I.Z " + generateRandomDataPengurus.alamatPengurus() + no_numeric,
                                "BayangBayang Semu:K/1.agung#a_n " + generateRandomDataPengurus.alamatKelurahan() + no_numeric, "BayangBayang Semu:K/3.agung#a_n " + generateRandomDataPengurus.alamatKecamatan() + no_numeric,
                                "011" + generateRandomDataPengurus.alamatDatiII(), "5" + generateRandomDataPengurus.noKTP(),
                                "11111A22222B33333C4444D55" + generateRandomDataPengurus.noAkte() + no_numeric, "01051995", "06062001", "011" + generateRandomDataPengurus.DatiIITempatLahr(),
                                generateRandomDataPengurus.jenisKelamin()};
                        writer.writeNext(dataPengurus);

                        File folders = new File(Const.resultApprovalFile);
                        File[] listOfFilesz = folders.listFiles();
                        System.out.println(listOfFilesz[1].getName());
                        String getName = null;   String pthApprovalFile = null;
                            if (listOfFilesz[1].isFile()) {
                                if (listOfFilesz[1].getName().equals("PENGURUS_" + code_company + "_" + kode_produk + "_" + number + pengurusData[0] + "_" + tanggal + Const.extCSV)) {
                                    System.out.println(listOfFilesz[1].getName()+ " ==IF==" + "\n");
                                    getName = listOfFilesz[1].getName();
                                    // add data to csv
                                    String[] dataPengurus2 = {pengurusData[0], "02", "03",
                                            String.valueOf(sandiJabatan), "04525",
                                            generateRandomDataPengurus.bentukPengurus(), generateRandomDataPengurus.modalDasar() + no_numeric + "000000", generateRandomDataPengurus.modalDisetor() + no_numeric + "000000",
                                            generateRandomDataPengurus.modalDitempatkan() + no_numeric + "000000", generateRandomDataPengurus.npwpPengurus(),
                                            "Surya Prans Andreas Farhano Baguso Pengurus Badan Usaha " + generateRandomDataPengurus.namaPengurus() + no_numeric, "Jln Pondok Indah T,r Patriot:V3/I.Z " + generateRandomDataPengurus.alamatPengurus() + no_numeric,
                                            "BayangBayang Semu:K/1.agung#a_n " + generateRandomDataPengurus.alamatKelurahan() + no_numeric, "BayangBayang Semu:K/3.agung#a_n " + generateRandomDataPengurus.alamatKecamatan() + no_numeric,
                                            "011" + generateRandomDataPengurus.alamatDatiII(), "5" + generateRandomDataPengurus.noKTP(),
                                            "11111A22222B33333C4444D55" + generateRandomDataPengurus.noAkte() + no_numeric, "01051995", "06062001", "011" + generateRandomDataPengurus.DatiIITempatLahr(),
                                            generateRandomDataPengurus.jenisKelamin()};
                                    writer.writeNext(dataPengurus2);

                                    String[] dataPengurus3 = {pengurusData[0], "03", "03",
                                            String.valueOf(sandiJabatan), "02462",
                                            generateRandomDataPengurus.bentukPengurus(), generateRandomDataPengurus.modalDasar() + no_numeric + "000000", generateRandomDataPengurus.modalDisetor() + no_numeric + "000000",
                                            generateRandomDataPengurus.modalDitempatkan() + no_numeric + "000000", generateRandomDataPengurus.npwpPengurus(),
                                            "Surya Prans Andreas Farhano Baguso Pengurus Badan Usaha " + generateRandomDataPengurus.namaPengurus() + no_numeric, "Jln Pondok Indah T,r Patriot:V3/I.Z " + generateRandomDataPengurus.alamatPengurus() + no_numeric,
                                            "BayangBayang Semu:K/1.agung#a_n " + generateRandomDataPengurus.alamatKelurahan() + no_numeric, "BayangBayang Semu:K/3.agung#a_n " + generateRandomDataPengurus.alamatKecamatan() + no_numeric,
                                            "011" + generateRandomDataPengurus.alamatDatiII(), "5" + generateRandomDataPengurus.noKTP(),
                                            "11111A22222B33333C4444D55" + generateRandomDataPengurus.noAkte() + no_numeric, "01051995", "06062001", "011" + generateRandomDataPengurus.DatiIITempatLahr(),
                                            generateRandomDataPengurus.jenisKelamin()};
                                    writer.writeNext(dataPengurus3);
                                }
                            }
                            // closing writer connection
                            number = number + 1;
                            ar = ar + 1;
                            writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                no_numeric--;sandiJabatan++;
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
        // call class format file
        CSVFileName csvFileName = new CSVFileName();
        csvFileName.parseDataFile(case1, case2, code_company, kode_produk, tanggal);
        //csvFileName.zipDataDummy(name_company,arrayData);

    }

    public String npwp() {
        return noNpwp;
    }
}
