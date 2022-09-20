package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class PreferencesPage extends BasePage {

    @FindBy(xpath = "//span[@id='icp-currency-dropdown-selected-item-prompt']" )
    private WebElement currencyMenuButton;

    @FindBy(xpath = "//div[@id='a-popover-1']//li")
    private List<WebElement> currencyOptions;

    @FindBy(xpath = "(//div[@id='a-popover-1']//li)[1]")
    private WebElement currencyOption;

    @FindBy(xpath = "//span[@id='icp-save-button']//input")
    private WebElement save;

    public PreferencesPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCurrencyOption() {return currencyOption;}

    public WebElement getCurrencyOption(final String currencyAbbr) {
        for (int i = 0; i < currencyOptions.size(); i++) {
            if (Objects.equals(currencyOptions.get(i).getAttribute("id"), currencyAbbr)) {
                return currencyOptions.get(i);
            }
        }
        throw new IllegalArgumentException();
    }

    public void clickOnCurrencyMenuButton() { currencyMenuButton.click();}

    public void clickOnSave() {save.click();}


}
