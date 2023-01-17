package writeFile;

import elementsPage.Const;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteTestData {

    public void writeData(String timeStamp) throws IOException {

        String excelFilePath = Const.pthTestData;
        File file = new File(excelFilePath);
        FileInputStream os = new FileInputStream(excelFilePath);
        XSSFWorkbook wb = new XSSFWorkbook(os);
        XSSFSheet sheet = wb.getSheet(Const.sheetTestData);
        int row = sheet.getLastRowNum();

        //insert new column data to excel
        sheet.getRow(1).createCell(8).setCellValue(timeStamp);

        //width autoSize
        FileOutputStream fout = new FileOutputStream(file);
        wb.write(fout);
        os.close();
        wb.close();
    }
}

