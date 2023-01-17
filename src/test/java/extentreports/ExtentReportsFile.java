package extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import testData.ReadTestData;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportsFile {
    static ReadTestData readTestData = new ReadTestData();
    static ExtentReports extent;
    public static ExtentReports report() {
        if(extent == null) {
            String pattern = "HHmmss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String fdate = simpleDateFormat.format(new Date());

            readTestData.testData();
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./test-output/Selenix-Spark/AT-Report_Chanelling_BadanUsaha_" + fdate + ".html")
                    .viewConfigurer()
                    .viewOrder()
                    .as(new ViewName[]{
                            ViewName.DASHBOARD,
                            ViewName.TEST,
                            ViewName.AUTHOR,
                            ViewName.DEVICE,
                            ViewName.EXCEPTION,
                            ViewName.LOG
                    })
                    .apply();
            sparkReporter.config().enableOfflineMode(true);
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setDocumentTitle("Badan Usaha : "+ readTestData.namaDebitur);
            sparkReporter.config().setReportName("Extent Report Channeling");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }
}
