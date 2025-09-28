package SeleniumTestNG.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
private WebDriver driver;
    
    private By closeLoginPopupBtn = By.xpath("//button[contains(text(),'✕')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void closeLoginPopupIfPresent() {
        try {
            WebElement closeBtn = driver.findElement(closeLoginPopupBtn);
            if (closeBtn.isDisplayed()) {
                closeBtn.click();
            }
        } catch (Exception e) {
            // Popup not displayed, no action needed
        }
    }

}
