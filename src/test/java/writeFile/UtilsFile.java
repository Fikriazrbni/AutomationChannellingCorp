package writeFile;

import elementsPage.Const;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UtilsFile {

    public static void copyRenameFile(String oldPathFileName, String newPathFileName) {

        Path sourceDirectory = Paths.get(oldPathFileName);
        Path targetDirectory = Paths.get(newPathFileName);
        try {
            Files.copy(sourceDirectory, targetDirectory, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void renameFile(String pthFile, String pthNewFile) {

        try {
            File file = new File(pthFile);
            File rename = new File(pthNewFile);
            boolean sts = file.renameTo(rename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String pthFile) {
        try {
            File file = new File(pthFile);
            boolean sts = file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getFileName(String key_fileName) {
        try {
            List<String> listOfStrings = new ArrayList<>();
            File folder = new File(Const.resultDataDummyFile);
            File[] listOfFiles = folder.listFiles();
            String fileName = null;
            for (int i = 0; i < Objects.requireNonNull(listOfFiles).length; i++) {
                if (listOfFiles[i].isFile()) {

                    if (listOfFiles[i].getName().contains(key_fileName)) {
                        fileName = listOfFiles[i].getName();

                    }
                }
            }
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String[] arrGetFileName(String pthFolder) {
        try {
            String[] fileNames =
                    Files.list(Paths.get(pthFolder)).filter(
                            Files::isRegularFile).map(
                            p -> p.toFile().getName()).toArray(String[]::new);

            for (String s : fileNames) {
                System.out.println(s);
            }
            return fileNames;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getFileNameZip(String foderLocation, String keyFileName) {

        String fp = null;
        long start = System.currentTimeMillis();
        long end = start + 120000;
        long lastModifiedTime = Long.MIN_VALUE;
        File chosenFile = null;
        boolean sts = true;
        while (sts) {

            File source = new File(foderLocation);
            List<String> filesListInDir = new ArrayList<>();
            File[] files = source.listFiles();

            assert files != null;
            for (File file : files) {
                if (file.isFile()) {
                    filesListInDir.add(file.getAbsolutePath());

                }

            }
            for (String filePath : filesListInDir) {
                if (filePath.contains(keyFileName)) {
                    fp = filePath;
                    sts = false;
                }
            }
            if (System.currentTimeMillis() > end) {
                break;
            }
        }
        return fp;
    }

    public static void unzip(File zippedFile, String pthZipTo) throws IOException {
        File destDir = new File(pthZipTo);
        byte[] buffer = new byte[2048];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zippedFile));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            if (zipEntry.isDirectory()) {
                continue;
            } else {
                File newFile = new File(pthZipTo + zipEntry.getName());
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
            }
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
    }

    public static void deleteInFolder(String pthFOlder) {
        File file = new File(pthFOlder);
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < Objects.requireNonNull(myFiles).length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }
        }
    }

    public static void deleteInFolderContainsFileName(String pthFOlder, String keyName) {
        File file = new File(pthFOlder);
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < Objects.requireNonNull(myFiles).length; i++) {
                File myFile = new File(file, myFiles[i]);
                if (myFile.getName().startsWith(keyName)) {
                    myFile.delete();
                }
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

    public static void deleteZipyExist(String pthFolder, String keyName) {
        File file = new File(pthFolder);
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                if (myFiles[i].contains(keyName))
                    myFile.delete();
            }
        }
    }
    public void dltAppFile() {

        File file = new File(Const.resultDataDummyFile);
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < Objects.requireNonNull(myFiles).length; i++) {
                File myFile = new File(file, myFiles[i]);
                if (myFile.getName().contains("APP")) {
                    myFile.delete();
                }
            }
        }
    }
}
