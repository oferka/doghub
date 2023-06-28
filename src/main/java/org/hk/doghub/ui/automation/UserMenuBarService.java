package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.element.display.status.ElementDisplayStatusRetriever;
import org.hk.doghub.automation.e2e.selenium.element.highlight.ElementHighlighter;
import org.hk.doghub.automation.e2e.selenium.ui.actions.click.ClickExecutor;
import org.hk.doghub.ui.components.shared.user.UserMenuBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        assert elementDisplayStatusRetriever.isDisplayed(webDriver, By.cssSelector("vaadin-menu-bar-list-box[role='menu']"));
    }
}
