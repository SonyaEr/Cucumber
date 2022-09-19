package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@id='sw-atc-details-single-container']//div/span")
    private WebElement cartTitle;

    @FindBy(xpath = "//span[@id='sc-buy-box-ptc-button']//div[@data-feature-id='proceed-to-checkout-label']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//div[@id='sw-subtotal']")
    private WebElement priceCart;

    @FindBy(xpath = "//div[@id='nav-flyout-ewc']//span/span")
    private WebElement priceNavFlyout;

    @FindBy(xpath = "//span[@id='sw-gtc']//a")
    private WebElement goToCartButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartTitle() {
        return  cartTitle.getText();
    }

    public WebElement getProceedToCheckoutButton() {
        return  proceedToCheckoutButton;
    }

    public String getPriceCart() {return  priceCart.getAttribute("data-price");}

    public String getPriceNavFlyout() {
        return  priceNavFlyout.getText();
    }

    public void isProceedToCheckoutVisibility() {
        proceedToCheckoutButton.isDisplayed();
    }

    public void isPriceCartVisibility() {
        priceCart.isDisplayed();
    }

    public void isPriceNavFlyoutVisibility() {
        priceNavFlyout.isDisplayed();
    }

    public void clickOnGoToCartButton() {goToCartButton.click();}
}
