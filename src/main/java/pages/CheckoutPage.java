package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//div[@class='clearfix']//h1")
    private WebElement title;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {return title.getText();}

    public WebElement getTitle() {return title;}
}
