package capture;

import elementsPage.Const;
import io.cucumber.java.Scenario;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import testData.ReadTestData;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImageExcel {

    public static String t_case;
    ReadTestData readTestData = new ReadTestData();


    public void insertImages(String image, int i, String pictName, String sheetName) throws IOException {

        String fileExcel = Const.pthFileValidation + Const.fileNMScenario;
//        String fileExcel = Const.pthFileValidation + Const.fileNMScenario2;

//        if (sheetName.equals(Const.sheetCaptureRecomend)) {
//            sheetImages = Const.sheetCaptureRecomend;
//        } else {
//            sheetImages = Const.sheetCaptureRealisasi;
//        }
        ImageExcel imageExcel = new ImageExcel();
        imageExcel.insertTextCapture(i - 1, sheetName, pictName);

        try {

            String excelFilePath = fileExcel;
            File file = new File(excelFilePath);
            FileInputStream os = new FileInputStream(excelFilePath);
            XSSFWorkbook wb = new XSSFWorkbook(os);
            XSSFSheet sheet = wb.getSheet(sheetName);

            //FileInputStream obtains input bytes from the image file
            InputStream inputStream = new FileInputStream(image);
            //Get the contents of an InputStream as a byte[].
            byte[] bytes = IOUtils.toByteArray(inputStream);
            //Adds a picture to the workbook
            int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            //close the input stream
            inputStream.close();

            //Returns an object that handles instantiating concrete classes
            CreationHelper helper = wb.getCreationHelper();

            //Creates the top-level drawing patriarch.
            Drawing drawing = sheet.createDrawingPatriarch();

            //Create an anchor that is attached to the worksheet
            ClientAnchor anchor = helper.createClientAnchor();
            //set top-left corner for the image
            anchor.setCol1(1);
            anchor.setRow1(i);

            CellStyle topAligned = wb.createCellStyle();
            topAligned.setVerticalAlignment(VerticalAlignment.TOP);
            //Creates a picture and text

            Picture pict = drawing.createPicture(anchor, pictureIdx);
//            insertTextCapture(i-1,"CaptureValidation", String.valueOf(i-1));
            //Reset the image to the original size

            pict.resize();

            //Write the Excel file
            FileOutputStream fileOut = new FileOutputStream(file);
            wb.write(fileOut);

            fileOut.close();
            fileOut.close();

        } catch (Exception e) {
            e.getCause();
            e.getMessage();
            e.printStackTrace();
        }
    }

    public void insertStatusExcel(int index, String nameAttachment, String status, String notes) {
        int iRow = index + 1;
        //get file name
        File folder = new File(Const.pthFileValidation);
        File[] listOfFiles = folder.listFiles();

        String fileExcel = null;
        if (listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {

                    if (listOfFiles[i].getName().contains(Const.pFileScenario)) {
                        fileExcel = listOfFiles[i].getName();
                    }
                }
            }
        }
        try {
            //date now
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            String fdate = simpleDateFormat.format(new Date());

            String excelFilePath = Const.pthFileValidation + fileExcel;
            File file = new File(excelFilePath);
            FileInputStream os = new FileInputStream(excelFilePath);
            XSSFWorkbook wb = new XSSFWorkbook(os);
            Scenario sc = null;
            XSSFSheet sheet = null;

            readTestData.testData();
            switch (readTestData.tagName) {
                case "approvalForm":
                    sheet = wb.getSheet(Const.sheetApprovalFormBU);
                    break;
                case "realizationForm":
                    sheet = wb.getSheet(Const.sheetRealizationFormBU);
                    break;
                case "validationApprovalFile":
                    sheet = wb.getSheet(Const.sheetApprovalFileBU);
                    break;
                case "validationRealizationFile":
                    sheet = wb.getSheet(Const.sheetRealisasiFileBU);
                    break;
            }

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
            int cell = row.getLastCellNum();
            System.out.println("Row: " + (iRow - 1));
            System.out.println(nameAttachment);

            CellStyle cs = wb.createCellStyle();
            cs.setWrapText(true);

            sheet.getRow(iRow).createCell(6).setCellValue(System.getProperty("user.name"));
            sheet.getRow(iRow).getCell(6).setCellStyle(topAligned);

            sheet.getRow(iRow).createCell(7).setCellValue(fdate);
            sheet.getRow(iRow).getCell(7).setCellStyle(topAligned);

            sheet.getRow(iRow).createCell(8).setCellValue(nameAttachment);
            sheet.getRow(iRow).getCell(8).setCellStyle(topAligned);

            if (status.equals(Const.fStatus)) {
                sheet.getRow(iRow).createCell(9).setCellValue(status);
                sheet.getRow(iRow).getCell(9).setCellStyle(styleGreen);
                sheet.getRow(iRow).getCell(9).setCellStyle(topAligned);
            } else {
                sheet.getRow(iRow).createCell(9).setCellValue(status);
                sheet.getRow(iRow).getCell(9).setCellStyle(styleGreen);
                sheet.getRow(iRow).getCell(9).setCellStyle(topAligned);
            }
            sheet.getRow(iRow).createCell(10).setCellValue(notes);
            sheet.getRow(iRow).getCell(10).setCellStyle(topAligned);

            FileOutputStream fout = new FileOutputStream(file);
            HSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
            wb.write(fout);
            os.close();
            wb.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertPathFileImages(int index, String nameAttachment, String reason) {
        int iRow = index + 1;
        //get file name
        File folder = new File(Const.pthFileValidation);
        File[] listOfFiles = folder.listFiles();

        String fileExcel = null;
        if (listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    if (listOfFiles[i].getName().contains(Const.pFileTC)) {
                        fileExcel = listOfFiles[i].getName();
                    }
                }
            }
        }
        try {
            String excelFilePath = Const.pthFileValidation + fileExcel;

            File file           = new File(excelFilePath);
            FileInputStream os  = new FileInputStream(excelFilePath);
            XSSFWorkbook wb     = new XSSFWorkbook(os);
            XSSFSheet sheet     = wb.getSheet(Const.sheetTCApprovFormBU);
            XSSFRow row         = sheet.getRow(0);

            XSSFCellStyle styleGreen = wb.createCellStyle();
            styleGreen.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
            styleGreen.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            XSSFCellStyle styleRed = wb.createCellStyle();
            styleRed.setFillForegroundColor(IndexedColors.RED.getIndex());
            styleRed.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle topAligned = wb.createCellStyle();
            topAligned.setVerticalAlignment(VerticalAlignment.TOP);

            //insert new header column
            int cell = row.getLastCellNum();
            System.out.println("Row: " + index);
            System.out.println(nameAttachment);

            CellStyle cs = wb.createCellStyle();
            cs.setWrapText(true);

            sheet.getRow(iRow).createCell(8).setCellValue(nameAttachment);
            sheet.getRow(iRow).getCell(8).setCellStyle(topAligned);

            if (reason.equals(Const.fStatus)) {
                sheet.getRow(iRow).createCell(9).setCellValue(reason);
                sheet.getRow(iRow).getCell(9).setCellStyle(styleGreen);
                sheet.getRow(iRow).getCell(9).setCellStyle(topAligned);
            } else {
                sheet.getRow(iRow).createCell(9).setCellValue(reason);
                sheet.getRow(iRow).getCell(9).setCellStyle(styleGreen);
                sheet.getRow(iRow).getCell(9).setCellStyle(topAligned);
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

    public void validationJFExcel(int iCollect, String namaDebtors, String pathfile, String statusApproval) {
        int iRow = iCollect + 1;
        //get file name
        File folder = new File(Const.pthFileValidation);
        File[] listOfFiles = folder.listFiles();

        String fileExcel = null;
        if (listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {

                    if (listOfFiles[i].getName().contains(Const.pFileScenario)) {
                        fileExcel = listOfFiles[i].getName();
                    }

                }
            }
        }
        try {
            String excelFilePath = Const.pthFileValidation + fileExcel;

            File file = new File(excelFilePath);
            FileInputStream os = new FileInputStream(excelFilePath);
            XSSFWorkbook wb = new XSSFWorkbook(os);
            XSSFSheet sheet = wb.getSheet("Approve Realisasi");
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
            int cell = row.getLastCellNum();
            System.out.println(namaDebtors);
            System.out.println("Row: " + iCollect);
//            if (iRow == 2) {
//                readTestData.testData();
//                sheet.shiftRows(2, Integer.parseInt(readTestData.jumlahData), 1, true, true);
//
//
//            }
            CellStyle cs = wb.createCellStyle();
            cs.setWrapText(true);

            sheet.createRow(iRow);
            sheet.getRow(iRow).createCell(0).setCellValue(iCollect);
            sheet.getRow(iRow).getCell(0).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(1).setCellValue("Validation Process");
            sheet.getRow(iRow).getCell(1).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(2).setCellValue("POSITIF");
            sheet.getRow(iRow).getCell(2).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(3)
                    .setCellValue("Search data sesuai data dummy ke " + iCollect + "\n" +
                            "- Status approved");
            sheet.getRow(iRow).getCell(3).setCellStyle(topAligned);
            sheet.getRow(iRow).getCell(3).setCellStyle(cs);
            sheet.getRow(iRow).createCell(4).setCellValue("Tampil data sesuai pencarian dan status \"approved\"");
            sheet.getRow(iRow).getCell(4).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(5).setCellValue("Automation");
            sheet.getRow(iRow).getCell(5).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(6).setCellValue(namaDebtors);
            sheet.getRow(iRow).getCell(6).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(7).setCellValue(pathfile);
            sheet.getRow(iRow).getCell(7).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(8).setCellValue(statusApproval);
            sheet.getRow(iRow).getCell(8).setCellStyle(topAligned);
            sheet.getRow(iRow).getCell(8).setCellStyle(cs);

            //insert new column data to excel


            sheet.getRow(iRow).createCell(9).setCellValue(Const.tStatus);
//            sheet.getRow(iRow).getCell(9).setCellStyle(styleGreen);
//            sheet.getRow(iRow).getCell(9).setCellStyle(topAligned);


            FileOutputStream fout = new FileOutputStream(file);
            HSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
            wb.write(fout);
            os.close();
            wb.close();

        } catch (Exception e) {
            e.getMessage();
        }
    }

    //    public static void main(String[] args) throws IOException {
//        ImageExcel imageExcel = new ImageExcel();
//        imageExcel.insertTextCapture(2, "CaptureValidation", "Test name");
//    }
    public void insertTextCapture(int iCollect, String sheetName, String pictName) throws IOException {

//        String sheetImages = null;
        String fileExcel = Const.pthFileValidation + Const.fileNMScenario;
//        if (sheetName.equals("Recomendation")) {
//            sheetImages = Const.sheetCaptureRecomend;
//        } else {
//            sheetImages = Const.sheetCaptureRealisasi;
//        }


        File file = new File(fileExcel);
        FileInputStream os = new FileInputStream(fileExcel);
        XSSFWorkbook wb = new XSSFWorkbook(os);
        XSSFSheet sheet = wb.getSheet(sheetName);
        XSSFRow row = sheet.getRow(0);

        CellStyle topAligned = wb.createCellStyle();
        topAligned.setVerticalAlignment(VerticalAlignment.TOP);
        sheet.createRow(iCollect);
        sheet.getRow(iCollect).createCell(0).setCellValue(pictName);
        sheet.getRow(iCollect).getCell(0).setCellStyle(topAligned);

        FileOutputStream fout = new FileOutputStream(file);
        HSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
        wb.write(fout);
        os.close();
        wb.close();
    }
}
