from selenium.webdriver.common.by import By
from pages.base_page import BasePage

class HomePage(BasePage):
    CLOSE_LOGIN_POPUP = (By.XPATH, "//button[contains(text(),'✕')]")
    SEARCH_BOX = (By.NAME, "q")

    def close_login_popup(self):
        try:
            self.click(self.CLOSE_LOGIN_POPUP)
        except:
            pass  # Popup not shown

    def search_product(self, product_name):
        self.enter_text(self.SEARCH_BOX, product_name + '\n')

    def verify_title_contains_flipkart(self):
        return "flipkart" in self.get_title().lower()
