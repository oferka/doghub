package org.hk.doghub.ui.e2e;

import org.hk.doghub.automation.e2e.selenium.element.highlight.ElementHighlighter;
import org.hk.doghub.ui.automation.UserMenuBarService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserMenuBarTest extends DogHubUITest {

    @Autowired
    private UserMenuBarService userMenuBarService;

    @Autowired
    private ElementHighlighter elementHighlighter;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayUserAvatarWhenLoggedIn(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        userMenuBarService.loginUser(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldPresentMenuBar(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        userMenuBarService.openMenuBar(webDriver);
        userMenuBarService.verifyMenuBarIsDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldGetMenuItems(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        userMenuBarService.openMenuBar(webDriver);
        List<WebElement> menuItems = userMenuBarService.getMenuItems(webDriver);
        for(WebElement menuItem : menuItems) {
            elementHighlighter.eventHighlight(webDriver, menuItem);
        }
    }
}
