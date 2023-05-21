package org.hk.doghub.automation.e2e.selenium.element.keys.sender;

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

class ElementKeysSenderTest extends BaseTest {

    @Autowired
    private ElementKeysSender elementKeysSender;

    @Autowired
    private ElementRetriever elementRetriever;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldSend(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        elementKeysSender.send(webDriver, elementRetriever.getByPresence(webDriver, landingPageElementLocatorProvider.getSubscriptionInput()), "some value");
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldSendOneByOne(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        elementKeysSender.send(webDriver, elementRetriever.getByPresence(webDriver, landingPageElementLocatorProvider.getSubscriptionInput()), "some value", true);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNotSendForNonExistingLocator(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        Exception exception = assertThrows(TimeoutException.class, () -> elementKeysSender.send(webDriver, elementRetriever.getByPresence(webDriver, By.id(UUID.randomUUID().toString())), "some value"));
        assertNotNull(exception);
    }
}