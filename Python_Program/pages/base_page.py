from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class BasePage:
    def __init__(self, driver):
        self.driver = driver
        self.wait = WebDriverWait(driver, 10)

    def click(self, by_locator):
        self.wait.until(EC.element_to_be_clickable(by_locator)).click()

    def enter_text(self, by_locator, text):
        self.wait.until(EC.visibility_of_element_located(by_locator)).send_keys(text)

    def is_visible(self, by_locator):
        return self.wait.until(EC.visibility_of_element_located(by_locator)).is_displayed()

    def get_title(self):
        return self.driver.title

    def switch_to_new_tab(self):
        tabs = self.driver.window_handles
        self.driver.switch_to.window(tabs[1])
