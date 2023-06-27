package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.page.TitleVerifier;
import org.hk.doghub.ui.views.site.help.HelpView;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HelpViewService {

    private final DogHubNavigator navigator;

    private final TitleVerifier titleVerifier;

    public void navigateDirectly(@NotNull WebDriver webDriver) {
        navigator.navigateToHelpView(webDriver);
        titleVerifier.verifyEquals(webDriver, HelpView.NAME);
    }
}
