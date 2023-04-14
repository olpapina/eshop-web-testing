package com.solvd.webtesting.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.webtesting.elements.ProductMenuBar;
import com.solvd.webtesting.elements.SearchSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class,'Button-module__blue-primary')]//*[contains(text(),'Принять')]")
    private ExtendedWebElement cookieButton;

    @FindBy(xpath = "//*[contains(@class,'styles_userToolsToggler__imcSl')]")
    private ExtendedWebElement accountMenu;

    @FindBy(css = ".userToolsBtn")
    private ExtendedWebElement loginButton;

    @FindBy(css = ".styles_userTools__2J7cp.undefined")
    private ExtendedWebElement accountMenuAfterLogin;

    @FindBy(css = ".userToolsSubtitle")
    private ExtendedWebElement userToolsTitle;

    @FindBy(xpath =  "//*[contains(@class,'styles_headerReactWrapper__3U15a') and contains(@class,'styles_headerReactWrapperAlt__3bM5y')]")
    private ProductMenuBar ProductMenuBar;

    @FindBy(xpath = "//*[contains(@class,'styles_headerReactLine__IWu_8') and contains(@class,'styles_headerReactLineSecond__tp1U0')]")
    private SearchSection SearchSection;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickCookieButton() {
        cookieButton.click(5L);
    }

    public void clickAccountMenu() {
        accountMenu.click();
    }

    public LoginPage clickLoginButton() {
        if (loginButton.isElementPresent() & loginButton.isClickable()) {
            loginButton.click();
        }
        return new LoginPage(getDriver());
    }

    public void clickAccountMenuAfterLogin() {
        if (accountMenuAfterLogin.isElementPresent() & accountMenuAfterLogin.isClickable()) {
            accountMenuAfterLogin.click();
        }
    }

    public String getAccountInfo() {
        return userToolsTitle.getText();
    }

    public ProductMenuBar getProductMenuBar() {
        return ProductMenuBar;
    }

    public SearchSection getSearchSection() {
        return SearchSection;
    }
}
