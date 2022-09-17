package manager;

import org.openqa.selenium.WebDriver;
import pages.Cart;
import pages.HomePage;
import pages.ProductPage;
import pages.SignInPage;

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

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public Cart getCart() {
        return new Cart(driver);
    }

}


