package com.solvd.webtesting;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.webtesting.page.*;
import com.zebrunner.agent.core.annotation.TestRailCaseId;
import com.zebrunner.agent.core.registrar.TestRail;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

import static com.solvd.webtesting.utils.CapabilityFactory.getCapabilities;

public class AccountSectionTest implements IAbstractTest {

    @BeforeSuite
    public void setUp() {
        TestRail.setSuiteId("185");
        TestRail.setRunName("Olga");
        TestRail.enableRealTimeSync();
    }

    @Test(testName = "verify that registration success with new email")
    @TestRailCaseId("3518")
    @Parameters("browser")
    public void verifyValidRegistrationTest(String browser) throws IOException {
        HomePage homePage = new HomePage(getDriver(browser, getCapabilities(browser)));
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
    @TestRailCaseId("3519")
    @Parameters("browser")
    public void verifyEnterIntoAccountTest(String browser) throws IOException {
        HomePage homePage = new HomePage(getDriver(browser, getCapabilities(browser)));
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
