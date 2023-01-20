package com.solvd.webtesting.utils;

import com.qaprosoft.carina.core.foundation.webdriver.core.capability.impl.desktop.ChromeCapabilities;
import com.qaprosoft.carina.core.foundation.webdriver.core.capability.impl.desktop.FirefoxCapabilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;

public class CapabilityFactory {
    private static final Logger LOGGER = LogManager.getLogger(CapabilityFactory.class);
    public static MutableCapabilities mutableCapabilities;

    public static MutableCapabilities getCapabilities(String browser) {
        switch (browser) {
            case "firefox":
                mutableCapabilities = new FirefoxCapabilities().getCapability("FirefoxTest");
                break;
            case "chrome":
                mutableCapabilities = new ChromeCapabilities().getCapability("ChromeTest");
                break;
            default:
                LOGGER.info("browser : " + browser + " is invalid, Launching Chrome as browser of choice..");
                mutableCapabilities = new ChromeCapabilities().getCapability("ChromeTest");
                break;
        }
        return mutableCapabilities;
    }
}
