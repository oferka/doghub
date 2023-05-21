package org.hk.doghub.automation.e2e.selenium.ui.actions.text.input;

import org.hk.doghub.automation.e2e.selenium.BaseTest;
import org.hk.doghub.automation.e2e.selenium.Setup;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TextInputExecutorTest extends BaseTest {

    @Autowired
    private TextInputExecutor textInputExecutor;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEnterText(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        textInputExecutor.enterText(webDriver, landingPageElementLocatorProvider.getSubscriptionInput(), "some value");
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNotEnterTextForNonExistingLocator(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        Exception exception = assertThrows(TimeoutException.class, () -> textInputExecutor.enterText(webDriver, By.id(UUID.randomUUID().toString()), "some value"));
        assertNotNull(exception);
    }
}