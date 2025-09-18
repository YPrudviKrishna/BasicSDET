package MavenDefaultProject;

	
	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	public class RequestDemoPageTest  {
		
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
		public void requestdemoPageLabelsTest()
		{
	        try {
			Thread.sleep(2000);
	        WebElement requestDemoButton = driver.findElement(By.xpath("//div[@class='coh-container utility-navbtn']/a[@title='Request Demo']"));
	        requestDemoButton.click();
	       
	        String expectedUrl = "https://www.automationanywhere.com/request-live-demo";
	        String actualUrl = driver.getCurrentUrl();      
	        Assert.assertEquals(actualUrl, expectedUrl,"URL  not matched");        
	        Thread.sleep(2000);   
	        
	        String actualfirstNameLabel = driver.findElement(By.xpath("//label[contains(text(),'First Name')]")).getText();      
	        String actuallastNameLabel = driver.findElement(By.xpath("//label[contains(text(),'Last Name')]")).getText();             
	        String ExpectedfirstNameLabel= "*First Name";
	        String ExpectedLastNameLabel= "*Last Name"; 
	        		      		
	        Assert.assertEquals(actualfirstNameLabel, ExpectedfirstNameLabel,"FirstName label  not matched");
	        Assert.assertEquals(actuallastNameLabel, ExpectedLastNameLabel,"LastName label  not matched");
	       
	        }
	        catch(Exception e) {		
	    		e.printStackTrace();
	    		}
	    		finally {  
	    			driver.close();
	    	        
	    		} 
	               
		}
		
		@AfterClass
		public void teardown()
		{   
			if (driver != null) {
				driver.quit();
				}			
		}
}
