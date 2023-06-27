package org.hk.doghub.ui.e2e;

import org.hk.doghub.data.content.generator.user.User;
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
    public void shouldDisplayErrorOnEmptyPassword(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterPassword(webDriver, EMPTY);
        viewService.verifyPasswordErrorMessage(webDriver);
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
        viewService.enterPassword(webDriver, viewService.getValidPassword());
        viewService.toggleShowHidePassword(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldClickContinue(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.clickContinue(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldLoadUserAndLogin(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        User user = viewService.loadUser();
        viewService.enterEmail(webDriver, user.getEmail());
        viewService.enterPassword(webDriver, user.getPassword());
        viewService.verifyLoggedIn(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldPresentIncorrectUsernameOrPasswordMessage(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterEmail(webDriver, viewService.getValidEmail());
        viewService.enterPassword(webDriver, viewService.getValidPassword());
        viewService.verifyIncorrectUsernameOrPasswordMessage(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldClickSignup(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.clickSignup(webDriver);
    }
}
