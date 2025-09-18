package Selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class automationanywhereTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDriver\\geckodriver-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();  
		
		try {
         driver.get("https://www.automationanywhere.com/");      
         driver.manage().window().maximize();
         
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         WebElement AcceptCookieButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Accept All Cookies']")));
         AcceptCookieButton.click(); 
         
         WebElement ProductsLinkText = driver.findElement(By.xpath("//a[text()='Products']"));        
         Actions actions = new Actions(driver);
         actions.moveToElement(ProductsLinkText).perform();
         
         WebElement processDiscoveryOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Process Discovery']")));  
         processDiscoveryOption.click();
         
         String expectedUrl = "https://www.automationanywhere.com/products/process-discovery";
         String actualUrl = driver.getCurrentUrl();
             
         if (actualUrl.equals(expectedUrl)) {
                 System.out.println("Test Passed: Navigated to the correct page, Actual Page Title is - "+ actualUrl);
             } else {
                 System.out.println("Test Failed: Expected URL: " + expectedUrl + " but got: " + actualUrl);
             }
             driver.close();
		} 
		catch(Exception e) {		
		e.printStackTrace();
		}
		finally {      
         driver.quit();
		}    		
	}


}
