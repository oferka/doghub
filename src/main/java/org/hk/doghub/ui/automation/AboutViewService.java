package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.page.TitleVerifier;
import org.hk.doghub.ui.views.app.about.AboutView;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AboutViewService {

    private final DogHubNavigator navigator;

    private final TitleVerifier titleVerifier;

    public void navigateDirectly(@NotNull WebDriver webDriver) {
        log.info("Navigate directly started");
        navigator.navigateToAboutView(webDriver);
        titleVerifier.verifyEquals(webDriver, AboutView.NAME);
        log.info("Navigate directly completed");
    }
}
