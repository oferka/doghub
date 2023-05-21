package org.hk.doghub.automation.e2e.selenium.ui.actions.click;

import org.hk.doghub.automation.e2e.selenium.BaseTest;
import org.hk.doghub.automation.e2e.selenium.Setup;
import org.hk.doghub.automation.e2e.selenium.element.retrieve.ElementRetriever;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClickExecutorTest extends BaseTest {

    @Autowired
    private ClickExecutor clickExecutor;

    @Autowired
    private ElementRetriever elementRetriever;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldClickByLocator(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        clickExecutor.click(webDriver, landingPageElementLocatorProvider.getSignupLoginLink());
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldClickByElement(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        clickExecutor.click(webDriver, elementRetriever.getByClickable(webDriver, landingPageElementLocatorProvider.getSignupLoginLink()));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNotClickForNonExistingLocator(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        Exception exception = assertThrows(TimeoutException.class, () -> clickExecutor.click(webDriver, By.id(UUID.randomUUID().toString())));
        assertNotNull(exception);
    }
}