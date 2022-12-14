package pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;
import java.util.Objects;

public class Header extends BasePage {

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchField;

    @FindBy(xpath = "//div[@id='nav-search-dropdown-card']/div")
    private WebElement navSearchListButton;

    @FindBy(xpath = "//div[@id='nav-search-dropdown-card']//option")
    private List<WebElement> searchOptions;

    @FindBy(xpath = "(//div[@id='nav-search-dropdown-card']//option)[1]")
    private WebElement searchOptionsFirst;

    @FindBy(xpath = "//div[@id='nav-search-dropdown-card']//option[@selected='selected']")
    private WebElement searchSelectedOptions;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    private WebElement userTitle;

    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private WebElement countCart;

    @FindBy(xpath = "//a[@id='nav-orders']")
    private WebElement ordersButton;

    @FindBy(xpath = "//a[@id='nav-bb-logo'] ")
    private WebElement backUpLogo;

    @FindBy(xpath = "//a[@id='icp-nav-flyout']")
    private WebElement customerPreferencesButton;

    @FindBy(xpath = "//a[@class='icp-flyout-change']")
    private List<WebElement> changeCurrencyButton;

    @FindBy(xpath = "//a[@class='icp-flyout-change']/parent::span")
    private WebElement changeCurrencyButtonBefore;

    public Header(WebDriver driver) {
        super(driver);
    }

    public void clickOnBackUpLogo() {backUpLogo.click();}

    public void searchByKeyword(final String keyword) {
        searchField.clear();
        searchField.sendKeys(keyword);
        searchButton.click();
    }
    public WebElement getSignInButton() { return signInButton;}

    public WebElement getCustomerPreferencesButton() {
        return  customerPreferencesButton;
    }

    public WebElement getSelectedOption() { return searchSelectedOptions;}

    public WebElement getSearchField() { return searchField;}

    public WebElement  getChangeCurrencyButtonBefore() { return changeCurrencyButtonBefore;}

    public WebElement getSearchOption() {  return searchOptionsFirst;}

    public String getUserTitleItem() {
        return  userTitle.getText();
    }

    public String getCountCart() {
        return  countCart.getText();
    }

    public WebElement getOption(final String searchText) {
        for (int i = 0; i < searchOptions.size(); i++) {
            if (Objects.equals(searchOptions.get(i).getText(), searchText)) {
                return searchOptions.get(i);
            }
        }
        throw new IllegalArgumentException();
    }

    public void clickOnChangeCurrencyButton() {changeCurrencyButton.get(0).click();}

    public void clickOnNavSearchListButton() {navSearchListButton.click();}

    public void clickOnOrdersButton() {ordersButton.click();}

    public void clickOnSearchButton() {searchButton.click();}

    public void isSearchFieldVisibility() {
        searchField.isDisplayed();
    }

    public void isCountCartVisibility() {
        countCart.isDisplayed();
    }

}
