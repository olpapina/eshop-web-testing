package com.solvd.eshop.page;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.eshop.elements.SideBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {
    @FindBy(xpath = "//*[contains(@class,'l-filter')]")
    private SideBar sideBar;

    public ProductPage(WebDriver driver) {
        super(driver);
        setPageURL("");
    }

    public SideBar getSideBar() {
        return sideBar;
    }
}
