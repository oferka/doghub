package org.hk.doghub.ui.e2e;

import org.hk.doghub.ui.automation.SiteHomeViewService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;

public class SiteHomeViewTest extends DogHubUITest {

    @Autowired
    private SiteHomeViewService siteHomeViewService;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNavigateFromHomePage(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        siteHomeViewService.navigateFromHomePage(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNavigateDirectly(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        siteHomeViewService.navigateDirectly(webDriver);
    }
}
