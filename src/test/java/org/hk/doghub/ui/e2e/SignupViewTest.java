package org.hk.doghub.ui.e2e;

import jakarta.validation.constraints.NotNull;
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

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldClickSignupWithFacebook(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.clickSignupWithFacebook(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEnterEmail(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterEmail(webDriver, "a.b@c.com");
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEnterPassword(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterPassword(webDriver, getValidPassword());
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldToggleShowHidePassword(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.toggleShowHidePassword(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEnterPasswordAndShowIt(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterPassword(webDriver, getValidPassword());
        viewService.toggleShowHidePassword(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldClickContinue(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.clickContinue(webDriver);
    }

    private @NotNull String getValidPassword() {
        return "aaaaaaaaa1";
    }
}
