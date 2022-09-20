package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(@class,'see-more')]")
    private List<WebElement> linkMoreProducts;

    @FindBy(xpath = "//a[contains(@class,'see-more')]//ancestor::div/div[@class='a-cardui-header']")
    private List<WebElement> titleSections;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public WebElement getCategory(String category) {
        return driver.findElement(xpath("//a[@aria-label='"+category+"']"));
    }

    public int getTitleSections(String name) {
        for (int i = 0; i < titleSections.size(); i++) {
            if (titleSections.get(i).getText().contains(name)) return i;
        }
        return 0;
    }
    public void clickOnLinkMoreProduct(String name){
            linkMoreProducts.get(getTitleSections(name)).click();
    }
}