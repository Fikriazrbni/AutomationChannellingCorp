package runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import elementsPage.ApprovalFormPage;
import io.cucumber.testng.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import jobs.DummyReaForm_BU;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
        tags = "@realizationForm",
        features = {"src/test/resources/Features/realizationFormBU.feature"},
        glue = {"definitions"}
)

public class FormRealizationRunner extends AbstractTestNGCucumberTests {

    public static WebDriver driver;
    private TestNGCucumberRunner testNGCucumberRunner;
    public static ExtentReports extent;
    public static ExtentTest extent_test_case;
    ApprovalFormPage appFile = new ApprovalFormPage();

    @BeforeTest
    public void setExtentReport(){
        extent = report();
    }
    @BeforeMethod
    public void cleanImages() throws IOException, InterruptedException {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

//        DummyReaForm_BU connServer = new DummyReaForm_BU();
//        connServer.serverAkses();

        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(options);
//        try {
//            driver = new RemoteWebDriver(new URL("http://localhost:4444"), options); //
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test(groups = "cucumber", description = "Runs Realization Form Scenarios", dataProvider = "scenarios")
    public void runScenarioReaForm(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }
    @AfterMethod
    public void close(){
        extent.flush();
    }
}