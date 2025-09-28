from selenium.webdriver.common.by import By
from pages.base_page import BasePage

class CartPage(BasePage):
    CART_TEXT = (By.XPATH, "//span[contains(text(),'My Cart') or contains(text(),'Place Order')]")

    def verify_item_added(self):
        return self.is_visible(self.CART_TEXT)
