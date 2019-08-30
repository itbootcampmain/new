package phptravel;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoPage {

	

	static WebDriver driver;
	
	public DemoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Elements
	
	private static List<WebElement> elementBox() {
		return driver.findElements(By.cssSelector("div.resource-box"));
	}
	
	private static List<WebElement> elementButtons() {
		return driver.findElements(By.cssSelector("div.resource-box div.col-md-6 a"));
	}
	
		
	// Actions 
	
	public void clickBox(Integer index) {
		elementButtons().get(index).click();
		
	}
	
	public String clickBoxText(Integer index) {
		return elementButtons().get(index).getText();
		
	}
	
	
	public String getChildWindowUrl() {
        Set<String> window = driver.getWindowHandles();
        Iterator iterator = window.iterator();
        String currentWindowId = null;
        String mainPage = driver.getWindowHandle();
        while(iterator.hasNext()){
            currentWindowId = iterator.next().toString();

            // Takes the url from child window
            if (!currentWindowId.equals(mainPage)){
                driver.switchTo().window(currentWindowId);
            }
        }
        return driver.getCurrentUrl();

    }
	
}
