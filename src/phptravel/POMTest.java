package phptravel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class POMTest {

	private static final String URL_PART = "admin"; 
	
	WebDriver driver;
	
	String pattern = "[^/]+$";
	Pattern compiled = Pattern.compile(pattern);
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell\\Desktop\\selenium\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	public WebDriverWait waiter() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		return wait;
	}
	
	public void elementClickable(WebElement element) {
		waiter().until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public void waitPageLoaded() {
		ExpectedCondition<Boolean> pageLoaded = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		try {
			System.out.println("Waiting page to be loaded");
			waiter().until(pageLoaded);
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
//	public void createUser() {
//		korak1;
//		korak2;
//		elementClickable(element);
//	
//	}
	
	
	@Test
	public void demoTest() throws Exception{
		
		driver.navigate().to(PageURLs.DEMO_PAGE);
		new DemoPage(driver).clickBox(1);
		String temp = new DemoPage(driver).clickBoxText(1);
		
		
		
		Matcher match = compiled.matcher(temp);

		while(match.find()) {
	         Assert.assertEquals(temp.substring(match.start(), match.end()), "ADMIN");
	      }
		Thread.sleep(7000);
		String childURL = new DemoPage(driver).getChildWindowUrl();
		Assert.assertTrue(childURL.contains(URL_PART));
	}
	
	
}
