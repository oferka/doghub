package org.hk.doghub.automation.e2e.selenium.element.display.status;

import org.hk.doghub.automation.e2e.selenium.BaseTest;
import org.hk.doghub.automation.e2e.selenium.Setup;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ElementDisplayStatusRetrieverTest extends BaseTest {

    @Autowired
    private ElementDisplayStatusRetriever elementDisplayStatusRetriever;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldBeDisplayed(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        boolean displayed = elementDisplayStatusRetriever.isDisplayed(webDriver, landingPageElementLocatorProvider.getSignupLoginLink());
        assertTrue(displayed);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNotBeDisplayed(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        boolean displayed = elementDisplayStatusRetriever.isDisplayed(webDriver, By.id(UUID.randomUUID().toString()));
        assertFalse(displayed);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldBeDisplayedWithHighlightTurnedOn(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        boolean displayed = elementDisplayStatusRetriever.isDisplayed(webDriver, landingPageElementLocatorProvider.getSignupLoginLink(), true);
        assertTrue(displayed);
    }
}