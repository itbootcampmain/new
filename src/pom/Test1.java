package phptravel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class POMTest {

	public static final String SEARCH_TERM = "java";

	
	WebDriver driver;

	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell\\Desktop\\selenium\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void youTubeTest() throws Exception{
		
		driver.navigate().to(PageURLs.YT_MAIN_PAGE);
		new YouTubeHomePage(driver).sendTextToSearch(SEARCH_TERM);
		//Thread.sleep(3000);
		new YouTubeHomePage(driver).clickOnSearchButton();
		new YouTubeSearchResultsPage(driver).clickFilterButton();
		new YouTubeSearchResultsPage(driver).clickFirstFilter();
		//new YouTubeSearchResultsPage(driver).clickFirstElement();
		String string = new YouTubeSearchResultsPage(driver).getFirstElementText();
		System.out.println(string);
		Assert.assertTrue(string.toLowerCase().contains(SEARCH_TERM));

		driver.close();
	}
	
	
}
