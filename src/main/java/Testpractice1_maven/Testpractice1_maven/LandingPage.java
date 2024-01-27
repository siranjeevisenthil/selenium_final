package Testpractice1_maven.Testpractice1_maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testpractice1_maven.Testpractice1_maven.absract.Abstract;

public class LandingPage extends Abstract {
	 WebDriver driver;
   
    
public LandingPage(WebDriver driver) {
	    super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(id="userEmail")
WebElement userEmail;

@FindBy(id="userPassword")
WebElement password ;

@FindBy(id="login")
WebElement login ;

public  Catalogue loginApplication(String Email,String Password) {
	userEmail.sendKeys(Email);
	password.sendKeys(Password);
	login.click();
	 Catalogue cl=new Catalogue(driver);
	 return cl;
}

public void login() {
	driver.get("https://rahulshettyacademy.com/client");
}
}
