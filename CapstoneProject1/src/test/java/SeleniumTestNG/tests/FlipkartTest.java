package SeleniumTestNG.tests;

import SeleniumTestNG.Base.BaseTest;
import SeleniumTestNG.Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;



public class FlipkartTest extends BaseTest {
	
	
	private LoginPage loginPage;
	private HomePage homePage;
	private SearchResultsPage resultsPage;
	private ProductPage productPage;
	private CartPage cartPage;	
    String firstItemName;
    String itemNameAddedtoCart;
    String mainWindowHandle;
	
	
	 @Test
	    public void CloseLoginPopup()
	    {
	        loginPage = new LoginPage(driver);
	        loginPage.closeLoginPopupIfPresent();
	    }
	 @Test
	 public void verifyFlipkartLogo()  {
	        

	        homePage = new HomePage(driver);
	        Assert.assertTrue(homePage.isFlipkartLogoPresent(), "Flipkart logo is not present.");
	 }
	 @Test
	 public void searchItem() throws InterruptedException  {

	        homePage.searchForItem("Macbook air m2");
	        Thread.sleep(3000);
	 }
	 @Test
	 public void ClickFirstItem()  {

	         resultsPage = new SearchResultsPage(driver);
	        
	        // Open first item in new tab because Flipkart opens product in a new tab
	        //String mainWindowHandle = driver.getWindowHandle();
	        firstItemName = resultsPage.FirstItemName();
	        System.out.println("First Displayed item :- "+firstItemName);
	        resultsPage.clickFirstItem();
	 }
	 @Test
	 public void AddToCart() throws InterruptedException  {
	 
	        
	        // Switch to new tab opened
	        mainWindowHandle = driver.getWindowHandle();
	        for (String handle : driver.getWindowHandles()) {
	            if (!handle.equals(mainWindowHandle)) {
	                driver.switchTo().window(handle);
	                break;
	            }
	        }

	        productPage = new ProductPage(driver);
	        productPage.clickAddToCart();
	        // Wait for cart update
	        Thread.sleep(6000);
	 }
	 @Test
	 public void VerifyItemAddedtoCart()  {

	       
	        cartPage = new CartPage(driver);
	        itemNameAddedtoCart = cartPage.CartItemName();
	        System.out.println("Item Added to Cart :- "+itemNameAddedtoCart);
	        Assert.assertEquals(itemNameAddedtoCart, firstItemName,"Item not added to cart ");
	        
	        // Close the product tab and switch back
	        driver.close();
	        driver.switchTo().window(mainWindowHandle);
	    }

}
