package org.hk.doghub.ui.e2e;

import org.hk.doghub.ui.automation.UserMenuBarService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMenuBarTest extends DogHubUITest {

    @Autowired
    private UserMenuBarService userMenuBarService;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayUserAvatarWhenLoggedIn(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        userMenuBarService.loginUser(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldPresentMenuBar(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        userMenuBarService.openMenuBar(webDriver);
        userMenuBarService.verifyMenuBarIsDisplayed(webDriver);
    }
}
