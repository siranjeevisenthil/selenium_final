package Testpractice1_maven.Testpractice1_maven;

import java.io.File;
import java.util.*;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.Writable;

public class Listener extends BaseTest implements ITestListener{

	
	
	ExtentTest test;
	ExtentReports report;
	ThreadLocal<ExtentTest> local=new ThreadLocal<>();
	
	@Override
	public void onTestStart(ITestResult result) {
	report= extentreport();
	test=	report.createTest(result.getMethod().getMethodName());
	local.set(test);
	
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	local.get().log(Status.PASS, "passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	local.get().fail(result.getThrowable());
	try {
		driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		String path=Screenshot(result.getMethod().getMethodName(),driver);
		test.addScreenCaptureFromPath("./"+result.getMethod().getMethodName()+".png",result.getMethod().getMethodName() );
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		 
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		ITestListener.super.onFinish(context);
	}

}
