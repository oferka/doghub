package org.hk.doghub.ui.e2e;

import org.hk.doghub.ui.automation.AboutViewService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;

public class AboutViewTest extends DogHubUITest {

    @Autowired
    private AboutViewService viewService;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNavigateDirectly(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateDirectly(webDriver);
    }
}
