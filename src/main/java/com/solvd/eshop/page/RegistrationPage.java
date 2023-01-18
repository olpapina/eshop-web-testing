package com.solvd.eshop.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends AbstractPage {

    @FindBy(css = ".style_inputStyle__1dvyw")
    private ExtendedWebElement emailField;

    @FindBy(css = ".styles_registerButton__18sPZ")
    private ExtendedWebElement continueButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        setPageURL("");
    }

    public void typeEmail(String email) {
        emailField.type(email, 5L);
    }

    public RegistrationPrivacyPage clickContinueButton() {
        if (continueButton.isElementPresent() & continueButton.isClickable()) {
            continueButton.click();
        }
        return new RegistrationPrivacyPage(getDriver());
    }

    public ExtendedWebElement getEmailField() {
        return emailField;
    }

    public ExtendedWebElement getContinueButton() {
        return continueButton;
    }
}
