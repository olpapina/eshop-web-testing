package com.solvd.webtesting.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ResultPage extends AbstractPage {
    @FindBy(css = ".result__name")
    private List<ExtendedWebElement> searchResultItems;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getFullNames() {
        return searchResultItems.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
    }
}
