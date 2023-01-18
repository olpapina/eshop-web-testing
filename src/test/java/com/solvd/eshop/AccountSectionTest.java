package com.solvd.eshop;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.eshop.page.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class AccountSectionTest extends AbstractTest {

    @Test(testName = "verify that registration success with new email", enabled = false)
    public void verifyValidRegistrationTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickCookieButton();
        homePage.clickAccountMenu();
        LoginPage loginPage = homePage.clickLoginButton();
        RegistrationPage registrationPage = loginPage.clickRegistrationButton();
        int num = (int) (Math.random() * 99999);
        registrationPage.typeEmail("friendmailtestflipper" + num + "@yopmail.com");
        RegistrationPrivacyPage registrationPrivacyPage = registrationPage.clickContinueButton();
        SuccessRegistrationPage successRegistrationPage = registrationPrivacyPage.clickPrivacyButton();
        String successMessage = successRegistrationPage.getSuccessRegistration().getText();
        Assert.assertEquals(successMessage, "Вы зарегистрированы", "Registration success message wasn't displayed");
    }

    @Test(testName = "verify enter into account", enabled = false)
    public void verifyEnterIntoAccountTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickCookieButton();
        homePage.clickAccountMenu();
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.typeLoginEmail("friendmailtestflipper1984@yopmail.com");
        loginPage.typeLoginPassword("33dca97f");
        homePage = loginPage.clickEnterButton();
        homePage.clickAccountMenuAfterLogin();
        String accountEmail = homePage.getAccountInfo();
        Assert.assertEquals(accountEmail, "friendmailtestflipper1984@yopmail.com", "Login is failed");
    }
}
