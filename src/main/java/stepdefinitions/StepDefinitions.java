package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;

public class StepDefinitions {

    private static final long DEFAULT_TIMEOUT = 60;
    private double priceProduct = 0;
    private String currency = null;

    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    CartPage cartPage;
    SignInPage signInPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;
    PreferencesPage preferencesPage;

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
        try {
            homePage.getHeaderPage().clickOnBackUpLogo();
        } catch (Exception ignore) {
        }
    }

    @When("I click 'Sign In' button")
    public void clickSignInButton() {
        WebElement sign = homePage.getHeaderPage().getSignInButton();
        homePage.waitForElementToBeClickable(5, sign);
        sign.click();
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
        assertTrue(homePage.getHeaderPage().getUserTitleItem().contains(name));
    }

    @When("I click 'Nav Search List' button")
    public void clickNavSearchListButton() {
        homePage.getHeaderPage().clickOnNavSearchListButton();
    }


    @And("I click search option by keyword {string}")
    public void clickSearchOptionNameOption(final String keyword) {
        homePage.waitForVisibilityOfElement(15, homePage.getHeaderPage().getSearchOption());
        homePage.getHeaderPage().getOption(keyword).click();
    }

    @And("I click 'Search' button")
    public void clickSearchButton() {
        homePage.getHeaderPage().clickOnSearchButton();
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("I compare current search option with {string} on header")
    public void compareCurrentSearchOptionWithNameOptionOnHeader(final String keyword) {
        assertEquals(searchResultsPage.getHeaderPage().getSelectedOption().getText(), searchResultsPage.getHeaderPage().getOption(keyword).getText());
    }

    @And("I check that url contains query of search option")
    public void checkThatUrlContainsQuery() {
        String query = searchResultsPage.getHeaderPage().getSelectedOption().getAttribute("value");
        String partsQuery = query.split("=")[1];
        assertTrue(driver.getCurrentUrl().contains(partsQuery));
    }

    @When("I make search by keyword {string}")
    public void fillInSearchFieldByKeywordKeyword(final String keyword) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.getHeaderPage().isSearchFieldVisibility();
        homePage.getHeaderPage().searchByKeyword(keyword);
    }

    @Then("I compare current search input with {string} on header")
    public void compareCurrentSearchInputWithKeywordOnHeader(final String keyword) {
        assertTrue(searchResultsPage.getHeaderPage().getSearchField().getAttribute("value").contains(keyword));
    }

    @And("I check that url contains {string}")
    public void checkThatUrlContainsQueryOfSearch(final String keyword) {
        assertTrue(driver.getCurrentUrl().contains(keyword));
    }

    @And("I check image of product visibility")
    public void checkImageOfProductVisibility() {
        searchResultsPage.isProductWithPricePictureVisibility();
    }

    @And("I click image on product with price")
    public void clickImageOnProductWithPrice() {
        searchResultsPage.clickOnProductWithPricePictureButton();
    }

    @And("I click 'Add to Cart' button on product")
    public void clickAddToCartButtonOnProduct() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickOnAddToCartButton();
    }

    @Then("I check that cart title is {string}")
    public void checkThatCartTitleIsTitle(final String title) {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(cartPage.getCartTitle(), title);
    }

    @And("I check 'count cart' visibility")
    public void checkCountCartVisibility() {
        cartPage.getHeaderPage().isCountCartVisibility();
    }

    @And("I check 'proceed to checkout' visibility")
    public void checkProceedToCheckoutVisibility() {
        cartPage.isProceedToCheckoutVisibility();
    }

    @And("I check 'price cart' visibility")
    public void checkPriceCartVisibility() {
        cartPage.isPriceCartVisibility();
    }

    @And("I check 'price nav flyout' visibility")
    public void checkPriceNavFlyoutVisibility() {
        cartPage.isPriceNavFlyoutVisibility();
    }

    @And("I compare 'count cart' with 'proceed to checkout'")
    public void compareCountCartWithProceedToCheckout() {
        String text = cartPage.getProceedToCheckoutButton().getText();
        String partsText = text.split("\\(")[1];
        String count = partsText.split(" ")[0];
        assertEquals(cartPage.getHeaderPage().getCountCart(), count);
    }

    @And("I compare 'price cart' with 'price nav flyout'")
    public void comparePriceCartWithPriceNavFlyout() {
        String text = cartPage.getPriceCart();
        String price = text.split(" ")[1];
        assertEquals(price, cartPage.getPriceNavFlyout().substring(1));
    }

    @And("I save 'price product'")
    public void savePriceProduct() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        boolean flag = false;
        while (!flag) {
            try {
                productPage.waitForElementToBeClickable(2, productPage.getPriceInCartSection());
                priceProduct = Double.parseDouble(productPage.getPriceInCartSection().getText().substring(1));
                flag = true;
            } catch (Exception ignore) {
                productPage.waitForElementToBeClickable(2, productPage.getPriceInCartSectionSponsored());
                priceProduct = Double.parseDouble(productPage.getPriceInCartSectionSponsored().getText().substring(1));

                flag = true;
            }
        }
    }

    @And("I compare 'price cart' with 'price product'")
    public void comparePriceCartWithPriceProduct() {
        String text = cartPage.getPriceCart();
        double price = Double.parseDouble(text.split(" ")[1]);
        assertEquals(price, priceProduct, 0.00);
    }

    @Then("I check error or warning visibility on sign in page")
    public void checkErrorOrWarningVisibilityOnSignInPage() {
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        boolean flag = false;
        while (!flag) {
            try {
                signInPage.waitForVisibilityOfElement(2, signInPage.getErrorSection());
                flag = true;
            } catch (Exception ignore) {
                signInPage.waitForVisibilityOfElement(2, signInPage.getWarningSection());
                flag = true;
            }
        }
    }

    @When("I click 'Orders' button")
    public void clickOrdersButton() {
        homePage.getHeaderPage().clickOnOrdersButton();
    }

    @And("I fill in sign in field by keyword {string} and enter")
    public void fillInSignInFieldByKeywordKeywordAndEnter(final String keyword) {
        signInPage.enterTextToSignUpFieldEnter(keyword);
    }

    @And("I fill in password field by keyword {string} and enter")
    public void fillInPasswordFieldByKeywordPasswordAndEnter(final String password) {
        signInPage.enterTextToPasswordFieldEnter(password);
    }

    @And("I click 'Go to Cart' button on product")
    public void clickGoToCartButtonOnProduct() {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        cartPage.clickOnGoToCartButton();
    }

    @And("I click 'Proceed to checkout' button on product")
    public void clickProceedToCheckoutButtonOnProduct() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.clickOnCheckoutButton();
    }

    @And("I check that checkout page contains {string}")
    public void checkThatCheckoutPageContainsTitle(final String title) {
        checkoutPage = pageFactoryManager.getCheckoutPage();
        checkoutPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(checkoutPage.getTitle(), title);
    }

    @When("I click category by keyword {string}")
    public void clickCategoryByKeywordKeyword(final String keyword) {
        homePage.getCategory(keyword).click();
    }

    @And("I click first price category")
    public void clickPriceCategory() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitForVisibilityOfElement(50, searchResultsPage.getProductCurrency());
        searchResultsPage.clickOnFirstPrice();
    }

    @And("I fill in low price field by keyword {string}")
    public void fillInLowPriceFieldByKeywordLowPrice(final String lowPrice) {
        searchResultsPage.enterLowPriceField(lowPrice);
    }
    @And("I fill in high price field by keyword {string}")
    public void fillInLowPriceFieldByKeywordHighPrice(final String highPrice) {
        searchResultsPage.enterHighPriceField(highPrice);
    }

    @And("I click 'Submit price'")
    public void clickSubmitPrice() {
        searchResultsPage.clickOnPriceSubmitButton();
    }

    @Then("I compare prices on page within {string} and {string}")
    public void comparePricesOnPageWithinLowPriceAndHighPrice(final String lowPrice, final String highPrice) {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        List <Double> prices=  searchResultsPage.getPrice();
        for(int i = 0; i<prices.size(); i++){
            assertTrue( prices.get(i)> Double.parseDouble(lowPrice) && prices.get(i)< Double.parseDouble(highPrice));
        }
    }

    @And("I click 'Reviews' button by {string}")
    public void clickReviewsButtonByName(final String name) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.getReviewResultItem(name).click();
    }

    @Then("I checks that product page contains {string}")
    public void checksThatProductPageContainsCustomerReviews( final String name) {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(productPage.getReviewsTitle(), name);
    }

    @When("I click link section by keyword {string}")
    public void clickLinkSectionByKeywordName(final String name) {
        homePage.clickOnLinkMoreProduct(name);
    }

    @And("I save 'currency'")
    public void saveCurrency() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        currency = searchResultsPage.getPriceCurrency();
    }

    @And("I click 'Customer Preferences' button")
    public void clickCustomerPreferencesButton() {
        searchResultsPage.actionsMoveToElement(searchResultsPage.getHeaderPage().getCustomerPreferencesButton());
    }

    @And("I click 'Currency change' button on header")
    public void clickCurrencyChangeButtonOnHeader() {
        searchResultsPage.waitForVisibilityOfElement(10,searchResultsPage.getHeaderPage().getChangeCurrencyButtonBefore());
        searchResultsPage.getHeaderPage().clickOnChangeCurrencyButton();
    }

    @And("I select currency by keyword {string}")
    public void selectCurrencyByKeywordCurrency(final String currency) {
        preferencesPage = pageFactoryManager.getPreferencesPage();
        preferencesPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        preferencesPage.clickOnCurrencyMenuButton();
        preferencesPage.waitForVisibilityOfElement(15, preferencesPage.getCurrencyOption());
        preferencesPage.getCurrencyOption(currency);
    }

    @And("I click 'Save changes' button on preferences page")
    public void clickSaveChangesButtonOnPreferencesPage() {
        preferencesPage.clickOnSave();
    }

    @Then("I compare 'currency' with current 'currency'")
    public void compareCurrencyWithCurrentCurrency() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitForVisibilityOfElement(15, searchResultsPage.getProductCurrency());
        String currencyNew = searchResultsPage.getPriceCurrency();
        assertEquals(currency, currencyNew);
    }
}
