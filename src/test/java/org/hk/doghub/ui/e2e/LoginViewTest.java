package org.hk.doghub.ui.e2e;

import org.hk.doghub.ui.automation.LoginViewService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;

import static org.apache.logging.log4j.util.Strings.EMPTY;

public class LoginViewTest extends DogHubUITest {

    @Autowired
    private LoginViewService viewService;

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
    public void shouldClickLoginWithGoogle(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.clickLoginWithGoogle(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldClickSignupWithFacebook(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.clickLoginWithFacebook(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEnterEmail(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterEmail(webDriver, viewService.getValidEmail());
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayErrorOnEmptyEmail(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterEmail(webDriver, EMPTY);
        viewService.verifyEmailErrorMessage(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEnterPassword(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterPassword(webDriver, viewService.getValidPassword());
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldToggleShowHidePassword(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.toggleShowHidePassword(webDriver);
    }
}
