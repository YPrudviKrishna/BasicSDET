package SeleniumTestNG.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
public class BaseTest {
	public static WebDriver driver;
	public static String baseUrl;

    @BeforeSuite
    public void setUpSuite() {
    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("force-device-scale-factor=1.0");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.flipkart.com/");      
        driver.manage().window().maximize();       
    }


    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
