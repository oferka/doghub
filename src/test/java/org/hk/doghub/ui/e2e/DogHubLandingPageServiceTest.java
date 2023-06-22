package org.hk.doghub.ui.e2e;

import org.hk.doghub.automation.e2e.selenium.element.highlight.ElementHighlighter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DogHubLandingPageServiceTest extends DogHubUITest {

    @Autowired
    private ElementHighlighter elementHighlighter;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNavigateToLandingPage(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldClickLogo(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        landingPageService.clickLogo(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldClickHome(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        landingPageService.clickHome(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldClickLogin(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        landingPageService.clickLogin(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldClickSignup(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        landingPageService.clickSignup(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldGetTabs(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        List<WebElement> navigationElements = landingPageService.getTabs(webDriver);
        for(WebElement navigationElement : navigationElements) {
            elementHighlighter.eventHighlight(webDriver, navigationElement);
        }
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldBrowseTabs(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        landingPageService.browseTabs(webDriver);
    }
}
