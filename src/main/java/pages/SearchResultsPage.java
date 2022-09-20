package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;
import java.util.stream.Collectors;

import static org.openqa.selenium.By.xpath;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'s-list-col-right')]//div[@class='sg-row']//a//ancestor::div/div[contains(@class,'s-list-col-lef')]")
    private WebElement productWithPricePictureInSearch;

    @FindBy(xpath = "//div[@id='s-refinements']//span[text()='Price']/ancestor-or-self::div/ul/li/span/a")
    private List<WebElement> prices;

    @FindBy(xpath = "//input[@id='high-price']")
    private WebElement highPriceField;

    @FindBy(xpath = "//input[@id='low-price']")
    private WebElement lowPriceField;

    @FindBy(xpath = "//span[@id='a-autoid-1']//input")
    private WebElement priceSubmitButton;

    @FindBy(xpath = "//span[@class='a-price']/span/following-sibling::span")
    private List<WebElement> productPrices;

    @FindBy(xpath = "//span[@class='a-price']/span/following-sibling::span/span[@class='a-price-symbol']")
    private List<WebElement> productCurrency;

    @FindBy(xpath = "(//span[@class='a-price']/span/following-sibling::span/span[@class='a-price-symbol'])[1]")
    private WebElement productCurrencyFirst;

    @FindBy(xpath = "//div[@class='a-row a-size-small']/span/following-sibling::span/a")
    private List<WebElement> reviews;

    @FindBy(xpath = "//div[contains(@class, 'SearchResultItem')]")
    private List<WebElement> resultItems;

     public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void enterHighPriceField(final String high_price) {
        highPriceField.clear();
        highPriceField.sendKeys(high_price);}

    public void enterLowPriceField(final String low_price) {
        lowPriceField.clear();
        lowPriceField.sendKeys(low_price);}

    public void clickOnProductWithPricePictureButton() {productWithPricePictureInSearch.click();}

    public void clickOnFirstPrice() {prices.get(0).click();}

    public void clickOnPriceSubmitButton() {priceSubmitButton.click();}

    public void isProductWithPricePictureVisibility() { productWithPricePictureInSearch.isDisplayed();}

    public WebElement getProductCurrency (){ return productCurrencyFirst;}

    public WebElement getResultItemByName(String name) {
        return driver.findElement(xpath( "//span[contains(text(),'"+name+"')]/ancestor::div[contains(@class, 'SearchResultItem')]"));
    }
    public WebElement getReviewResultItem(String name){
        for (int i = 0; i < resultItems.size(); i++) {
            if(getResultItemByName(name).equals(resultItems.get(i))){
                try{ return reviews.get(i);
                }
                catch (Exception e){
                    System.out.println("Item with such name doesn't have reviews");
                }
            }
        }
        return null;
    }

    public List<Double>  getPrice() {
        for (int i = 0; i < productPrices.size(); i++) {
            ArrayList<Double> ref = new ArrayList<>();
            double d = Double.parseDouble(productPrices.get(i+1).getText().replace('\n','.').substring(1));
            ref.add(d);
            return ref;
        }
        throw new IllegalArgumentException();
    }

    public String getPriceCurrency() {
        for (int i = 0; i < productCurrency.size(); i++) {
            ArrayList<String> ref = new ArrayList<>();
            String currency = productCurrency.get(i+1).getText();
            ref.add(currency);
            return ref.stream().distinct().collect(Collectors.toList()).get(0);
        }
        throw new IllegalArgumentException();
    }

}