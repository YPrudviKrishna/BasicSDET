import pytest
from pages.home_page import HomePage
from pages.search_results_page import SearchResultsPage
from pages.product_page import ProductPage
from pages.cart_page import CartPage



def test_flipkart_cart_flow(driver):
    home = HomePage(driver)
    home.close_login_popup()
    assert home.verify_title_contains_flipkart(), "Flipkart title not found"

    home.search_product("Macbook air m2")

    search_page = SearchResultsPage(driver)
    search_page.click_first_item()

    # Switch to new tab
    home.switch_to_new_tab()

    product = ProductPage(driver)
    product.add_to_cart()

    cart = CartPage(driver)
    assert cart.verify_item_added(), "Item not added to cart"



