package com.solvd.webtesting.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SuccessRegistrationPage extends AbstractPage {
    @FindBy(css = ".styles_successTitle__1IDi2")
    private ExtendedWebElement successRegistration;

    public SuccessRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getSuccessRegistration() {
        return successRegistration;
    }
}
