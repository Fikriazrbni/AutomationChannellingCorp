package writeFile;

import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;
import elementsPage.Const;

public class TempImages {
    private String pthFileValidation = Const.pthFileValidation + Const.fileNMScenario;

    public int getIndexImages(String sheetImages) {

        int countPict = 0;
        try {
            Workbook workbook = new Workbook();
            //Load an Excel file
            workbook.loadFromFile(pthFileValidation);
            Worksheet sheet = workbook.getWorksheets().get(sheetImages);
            countPict = sheet.getPictures().getCount();

            workbook.save();

        } catch (Exception e) {
            e.getMessage();
        }
        return countPict;
    }
    public void cleanSheetImages(String sheetImages) {

        try {
            Workbook workbook = new Workbook();
            //Load an Excel file
            workbook.loadFromFile(pthFileValidation);
            Worksheet sheet = workbook.getWorksheets().get(sheetImages);

            for (int i = sheet.getPictures().getCount() - 1; i >= 0; i--) {

                //Delete an image by its index
                sheet.getPictures().get(i).remove();
            }

            for (int i = sheet.getLastRow(); i >= 1; i--)
            {
                //Detect if a row is blank
//                if (sheet.getRows()[i-1].isBlank())
                {
                    //Remove blank row
                    sheet.deleteRow(i);
                }
            }

            workbook.save();

        } catch (Exception e) {
            e.getMessage();
        }
    }
}
