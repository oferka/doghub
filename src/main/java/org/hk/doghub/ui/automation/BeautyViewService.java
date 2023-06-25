package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.page.TitleVerifier;
import org.hk.doghub.automation.e2e.selenium.ui.actions.click.ClickExecutor;
import org.hk.doghub.ui.views.site.beauty.BeautyView;
import org.hk.doghub.ui.views.site.layout.DogHubSiteLayoutTab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class BeautyViewService {

    private final ClickExecutor clickExecutor;

    private final TitleVerifier titleVerifier;

    private final DogHubNavigator navigator;

    public void navigateFromHomePage(@NotNull WebDriver webDriver) {
        log.info("Navigate from home page started");
        clickExecutor.click(webDriver, By.id(format("%s-%s", DogHubSiteLayoutTab.CLASS_NAME, BeautyView.NAME)));
        titleVerifier.verifyEquals(webDriver, BeautyView.NAME);
        log.info("Navigate from home page completed");
    }

    public void navigateDirectly(@NotNull WebDriver webDriver) {
        log.info("Navigate directly started");
        navigator.navigateToBeautyView(webDriver);
        titleVerifier.verifyEquals(webDriver, BeautyView.NAME);
        log.info("Navigate directly completed");
    }
}
