package com.solvd.webtesting;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.webtesting.elements.ProductMenuBar;
import com.solvd.webtesting.elements.SideBar;
import com.solvd.webtesting.page.BrandProductPage;
import com.solvd.webtesting.page.ProductPage;
import com.solvd.webtesting.page.HomePage;
import com.solvd.webtesting.page.ResultPage;
import com.solvd.webtesting.elements.SearchSection;
import com.zebrunner.agent.core.annotation.TestRailCaseId;
import com.zebrunner.agent.core.registrar.TestRail;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

import static com.solvd.webtesting.utils.CapabilityFactory.getCapabilities;

public class SearchTest implements IAbstractTest {

    @BeforeSuite
    public void setUp() {
        TestRail.setSuiteId("185");
        TestRail.setRunName("Olga");
        TestRail.enableRealTimeSync();
    }

    @Test(testName = "verify that results contains input text")
    @TestRailCaseId("3521")
    @Parameters({"browser"})
    public void verifySearchTextTypeResultsTest(String browser) throws IOException {
        HomePage homePage = new HomePage(getDriver(browser, getCapabilities(browser)));
        homePage.open();
        homePage.clickCookieButton();
        SearchSection searchSection = homePage.getSearchSection();
        String inputText = "Ломтерезка";
        searchSection.typeTextInSearch(inputText);
        ResultPage resultPage = searchSection.clickSearchButton();
        List<String> fullNames = resultPage.getFullNames();

        SoftAssert sa = new SoftAssert();
        fullNames.forEach(name -> sa.assertTrue(name.contains(inputText), "The result doesn't have " + inputText + " in the name"));
        sa.assertAll();
    }

    @Parameters({"browser", "product", "brand"})
    @Test(testName = "verify advance search that product brand will be found in results", enabled = false)
    @TestRailCaseId("3522")
    public void verifyAdvanceSearchItemBrandTest(String browser, String product, String brand) throws IOException {
        HomePage homePage = new HomePage(getDriver(browser, getCapabilities(browser)));
        homePage.open();
        homePage.clickCookieButton();
        ProductMenuBar productMenuBar = homePage.getProductMenuBar();
        ProductPage productPage = productMenuBar.selectProduct(product);
        SideBar sideBar = productPage.getSideBar();
        sideBar.selectCheckbox(brand);
        BrandProductPage brandProductPage = sideBar.clickShowProductsButton();
        List<String> resultNames = brandProductPage.getFullNames();

        SoftAssert sa = new SoftAssert();
        resultNames.forEach(resultName -> sa.assertTrue(resultName.contains(brand), "The result doesn't have " + brand + " in the name"));
        sa.assertAll();
    }

    @Parameters({"browser", "product", "minPrice", "maxPrice"})
    @Test(testName = "verify advance search that product price in selected interval", enabled = false)
    @TestRailCaseId("3523")
    public void verifyAdvanceSearchPriceOfResultTest(String browser, String product, String minPrice, String maxPrice) throws IOException {
        HomePage homePage = new HomePage(getDriver(browser, getCapabilities(browser)));
        homePage.open();
        homePage.clickCookieButton();
        ProductMenuBar productMenuBar = homePage.getProductMenuBar();
        ProductPage productPage = productMenuBar.selectProduct(product);
        SideBar sideBar = productPage.getSideBar();
        sideBar.typeMinPriceField(minPrice);
        sideBar.typeMaxPriceField(maxPrice);
        BrandProductPage brandProductPage = sideBar.clickShowProductsButton();
        List<String> resultPrices = brandProductPage.getResultPrices();
        List<Double> prices = brandProductPage.getPrices(resultPrices);

        SoftAssert sa = new SoftAssert();
        prices.forEach(price -> {
            sa.assertTrue(price > Double.parseDouble(minPrice), "The result price less minimum price");
            sa.assertTrue(price < Double.parseDouble(maxPrice), "The result price more maximum price");
        });
        sa.assertAll();
    }
}
