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
        viewService.enterEmail(webDriver, viewService.getValidEmail());
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayErrorOnInvalidEmail(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterEmail(webDriver, viewService.getInvalidEmail());
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
    public void shouldDisplayErrorOnInvalidPassword(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterPassword(webDriver, viewService.getInvalidPassword());
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
    public void shouldSignup(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        String username = viewService.getValidEmail();
        String password = viewService.getValidPassword();
        submitSignupWithEmailForm(username, password);
        viewService.verifySignup(webDriver, username);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNotSignupOnInvalidEmail(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        String username = viewService.getInvalidEmail();
        String password = viewService.getValidPassword();
        submitSignupWithEmailForm(username, password);
        viewService.verifyEmailErrorMessage(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNotSignupOnInvalidPassword(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        String username = viewService.getValidEmail();
        String password = viewService.getInvalidPassword();
        submitSignupWithEmailForm(username, password);
        viewService.verifyPasswordErrorMessage(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNotSignupOnInvalidEmailAndPassword(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        String username = viewService.getInvalidEmail();
        String password = viewService.getInvalidPassword();
        submitSignupWithEmailForm(username, password);
        viewService.verifyEmailErrorMessage(webDriver);
        viewService.verifyPasswordErrorMessage(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldClickTermsOfService(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.clickTermsOfService(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldClickPrivacyPolicy(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.clickPrivacyPolicy(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldClickSignIn(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.clickSignIn(webDriver);
    }

    private void submitSignupWithEmailForm(String username, String password) {
        viewService.enterEmail(webDriver, username);
        viewService.enterPassword(webDriver, password);
        viewService.clickContinue(webDriver);
    }
}
