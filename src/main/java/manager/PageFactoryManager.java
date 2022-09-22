package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public SignInPage getSignInPage() {
        return new SignInPage(driver);
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(driver);
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }


    public CartPage getCartPage() {
        return new CartPage(driver);
    }

    public ShoppingCartPage getShoppingCartPage() {
        return new ShoppingCartPage(driver);
    }

    public CheckoutPage getCheckoutPage() {
        return new CheckoutPage(driver);
    }

    public PreferencesPage getPreferencesPage(){ return new PreferencesPage(driver);}

}


