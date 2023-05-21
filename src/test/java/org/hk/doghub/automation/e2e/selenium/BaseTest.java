package org.hk.doghub.automation.e2e.selenium;

import org.hk.doghub.automation.e2e.selenium.browser.BrowserProvider;
import org.hk.doghub.automation.e2e.selenium.browser.WebDriverProvider;
import org.hk.doghub.automation.e2e.selenium.mapping.navigation.Navigator;
import org.hk.doghub.automation.e2e.selenium.mapping.provider.LandingPageElementLocatorProvider;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class BaseTest {

    @Autowired
    private BrowserProvider browserProvider;

    @Autowired
    private WebDriverProvider webDriverProvider;

    @Autowired
    protected LandingPageElementLocatorProvider landingPageElementLocatorProvider;

    @Autowired
    private Navigator navigator;


    protected WebDriver webDriver;

    protected void initiateWebDriverAndNavigateToTestPage(Setup setup) {
        webDriver = webDriverProvider.get(browserProvider.get(setup.getBrowserConfiguration()));
        navigator.navigateToLandingPage(webDriver);
    }

    @AfterEach
    public void quitWebDriver() {
        webDriver.quit();
    }
}
