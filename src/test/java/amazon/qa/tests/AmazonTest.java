package amazon.qa.tests;

import amazon.qa.pages.HomePage;
import amazon.qa.pages.ProductPage;
import amazon.qa.pages.ResultsPage;
import amazon.qa.pages.CheckoutPage;
import amazon.qa.pages.CartPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonTest {
	WebDriver driver;
	WebDriverWait wait;
	HomePage hp;
	ResultsPage rs;
	ProductPage pp;
	CartPage cp;
	CheckoutPage check;
	String searchString = "qa testing for beginners";
	String resultPagePrice;
	String ProductPagePrice;
	String CartPagePrice;
	String CheckoutPagePrice;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C://Users//vloke//Downloads//chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10000);
		driver.get("https://www.amazon.com");
		hp = new HomePage(driver, wait);
		rs = new ResultsPage(driver, wait);
		pp = new ProductPage(driver, wait);
		cp = new CartPage(driver, wait);
		check= new CheckoutPage(driver,wait);
	}

	@Test(groups = { "amazon" }, description = "Test search functionality")
	public void verifyPricesMatchBetweenPages() {
		hp.enterSearchtext(searchString);
		hp.submitSearchBtn();
		resultPagePrice = rs.getFirstSearchResultPriceText();
		rs.clickFirstSearchResult();
		ProductPagePrice = pp.getPriceText();
		Assert.assertEquals(resultPagePrice, ProductPagePrice,
				"hmm. price between results and product page does not match. possible bug");
		pp.addToCartEle();
		CartPagePrice = cp.getPriceText();
		Assert.assertEquals(resultPagePrice, CartPagePrice,
				"hmm. price between results and cart page does not match. possible bug");
		cp.clickProceedCheckoutBtn();
		CheckoutPagePrice=check.getPriceText();
		Assert.assertEquals(resultPagePrice, CheckoutPagePrice,
				"hmm. price between results and checkout page does not match. possible bug");
		
	}
}
