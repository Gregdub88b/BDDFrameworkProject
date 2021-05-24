package StepDefinitions;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "src/test/resources/Features",
		
		glue = {"StepDefinitions"},
		
		monochrome = true,
		
		//tags="@3Shools",
		
		plugin = { "pretty"}  
)
		
public class TestRunner {

	
	@BeforeClass
	public static void test()
	{

	//ExtentReportListener report = new ExtentReportListener();
	//ExtentReports extent = ExtentReportListener.setUp();
	}
	
}
