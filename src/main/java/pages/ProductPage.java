package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartListButton;

    @FindBy(xpath = "//span[@id='priceblock_ourprice']")
    private WebElement priceInCartSection;

    @FindBy(xpath = "//div[@id='reviewsMedley']//h2")
    private WebElement reviewsTitle;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCartButton() {addToCartListButton.click();}

    public WebElement getPriceInCartSection() {return priceInCartSection;}

    public String getReviewsTitle() { return reviewsTitle.getText();}



}
