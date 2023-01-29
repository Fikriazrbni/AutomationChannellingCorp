package runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import createDataCSV.DataCSV;
import elementsPage.Const;
import io.cucumber.testng.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import jobs.DummyAppForm_BU;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import writeFile.MoveFileScenario;
import writeFile.TempImages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static extentreports.ExtentReportsFile.report;


@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-report/cucumber.html",
                "json:target/cucumber-report/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = "@approvalForm",
        features = {"src/test/resources/Features/approvalFormBU.feature"},
        glue = {"definitions"}
)

public class FormApprovalRunner extends AbstractTestNGCucumberTests {
    public static WebDriver driver;
    private TestNGCucumberRunner testNGCucumberRunner;
    public static ExtentReports extent;
    public static ExtentTest extent_test_case;

    @BeforeTest
    public void setExtentReport(){
        extent = report();
    }
    @BeforeMethod
    public void cleanImages() throws IOException {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

        MoveFileScenario cleanImagesFolder = new MoveFileScenario();
        cleanImagesFolder.deletePNG();

        System.out.println("================Clean Success================");

        MoveFileScenario moveFileScenario = new MoveFileScenario();
        moveFileScenario.dltDummyExist();
        DataCSV dataCSV = new DataCSV();
        dataCSV.dataDummy(Const.appFile, Const.reaFile, "10");
        DummyAppForm_BU connServer = new DummyAppForm_BU();
        connServer.serverAkses();

        WebDriverManager.edgedriver().setup();
        //driver = new EdgeDriver();
        EdgeOptions options = new EdgeOptions();
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), options); //"http://10.121.21.25:4444
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test(groups = "cucumber", description = "Runs Approval Form Scenarios", dataProvider = "scenarios")
    public void runScenarioAppForm(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }
    @AfterMethod
    public void close(){
//        driver.quit();
        extent.flush();
    }
}