package com.solvd.webtesting.elements;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.webtesting.page.BrandProductPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SideBar extends AbstractUIObject {

    @FindBy(xpath = ".//*[contains(@class,'j-plus__toggle g-pseudo_href')]")
    private ExtendedWebElement showAllButton;

    @FindBy(xpath = ".//*[contains(@class, 'filter__attrs cr-filter__producers')]//*[@class='filter-attr__value']")
    private List<ExtendedWebElement> checkboxes;

    @FindBy(css = "#j-filter__btn")
    private ExtendedWebElement showProductsButton;

    @FindBy(xpath = ".//*[contains(@class,'cr-filter__price')]//*[@class='g-form__inputwrap']//*[@name='filter[price][from]']")
    private ExtendedWebElement minPriceField;

    @FindBy(xpath = ".//*[contains(@class,'cr-filter__price')]//*[@class='g-form__inputwrap']//*[@name='filter[price][to]']")
    private ExtendedWebElement maxPriceField;

    public SideBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void selectCheckbox(String brand) {
            ExtendedWebElement requiredCheckbox = checkboxes.stream()
                    .filter(checkbox -> checkbox.getText().equals(brand))
                    .findFirst()
                    .orElseThrow();
            requiredCheckbox.scrollTo();
            requiredCheckbox.check();
    }

    public BrandProductPage clickShowProductsButton() {
        if (showProductsButton.isElementPresent(20L) & showProductsButton.isClickable()) {
            showProductsButton.click();
        }
        return new BrandProductPage(getDriver());
    }

    public void typeMinPriceField(String minPrice) {
        minPriceField.type(minPrice, 5L);
    }

    public void typeMaxPriceField(String maxPrice) {
        maxPriceField.type(maxPrice, 5L);
    }

    public ExtendedWebElement getShowAllButton() {
        return showAllButton;
    }

    public ExtendedWebElement getShowProductsButton() {
        return showProductsButton;
    }

    public ExtendedWebElement getMinPriceField() {
        return minPriceField;
    }

    public ExtendedWebElement getMaxPriceField() {
        return maxPriceField;
    }

    public List<ExtendedWebElement> getCheckboxes() {
        return checkboxes;
    }
}
