package org.hk.doghub.automation.e2e.selenium.ui.actions.scroll;

import org.hk.doghub.automation.e2e.selenium.BaseTest;
import org.hk.doghub.automation.e2e.selenium.Setup;
import org.hk.doghub.automation.e2e.selenium.element.retrieve.ElementRetriever;
import org.hk.doghub.automation.e2e.selenium.ui.actions.pause.PauseExecutor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.UUID;

import static org.hk.doghub.automation.e2e.selenium.ui.actions.scroll.ScrollInstructions.ScrollDirections.DOWN;
import static org.hk.doghub.automation.e2e.selenium.ui.actions.scroll.ScrollInstructions.ScrollDirections.UP;
import static org.hk.doghub.automation.e2e.selenium.ui.actions.scroll.ScrollInstructions.ScrollSpeeds.FAST;
import static org.hk.doghub.automation.e2e.selenium.ui.actions.scroll.ScrollInstructions.ScrollSpeeds.MEDIUM;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScrollExecutorTest extends BaseTest {

    @Autowired
    private ScrollExecutor scrollExecutor;

    @Autowired
    private ElementRetriever elementRetriever;

    @Autowired
    private PauseExecutor pauseExecutor;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldScrollByInstructions(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        ScrollInstructions scrollInstructions = new ScrollInstructions(DOWN, 500, MEDIUM);
        scrollExecutor.scroll(webDriver, scrollInstructions);
        pauseExecutor.pause(Duration.ofSeconds(1));
        scrollInstructions = new ScrollInstructions(UP, 500, FAST);
        scrollExecutor.scroll(webDriver, scrollInstructions);
        pauseExecutor.pause(Duration.ofSeconds(1));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldScrollByElement(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        scrollExecutor.scroll(webDriver, elementRetriever.getByPresence(webDriver, landingPageElementLocatorProvider.getSubscriptionInput()));
        pauseExecutor.pause(Duration.ofSeconds(1));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldScrollByLocator(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        scrollExecutor.scroll(webDriver, landingPageElementLocatorProvider.getSubscriptionInput());
        pauseExecutor.pause(Duration.ofSeconds(1));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNotScrollForNonExistingLocator(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        Exception exception = assertThrows(TimeoutException.class, () -> scrollExecutor.scroll(webDriver, By.id(UUID.randomUUID().toString())));
        assertNotNull(exception);
    }
}