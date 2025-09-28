package SeleniumTestNG.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	private WebDriver driver;
	WebDriverWait wait;
	WebElement firstElement; 

    private By cartItem = By.xpath("//a[contains(@class, 'T2CNXf QqLTQ-')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
      
    }
    public String CartItemName() {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(cartItem)); 
    	//Added logic to pick most recently added cart item
    	List<WebElement> elements = driver.findElements(cartItem);
        if (!elements.isEmpty()) {
             firstElement = elements.get(0);
             return firstElement.getText();
        } else {
        	System.out.println("Item not added to Cart");
            return null;
        }
    
  
    }

}
