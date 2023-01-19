package com.solvd.webtesting.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class BrandProductPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class,'result__name')]")
    private List<ExtendedWebElement> brandProducts;

    @FindBy(xpath = "//*[contains(@class,'cr-result__full')]//*[contains(@class,'result__price')]//*[contains(@class,'j-item-data')]")
    private List<ExtendedWebElement> productPrices;

    public BrandProductPage(WebDriver driver) {
        super(driver);
        setPageURL("");
    }

    public List<String> getFullNames() {
        new WebDriverWait(this.driver, Duration.ofSeconds(30))
                .until((ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".result__name"))));
        return brandProducts.stream()
                .map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

    public List<String> getResultPrices() {
        new WebDriverWait(this.driver, Duration.ofSeconds(30))
                .until((ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".result__name"))));
        return productPrices.stream()
                .map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

    public List<Double> getPrices(List<String> resultPrices) {
        List<String> newResultPrices = resultPrices.stream()
                .map(price -> price.replace(',', '.'))
                .collect(Collectors.toList());
        return newResultPrices.stream()
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    public List<ExtendedWebElement> getBrandProducts() {
        return brandProducts;
    }

    public void setBrandProducts(List<ExtendedWebElement> brandProducts) {
        this.brandProducts = brandProducts;
    }

    public List<ExtendedWebElement> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(List<ExtendedWebElement> productPrices) {
        this.productPrices = productPrices;
    }
}
