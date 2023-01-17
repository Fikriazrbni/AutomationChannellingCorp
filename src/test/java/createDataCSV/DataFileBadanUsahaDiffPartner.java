package createDataCSV;

import com.opencsv.CSVWriter;
import elementsPage.Const;
import formatFile.CSVFileName;
import randomValue.GenerateDataFileBadanUsaha;
import testData.ReadTestData;
import writeFile.WriteTestData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DataFileBadanUsahaDiffPartner {

    private String pthResultDataFile = Const.resultApprovalFileDiffPartner; //resultApprovalFile   resultApprovalFileDiffPartner

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

        try {
            FileWriter outputfileApp     = new FileWriter(fileApp);
            CSVWriter writerApp          = new CSVWriter(outputfileApp, '|', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
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

            //System.out.println("Jumlah Data          : " + jumlahData);
            System.out.println("Company Code         : " + code_company);
            System.out.println("Product Code         : " + kode_produk);
            System.out.println("Jangka Waktu         : " + generateRandomDataFile.jangkaWaktu(code_company));
            System.out.println("Keyword              : " + generateRandomDataFile.timeStamp);
            System.out.println("========================================================");

            writerApp.writeAll(dataApp);
            // closing writer connection
            writerApp.close();

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
