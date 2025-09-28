package SeleniumTestNG.Pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
	private WebDriver driver;
	WebElement firstElement; 

    private By firstItem = By.xpath("//div[contains(@class, 'KzDlHZ')]");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }
    public String FirstItemName() {
    	//Added logic to pick first item displayed on the screen
    	List<WebElement> elements = driver.findElements(firstItem);
        if (!elements.isEmpty()) {
             firstElement = elements.get(0);
             return firstElement.getText();
        } else {
        	System.out.println("Element Not found!");
            return null;
        }
    }

    public void clickFirstItem() { 	
    	firstElement.click();
    	
    }
    

}
