package com.solvd.webtesting.elements;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.webtesting.page.ProductPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductMenuBar extends AbstractUIObject {

    @FindBy(css = ".styles_promoItem__3H-t7")
    private List<ExtendedWebElement> itemProducts;

    public ProductMenuBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ProductPage selectProduct(String productName) {
        ExtendedWebElement requiredProduct = itemProducts.stream()
                .filter(product -> product.getText().equals(productName))
                .findFirst()
                .orElseThrow();
        requiredProduct.click();
        return new ProductPage(getDriver());
    }
}
