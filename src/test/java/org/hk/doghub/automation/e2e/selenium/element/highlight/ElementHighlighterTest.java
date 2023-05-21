package org.hk.doghub.automation.e2e.selenium.element.highlight;

import org.hk.doghub.automation.e2e.selenium.BaseTest;
import org.hk.doghub.automation.e2e.selenium.Setup;
import org.hk.doghub.automation.e2e.selenium.element.retrieve.ElementRetriever;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ElementHighlighterTest extends BaseTest {

    @Autowired
    private ElementHighlighter elementHighlighter;

    @Autowired
    private ElementRetriever elementRetriever;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldHighlightByElement(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        elementHighlighter.highlight(webDriver, elementRetriever.getByPresence(webDriver, landingPageElementLocatorProvider.getSignupLoginLink()));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldHighlightByLocator(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        elementHighlighter.highlight(webDriver, landingPageElementLocatorProvider.getSignupLoginLink());
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldThrowExceptionForHighlightByNonExistingLocator(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        Exception exception = assertThrows(TimeoutException.class, () -> elementHighlighter.highlight(webDriver, By.id(UUID.randomUUID().toString())));
        Throwable cause = exception.getCause();
        assertTrue(cause instanceof NoSuchElementException);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEventHighlightByElement(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        elementHighlighter.eventHighlight(webDriver, elementRetriever.getByPresence(webDriver, landingPageElementLocatorProvider.getSignupLoginLink()));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEventHighlightByLocator(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        elementHighlighter.eventHighlight(webDriver, landingPageElementLocatorProvider.getSignupLoginLink());
    }
}