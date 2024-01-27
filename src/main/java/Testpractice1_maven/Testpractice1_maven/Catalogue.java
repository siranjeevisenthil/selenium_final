package Testpractice1_maven.Testpractice1_maven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testpractice1_maven.Testpractice1_maven.absract.Abstract;

public class Catalogue extends Abstract{

	
	 WebDriver driver;
	   
	    
public Catalogue(WebDriver driver) {
     	super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(css = ".mb-3")
List<WebElement> products;

@FindBy(css = ".ng-animating")
WebElement spinner;

By productsBy = By.cssSelector(".mb-3");
By addToCart = By.cssSelector(".card-body button:last-of-type");
By toastMessage = By.cssSelector("#toast-container");

public List<WebElement> getProductList() {
	waitForElementToAppear(productsBy);
	return products;
}

public WebElement getProductByName( String str) {
	
	WebElement prod =	getProductList().stream().filter(product->
	product.findElement(By.cssSelector("b")).getText().equals(str)).findFirst().orElse(null);
	return prod;
}
public void addProductToCart(String productName) throws InterruptedException
{
	WebElement prod = getProductByName(productName);
	prod.findElement(addToCart).click();
	waitForElementToAppear(toastMessage);
	waitForElementToDisappear(spinner);
	 


}

}









