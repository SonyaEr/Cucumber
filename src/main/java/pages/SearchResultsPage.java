package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'s-list-col-right')]//div[@class='sg-row']//a//ancestor::div/div[contains(@class,'s-list-col-lef')]")
    private WebElement productWithPricePicture;

     public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnProductWithPricePictureButton() {productWithPricePicture.click();}

    public void isProductWithPricePictureVisibility() { productWithPricePicture.isDisplayed();}


}