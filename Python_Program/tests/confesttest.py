import pytest
from Utils.driver_factory import create_driver

@pytest.fixture(scope="session")
def driver():
    driver = create_driver()
    driver.get("https://www.flipkart.com/")
    yield driver
    driver.quit()
