package readFile;

import elementsPage.Const;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Main class
public class ReadTextFile {
    private String pthFileValidation = Const.pthFileValidation;
    private String txtApp = Const.txtApp;
    private String txtRea = Const.txtRea;
    public String st = "";

    File folder = new File(pthFileValidation);
    File[] listOfFiles = folder.listFiles();
    String fileExcel = null;

    public String txtApp() throws IOException {

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                if (listOfFiles[i].getName().contains(txtApp)) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }

        {
            File file = new File(pthFileValidation + fileExcel);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while ((s = br.readLine()) != null) {
                st = st + s;
            }
        }
        return st;
    }


    public String txtRea() throws IOException {

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                if (listOfFiles[i].getName().contains(txtRea)) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }

        {
            File file = new File(pthFileValidation + fileExcel);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while ((s = br.readLine()) != null) {
                st = st + s;
            }
        }
        return st;
    }
}
