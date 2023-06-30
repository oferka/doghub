package org.hk.doghub.ui.e2e;

import org.hk.doghub.ui.automation.ProfileViewService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ProfileViewTest extends DogHubUITest {

    @Autowired
    private ProfileViewService viewService;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNavigateFromHomePage(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
    }
}
