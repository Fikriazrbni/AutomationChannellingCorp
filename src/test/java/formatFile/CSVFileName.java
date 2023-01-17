package formatFile;

import elementsPage.Const;
import org.openqa.selenium.io.Zip;
import testData.ReadTestData;
import writeFile.MoveFileScenario;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;

public class CSVFileName {
    private String nomorAplikasi;
    private String kodeProduk;
    ReadTestData readTestData = new ReadTestData();
    MoveFileScenario moveFileScenario = new MoveFileScenario();

    public void parseData(String case1, String case2, String nomor_aplikasi, String kode_produk, String tanggal) {
        String pthResultDataDummyFile = Const.resultDataDummyFile;  //resultDataDummyFile    resultApprovalFile   resultApprovalFileDiffPartner
        this.nomorAplikasi = nomor_aplikasi;
        this.kodeProduk = kode_produk;

        try {
            File fileApp = new File(pthResultDataDummyFile + case1 + Const.extCSV);
            File fileRea = new File(pthResultDataDummyFile + case2 + Const.extCSV);

            fileApp.renameTo(new File(pthResultDataDummyFile + case1 + "_" + nomor_aplikasi + "_" + kode_produk + "_" + tanggal + Const.extCSV));
            fileRea.renameTo(new File(pthResultDataDummyFile + case2 + "_" + nomor_aplikasi + "_" + kode_produk + "_" + tanggal + Const.extCSV));

        } catch (Exception ex) {
            System.out.println("gagal");
        }
    }
    public void parseDataFile(String case1, String case2, String nomor_aplikasi, String kode_produk, String tanggal) {
        String pthApprovalFile = Const.resultApprovalFile;
        this.nomorAplikasi = nomor_aplikasi;
        this.kodeProduk = kode_produk;

        try {
            File fileApp = new File(pthApprovalFile + case1 + Const.extCSV);
            File fileRea = new File(pthApprovalFile + case2 + Const.extCSV);

            fileApp.renameTo(new File(pthApprovalFile + case1 + "_" + nomor_aplikasi + "_" + kode_produk + "_" + tanggal + Const.extCSV));
            fileRea.renameTo(new File(pthApprovalFile + case2 + "_" + nomor_aplikasi + "_" + kode_produk + "_" + tanggal + Const.extCSV));

        } catch (Exception ex) {
            System.out.println("gagal");
        }
    }
    public void parseDataFileDiffPartner(String case1, String case2, String nomor_aplikasi, String kode_produk, String tanggal) {
        String pthResultDataDummyFile = Const.resultApprovalFileDiffPartner;  //resultDataDummyFile    resultApprovalFile   resultApprovalFileDiffPartner
        this.nomorAplikasi = nomor_aplikasi;
        this.kodeProduk = kode_produk;

        try {
            File fileApp = new File(pthResultDataDummyFile + case1 + Const.extCSV);
            File fileRea = new File(pthResultDataDummyFile + case2 + Const.extCSV);

            fileApp.renameTo(new File(pthResultDataDummyFile + case1 + "_" + nomor_aplikasi + "_" + kode_produk + "_" + tanggal + Const.extCSV));
            fileRea.renameTo(new File(pthResultDataDummyFile + case2 + "_" + nomor_aplikasi + "_" + kode_produk + "_" + tanggal + Const.extCSV));

        } catch (Exception ex) {
            System.out.println("gagal");
        }
    }


//    public void zipDataDummy(String name_company, ArrayList<String[]> arrayData){
//        String pattern = Const.pPattern;
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        String date = simpleDateFormat.format(new Date());
//
//        try {
//            String zip = Zip.zip(new File(Const.resultDataDummyFile));
//
//            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(".//dummyZIP"+"//DATADUMMY_B_"+nomorAplikasi+name_company.toUpperCase().replace("NEW ","")+"_"+kodeProduk+"_"+date+".zip"));
//            byte[] decode = Base64.getDecoder().decode(zip);
//            stream.write(decode);
//            stream.close();
//
//        } catch (Exception e) {
//            e.getCause();
//        }
//    }
public void zipDataDummy(String companyName, ArrayList<String[]> arrayData) {

    readTestData.testData();
    String pattern = Const.glPattern;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    String date = simpleDateFormat.format(new Date());

    BufferedOutputStream stream = null;
    BufferedOutputStream stream2 = null;
    BufferedOutputStream streamSupDoc = null;
    try {
        String zip = Zip.zip(new File(Const.resultDataDummyFile));
        String zipSupDoc = Zip.zip(new File(".//dummy_SuppDoc//"));

        if (companyName.equals("New Akseleran") || companyName.equals("New Komunal")) {
            moveFileScenario.dltZipyExist();
            stream = new BufferedOutputStream(new FileOutputStream(".//dummy_suppDoc//" + "DATADUMMY_B_" + nomorAplikasi + companyName.toUpperCase().replace(" ","")+ "_" + kodeProduk + "_" + date + "_" + readTestData.timeStamp + ".zip"));

            byte[] decode = Base64.getDecoder().decode(zip);
            stream.write(decode);
            stream.close();

            //create support document
            for (String[] reaData : arrayData) {
                if (reaData[0] != "Nomor_Aplikasi") {
                    stream2 = new BufferedOutputStream(new FileOutputStream(".//dummy_suppDoc//" + reaData[0] + "_" + date + ".zip"));
                    byte[] decode2 = Base64.getDecoder().decode(zip);
                    stream2.write(decode2);
                    stream2.close();
                }
            }

            Path source = Paths.get(".//dummy_SuppDoc//");
            ZipFolder.zipFolder(source,".//dummy_suppDocZip//" + "DATADUMMY_SUPPDOC_B_" + nomorAplikasi + companyName.toUpperCase().replace(" ","") + "_" + kodeProduk + "_" + date + "_" + readTestData.timeStamp + ".zip".replace(" ",""));

        } else if (companyName.equals("KOPNUS")) {

            stream = new BufferedOutputStream(new FileOutputStream(Const.pthDummyZIP + "DATADUMMY_P_" + nomorAplikasi + companyName + "_" + kodeProduk + "_" + date + "_" + readTestData.timeStamp + ".zip"));
            byte[] decode = Base64.getDecoder().decode(zip);
            stream.write(decode);
            stream.close();

        } else {
            moveFileScenario.dltZipyExist();
            stream = new BufferedOutputStream(new FileOutputStream(".//dummy_suppDoc//" + "DATADUMMY_B_" + nomorAplikasi + "MORA_" + kodeProduk + "_" + date + "_" + readTestData.timeStamp + ".zip"));
            byte[] decode = Base64.getDecoder().decode(zip);
            stream.write(decode);
            stream.close();

            for (String[] reaData : arrayData) {
                if (reaData[0] != "Nomor_Aplikasi") {
                    stream2 = new BufferedOutputStream(new FileOutputStream(".//dummy_suppDoc//" + reaData[0] + "_" + date + ".zip"));
                    byte[] decode2 = Base64.getDecoder().decode(zip);
                    stream2.write(decode2);
                    stream2.close();
                }
            }

            Path source = Paths.get(".//dummy_SuppDoc//");
            ZipFolder.zipFolder(source,".//dummy_suppDocZip//" + "DATADUMMY_SUPPDOC_B_" + nomorAplikasi + companyName + "_" + kodeProduk + "_" + date + "_" + readTestData.timeStamp + ".zip");

        }

    } catch (
            Exception e) {
        e.getCause();
    }
}
}



