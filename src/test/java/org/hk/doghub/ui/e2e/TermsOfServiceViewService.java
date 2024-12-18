package org.hk.doghub.ui.e2e;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TermsOfServiceViewService {

    private final DogHubNavigator navigator;

    public void navigateDirectly(@NotNull WebDriver webDriver) {
        navigator.navigateToTermsOfServiceView(webDriver);
    }
}
