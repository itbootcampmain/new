package phptravel;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WaitFluent {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Dell\\Desktop\\selenium\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	public WebDriverWait waiter() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		return wait;
	}
	
	public void elementVisible(By locator) {
		waiter().until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	@Test(dataProviderClass = Helper.class, dataProvider = "LoginData")
	public void moderatorUser(String username, String password) {
		driver.get("https://www.phptravels.net/admin");
		
		klik
		otovorile se reklame
		
		Set<String> list = driver.getWindowHandles();
		String mainWindow;
		for (String tab : list) {
			driver.switchTo().window(tab);
			if (driver.getCurrentUrl().contains("homeUrl") || driver.getCurrentUrl().contains("second")) {
				mainWindow = tab;
			} else {
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		
		String list1 = driver.getWindowHandle();
		
		elementVisible(By.cssSelector("input[name=\"email\"]"));
		
		driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys(username);
		driver.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys(password);
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	}

}
