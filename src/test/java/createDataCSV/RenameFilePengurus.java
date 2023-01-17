package createDataCSV;

import elementsPage.Const;
import readFile.ReadCSVFormApproval;
import testData.ReadTestData;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RenameFilePengurus {

    private String pthResultDataFile = Const.resultApprovalFile;

    public void updateFileName() throws IOException {

        String code_company, kode_produk, tanggal;
        ReadTestData readTestData        = new ReadTestData();
        readTestData.testData();
        String pattern                    = Const.glPattern;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String fdate                      = simpleDateFormat.format(new Date());
        code_company                      = String.valueOf(readTestData.cellDataValue[3]);
        kode_produk                       = String.valueOf(readTestData.cellDataValue[4]);
        tanggal                           = fdate;

        // Update file pengurus 1
        String[] arr;
        ReadCSVFormApproval readCSVFormApproval = new ReadCSVFormApproval();
        arr = readCSVFormApproval.fileCSVAppPartner();
        System.out.println("TOTAL ARRAY = "+ Arrays.stream(arr).count()+"\n");

        File folder = new File(pthResultDataFile);
        File[] listOfFiles = folder.listFiles();
        File pengurus_1 = new File(pthResultDataFile+("PENGURUS_" + code_company + "_" + kode_produk + "_"  + arr[8]  + "_" + tanggal + Const.extCSV));
        File pengurus_2 = new File(pthResultDataFile+("PENGURUS_" + code_company + "_" + kode_produk + "_"  + arr[16] + "_" + tanggal + Const.extCSV));
        File pengurus_3 = new File(pthResultDataFile+("PENGURUS_" + code_company + "_" + kode_produk + "_"  + arr[24] + "_" + tanggal + Const.extCSV));
        File pengurus_4 = new File(pthResultDataFile+("PENGURUS_" + code_company + "_" + kode_produk + "_"  + arr[32] + "_" + tanggal + Const.extCSV));
        File pengurus_5 = new File(pthResultDataFile+("PENGURUS_" + code_company + "_" + kode_produk + "_"  + arr[40] + "_" + tanggal + Const.extCSV));

        for (int i=0 ; i< listOfFiles.length; i++){
            System.out.println(listOfFiles[i]);
        }

        if (listOfFiles[1].getName().contains("PENGURUS")) {
            listOfFiles[1].renameTo(pengurus_1);
            listOfFiles[2].renameTo(pengurus_2);
            listOfFiles[3].renameTo(pengurus_3);
            listOfFiles[4].renameTo(pengurus_4);
            listOfFiles[5].renameTo(pengurus_5);
        }
    }
}
