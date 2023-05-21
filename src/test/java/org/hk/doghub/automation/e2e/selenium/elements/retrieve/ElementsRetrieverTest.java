package org.hk.doghub.automation.e2e.selenium.elements.retrieve;

import org.hk.doghub.automation.e2e.selenium.BaseTest;
import org.hk.doghub.automation.e2e.selenium.Setup;
import org.hk.doghub.automation.e2e.selenium.element.highlight.ElementHighlighter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ElementsRetrieverTest extends BaseTest {

    @Autowired
    private ElementsRetriever elementsRetriever;

    @Autowired
    private ElementHighlighter elementHighlighter;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldRetrieveByPresence(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        List<WebElement> elements = elementsRetriever.getByPresence(webDriver, landingPageElementLocatorProvider.getNavigationBarLinks());
        verifyRetrievedElements(elements);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldRetrieveByPresenceWithSpecifiedTimeout(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        List<WebElement> elements = elementsRetriever.getByPresence(webDriver, landingPageElementLocatorProvider.getNavigationBarLinks(), 10);
        verifyRetrievedElements(elements);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldThrowExceptionForRetrieveByPresenceForNonExistingLocator(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        assertThrows(TimeoutException.class, () -> elementsRetriever.getByPresence(webDriver, By.id(UUID.randomUUID().toString()), 2));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldRetrieveByVisibility(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        List<WebElement> elements = elementsRetriever.getByVisibility(webDriver, landingPageElementLocatorProvider.getNavigationBarLinks());
        verifyRetrievedElements(elements);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldRetrieveByVisibilityWithSpecifiedTimeout(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        List<WebElement> elements = elementsRetriever.getByVisibility(webDriver, landingPageElementLocatorProvider.getNavigationBarLinks(), 10);
        verifyRetrievedElements(elements);
    }

    private void verifyRetrievedElements(List<WebElement> elements) {
        assertNotNull(elements);
        for (WebElement element : elements) {
            elementHighlighter.eventHighlight(webDriver, element);
        }
    }
}