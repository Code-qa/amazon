package amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

	private final WebDriver driver;
	private final WebDriverWait wait;

	private By price = By.xpath("//span[@class=\"a-color-price\"]");

	public CheckoutPage(final WebDriver driver, final WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	
	public WebElement priceEle() {
		WebElement ele = null;
		try {
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(price));

		} catch (final NoSuchElementException e) {
			e.printStackTrace();
		}
		return ele;
	}

	public String getPriceText() {
		return priceEle().getText();

	}

}
