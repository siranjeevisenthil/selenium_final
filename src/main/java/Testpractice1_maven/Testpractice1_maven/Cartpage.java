package Testpractice1_maven.Testpractice1_maven;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testpractice1_maven.Testpractice1_maven.absract.*;


public class Cartpage extends Abstract {
	WebDriver driver;

	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;

	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProducts;

	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public Boolean VerifyProductDisplay(String productName) {
		Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		System.out.println(cartProducts.stream().filter(product -> product.getText().equals(productName)));
		return match;

	}

	public CheckoutPage goToCheckout() {
		checkoutEle.click();
		return new CheckoutPage(driver);
		

	}

}
