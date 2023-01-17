package writeFile;

import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;
import elementsPage.Const;

public class CountImages {
    private String pthFileValidation = Const.pthFileValidation + Const.fileNMScenario;

    public int getIndexImages() {

        int countPict = 0;
        try {
            Workbook workbook = new Workbook();
            //Load an Excel file
            workbook.loadFromFile(pthFileValidation);
            Worksheet sheet = workbook.getWorksheets().get(Const.sheetImages);
            countPict = sheet.getPictures().getCount();


            workbook.save();

        } catch (Exception e) {
            e.getMessage();
        }
        return countPict;
    }
}
