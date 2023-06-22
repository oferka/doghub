package org.hk.doghub.ui.e2e;

import org.hk.doghub.automation.e2e.selenium.browser.BrowserProvider;
import org.hk.doghub.automation.e2e.selenium.browser.WebDriverProvider;
import org.hk.doghub.ui.automation.DogHubLandingPageService;
import org.hk.doghub.ui.automation.DogHubTestApplication;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DogHubTestApplication.class)
public abstract class BaseLandingPageTest {

    @Autowired
    private BrowserProvider browserProvider;

    @Autowired
    private WebDriverProvider webDriverProvider;

    @Autowired
    protected DogHubLandingPageService dogHubLandingPageService;

    protected WebDriver webDriver;

    protected void initiateWebDriverAndNavigateToLandingPage(Setup setup) {
        webDriver = webDriverProvider.get(browserProvider.get(setup.getBrowserConfiguration()));
        dogHubLandingPageService.navigate(webDriver);
    }

    @AfterEach
    public void quitWebDriver() {
        webDriver.quit();
    }
}
