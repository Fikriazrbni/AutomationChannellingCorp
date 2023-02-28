package readFile;

import elementsPage.Const;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVFormApproval {
    String nomorAplikasi;
    public String[] fileCSVAppForm() throws IOException {

        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(Const.resultDataDummyFile); //resultDataDummyFile   resultApprovalFile
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                if (listOfFiles[i].getName().contains("APPFILE_L000001")) { //APPFILE_L000002
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(Const.resultDataDummyFile + fileExcel); //resultDataDummyFile   resultApprovalFile
        // Created a string to store each character to form word
        String s = new String();
        char ch;

        // checking for EOF
        while (fr.ready()) {
            ch = (char) fr.read();
            // Used to specify the delimiters
            if (ch == '|' || ch == '\n') {
                // Storing each string in arraylist
                listOfStrings.add(s.toString());
                // clearing content in string
                s = new String();
            } else {
                // appending each character to string if the current character is not delimiter
                s += ch;
            }
        }
        if (s.length() > 0) {
            // appending last line of strings to list
            listOfStrings.add(s.toString());
        }
        // storing the data in arraylist to array
        String[] array = listOfStrings.toArray(new String[0]);
        // printing each line of file which is stored in array

//        for (String ignored : array) {
////            if (idxNomorAplikasi < array.length) {
//            if (array.length - (idxNomorAplikasi + 1) > 0) {
//                nomorAplikasi = array[idxNomorAplikasi];
//
//                String[] value = new String[2];
//                value[0] = nomorAplikasi;
//                value2 = value;
//
//            }
//        }
        return array;
    }
    public String[] fileCSVAppForm2() throws IOException { //for 30 character

        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(Const.resultDataDummyFile); //resultDataDummyFile   resultApprovalFile
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                if (listOfFiles[i].getName().contains("APPFILE_L000005")) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(Const.resultDataDummyFile + fileExcel); //resultDataDummyFile   resultApprovalFile
        // Created a string to store each character to form word
        String s = new String();
        char ch;

        // checking for EOF
        while (fr.ready()) {
            ch = (char) fr.read();
            // Used to specify the delimiters
            if (ch == '|' || ch == '\n') {
                // Storing each string in arraylist
                listOfStrings.add(s.toString());
                // clearing content in string
                s = new String();
            } else {
                // appending each character to string if the current character is not delimiter
                s += ch;
            }
        }
        if (s.length() > 0) {
            // appending last line of strings to list
            listOfStrings.add(s.toString());
        }
        // storing the data in arraylist to array
        String[] array = listOfStrings.toArray(new String[0]);
        // printing each line of file which is stored in array

//        for (String ignored : array) {
////            if (idxNomorAplikasi < array.length) {
//            if (array.length - (idxNomorAplikasi + 1) > 0) {
//                nomorAplikasi = array[idxNomorAplikasi];
//
//                String[] value = new String[2];
//                value[0] = nomorAplikasi;
//                value2 = value;
//
//            }
//        }
        return array;
    }
    public String[] fileCSVAppFile() throws IOException {

        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(Const.resultApprovalFile); //resultApprovalFile
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                if (listOfFiles[i].getName().contains(Const.appFile)) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(Const.resultApprovalFile + fileExcel); //resultDataDummyFile   resultApprovalFile
        // Created a string to store each character to form word
        String s = new String();
        char ch;

        // checking for EOF
        while (fr.ready()) {
            ch = (char) fr.read();
            // Used to specify the delimiters
            if (ch == '|' || ch == '\n') {
                // Storing each string in arraylist
                listOfStrings.add(s.toString());
                // clearing content in string
                s = new String();
            } else {
                // appending each character to string if the current character is not delimiter
                s += ch;
            }
        }
        if (s.length() > 0) {
            // appending last line of strings to list
            listOfStrings.add(s.toString());
        }
        // storing the data in arraylist to array
        String[] array = listOfStrings.toArray(new String[0]);
        return array;
    }

    public String[] fileCSVAppPartner() throws IOException {

        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(Const.resultApprovalFile);
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if (listOfFiles[i].getName().contains(Const.csvApp)) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(Const.resultApprovalFile + fileExcel); //resultDataDummyFile   resultApprovalFile  resultApprovalFileDiffPartner
        String s = new String();
        char ch;

        while (fr.ready()) {
            ch = (char) fr.read();
            if (ch == '|' || ch == '\n') {
                listOfStrings.add(s.toString());
                s = new String();
            } else {
                s += ch;
            }
        }
        if (s.length() > 0) {
            listOfStrings.add(s.toString());
        }
        String[] array = listOfStrings.toArray(new String[0]);
        return array;
    }
    public String[] fileCSVAppDiffPartner() throws IOException {

        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(Const.resultApprovalFileDiffPartner);
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if (listOfFiles[i].getName().contains(Const.csvApp)) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(Const.resultApprovalFileDiffPartner + fileExcel); //resultDataDummyFile   resultApprovalFile  resultApprovalFileDiffPartner
        String s = new String();
        char ch;

        while (fr.ready()) {
            ch = (char) fr.read();
            if (ch == '|' || ch == '\n') {
                listOfStrings.add(s.toString());
                s = new String();
            } else {
                s += ch;
            }
        }
        if (s.length() > 0) {
            listOfStrings.add(s.toString());
        }
        String[] array = listOfStrings.toArray(new String[0]);
        return array;
    }
    public String[] fileCSVAppPending() throws IOException {

        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(Const.resultDataDummyFilePending);
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if (listOfFiles[i].getName().contains(Const.csvApp)) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(Const.resultDataDummyFilePending + fileExcel); //resultDataDummyFile   resultApprovalFile  resultApprovalFileDiffPartner
        String s = new String();
        char ch;

        while (fr.ready()) {
            ch = (char) fr.read();
            if (ch == '|' || ch == '\n') {
                listOfStrings.add(s.toString());
                s = new String();
            } else {
                s += ch;
            }
        }
        if (s.length() > 0) {
            listOfStrings.add(s.toString());
        }
        String[] array = listOfStrings.toArray(new String[0]);
        return array;
    }
    public String[] fileCSVReaPartner() throws IOException {

        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(Const.resultApprovalFile); //resultDataDummyFile   resultApprovalFile
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if (listOfFiles[i].getName().contains(Const.csvRea)) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(Const.resultApprovalFile + fileExcel); //resultDataDummyFile   resultApprovalFile
        String s = new String();
        char ch;

        while (fr.ready()) {
            ch = (char) fr.read();
            if (ch == '|' || ch == '\n') {
                listOfStrings.add(s.toString());
                s = new String();
            } else {
                s += ch;
            }
        }
        if (s.length() > 0) {
            listOfStrings.add(s.toString());
        }
        String[] array = listOfStrings.toArray(new String[0]);

        return array;
    }
    public String[] fileCSVReaDiffPartner() throws IOException {

        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(Const.resultApprovalFileDiffPartner);
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if (listOfFiles[i].getName().contains(Const.csvRea)) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(Const.resultApprovalFileDiffPartner + fileExcel); //resultDataDummyFile   resultApprovalFile  resultApprovalFileDiffPartner
        String s = new String();
        char ch;

        while (fr.ready()) {
            ch = (char) fr.read();
            if (ch == '|' || ch == '\n') {
                listOfStrings.add(s.toString());
                s = new String();
            } else {
                s += ch;
            }
        }
        if (s.length() > 0) {
            listOfStrings.add(s.toString());
        }
        String[] array = listOfStrings.toArray(new String[0]);
        return array;
    }
    public String[] fileCSVReaPending() throws IOException {

        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(Const.resultDataDummyFilePending);
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if (listOfFiles[i].getName().contains(Const.csvRea)) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(Const.resultDataDummyFilePending + fileExcel); //resultDataDummyFile   resultApprovalFile  resultApprovalFileDiffPartner
        String s = new String();
        char ch;

        while (fr.ready()) {
            ch = (char) fr.read();
            if (ch == '|' || ch == '\n') {
                listOfStrings.add(s.toString());
                s = new String();
            } else {
                s += ch;
            }
        }
        if (s.length() > 0) {
            listOfStrings.add(s.toString());
        }
        String[] array = listOfStrings.toArray(new String[0]);
        return array;
    }
    public String[] fileCSVRea() throws IOException {

        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(Const.resultDataDummyFile); //resultDataDummyFile   resultApprovalFile
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if (listOfFiles[i].getName().contains("REAFILE_L000001")) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(Const.resultDataDummyFile + fileExcel); //resultDataDummyFile   resultApprovalFile
        String s = new String();
        char ch;

        while (fr.ready()) {
            ch = (char) fr.read();
            if (ch == '|' || ch == '\n') {
                listOfStrings.add(s.toString());
                s = new String();
            } else {
                s += ch;
            }
        }
        if (s.length() > 0) {
            listOfStrings.add(s.toString());
        }
        String[] array = listOfStrings.toArray(new String[0]);

        return array;
    }

    public String[] fileCSVPengurusForm() throws IOException {

        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(Const.resultDataDummyFile); //resultDataDummyFile   resultApprovalFile
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;
        String[] arr = fileCSVAppForm();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if (listOfFiles[i].getName().contains(arr[8])) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(Const.resultDataDummyFile + fileExcel); //resultDataDummyFile   resultApprovalFile
        String s = new String();
        char ch;
        // checking for EOF
        while (fr.ready()) {
            ch = (char) fr.read();
            if (ch == '|' || ch == '\n') {
                listOfStrings.add(s.toString());
                s = new String();
            } else {
                s += ch;
            }
        }
        if (s.length() > 0) {
            listOfStrings.add(s.toString());
        }
        String[] array = listOfStrings.toArray(new String[0]);

        return array;
    }

    public String[] fileCSVPengurusFile() throws IOException {

        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(Const.resultApprovalFile); //resultDataDummyFile   resultApprovalFile
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;
        String[] arr = fileCSVAppFile();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if (listOfFiles[i].getName().contains(arr[8])) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(Const.resultApprovalFile + fileExcel); //resultDataDummyFile   resultApprovalFile
        String s = new String();
        char ch;
        // checking for EOF
        while (fr.ready()) {
            ch = (char) fr.read();
            if (ch == '|' || ch == '\n') {
                listOfStrings.add(s.toString());
                s = new String();
            } else {
                s += ch;
            }
        }
        if (s.length() > 0) {
            listOfStrings.add(s.toString());
        }
        String[] array = listOfStrings.toArray(new String[0]);

        return array;
    }
    public String[] fileCSVPengurusFile2() throws IOException {

        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(Const.resultApprovalFile); //resultDataDummyFile   resultApprovalFile
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;
        String[] arr = fileCSVAppPartner();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if (listOfFiles[i].getName().contains(arr[16])) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(Const.resultApprovalFile + fileExcel); //resultDataDummyFile   resultApprovalFile
        String s = new String();
        char ch;
        // checking for EOF
        while (fr.ready()) {
            ch = (char) fr.read();
            if (ch == '|' || ch == '\n') {
                listOfStrings.add(s.toString());
                s = new String();
            } else {
                s += ch;
            }
        }
        if (s.length() > 0) {
            listOfStrings.add(s.toString());
        }
        String[] array = listOfStrings.toArray(new String[0]);

        return array;
    }
}
