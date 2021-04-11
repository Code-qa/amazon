package amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {

private final WebDriver driver ;
private final WebDriverWait wait ;

private By firstSearchResult=By.xpath("//span[@data-component-id='1']/following-sibling::div/h2");
private By firstSearchResultPrice=By.xpath("//span[@data-component-id='1']/following-sibling::div[3]//span[@class='a-price']");

public ResultsPage(final WebDriver driver,final WebDriverWait wait) {
	this.driver=driver;
	this.wait=wait;
}

public WebElement firstSearchResultEle() {
	WebElement ele=null;
	try {
		ele =wait.until(ExpectedConditions.visibilityOfElementLocated(firstSearchResult));
		
	}catch(final NoSuchElementException e) {
		e.printStackTrace();
	}
	return ele;
}
	
public WebElement firstSearchResultPriceEle() {
	WebElement ele=null;
	try {
		ele =wait.until(ExpectedConditions.visibilityOfElementLocated(firstSearchResultPrice));
		
	}catch(final NoSuchElementException e) {
		e.printStackTrace();
	}
	return ele;
}
	
	public void clickFirstSearchResult() {
		firstSearchResultEle().click();
	}
	
	public String getFirstSearchResultPriceText() {
		return firstSearchResultPriceEle().getText();
		
	}

}
