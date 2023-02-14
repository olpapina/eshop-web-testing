package com.solvd.webtesting.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RegistrationPrivacyPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='Button-module__buttonText' and contains(text(),'Соглашаюсь')]")
    private ExtendedWebElement privacyButton;

    public RegistrationPrivacyPage(WebDriver driver) {
        super(driver);
    }

    public SuccessRegistrationPage clickPrivacyButton() {
        if (privacyButton.isElementPresent(5L) & privacyButton.isClickable()) {
            privacyButton.click();
        }
        return new SuccessRegistrationPage(getDriver());
    }
}
