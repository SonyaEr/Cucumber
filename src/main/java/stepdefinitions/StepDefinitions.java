package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Cart;
import pages.HomePage;
import pages.ProductPage;
import pages.SignInPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {

    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    HomePage homePage;
    Cart cart;
    SignInPage signInPage;
    ProductPage productPage;

    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }


    @After
    public void tearDown() {
        driver.close();
    }

    @And("I open {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @When("I click 'Sign In' button")
    public void clickSignInButton() {
        homePage.getHeaderPage().clickOnSignInButton();
    }

    @And("I check sign in field visibility on sign in page")
    public void checkEmailPhoneFieldVisibilityOnSignInPage() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.isSignInFieldVisible();
    }

    @And("I fill in sign in field by keyword {string}")
    public void fillInSignInFieldByKeywordEmail(final String email) {
        signInPage.enterTextToSignUpField(email);
    }

    @And("I click 'Sign in Continue' button")
    public void clickContinueButton() {
        signInPage.clickContinueButton();
    }

    @And("I check password field visibility on sign in page")
    public void checkPasswordFieldVisibilityOnSignInPage() {
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.isPasswordFieldVisible();
    }

    @And("I fill in password field by keyword {string}")
    public void fillInPasswordFieldByKeywordPassword(final String password) {
        signInPage.enterTextToPasswordField(password);
    }

    @And("I click 'Sign in Submit' button")
    public void clickSignInSubmitButton() {
        signInPage.clickSignInSubmitButton();
    }

    @Then("I check that user title contains {string}")
    public void checkThatUserTitleContainsName(final String name) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue( homePage.getHeaderPage().getUserTitleItem().contains(name));
    }
}
