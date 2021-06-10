package StepDefinitions;

import org.testng.annotations.DataProvider;
//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/Features", glue = { "StepDefinitions" }, monochrome = true, plugin = {
				"pretty" })
//TestNG
public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true) //parallel test flag
	public Object[][] scenarios() {
		return super.scenarios();

	}
}
