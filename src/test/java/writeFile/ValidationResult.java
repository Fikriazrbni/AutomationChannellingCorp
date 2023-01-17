package writeFile;

import elementsPage.Const;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import testData.ReadTestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ValidationResult {
    String fileExcel = null;
    String pthFileValidation = Const.pthFileValidation;
    ReadTestData readTestData = new ReadTestData();

    public void excelResultApp(int iCollect, String nomorAplikasi, String Status, boolean bStatus) {

        int iRow = iCollect + 1;
        //get file name
        File folder = new File(pthFileValidation);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {

                    if (listOfFiles[i].getName().contains(Const.pFileScenario)) {
                        fileExcel = listOfFiles[i].getName();
                        //System.out.println(fileExcel);
                    }
                }
            }
        }
        try {
            String excelFilePath = pthFileValidation + fileExcel;

            File file = new File(excelFilePath);
            FileInputStream os = new FileInputStream(excelFilePath);
            XSSFWorkbook wb = new XSSFWorkbook(os);
            XSSFSheet sheet = wb.getSheet(Const.scSheetApp);
            XSSFRow row = sheet.getRow(0);

            XSSFCellStyle styleGreen = wb.createCellStyle();
            styleGreen.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
            styleGreen.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            XSSFCellStyle styleRed = wb.createCellStyle();
            styleRed.setFillForegroundColor(IndexedColors.RED.getIndex());
            styleRed.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            XSSFCellStyle styleYellow = wb.createCellStyle();
            styleYellow.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            styleYellow.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle topAligned = wb.createCellStyle();
            topAligned.setVerticalAlignment(VerticalAlignment.TOP);

            //insert new header column
            int cell = row.getLastCellNum();
            System.out.println(nomorAplikasi);
            System.out.println(Status);
            System.out.println("Row: " + iCollect);
            if (iRow == 2) {
                readTestData.testData();
                sheet.shiftRows(2, Integer.parseInt(readTestData.jumlahData), 1, true, true);


            }
            CellStyle cs = wb.createCellStyle();
            cs.setWrapText(true);

            sheet.createRow(iRow);
            sheet.getRow(iRow).createCell(0).setCellValue(iCollect);
            sheet.getRow(iRow).getCell(0).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(1).setCellValue("Approval Process");
            sheet.getRow(iRow).getCell(1).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(2).setCellValue("POSITIF");
            sheet.getRow(iRow).getCell(2).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(3).setCellValue(
                    "Nomor_Aplikasi \n" +
                            "NIK \n" +
                            "NPWP \n" +
                            "Jenis_Debitur \n" +
                            "Nama_Debitur \n" +
                            "Jangka_Waktu_Kredit \n" +
                            "Interest_Rate \n" +
                            "Plafon_Kredit");
            sheet.getRow(iRow).getCell(3).setCellStyle(topAligned);
            sheet.getRow(iRow).getCell(3).setCellStyle(cs);
            sheet.getRow(iRow).createCell(4).setCellValue("BERHASIL");
            sheet.getRow(iRow).getCell(4).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(5).setCellValue("Automation");
            sheet.getRow(iRow).getCell(5).setCellStyle(topAligned);

            //insert new column data to excel
            if (bStatus == true && Status.contains(Const.rBerhasil)) {

                sheet.getRow(iRow).createCell(6).setCellValue(Status);
                sheet.getRow(iRow).getCell(6).setCellStyle(topAligned);

                sheet.getRow(iRow).createCell(7).setCellValue(Const.tStatus);
                sheet.getRow(iRow).getCell(7).setCellStyle(styleGreen);
                sheet.getRow(iRow).getCell(7).setCellStyle(topAligned);
            } else if (bStatus == true && !Status.contains(Const.rBerhasil)) {

                sheet.getRow(iRow).createCell(6).setCellValue(Status);
                sheet.getRow(iRow).getCell(6).setCellStyle(topAligned);

                sheet.getRow(iRow).createCell(7).setCellValue(Const.fStatus);
                sheet.getRow(iRow).getCell(7).setCellStyle(topAligned);
                sheet.getRow(iRow).getCell(7).setCellStyle(styleRed);
            } else {
                sheet.getRow(iRow).createCell(6).setCellValue(Const.sStatus); //sNull
                sheet.getRow(iRow).getCell(6).setCellStyle(topAligned);
                sheet.getRow(iRow).getCell(6).setCellStyle(styleYellow);


                sheet.getRow(iRow).createCell(7).setCellValue(Const.fStatus);
                sheet.getRow(iRow).getCell(7).setCellStyle(topAligned);
                sheet.getRow(iRow).getCell(7).setCellStyle(styleRed);
            }

            FileOutputStream fout = new FileOutputStream(file);
            HSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
            wb.write(fout);
            os.close();
            wb.close();

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void excelResultRea(int iCollect, String nomorAplikasi, String Status, boolean bStatus) throws IOException {

        File folder = new File(pthFileValidation);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {

                    if (listOfFiles[i].getName().contains(Const.pFileScenario)) {
                        fileExcel = listOfFiles[i].getName();
                    }
                }
            }
        }

        XSSFSheet sheet = null;
        XSSFWorkbook wb = null;
        int cell = 0;
        try {
            String excelFilePath = pthFileValidation + fileExcel;

            File file = new File(excelFilePath);
            FileInputStream os = new FileInputStream(excelFilePath);
            wb = new XSSFWorkbook(os);
            sheet = wb.getSheet(Const.scSheetRea);
            XSSFRow row = sheet.getRow(0);

            XSSFCellStyle styleGreen = wb.createCellStyle();
            styleGreen.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
            styleGreen.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            XSSFCellStyle styleRed = wb.createCellStyle();
            styleRed.setFillForegroundColor(IndexedColors.RED.getIndex());
            styleRed.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle topAligned = wb.createCellStyle();
            topAligned.setVerticalAlignment(VerticalAlignment.TOP);

            //insert new header column
            cell = row.getLastCellNum();
            int iRow = iCollect + 1;
            System.out.println(nomorAplikasi);
            System.out.println(Status);
            System.out.println("Row: " + iCollect);
            if (iRow == 2) {
                readTestData.testData();
                sheet.shiftRows(2, Integer.parseInt(readTestData.jumlahData), 1, true, true);


            }
            CellStyle cs = wb.createCellStyle();
            cs.setWrapText(true);

            sheet.createRow(iRow);
            sheet.getRow(iRow).createCell(0).setCellValue(iCollect);
            sheet.getRow(iRow).getCell(0).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(1).setCellValue("Approval Process");
            sheet.getRow(iRow).getCell(1).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(2).setCellValue("POSITIF");
            sheet.getRow(iRow).getCell(2).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(3).setCellValue(
                    "Nomor_Aplikasi \n" + "Nama_Debitur \n" + "Jenis_Debitur \n" +
                            "Alamat \n" + "Alamat_Kelurahan \n" + "Alamat_Kecamatan \n" +
                            "Alamat_Kode_Pos \n" + "Alamat_KODE_DATI_II \n" + "No_Telepon \n" +
                            "No_Akte \n" + "Tanggal_Berdiri \n" + "No_Akte_Terakhir \n" +
                            "Tanggal_Akte_Terakhir \n" + "Bidang_Usaha \n" + "Nomor_NPWP \n" +
                            "Jangka_Waktu \n" + "Jenis_Kredit \n" + "Plafon \n" + "Interest_Rate \n" +
                            "Nomor_PK \n" + "Tanggal_Akad \n" + "Tanggal_Angsuran_1 \n" +
                            "Jenis_Penggunaan \n" + "Sektor_Ekonomi \n" + "Omzet \n" +
                            "Go_Public \n" + "Sandi_Golongan_Debitur \n" + "Penghasilan_Kotor_Per_Tahun \n" +
                            "Bentuk_Badan_Usaha \n" + "Tempat_berdiri_badan_usaha");
            //sheet.getRow(iRow).getCell(3).setCellStyle(topAligned);
            sheet.getRow(iRow).getCell(3).setCellStyle(cs);
            sheet.getRow(iRow).createCell(4).setCellValue("BERHASIL");
            sheet.getRow(iRow).getCell(4).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(5).setCellValue("Automation");
            sheet.getRow(iRow).getCell(5).setCellStyle(topAligned);

            //insert new column data to excel
            if (bStatus == true && Status.contains(Const.rBerhasil)) {

                sheet.getRow(iRow).createCell(6).setCellValue(Status);
                sheet.getRow(iRow).getCell(6).setCellStyle(topAligned);

                sheet.getRow(iRow).createCell(7).setCellValue(Const.tStatus);
                sheet.getRow(iRow).getCell(7).setCellStyle(styleGreen);
                sheet.getRow(iRow).getCell(7).setCellStyle(topAligned);
            } else if (bStatus == true && !Status.contains(Const.rBerhasil)) {

                sheet.getRow(iRow).createCell(6).setCellValue(Status);
                sheet.getRow(iRow).getCell(6).setCellStyle(topAligned);

                sheet.getRow(iRow).createCell(7).setCellValue(Const.fStatus);
                sheet.getRow(iRow).getCell(7).setCellStyle(topAligned);
                sheet.getRow(iRow).getCell(7).setCellStyle(styleRed);
            } else {
                sheet.getRow(iRow).createCell(6).setCellValue(Const.sNull);
                sheet.getRow(iRow).getCell(6).setCellStyle(topAligned);

                sheet.getRow(iRow).createCell(7).setCellValue(Const.fStatus);
                sheet.getRow(iRow).getCell(7).setCellStyle(topAligned);
                sheet.getRow(iRow).getCell(7).setCellStyle(styleRed);
            }

            //width autoSize
            FileOutputStream fout = new FileOutputStream(file);
            HSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
            wb.write(fout);
            fout.close();
            os.close();
            wb.close();

        } catch (Exception e) {
            e.getMessage();
        }
        readTestData.testData();
        if (iCollect == Integer.parseInt(readTestData.jumlahData)) {
            for (int colNum = 0; colNum < cell; colNum++) {
                sheet.autoSizeColumn(colNum);
            }
            // call class result percentage
            ScenarioResult scenarioResult = new ScenarioResult();
            scenarioResult.percentages();
            scenarioResult.scenarioFile();

            //Clean content
            System.out.println("Clean Text Scenario. . .");
            MoveFileScenario moveFileScenario = new MoveFileScenario();
            moveFileScenario.copyFile();

            moveFileScenario.deletePNG();

        }
    }
}

