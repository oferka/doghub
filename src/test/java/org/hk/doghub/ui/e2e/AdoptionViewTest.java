package org.hk.doghub.ui.e2e;

import org.hk.doghub.ui.automation.AdoptionViewService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;

public class AdoptionViewTest extends DogHubUITest {

    @Autowired
    private AdoptionViewService viewService;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNavigateFromHomePage(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNavigateDirectly(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateDirectly(webDriver);
    }
}
