package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-report/cucumber.html",
                "json:target/cucumber-report/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = "@dataDummy",
        features = {"src/test/resources/Features/dataDummy.feature"},
        glue = {"definitions"}
)

public class GenerateData extends AbstractTestNGCucumberTests {
}
