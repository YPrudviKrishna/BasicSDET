from selenium.webdriver.common.by import By
from pages.base_page import BasePage

class SearchResultsPage(BasePage):
    FIRST_ITEM = (By.XPATH, "(//div[@class='_4rR01T' or @class='s1Q9rs'])[1]")

    def click_first_item(self):
        self.click(self.FIRST_ITEM)
