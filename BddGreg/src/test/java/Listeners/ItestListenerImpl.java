package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.model.ScreenCapture;

import Utility.Log;

//methods for TestNG Listeners for ExtentReport

public class ItestListenerImpl extends ExtentReportListener implements ITestListener{
	
	
	private static ExtentReports extent;

	public void onTestStart(ITestResult result) {
		
		
	}
	
	
	
	
	public void onTestSuccess(ITestResult result) {
		Log.info("Gherkin Step Passed");
		
	}
	
	
	public void onTestFailure(ITestResult result) {
		Log.info("FAILED");
		
		
		
		
		
	}
	

	public void onTestSkipped(ITestResult result) {
	
		Log.info("SKIP");
		
	}
	
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	
	public void onStart(ITestContext context) {
		Log.info("Execution started..");
		extent = setUp();
	}
	
	
	public void onFinish(ITestContext context) {
		Log.info("Execution completed..");
		extent.flush();
		Log.info("generate report");
		
	}
	
	
	
	
	

}
