package com.solvd.webtesting.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class,'styles_bottomLinks__349w0')]//*[contains(text(),'Регистрация')]")
    private ExtendedWebElement registrationButton;

    @FindBy(css = "#login-email")
    private ExtendedWebElement emailField;

    @FindBy(css = "#login-password")
    private ExtendedWebElement passwordField;

    @FindBy(css = ".style_actions__2mIsz .style_baseActionButton__2LQYJ ")
    private ExtendedWebElement enterButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageURL("");
    }

    public RegistrationPage clickRegistrationButton() {
        if (registrationButton.isElementPresent(5L) & registrationButton.isClickable()) {
            registrationButton.click();
        }
        return new RegistrationPage(getDriver());
    }

    public void typeLoginEmail(String email) {
        if (emailField.isElementPresent(5L)) {
            emailField.type(email);
        }
    }

    public void typeLoginPassword(String password) {
        if (passwordField.isElementPresent(5L)) {
            passwordField.type(password);
        }
    }

    public HomePage clickEnterButton() {
        if (enterButton.isElementPresent(5L) & enterButton.isClickable()) {
            enterButton.click();
        }
        return new HomePage(getDriver());
    }

    public ExtendedWebElement getRegistrationButton() {
        return registrationButton;
    }
}
