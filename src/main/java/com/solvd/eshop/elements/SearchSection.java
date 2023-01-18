package com.solvd.eshop.elements;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.eshop.page.ResultPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchSection extends AbstractUIObject {
    @FindBy(xpath = ".//*[@class='Search_searchInput__mTD6r']")
    private ExtendedWebElement searchField;

    @FindBy(xpath = ".//*[@class='Search_searchBtn__3fSOy']")
    private ExtendedWebElement searchButton;

    public SearchSection(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void typeTextInSearch(String searchText) {
        searchField.type(searchText);
    }

    public ResultPage clickSearchButton() {
        if (searchButton.isClickable(5L)) {
            searchButton.click();
        }
        return new ResultPage(getDriver());
    }

    public ExtendedWebElement getSearchField() {
        return searchField;
    }

    public void setSearchField(ExtendedWebElement searchField) {
        this.searchField = searchField;
    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(ExtendedWebElement searchButton) {
        this.searchButton = searchButton;
    }
}
