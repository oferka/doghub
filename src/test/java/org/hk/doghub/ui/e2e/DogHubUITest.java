package org.hk.doghub.ui.e2e;

import org.hk.doghub.DogHubApplication;
import org.hk.doghub.automation.e2e.selenium.browser.BrowserProvider;
import org.hk.doghub.automation.e2e.selenium.browser.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DogHubApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public abstract class DogHubUITest {

    @Autowired
    private BrowserProvider browserProvider;

    @Autowired
    private WebDriverProvider webDriverProvider;

    @Autowired
    protected SiteHomeViewService siteHomeViewService;

    protected WebDriver webDriver;

    protected void initiateWebDriverAndNavigateToLandingPage(Setup setup) {
        webDriver = webDriverProvider.get(browserProvider.get(setup.getBrowserConfiguration()));
        siteHomeViewService.navigateDirectly(webDriver);
    }

    @AfterEach
    public void quitWebDriver() {
        webDriver.quit();
    }
}
