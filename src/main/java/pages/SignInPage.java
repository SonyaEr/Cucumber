package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement signInField;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    private WebElement signInSubmitButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void isSignInFieldVisible() {
        signInField.isDisplayed();
    }
    public void isPasswordFieldVisible() {
        passwordField.isDisplayed();
    }


    public void enterTextToSignUpField(final String emailOrPhoneText) {
        signInField.clear();
        signInField.sendKeys(emailOrPhoneText);
    }

    public void enterTextToPasswordField(final String passwordText) {
        passwordField.clear();
        passwordField.sendKeys(passwordText);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void clickSignInSubmitButton() {
        signInSubmitButton.click();
    }


}
