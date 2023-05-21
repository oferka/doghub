package org.hk.doghub.automation.e2e.selenium.ui.actions.select;

import org.hk.doghub.automation.e2e.selenium.BaseTest;
import org.hk.doghub.automation.e2e.selenium.Setup;
import org.hk.doghub.automation.e2e.selenium.mapping.provider.LandingPageElementLocatorProvider;
import org.hk.doghub.automation.e2e.selenium.mapping.provider.SignupElementLocatorProvider;
import org.hk.doghub.automation.e2e.selenium.mapping.provider.SignupLoginElementLocatorProvider;
import org.hk.doghub.automation.e2e.selenium.ui.actions.click.ClickExecutor;
import org.hk.doghub.automation.e2e.selenium.ui.actions.text.input.TextInputExecutor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import static java.lang.String.format;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

class SelectExecutorTest extends BaseTest {

    @Autowired
    private SelectExecutor selectExecutor;

    @Autowired
    private ClickExecutor clickExecutor;

    @Autowired
    private TextInputExecutor textInputExecutor;

    @Autowired
    private SignupElementLocatorProvider signupElementLocatorProvider;

    @Autowired
    private LandingPageElementLocatorProvider landingPageElementLocatorProvider;

    @Autowired
    private SignupLoginElementLocatorProvider signupLoginElementLocatorProvider;

    @ParameterizedTest
    @EnumSource(Setup.class)
    void shouldSelectByVisibleText(Setup setup) {
        initiateWebDriverAndNavigateToSignupPage(setup);
        selectExecutor.selectByVisibleText(webDriver, getCountrySelector(), "Israel");
        selectExecutor.selectByVisibleText(webDriver, getCountrySelector(), "India");
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    void shouldSelectByValue(Setup setup) {
        initiateWebDriverAndNavigateToSignupPage(setup);
        selectExecutor.selectByValue(webDriver, getCountrySelector(), "Israel");
        selectExecutor.selectByValue(webDriver, getCountrySelector(), "India");
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    void shouldSelectByIndex(Setup setup) {
        initiateWebDriverAndNavigateToSignupPage(setup);
        selectExecutor.selectByIndex(webDriver, getCountrySelector(), 4);
        selectExecutor.selectByIndex(webDriver, getCountrySelector(), 0);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    void shouldSelectRandom(Setup setup) {
        initiateWebDriverAndNavigateToSignupPage(setup);
        selectExecutor.selectRandom(webDriver, getCountrySelector());
        selectExecutor.selectRandom(webDriver, getCountrySelector());
    }

    private void initiateWebDriverAndNavigateToSignupPage(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        clickExecutor.click(webDriver, getSignupLoginLink());
        textInputExecutor.enterText(webDriver, getNameInput(), randomAlphabetic(12), false, true);
        textInputExecutor.enterText(webDriver, getEmailInput(), format("%s@%s.com", randomAlphabetic(8), randomAlphabetic(5)), false, true);
        clickExecutor.click(webDriver, getSignupButton());
    }

    private By getCountrySelector() {
        return signupElementLocatorProvider.getCountrySelector();
    }

    private By getSignupLoginLink() {
        return landingPageElementLocatorProvider.getSignupLoginLink();
    }

    private By getNameInput() {
        return signupLoginElementLocatorProvider.getSignupNameInput();
    }

    private By getEmailInput() {
        return signupLoginElementLocatorProvider.getSignupEmailAddressInput();
    }

    private By getSignupButton() {
        return signupLoginElementLocatorProvider.getSignupButton();
    }
}