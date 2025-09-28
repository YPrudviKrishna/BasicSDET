package SeleniumTestNG.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private WebDriver driver;

    private By flipkartLogo = By.xpath("//img[@title='Flipkart']");
    private By searchBox = By.name("q");
    private By searchButton = By.xpath("//button[@type='submit']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isFlipkartLogoPresent() {
        try {
            WebElement logo = driver.findElement(flipkartLogo);
            return logo.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void enterSearchText(String text) {
        driver.findElement(searchBox).sendKeys(text);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void searchForItem(String item) {
        enterSearchText(item);
        clickSearchButton();
    }

}
