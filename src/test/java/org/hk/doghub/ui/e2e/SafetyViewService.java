package org.hk.doghub.ui.e2e;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.page.TitleVerifier;
import org.hk.doghub.automation.e2e.selenium.ui.actions.click.ClickExecutor;
import org.hk.doghub.ui.views.site.layout.DogHubSiteLayoutTab;
import org.hk.doghub.ui.views.site.safety.SafetyView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class SafetyViewService {

    private final ClickExecutor clickExecutor;

    private final TitleVerifier titleVerifier;

    private final DogHubNavigator navigator;

    public void navigateFromHomePage(@NotNull WebDriver webDriver) {
        clickExecutor.click(webDriver, By.id(format("%s-%s", DogHubSiteLayoutTab.CLASS_NAME, SafetyView.NAME)));
        titleVerifier.verifyEquals(webDriver, SafetyView.NAME);
    }

    public void navigateDirectly(@NotNull WebDriver webDriver) {
        navigator.navigateToSafetyView(webDriver);
        titleVerifier.verifyEquals(webDriver, SafetyView.NAME);
    }
}
