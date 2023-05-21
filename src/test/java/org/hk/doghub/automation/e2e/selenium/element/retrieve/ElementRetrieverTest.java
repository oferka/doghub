package org.hk.doghub.automation.e2e.selenium.element.retrieve;

import org.hk.doghub.automation.e2e.selenium.BaseTest;
import org.hk.doghub.automation.e2e.selenium.Setup;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ElementRetrieverTest extends BaseTest {

    @Autowired
    private ElementRetriever elementRetriever;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldRetrieveByPresence(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        WebElement element = elementRetriever.getByPresence(webDriver, landingPageElementLocatorProvider.getSignupLoginLink());
        assertNotNull(element);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldRetrieveByPresenceWithSpecifiedTimeout(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        WebElement element = elementRetriever.getByPresence(webDriver, landingPageElementLocatorProvider.getSignupLoginLink(), 10);
        assertNotNull(element);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldThrowExceptionForRetrieveByPresenceForNonExistingLocator(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        Exception exception = assertThrows(TimeoutException.class, () -> elementRetriever.getByPresence(webDriver, By.id(UUID.randomUUID().toString()), 2));
        Throwable cause = exception.getCause();
        assertTrue(cause instanceof NoSuchElementException);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldRetrieveByClickable(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        WebElement element = elementRetriever.getByClickable(webDriver, landingPageElementLocatorProvider.getSignupLoginLink());
        assertNotNull(element);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldRetrieveByClickableWithSpecifiedTimeout(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        WebElement element = elementRetriever.getByClickable(webDriver, landingPageElementLocatorProvider.getSignupLoginLink(), 10);
        assertNotNull(element);
    }
}