package org.hk.doghub.ui.e2e;

import org.hk.doghub.ui.automation.SignupViewService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;

public class SignupViewTest extends DogHubUITest {

    @Autowired
    private SignupViewService viewService;

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

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldClickSignupWithGoogle(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.clickSignupWithGoogle(webDriver);
    }
}
