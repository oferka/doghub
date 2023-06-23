package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.ui.actions.click.ClickExecutor;
import org.hk.doghub.ui.views.site.signup.SignupWithGoogle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SignupViewService {

    private final DogHubLandingPageService landingPageService;

    private final DogHubNavigator navigator;

    private final ClickExecutor clickExecutor;

    public void navigateFromHomePage(@NotNull WebDriver webDriver) {
        log.info("Navigate from home page started");
        landingPageService.clickSignup(webDriver);
        log.info("Navigate from home page completed");
    }

    public void navigateDirectly(@NotNull WebDriver webDriver) {
        log.info("Navigate directly started");
        navigator.navigateToSignupView(webDriver);
        log.info("Navigate directly completed");
    }

    public void clickSignupWithGoogle(@NotNull WebDriver webDriver) {
        log.info("Click signup with google started");
        clickExecutor.click(webDriver, By.className(SignupWithGoogle.CLASS_NAME));
        log.info("Click signup with google completed");
    }
}
