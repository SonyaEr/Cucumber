package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public WebElement getCategory(String category) {
        return driver.findElement(xpath("//a[@aria-label='"+category+"']"));
    }

}