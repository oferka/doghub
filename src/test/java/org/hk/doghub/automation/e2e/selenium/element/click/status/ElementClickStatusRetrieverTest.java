package org.hk.doghub.automation.e2e.selenium.element.click.status;

import org.hk.doghub.automation.e2e.selenium.BaseTest;
import org.hk.doghub.automation.e2e.selenium.Setup;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ElementClickStatusRetrieverTest extends BaseTest {

    @Autowired
    private ElementClickStatusRetriever elementClickStatusRetriever;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldBeClickable(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        boolean clickable = elementClickStatusRetriever.isClickable(webDriver, landingPageElementLocatorProvider.getSignupLoginLink());
        assertTrue(clickable);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldBeClickableWithHighlightTurnedOn(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        boolean clickable = elementClickStatusRetriever.isClickable(webDriver, landingPageElementLocatorProvider.getSignupLoginLink(), true);
        assertTrue(clickable);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNotBeClickableNonExistingElement(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        boolean clickable = elementClickStatusRetriever.isClickable(webDriver, By.id(UUID.randomUUID().toString()));
        assertFalse(clickable);
    }
}