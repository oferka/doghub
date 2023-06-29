package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.element.display.status.ElementDisplayStatusRetriever;
import org.hk.doghub.automation.e2e.selenium.element.highlight.ElementHighlighter;
import org.hk.doghub.automation.e2e.selenium.elements.retrieve.ElementsRetriever;
import org.hk.doghub.automation.e2e.selenium.page.TitleVerifier;
import org.hk.doghub.automation.e2e.selenium.ui.actions.click.ClickExecutor;
import org.hk.doghub.ui.components.shared.user.UserMenuBar;
import org.hk.doghub.ui.views.site.profile.ProfileView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserMenuBarService {

    @Autowired
    private LoginViewService loginViewService;

    @Autowired
    private ElementHighlighter elementHighlighter;

    @Autowired
    private ClickExecutor clickExecutor;

    @Autowired
    private ElementDisplayStatusRetriever elementDisplayStatusRetriever;

    @Autowired
    private ElementsRetriever elementsRetriever;

    @Autowired
    private TitleVerifier titleVerifier;

    public void loginUser(@NotNull WebDriver webDriver) {
        loginViewService.navigateFromHomePage(webDriver);
        loginViewService.loginUser(webDriver, loginViewService.loadUser());
        elementHighlighter.highlight(webDriver, By.className(UserMenuBar.CLASS_NAME));
    }

    public void openMenuBar(@NotNull WebDriver webDriver) {
        loginViewService.navigateFromHomePage(webDriver);
        loginViewService.loginUser(webDriver, loginViewService.loadUser());
        clickExecutor.click(webDriver, By.className(UserMenuBar.CLASS_NAME));
    }

    public void verifyMenuBarIsDisplayed(@NotNull WebDriver webDriver) {
        assert isMenuBarIsDisplayed(webDriver);
    }

    private boolean isMenuBarIsDisplayed(@NotNull WebDriver webDriver) {
        return elementDisplayStatusRetriever.isDisplayed(webDriver, By.cssSelector("vaadin-menu-bar-list-box[role='menu']"));
    }

    public List<WebElement> getMenuItems(@NotNull WebDriver webDriver) {
        return elementsRetriever.getByPresence(webDriver, By.cssSelector("vaadin-menu-bar-item"));
    }

    public void navigateToProfileView(@NotNull WebDriver webDriver) {
        openMenuBar(webDriver);
        clickExecutor.click(webDriver, By.xpath("//vaadin-menu-bar-item/child::a[@href='profile']"));
        titleVerifier.verifyEquals(webDriver, ProfileView.NAME);
    }
}
