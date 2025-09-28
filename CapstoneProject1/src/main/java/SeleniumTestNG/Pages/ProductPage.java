package SeleniumTestNG.Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	private WebDriver driver;

    private By addToCartButton = By.xpath("//button[contains(text(),'Add to cart')]");
    private By goToCartButton = By.xpath("//button[contains(text(),'GO TO CART')]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    
    public void clickAddToCart() throws InterruptedException {
    	Thread.sleep(6000);
        driver.findElement(addToCartButton).click();
        Thread.sleep(6000);
        if(driver.findElement(addToCartButton).isDisplayed()) {   	
        String Cartbutton=driver.findElement(addToCartButton).getText();
        if(Cartbutton.equals("ADD TO CART")||Cartbutton.equals("Going to cart"))
        {
        	driver.navigate().refresh();
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        	wait.until(ExpectedConditions.visibilityOfElementLocated(goToCartButton)).click();
        	Thread.sleep(6000);
        	      	
        }
        }
        
    }

}
