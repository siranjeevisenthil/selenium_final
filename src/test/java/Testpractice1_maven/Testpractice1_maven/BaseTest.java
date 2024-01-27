package Testpractice1_maven.Testpractice1_maven;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.TakesScreenshot;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import Testpractice1_maven.Testpractice1_maven.LandingPage;


public class BaseTest {
	public 	 WebDriver driver =null;
	public WebDriver  initializedriver() throws IOException {

		/*
		 * Properties prop=new Properties(); FileInputStream fi=new
		 * FileInputStream("C:\\Users\\91753\\Documents\\My java\\Testpractice1_maven");
		 * prop.load(fi); String browser=prop.getProperty("browser");
		 * if(browser.equalsIgnoreCase("chrome")) { driver=new ChromeDriver();
		 * 
		 * } else if(browser.equalsIgnoreCase("Firefox")) { driver=new FirefoxDriver();
		 * }
		 */
	    WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
	    return driver;
		}
	
	public String Screenshot(String Testname,WebDriver driver ) throws IOException {
		   TakesScreenshot ts=(TakesScreenshot)driver;
		   File source=  ts.getScreenshotAs(OutputType.FILE);
		  File f=new File("C:\\Users\\91753\\Documents\\My java\\Testpractice1_maven\\reports\\"+Testname+".png");
			FileUtils.copyFile(source, f);
			return "C:\\Users\\91753\\Documents\\My java\\Testpractice1_maven\\reports\\"+Testname+".png";
		
	}
	
public ExtentReports extentreport()
	
	{
	String path=	System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter s=new ExtentSparkReporter(path);
	s.config().setReportName("web automation result");
	s.config().setDocumentTitle("Siranjeevitesting");
	ExtentReports r=new ExtentReports();
	r.attachReporter(s);
	r.setSystemInfo("Tester", "Siranjeevi");
	return r;

	}
	



	}


