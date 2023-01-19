package com.solvd.webtesting.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RegistrationPrivacyPage extends AbstractUIObject {

    @FindBy(xpath = "//*[@class='styles_buttons__3IGzu']//*[contains(text(),'Соглашаюсь')]")
    private ExtendedWebElement privacyButton;

    public RegistrationPrivacyPage(WebDriver driver) {
        super(driver);
        setPageURL("");
    }

    public SuccessRegistrationPage clickPrivacyButton() {
        if (privacyButton.isElementPresent(5L) & privacyButton.isClickable()) {
            privacyButton.click();
        }
        return new SuccessRegistrationPage(getDriver());
    }

    public ExtendedWebElement getPrivacyButton() {
        return privacyButton;
    }
}
