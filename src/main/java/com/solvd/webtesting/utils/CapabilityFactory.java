package com.solvd.webtesting.utils;

import com.qaprosoft.carina.core.foundation.webdriver.core.capability.impl.desktop.ChromeCapabilities;
import com.qaprosoft.carina.core.foundation.webdriver.core.capability.impl.desktop.FirefoxCapabilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;

import java.io.IOException;

public class CapabilityFactory {
    private static final Logger LOGGER = LogManager.getLogger(CapabilityFactory.class);
    public static MutableCapabilities mutableCapabilities;

    public static MutableCapabilities getCapabilities(String browser) throws IOException {
        switch (browser) {
            case "firefox":
                mutableCapabilities = new FirefoxCapabilities().getCapability("FirefoxTest");
                break;
            case "chrome":
                mutableCapabilities = new ChromeCapabilities().getCapability("ChromeTest");
                break;
            default:
                mutableCapabilities = new ChromeCapabilities().getCapability("ChromeTest");
                throw new IOException("browser : " + browser + " is invalid, Launching Chrome as browser of choice..");
        }
        return mutableCapabilities;
    }
}
