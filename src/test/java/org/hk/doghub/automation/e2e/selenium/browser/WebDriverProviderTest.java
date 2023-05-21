package org.hk.doghub.automation.e2e.selenium.browser;

import org.hk.doghub.automation.e2e.selenium.Setup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class WebDriverProviderTest {

    @Autowired
    private BrowserProvider browserProvider;

    @Autowired
    private WebDriverProvider webDriverProvider;

    @Test
    public void shouldGet() {
        Browser browser = browserProvider.get();
        WebDriver webDriver = webDriverProvider.get(browser);
        assertNotNull(browser);
        webDriver.quit();
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldGetWithSpecifiedConfiguration(Setup setup) {
        Browser browser = browserProvider.get(setup.getBrowserConfiguration());
        WebDriver webDriver = webDriverProvider.get(browser);
        assertNotNull(browser);
        webDriver.quit();
    }
}