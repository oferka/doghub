package org.hk.doghub.automation.e2e.selenium.page;

import org.hk.doghub.automation.e2e.selenium.BaseTest;
import org.hk.doghub.automation.e2e.selenium.Setup;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hk.doghub.automation.e2e.selenium.mapping.page.LandingPage.TITLE;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TitleVerifierTest extends BaseTest {

    @Autowired
    private TitleVerifier titleVerifier;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldVerifyEquals(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        titleVerifier.verifyEquals(webDriver, TITLE);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldThrowExceptionForEqualsWrongTitle(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        assertThrows(TimeoutException.class, () -> titleVerifier.verifyEquals(webDriver, "Wrong Title"));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldVerifyContains(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        titleVerifier.verifyContains(webDriver, TITLE.substring(2,8));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldThrowExceptionForContainsWrongTitle(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        assertThrows(TimeoutException.class, () -> titleVerifier.verifyContains(webDriver, "Wrong Title"));
    }
}