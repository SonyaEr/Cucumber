package pages;

import org.openqa.selenium.Keys;
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

    @FindBy(xpath = "//div[@id='auth-error-message-box']")
    private WebElement errorSection;

    @FindBy(xpath = "//div[@id='auth-warning-message-box']")
    private WebElement warningSection;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getErrorSection() {return errorSection;}

    public WebElement getWarningSection() {return warningSection;}

    public void clickContinueButton() {continueButton.click();}

    public void clickSignInSubmitButton() {signInSubmitButton.click();}

    public void isSignInFieldVisible() {signInField.isDisplayed(); }

    public void isPasswordFieldVisible() {passwordField.isDisplayed();}

    public void enterTextToSignUpField(final String emailOrPhoneText) {
        signInField.clear();
        signInField.sendKeys(emailOrPhoneText);
    }
    public void enterTextToSignUpFieldEnter(final String emailOrPhoneText) {
        signInField.clear();
        signInField.sendKeys(emailOrPhoneText);
        signInField.sendKeys(Keys.ENTER);
    }

    public void enterTextToPasswordField(final String passwordText) {
        passwordField.clear();
        passwordField.sendKeys(passwordText);
    }
    public void enterTextToPasswordFieldEnter(final String passwordText) {
        passwordField.clear();
        passwordField.sendKeys(passwordText);
        passwordField.sendKeys(Keys.ENTER);
    }


}
