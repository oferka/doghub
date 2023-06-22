package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HelpViewService {

    private final DogHubNavigator navigator;

    public void navigateDirectly(@NotNull WebDriver webDriver) {
        log.info("Navigate directly started");
        navigator.navigateToHelpView(webDriver);
        log.info("Navigate directly completed");
    }
}
