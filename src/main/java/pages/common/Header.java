package pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class Header extends BasePage {

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    private WebElement userTitle;

    public Header(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword);
        searchButton.click();
    }
    public void clickOnSignInButton() {
        signInButton.click();
    }

    public String getUserTitleItem() {
        return  userTitle.getText();
    }

}
