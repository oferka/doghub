package org.hk.doghub.automation.e2e.selenium.ui.actions.alert;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.BaseTest;
import org.hk.doghub.automation.e2e.selenium.Setup;
import org.hk.doghub.automation.e2e.selenium.mapping.provider.LandingPageElementLocatorProvider;
import org.hk.doghub.automation.e2e.selenium.ui.actions.click.ClickExecutor;
import org.hk.doghub.automation.e2e.selenium.ui.actions.text.input.TextInputExecutor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import static java.lang.String.format;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Slf4j
class ConfirmBoxExecutorTest extends BaseTest {

    @Autowired
    private ConfirmBoxExecutor confirmBoxExecutor;

    @Autowired
    private ClickExecutor clickExecutor;

    @Autowired
    private TextInputExecutor textInputExecutor;

    @Autowired
    private LandingPageElementLocatorProvider landingPageElementLocatorProvider;

    @ParameterizedTest
    @EnumSource(Setup.class)
    void shouldAccept(Setup setup) {
        initiateWebDriverAndNavigateToContactUsPage(setup);
        enterEmail(webDriver, format("%s@%s.com", randomAlphabetic(8), randomAlphabetic(5)));
        clickSubmit(webDriver);
        confirmBoxExecutor.accept(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    void shouldDismiss(Setup setup) {
        initiateWebDriverAndNavigateToContactUsPage(setup);
        enterEmail(webDriver, format("%s@%s.com", randomAlphabetic(8), randomAlphabetic(5)));
        clickSubmit(webDriver);
        confirmBoxExecutor.dismiss(webDriver);
    }

    private void initiateWebDriverAndNavigateToContactUsPage(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        clickExecutor.click(webDriver, landingPageElementLocatorProvider.getContactUsLink());
    }

    private void enterEmail(@NotNull WebDriver webDriver, @Email String email) {
        log.info("Enter '{}' as the email of user that creates the ticket started", email);
        textInputExecutor.enterText(webDriver, By.xpath("//input[@data-qa='email']"), email, false, true);
        log.info("Enter '{}' as the email of user that creates the ticket completed", email);
    }

    private void clickSubmit(@NotNull WebDriver webDriver) {
        log.info("Click submit started");
        clickExecutor.click(webDriver, By.xpath("//input[@data-qa='submit-button']"));
        log.info("Click submit completed");
    }
}