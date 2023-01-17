package readFile;

import elementsPage.Const;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadReaTXT {
    String status;
    String nomorAplikasi;
    String pthFileValidation = Const.pthFileValidation;
    String txtRea = Const.txtRea;
    String[] value2;

    public String[] textFile(int idxNomorAplikasi, int idxStatus) throws IOException {
        String str;
        String eachString1;

        String[] stringarray;
        // arraylist to store strings
        List<String> listOfStrings = new ArrayList<>();

        //get file name
        String fileExcel = null;
        File folder = new File(pthFileValidation);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                if (listOfFiles[i].getName().contains(txtRea)) {
                    fileExcel = listOfFiles[i].getName();
                    //System.out.println(fileExcel);
                }
            }
        }
        // load content of file based on specific delimiter
        Scanner sc = new Scanner(new FileReader(pthFileValidation + fileExcel)).useDelimiter(",");

        // checking end of file
        while (sc.hasNext()) {
            str = sc.next();

            // adding each string to arraylist
            listOfStrings.add(str);
        }

        // convert any arraylist to array
        String[] array = listOfStrings.toArray(new String[0]);

        // print each string in array
        for (String eachString : array) {
            eachString = eachString.replace("\n", "|");
            eachString1 = eachString;

            stringarray = eachString1.split("\\|");
            for (int i = 0; i < stringarray.length; i++) {
                nomorAplikasi = stringarray[idxNomorAplikasi];
                status = stringarray[idxStatus];

                String[] value = new String[2];
                value[0] = nomorAplikasi;
                value[1] = status;
                value2 = value;
            }
        }
//		System.out.println(value2);
        return value2;

    }
}
