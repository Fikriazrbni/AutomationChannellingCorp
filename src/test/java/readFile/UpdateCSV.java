package readFile;

import badanUsaha.LibUtils;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import elementsPage.Const;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class UpdateCSV {

    public static String timeStamp;

    public static void updateFieldCSV(String strData, String newData) throws IOException, CsvException {

        String pattern = "HHmmss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String fdate = simpleDateFormat.format(new Date());
        timeStamp = fdate;

        File folder = new File(Const.resultDataDummyFile); ////resultDataDummyFile resultApprovalFile
        File[] listOfFiles = folder.listFiles();
        String getFileCSV = null;

        for (int i = 0; i < Objects.requireNonNull(listOfFiles).length; i++) {
            if (listOfFiles[i].isFile()) {
                if (listOfFiles[i].getName().contains(Const.csvRea)) {
                    getFileCSV = listOfFiles[i].getName();
                }
            }
        }
        CSVReader reader = new CSVReader(new FileReader(new File(Const.resultDataDummyFile + getFileCSV))); //resultDataDummyFile resultApprovalFile
        List<String[]> csvBody = reader.readAll();
        ArrayList<String[]> dataApp = new ArrayList<>();

        for (int i = 0; i < csvBody.size(); i++) {
            String[] strArray = csvBody.get(i);
            for (int j = 0; j < strArray.length; j++) {
                if (strArray[j].contains(strData)) { //String to be replaced
                    String[] p = new String[0];
                    for (String[] s : csvBody) {
                        for (int index = 0; index < s.length; index++) {
                            p = s[index].split("\\|");

//                            if (p[27].equals(strData)) { // 3 14 17 27
//                                p[27] = newData; //+ timeStamp
//                            }
//                            if (p[14].equals(strData)) {
//                                p[14] = newData ;
//                            }
//                            if (p[2].equals(strData)) {
//                                p[2] = newData ;
//                                System.out.println(p[3]);
//                            }
                            if (p[2].equals(strData)) {
                                p[2] = newData ;
                                System.out.println(p[2]);
                            }

                            dataApp.add(p);
                        }
                    }
                }
            }
        }
        reader.close();

        File fileApp = new File(Const.resultDataDummyFile + getFileCSV); //resultDataDummyFile resultApprovalFile
        FileWriter outputfileApp = new FileWriter(fileApp);
        CSVWriter writer = new CSVWriter(outputfileApp, '|',
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);
        writer.writeAll(dataApp);
        writer.flush();
        writer.close();

    }

    public static void updateFieldReaFileCSV(String strData, String newData) throws IOException, CsvException {

        File folder = new File(Const.resultDataDummyFile);
        File[] listOfFiles = folder.listFiles();
        String getFileCSV = null;

        for (int i = 0; i < Objects.requireNonNull(listOfFiles).length; i++) {
            if (listOfFiles[i].isFile()) {

                if (listOfFiles[i].getName().contains(Const.csvRea)) {
                    getFileCSV = listOfFiles[i].getName();
                }
            }
        }
        CSVReader reader = new CSVReader(new FileReader(new File(Const.resultDataDummyFile + getFileCSV)));
        List<String[]> csvBody = reader.readAll();
        ArrayList<String[]> dataApp = new ArrayList<>();

        for (int i = 0; i < csvBody.size(); i++) {
            String[] strArray = csvBody.get(i);
            for (int j = 0; j < strArray.length; j++) {
                if (strArray[j].contains(strData)) { //String to be replaced
                    String[] p = new String[0];
                    for (String[] s : csvBody) {
                        for (int index = 0; index < s.length; index++) {
                            p = s[index].split("\\|");

                            if (p[3].equals(strData)) {
                                p[3] = newData; // + LibUtils.timestamp()
                                System.out.println(p[3]);
                            }
                            dataApp.add(p);
                        }
                    }
                }
            }
        }
        reader.close();

        File fileApp = new File(Const.resultDataDummyFile + getFileCSV);
        FileWriter outputfileApp = new FileWriter(fileApp);
        CSVWriter writer = new CSVWriter(outputfileApp, '|',
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);
        writer.writeAll(dataApp);
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException, CsvException {
        ReadCSVFormApproval readCSVFormRealization = new ReadCSVFormApproval();
        String[] arr       = readCSVFormRealization.fileCSVRea();
        String alamat      = arr[33];
        String alamat2     = arr[63];
        String alamat3     = arr[93];
        String alamat4     = arr[123];
        String alamat5     = arr[153];
        String[] modifData = {alamat};
        updateFieldReaFileCSV(alamat, "Jalan Bahyang  update");
        updateFieldReaFileCSV(alamat2, "Jalan Bahyang  update");
        updateFieldReaFileCSV(alamat3, "Jalan Bahyang  update");
        updateFieldReaFileCSV(alamat4, "Jalan Bahyang  update");
        updateFieldReaFileCSV(alamat5, "Jalan Bahyang  update");

//        for (int i = 0; i < modifData.length; i++) {
//            switch (i) {
//                case 0:
//                    updateFieldReaFileCSV(modifData[i], "TEST 1");
//                    break;
//            }
//        }

//        ReadCSVFormApproval readCSVFormRealization = new ReadCSVFormApproval();
//        String[] arr   = readCSVFormRealization.fileCSVRea();
//        String alamat1    = arr[33]; //44 74 | 33 63 93
//        String alamat2   = arr[63];
//        System.out.println(npwp);
//        updateFieldCSV(alamat1, "WAQA 100");
//        updateFieldCSV(alamat2, "WAQA 101");

//        String npwp   = arr[44]; //44 74 | 33 63 93
//        System.out.println(npwp);
//        updateFieldCSV(npwp, "");
//        String plafon = arr[57];  //47//
//        System.out.println(plafon);//
//        updateFieldCSV(plafon, "LOKP");

    }
}