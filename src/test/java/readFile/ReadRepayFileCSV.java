package readFile;

import elementsPage.Const;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadRepayFileCSV {

    public String[] fileCSVRepayReq() throws IOException {

        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(Const.resultDataDummyFile);
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                if (listOfFiles[i].getName().contains(Const.repayFileRequest)) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(Const.resultDataDummyFile + fileExcel);
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

        return array;
    }

    public String[] fileCSVRepaySuccess() throws IOException {

        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(Const.resultDataDummyFile);
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                if (listOfFiles[i].getName().contains(Const.repayFileSuccess)) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(Const.resultDataDummyFile + fileExcel);
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

        return array;
    }

    public String[] fileCSVRepayError() throws IOException {

        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(Const.resultDataDummyFile);
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                if (listOfFiles[i].getName().contains(Const.repayFileError)) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(Const.resultDataDummyFile + fileExcel);
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

        return array;
    }

    public String[] fileCSVRepayReq2() throws IOException {

        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(Const.resultDataDummyFile);
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                if (listOfFiles[i].getName().contains(Const.repayFileRequest)) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(Const.resultDataDummyFile + fileExcel);
        // Created a string to store each character to form word
        String s = new String();
        char ch;

        // checking for EOF
        while (fr.ready()) {
            ch = (char) fr.read();
            // Used to specify the delimiters
            if (ch == '\n') {
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

        return array;
    }

    public String[] fileCSVRepaySuccess2() throws IOException {

        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(Const.resultDataDummyFile);
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                if (listOfFiles[i].getName().contains(Const.repayFileSuccess)) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(Const.resultDataDummyFile + fileExcel);
        // Created a string to store each character to form word
        String s = new String();
        char ch;

        // checking for EOF
        while (fr.ready()) {
            ch = (char) fr.read();
            // Used to specify the delimiters
            if (ch == '\n') {
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

        return array;
    }

    public String[] fileCSVRepayExist() throws IOException {

        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(Const.resultDataDummyFileRepay);
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                if (listOfFiles[i].getName().contains(Const.repayFileExist)) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(Const.resultDataDummyFileRepay + fileExcel);
        // Created a string to store each character to form word
        String s = new String();
        char ch;

        // checking for EOF
        while (fr.ready()) {
            ch = (char) fr.read();
            // Used to specify the delimiters
            if (ch == '\n') {
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

        return array;
    }

    public String[] fileCSVRepayError2() throws IOException {

        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(Const.resultDataDummyFile);
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                if (listOfFiles[i].getName().contains(Const.repayFileError)) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(Const.resultDataDummyFile + fileExcel);
        // Created a string to store each character to form word
        String s = new String();
        char ch;

        // checking for EOF
        while (fr.ready()) {
            ch = (char) fr.read();
            // Used to specify the delimiters
            if (ch == '\n') {
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

        return array;
    }
}
