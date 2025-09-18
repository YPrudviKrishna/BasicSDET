package AutomationAnyWhereURL;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductDiscoveryPageTest {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void launchHomepage()
	{				
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver-win32\\chromedriver.exe");
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(options);
         driver.get("https://www.automationanywhere.com/");      
         driver.manage().window().maximize();
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         WebElement AcceptCookieButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Accept All Cookies']")));
         AcceptCookieButton.click(); 
	}
	
	@Test
	public void productDiscoveryPageTitleTest()
	{       
        WebElement ProductsLinkText = driver.findElement(By.xpath("//a[text()='Products']"));        
        Actions actions = new Actions(driver);
        actions.moveToElement(ProductsLinkText).perform();
        
        WebElement processDiscoveryOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Process Discovery']")));  
        processDiscoveryOption.click();
        
        String expectedUrl = "https://www.automationanywhere.com/products/process-discovery";
        String actualUrl = driver.getCurrentUrl();       
        Assert.assertEquals(actualUrl, expectedUrl,"Title page not matched");
        driver.close();      		
	}
	
	@AfterClass
	public void teardown()
	{   
		if (driver != null) {
			driver.quit();
			}				
	}		

}
