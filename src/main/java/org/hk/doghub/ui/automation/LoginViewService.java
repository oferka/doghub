package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.page.TitleVerifier;
import org.hk.doghub.ui.views.site.login.LoginView;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginViewService {

    private final DogHubLandingPageService landingPageService;

    private final DogHubNavigator navigator;

    private final TitleVerifier titleVerifier;

    public void navigateFromHomePage(@NotNull WebDriver webDriver) {
        log.info("Navigate from home page started");
        landingPageService.clickLogin(webDriver);
        log.info("Navigate from home page completed");
    }

    public void navigateDirectly(@NotNull WebDriver webDriver) {
        log.info("Navigate directly started");
        navigator.navigateToLoginView(webDriver);
        titleVerifier.verifyEquals(webDriver, LoginView.NAME);
        log.info("Navigate directly completed");
    }
}
