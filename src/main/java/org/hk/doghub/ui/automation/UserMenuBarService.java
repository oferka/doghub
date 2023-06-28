package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.element.highlight.ElementHighlighter;
import org.hk.doghub.ui.components.shared.EntityAvatar;
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


    public void loginUser(@NotNull WebDriver webDriver) {
        loginViewService.navigateFromHomePage(webDriver);
        loginViewService.loginUser(webDriver, loginViewService.loadUser());
        elementHighlighter.highlight(webDriver, By.className(EntityAvatar.CLASS_NAME));
    }
}
