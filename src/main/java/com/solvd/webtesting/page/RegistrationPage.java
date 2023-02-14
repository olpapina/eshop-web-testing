package com.solvd.webtesting.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends AbstractPage {

    @FindBy(css = ".style_inputStyle__1dvyw")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//*[contains(text(),'Продолжить')]")
    private ExtendedWebElement continueButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
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
}
