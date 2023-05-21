package org.hk.doghub.automation.e2e.selenium.ui.actions.mouse.hover;

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

class MouseHoverExecutorTest extends BaseTest {

    @Autowired
    private MouseHoverExecutor mouseHoverExecutor;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldHoverByLocator(Setup setup) throws InterruptedException {
        initiateWebDriverAndNavigateToTestPage(setup);
        mouseHoverExecutor.hover(webDriver, landingPageElementLocatorProvider.getSignupLoginLink());
        Thread.sleep(10000);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNotHoverForNonExistingLocator(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        Exception exception = assertThrows(TimeoutException.class, () -> mouseHoverExecutor.hover(webDriver, By.id(UUID.randomUUID().toString())));
        assertNotNull(exception);
    }
}