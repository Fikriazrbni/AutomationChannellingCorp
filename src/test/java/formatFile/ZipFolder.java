package formatFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFolder {

//    public static void main(String[] args) {
//
//        Path source = Paths.get(".//dummy_SuppDoc//");
//
//        if (!Files.isDirectory(source)) {
//            System.out.println("Please provide a folder.");
//            return;
//        }
//
//        try {
//
//            ZipFolder.zipFolder(source);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Done");
//
//    }

    // zip a directory, including sub files and sub directories
    public static void zipFolder(Path source, String suppDocName) throws IOException {

        // get folder name as zip file name
        String zipFileName = source.getFileName().toString() + ".zip";
        String newZipFileName = zipFileName.replace(zipFileName, suppDocName);
        try (
                ZipOutputStream zos = new ZipOutputStream(
                        new FileOutputStream(newZipFileName))
        ) {

            Files.walkFileTree(source, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file,
                                                 BasicFileAttributes attributes) {

                    // only copy files, no symbolic links
                    if (attributes.isSymbolicLink()) {
                        return FileVisitResult.CONTINUE;
                    }

                    try (FileInputStream fis = new FileInputStream(file.toFile())) {

                        Path targetFile = source.relativize(file);
                        zos.putNextEntry(new ZipEntry(targetFile.toString()));

                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = fis.read(buffer)) > 0) {
                            zos.write(buffer, 0, len);
                        }

                        // if large file, throws out of memory
                        //byte[] bytes = Files.readAllBytes(file);
                        //zos.write(bytes, 0, bytes.length);

                        zos.closeEntry();

//                        System.out.printf("Zip file : %s%n", file);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    System.err.printf("Unable to zip : %s%n%s%n", file, exc);
                    return FileVisitResult.CONTINUE;
                }
            });

        }

    }

    public static void zipFolder(String pthFolder, String suppDocName) {

        try {
            File source = new File(pthFolder);
            List<String> filesListInDir = new ArrayList<>();
            File[] files = source.listFiles();

            for (File file : files) {
                if (file.isFile()) {
                    filesListInDir.add(file.getAbsolutePath());
                }
            }
            //create ZipOutputStream to write to the zip file zip
            FileOutputStream fos = new FileOutputStream(suppDocName);
            ZipOutputStream zos = new ZipOutputStream(fos);

            for (String filePath : filesListInDir) {

                ZipEntry ze = new ZipEntry(filePath.substring(source.getAbsolutePath().length() + 1));
                zos.putNextEntry(ze);

                FileInputStream fis = new FileInputStream(filePath);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                zos.closeEntry();
                fis.close();
            }

            zos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}