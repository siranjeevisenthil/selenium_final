package Testpractice1_maven.Testpractice1_maven;

import Testpractice1_maven.Testpractice1_maven.absract.*;

import Testpractice1_maven.data.*;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.*;

import org.testng.Assert;
import org.testng.annotations.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.*;
import java.util.Map;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Test1 extends BaseTest{


	
      @Test(dataProvider="getdata")
	  public void submitordertest (HashMap<String,String>input) throws InterruptedException, IOException {
		String ProductName ;
		String cntr="india";
	
		WebDriver driver=initializedriver();
		LandingPage lp=new LandingPage(driver);
		  lp.login();
	      Catalogue cl= lp.loginApplication(input.get("email"), input.get("Password"));
	      cl.addProductToCart(input.get("ProductName"));
	      Cartpage cart= cl.goToCartPage();
	     Boolean as=  cart.VerifyProductDisplay(input.get("ProductName"));
	       Assert.assertTrue(as);
	     CheckoutPage checkout= cart.goToCheckout();
	     checkout.selectCountry( cntr);
	     ConfirmationPage confirm=checkout.submitOrder();
	     String confmsg=confirm.getConfirmationMessage();
	    
	   

	
	}
      
      @Test
	  public void submitordertest2 () throws InterruptedException, IOException {
		
		String cntr="india";
	
		WebDriver driver=initializedriver();
		LandingPage lp=new LandingPage(driver);
		  lp.login();
	      Catalogue cl= lp.loginApplication("anshika@gmail.com", "Iamking@000");
	      cl.addProductToCart("ZARA COAT 3");
	      Cartpage cart= cl.goToCartPage();
	     Boolean as=  cart.VerifyProductDisplay("ZARA COAT 3");
	       Assert.assertTrue(as);
	     CheckoutPage checkout= cart.goToCheckout();
	     checkout.selectCountry( cntr);
	     ConfirmationPage confirm=checkout.submitOrder();
	     String confmsg=confirm.getConfirmationMessage();
	   // Assert.assertTrue(confmsg.contains("THANKYOU FOR THE ORDER"));  

	
	}
      
    @DataProvider
      public Object[][] getdata()  {
			
		    	HashMap<String,String> a =new HashMap<String,String>();
			   a.put("email", "siranjeevisenthil.r@gmail.com"); 
			   a.put("Password", "Senthilw@1");
			   a.put("ProductName","ZARA COAT 3" ); 
			   HashMap<String,String> a1 =new
			   HashMap<String,String>();
			   a1.put("email", "anshika@gmail.com");
			 a1.put("Password", "Iamking@000"); 
			 a1.put("ProductName","ZARA COAT 3" );
			/* Datareader data=new Datareader(); 
			 List<HashMap<String,String>> data1=
			 data.getjsondata(); */
			 
			 return new Object[][] {{a},{a1}};
			 
    	  
      }

}
