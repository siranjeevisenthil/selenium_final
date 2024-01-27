package Testpractice1_maven.Testpractice1_maven.absract;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Testpractice1_maven.Testpractice1_maven.Cartpage;
public class Abstract {
	WebDriver driver;
	public Abstract(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;
	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));

	}
	
	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));

	}
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
     	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	   // wait.until(ExpectedConditions.invisibilityOf(ele));

	}
	public Cartpage goToCartPage()
	{
		cartHeader.click();
		Cartpage cartPage = new Cartpage(driver);
		return cartPage;
	}
	
//	public OrderPage goToOrdersPage()
	{
	//	orderHeader.click();
	///-	OrderPage orderPage = new OrderPage(driver);
	//	return orderPage;
	}
	


}