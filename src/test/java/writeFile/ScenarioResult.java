package writeFile;

import com.spire.xls.Chart;
import com.spire.xls.ExcelChartType;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;
import com.spire.xls.charts.ChartSerie;
import elementsPage.Const;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScenarioResult {
    String pattern = Const.pPattern;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    String date = simpleDateFormat.format(new Date());

    private  String pthTempScenario = Const.pthFileValidation + Const.fileNMScenario;
    private String pthFileScenaio = Const.pthResultScenario + Const.nameFileScenario + date + Const.extExcel;

    public void scenarioFile(){

        try {
            FileSystem system = FileSystems.getDefault();
            Path original = system.getPath(pthTempScenario);
            Path target = system.getPath(pthFileScenaio);
            Files.copy(original, target);

        } catch (IOException ex) {
            System.out.println();
        }
    }

    public void percentages() {
        //Import an Excel document
        try {

            Workbook workbook = new Workbook();
            workbook.loadFromFile(pthTempScenario);

            //Get the first worksheet
            Worksheet sheet = workbook.getWorksheets().get(Const.scSheetPercentages);
            Chart chart = sheet.getCharts().add(ExcelChartType.ColumnStacked);

            //Set data range of chart
            chart.setDataRange(sheet.getCellRange("D3:D4")); // nilai persentase
            chart.setSeriesDataFromRange(false);

            //Set position of the chart
            chart.setLeftColumn(1); // start kolom posisi PIE cahrt
            chart.setTopRow(7); // start baris PIE chart
            chart.setRightColumn(11);
            chart.setBottomRow(20);

            //Set chart title
            chart.setChartTitle(Const.chartTitleB);
            chart.getChartTitleArea().isBold(true);
            chart.getChartTitleArea().setSize(14);

            //Set series data label
            ChartSerie cs = chart.getSeries().get(0);
            cs.setCategoryLabels(sheet.getCellRange("A3:A4")); // nama scenario
            cs.setValues(sheet.getCellRange("D3:D4")); // nilai persentase
            cs.getDataPoints().getDefaultDataPoint().getDataLabels().hasValue(true);
            chart.getPlotArea().getFill().setVisible(false);

            //Save the document
            workbook.save();
        }catch (Exception e){
            e.getCause();
        }

    }
}
