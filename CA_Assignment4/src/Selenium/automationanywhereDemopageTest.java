package Selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class automationanywhereDemopageTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDriver\\geckodriver-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();  
		
		try {
         driver.get("https://www.automationanywhere.com/");      
         driver.manage().window().maximize();
         
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
         WebElement AcceptCookieButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Accept All Cookies']")));
         AcceptCookieButton.click();
         
         Thread.sleep(2000);
         WebElement requestDemoButton = driver.findElement(By.xpath("//div[@class='coh-container utility-navbtn']/a[@title='Request Demo']"));
         requestDemoButton.click();
        
         String expectedUrl = "https://www.automationanywhere.com/request-live-demo";
         String actualUrl = driver.getCurrentUrl();

         if (actualUrl.equals(expectedUrl)) {
             System.out.println("Navigated to correct URL: " + actualUrl);
         } else {
             System.out.println("Incorrect URL. Found: " + actualUrl);
         }
         
         Thread.sleep(2000);       
         WebElement firstNameLabel = driver.findElement(By.xpath("//label[contains(text(),'First Name')]"));      
         WebElement lastNameLabel = driver.findElement(By.xpath("//label[contains(text(),'Last Name')]"));
               

         if (firstNameLabel.isDisplayed() && firstNameLabel.getText().trim().equals("*First Name")) {
             System.out.println("First Name label is correct and the labelname is:" +firstNameLabel.getText());
         } else {
             System.out.println("First Name label not found or incorrect." +firstNameLabel.getText());
         }

         if (lastNameLabel.isDisplayed() && lastNameLabel.getText().trim().equals("*Last Name")) {
             System.out.println("Last Name label is correct and the labelname is:"+lastNameLabel.getText());
         } else {
             System.out.println("Last Name label not found or incorrect."+lastNameLabel.getText());
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
