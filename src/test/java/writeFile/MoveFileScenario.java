package writeFile;

import elementsPage.Const;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class MoveFileScenario {

    public void copyFile() {
        Path sourceDirectory = Paths.get(Const.pthTemp + Const.fileNMScenario);
        Path targetDirectory = Paths.get(Const.pthFileValidation + Const.fileNMScenario);
        try {
            Files.copy(sourceDirectory, targetDirectory, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void deletePNG() {
        File file = new File(Const.pthImages);
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }
        }
    }

    public void dltDummyExist() {
        try {
            dltZipyExist();
            File file = new File(Const.resultDataDummyFile);
            String[] myFiles;
            if (file.isDirectory()) {
                myFiles = file.list();
                for (int i = 0; i < myFiles.length; i++) {
                    File myFile = new File(file, myFiles[i]);
                    myFile.delete();
                }
            }
        } catch (Exception ignored) {
        }
    }

    public void dltDataFileExist(){
        File file = new File(Const.resultApprovalFile);
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }
        }
    }

    public void dltDataFileDiffPartnerExist(){
        File file = new File(Const.resultApprovalFileDiffPartner);
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }
        }
    }

    public static void dltZipyExist() {
        File file = new File(".//dummy_SuppDoc//");
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                if (myFiles[i].contains("zip"))
                    myFile.delete();
            }
        }
    }

    public void dltAppFile() {

        File file = new File(Const.resultDataDummyFile);
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                if (myFile.getName().contains("APP")) {
                    myFile.delete();
                }
            }
        }
    }
}
