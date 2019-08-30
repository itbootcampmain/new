package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YouTubeSearchResultsPage {

	
	static WebDriver driver;
	
	public YouTubeSearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Elements
	
	private static List<WebElement> searchVideos() {
		return driver.findElements(By.cssSelector("div#dismissable"));
	}
	
	private static WebElement filterButton() {
		return driver.findElement(By.cssSelector("yt-icon.style-scope.ytd-toggle-button-renderer"));
	}
	
	private static List<WebElement> filterList() {
		return driver.findElements(By.cssSelector("yt-formatted-string.style-scope.ytd-search-filter-renderer"));
	}
	
	// Actions 
	
	public List<WebElement> getSearchVideos() {
		return searchVideos();
	}
	
	public List<WebElement> getFilterList() {
		return filterList();
	}
	
	public void clickFirstElement() {
		getSearchVideos().get(0).click();
	}
	
	public void clickFirstFilter() {
		getFilterList().get(0).click();
	}
	
	public void clickFilterButton() {
		filterButton().click();
	}
	
	public String getFirstElementText() {
		return getSearchVideos().get(0).getText();
	}
	

}
