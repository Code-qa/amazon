package amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
private final WebDriver driver ;
private final WebDriverWait wait ;

private By searchBox=By.id("twotabsearchtextbox");
private By submitBtn=By.id("nav-search-submit-button");


public HomePage(final WebDriver driver,final WebDriverWait wait) {
	this.driver=driver;
	this.wait=wait;
}

public WebElement searchBoxEle() {
	WebElement ele=null;
	try {
		ele =wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
		
	}catch(final NoSuchElementException e) {
		e.printStackTrace();
	}
	return ele;
}

public WebElement submitBtnEle() {
	WebElement ele=null;
	try {
		ele =wait.until(ExpectedConditions.visibilityOfElementLocated(submitBtn));
		
	}catch(final NoSuchElementException e) {
		e.printStackTrace();
	}
	return ele;
}

	public void enterSearchtext(String searchString) {
		searchBoxEle().sendKeys(searchString);
	}
	
	public void submitSearchBtn() {
		submitBtnEle().click();
	}

}
